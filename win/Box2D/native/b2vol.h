// b2vol.h - Box2D 3.2.0 Volcano (Windows) native shim layer.
// Pure ASCII only. Do not add non-ASCII text here (MSVC C4819 is an error).
// This header is included after <box2d/box2d.h>.
//
// Contents
//   1. small value helpers (vec2 / transform / text)
//   2. flattened callback typedefs + global slots + thunks for callbacks whose
//      C prototype carries a struct BY VALUE (Volcano passes local-struct params
//      by reference, which is not ABI compatible with a by-value C parameter)
//   3. out-scalar shims (a Volcano embedded line cannot take the address of an
//      ordinary integer / float local variable)
//   4. array / pointer / function-pointer / enum field accessors
//
// Every function here mirrors exactly one Volcano method; the corresponding
// C name is stated in the Volcano method comment for audit.

#ifndef B2VOL_H
#define B2VOL_H

// ---------------------------------------------------------------------------
// 1. value helpers
// ---------------------------------------------------------------------------

// Pack a shape id into two 32 bit integers: low = index1, high = world0 | generation << 16.
static inline int b2vol_packIdLow( int index1, int world0, int generation )
{
	(void)world0;
	(void)generation;
	return index1;
}

static inline int b2vol_packIdHigh( int index1, int world0, int generation )
{
	(void)index1;
	return ( world0 & 0xFFFF ) | ( ( generation & 0xFFFF ) << 16 );
}

// Build a vector from two scalars.
static inline b2Vec2 b2vol_vec2( float x, float y )
{
	b2Vec2 v;
	v.x = x;
	v.y = y;
	return v;
}

// Build a rotation from an angle in radians.
static inline b2Rot b2vol_rot( float angle )
{
	return b2MakeRot( angle );
}

// Build an identity transform.
static inline b2Transform b2vol_transformIdentity( void )
{
	return b2Transform_identity;
}

// Build a zero matrix (2 by 2).
static inline b2Mat22 b2vol_mat22Zero( void )
{
	return b2Mat22_zero;
}

// Convert an AABB to a b2Vec2 pair through a static slot, used by debug draw callbacks.
static inline float b2vol_aabbLowerX( b2AABB a ) { return a.lowerBound.x; }
static inline float b2vol_aabbLowerY( b2AABB a ) { return a.lowerBound.y; }
static inline float b2vol_aabbUpperX( b2AABB a ) { return a.upperBound.x; }
static inline float b2vol_aabbUpperY( b2AABB a ) { return a.upperBound.y; }

// Read one element out of a native b2Vec2 array handed to a debug draw callback.
static inline b2Vec2 b2vol_readVec2( const void* points, int index )
{
	const b2Vec2* p = (const b2Vec2*)points;
	b2Vec2 v;
	v.x = p[index].x;
	v.y = p[index].y;
	return v;
}

// Convert a UTF-8 string into a caller supplied wchar_t buffer, returns the character count.
// The result is NOT null terminated by this function when the buffer is smaller than the text.
static inline int b2vol_utf8_to_wchar( const char* s, wchar_t* out, int capacity )
{
	int n = 0;
	if ( s == 0 || out == 0 || capacity <= 0 )
	{
		return 0;
	}

	while ( *s != 0 && n < capacity )
	{
		unsigned char c = (unsigned char)*s;
		unsigned int cp = 0;
		int extra = 0;

		if ( c < 0x80 )
		{
			cp = c;
		}
		else if ( ( c & 0xE0 ) == 0xC0 )
		{
			cp = (unsigned int)( c & 0x1F );
			extra = 1;
		}
		else if ( ( c & 0xF0 ) == 0xE0 )
		{
			cp = (unsigned int)( c & 0x0F );
			extra = 2;
		}
		else if ( ( c & 0xF8 ) == 0xF0 )
		{
			cp = (unsigned int)( c & 0x07 );
			extra = 3;
		}
		else
		{
			s += 1;
			continue;
		}

		s += 1;
		for ( int i = 0; i < extra; ++i )
		{
			if ( ( (unsigned char)*s & 0xC0 ) != 0x80 )
			{
				cp = 0xFFFD;
				break;
			}
			cp = ( cp << 6 ) | (unsigned int)( (unsigned char)*s & 0x3F );
			s += 1;
		}

		out[n] = (wchar_t)cp;
		n += 1;
	}

	return n;
}

// Copy a UTF-8 string into a private ring of static buffers, so a Volcano caller can hand the
// result to a C API that keeps the pointer. Eight slots are kept so a handful of definitions can
// hold a name at the same time.
#define B2VOL_NAME_SLOT_COUNT 16
#define B2VOL_NAME_SLOT_SIZE 128

static char b2vol_nameSlots[B2VOL_NAME_SLOT_COUNT][B2VOL_NAME_SLOT_SIZE];
static int b2vol_nameSlotCursor = 0;

static inline char* b2vol_storeName( const char* s )
{
	int slot = b2vol_nameSlotCursor;
	b2vol_nameSlotCursor = ( b2vol_nameSlotCursor + 1 ) % B2VOL_NAME_SLOT_COUNT;

	char* dst = b2vol_nameSlots[slot];
	int i = 0;
	if ( s != 0 )
	{
		while ( s[i] != 0 && i < B2VOL_NAME_SLOT_SIZE - 1 )
		{
			dst[i] = s[i];
			i += 1;
		}
	}
	dst[i] = 0;
	return dst;
}

// ---------------------------------------------------------------------------
// 2. flattened callbacks (struct-by-value prototypes)
// ---------------------------------------------------------------------------

// ---- world: overlap result, flattened into (index, world-generation) pairs
typedef bool ( *b2volOverlapResultFcn )( int idIndex, int idWorldGen, void* context );
static b2volOverlapResultFcn b2vol_overlapResultSlot = 0;

static bool b2vol_overlapResultThunk( b2ShapeId shapeId, void* context )
{
	if ( b2vol_overlapResultSlot == 0 )
	{
		return false;
	}
	bool r = b2vol_overlapResultSlot( shapeId.index1, b2vol_packIdHigh( 0, shapeId.world0, shapeId.generation ), context );
	return r ? true : false;
}

static inline b2TreeStats b2vol_world_overlapAABB( b2WorldId worldId, b2Pos origin, b2AABB aabb, b2QueryFilter filter,
												  b2volOverlapResultFcn fcn, void* context )
{
	b2vol_overlapResultSlot = fcn;
	return b2World_OverlapAABB( worldId, origin, aabb, filter, fcn != 0 ? b2vol_overlapResultThunk : 0, context );
}

static inline b2TreeStats b2vol_world_overlapShape( b2WorldId worldId, b2Pos origin, const b2ShapeProxy* proxy,
													b2QueryFilter filter, b2volOverlapResultFcn fcn, void* context )
{
	b2vol_overlapResultSlot = fcn;
	return b2World_OverlapShape( worldId, origin, proxy, filter, fcn != 0 ? b2vol_overlapResultThunk : 0, context );
}

// ---- world: cast result
typedef float ( *b2volCastResultFcn )( int idIndex, int idWorldGen, float pointX, float pointY, float normalX,
									  float normalY, float fraction, void* context );
static b2volCastResultFcn b2vol_castResultSlot = 0;

static float b2vol_castResultThunk( b2ShapeId shapeId, b2Pos point, b2Vec2 normal, float fraction, void* context )
{
	if ( b2vol_castResultSlot == 0 )
	{
		return 0.0f;
	}
	return b2vol_castResultSlot( shapeId.index1, b2vol_packIdHigh( 0, shapeId.world0, shapeId.generation ), point.x,
								 point.y, normal.x, normal.y, fraction, context );
}

static inline b2TreeStats b2vol_world_castRay( b2WorldId worldId, b2Pos origin, b2Vec2 translation, b2QueryFilter filter,
											   b2volCastResultFcn fcn, void* context )
{
	b2vol_castResultSlot = fcn;
	return b2World_CastRay( worldId, origin, translation, filter, fcn != 0 ? b2vol_castResultThunk : 0, context );
}

static inline b2TreeStats b2vol_world_castShape( b2WorldId worldId, b2Pos origin, const b2ShapeProxy* proxy,
												 b2Vec2 translation, b2QueryFilter filter, b2volCastResultFcn fcn,
												 void* context )
{
	b2vol_castResultSlot = fcn;
	return b2World_CastShape( worldId, origin, proxy, translation, filter, fcn != 0 ? b2vol_castResultThunk : 0,
							  context );
}

// ---- world: plane result
typedef bool ( *b2volPlaneResultFcn )( int idIndex, int idWorldGen, void* planeResult, void* context );
static b2volPlaneResultFcn b2vol_planeResultSlot = 0;

static bool b2vol_planeResultThunk( b2ShapeId shapeId, const b2PlaneResult* plane, void* context )
{
	if ( b2vol_planeResultSlot == 0 )
	{
		return false;
	}
	bool r = b2vol_planeResultSlot( shapeId.index1, b2vol_packIdHigh( 0, shapeId.world0, shapeId.generation ),
									(void*)plane, context );
	return r ? true : false;
}

static inline void b2vol_world_collideMover( b2WorldId worldId, b2Pos origin, const b2Capsule* mover, b2QueryFilter filter,
											 b2volPlaneResultFcn fcn, void* context )
{
	b2vol_planeResultSlot = fcn;
	b2World_CollideMover( worldId, origin, mover, filter, fcn != 0 ? b2vol_planeResultThunk : 0, context );
}

// ---- world: custom filter
typedef bool ( *b2volCustomFilterFcn )( int aIndex, int aWorldGen, int bIndex, int bWorldGen, void* context );
static b2volCustomFilterFcn b2vol_customFilterSlot = 0;

static bool b2vol_customFilterThunk( b2ShapeId shapeIdA, b2ShapeId shapeIdB, void* context )
{
	if ( b2vol_customFilterSlot == 0 )
	{
		return true;
	}
	bool r = b2vol_customFilterSlot( shapeIdA.index1, b2vol_packIdHigh( 0, shapeIdA.world0, shapeIdA.generation ),
									 shapeIdB.index1, b2vol_packIdHigh( 0, shapeIdB.world0, shapeIdB.generation ), context );
	return r ? true : false;
}

static inline void b2vol_world_setCustomFilterCallback( b2WorldId worldId, b2volCustomFilterFcn fcn, void* context )
{
	b2vol_customFilterSlot = fcn;
	b2World_SetCustomFilterCallback( worldId, fcn != 0 ? b2vol_customFilterThunk : 0, context );
}

// ---- world: pre solve
typedef void ( *b2volPreSolveFcn )( int aIndex, int aWorldGen, int bIndex, int bWorldGen, void* manifold, void* context );
static b2volPreSolveFcn b2vol_preSolveSlot = 0;

static void b2vol_preSolveThunk( b2ShapeId shapeIdA, b2ShapeId shapeIdB, b2Manifold* manifold, void* context )
{
	if ( b2vol_preSolveSlot == 0 )
	{
		return;
	}
	b2vol_preSolveSlot( shapeIdA.index1, b2vol_packIdHigh( 0, shapeIdA.world0, shapeIdA.generation ), shapeIdB.index1,
						b2vol_packIdHigh( 0, shapeIdB.world0, shapeIdB.generation ), (void*)manifold, context );
}

// ---- world: pre continuous
typedef bool ( *b2volPreContinuousFcn )( int aIndex, int aWorldGen, int bIndex, int bWorldGen, float pointX, float pointY,
										 float normalX, float normalY, void* context );
static b2volPreContinuousFcn b2vol_preContinuousSlot = 0;

static bool b2vol_preContinuousThunk( b2ShapeId shapeIdA, b2ShapeId shapeIdB, b2Pos point, b2Vec2 normal, void* context )
{
	if ( b2vol_preContinuousSlot == 0 )
	{
		return true;
	}
	bool r = b2vol_preContinuousSlot( shapeIdA.index1, b2vol_packIdHigh( 0, shapeIdA.world0, shapeIdA.generation ),
									  shapeIdB.index1, b2vol_packIdHigh( 0, shapeIdB.world0, shapeIdB.generation ),
									  point.x, point.y, normal.x, normal.y, context );
	return r ? true : false;
}

static inline void b2vol_world_setPreSolveCallback( b2WorldId worldId, b2volPreSolveFcn preSolveFcn,
													b2volPreContinuousFcn preContinuousFcn, void* context )
{
	b2vol_preSolveSlot = preSolveFcn;
	b2vol_preContinuousSlot = preContinuousFcn;
	b2World_SetPreSolveCallback( worldId, preSolveFcn != 0 ? b2vol_preSolveThunk : 0,
								 preContinuousFcn != 0 ? b2vol_preContinuousThunk : 0, context );
}

// ---- debug draw: 10 leaf callbacks, every struct parameter flattened into scalars
typedef void ( *b2volDrawPolygonFcn )( float tx, float ty, float qc, float qs, void* vertices, int vertexCount,
									   int color, void* context );
typedef void ( *b2volDrawSolidPolygonFcn )( float tx, float ty, float qc, float qs, void* vertices, int vertexCount,
											float radius, int color, void* context );
typedef void ( *b2volDrawCircleFcn )( float cx, float cy, float radius, int color, void* context );
typedef void ( *b2volDrawSolidCircleFcn )( float tx, float ty, float qc, float qs, float cx, float cy, float radius,
										   int color, void* context );
typedef void ( *b2volDrawSolidCapsuleFcn )( float p1x, float p1y, float p2x, float p2y, float radius, int color,
											void* context );
typedef void ( *b2volDrawLineFcn )( float p1x, float p1y, float p2x, float p2y, int color, void* context );
typedef void ( *b2volDrawTransformFcn )( float tx, float ty, float qc, float qs, void* context );
typedef void ( *b2volDrawPointFcn )( float px, float py, float size, int color, void* context );
typedef void ( *b2volDrawStringFcn )( float px, float py, void* text, int color, void* context );
typedef void ( *b2volDrawBoundsFcn )( float lx, float ly, float ux, float uy, int color, void* context );

static b2volDrawPolygonFcn b2vol_drawPolygonSlot = 0;
static b2volDrawSolidPolygonFcn b2vol_drawSolidPolygonSlot = 0;
static b2volDrawCircleFcn b2vol_drawCircleSlot = 0;
static b2volDrawSolidCircleFcn b2vol_drawSolidCircleSlot = 0;
static b2volDrawSolidCapsuleFcn b2vol_drawSolidCapsuleSlot = 0;
static b2volDrawLineFcn b2vol_drawLineSlot = 0;
static b2volDrawTransformFcn b2vol_drawTransformSlot = 0;
static b2volDrawPointFcn b2vol_drawPointSlot = 0;
static b2volDrawStringFcn b2vol_drawStringSlot = 0;
static b2volDrawBoundsFcn b2vol_drawBoundsSlot = 0;

static void b2vol_drawPolygonThunk( b2WorldTransform transform, const b2Vec2* vertices, int vertexCount, b2HexColor color,
									void* context )
{
	if ( b2vol_drawPolygonSlot == 0 )
	{
		return;
	}
	b2vol_drawPolygonSlot( transform.p.x, transform.p.y, transform.q.c, transform.q.s, (void*)vertices, vertexCount,
						   (int)color, context );
}

static void b2vol_drawSolidPolygonThunk( b2WorldTransform transform, const b2Vec2* vertices, int vertexCount, float radius,
										 b2HexColor color, void* context )
{
	if ( b2vol_drawSolidPolygonSlot == 0 )
	{
		return;
	}
	b2vol_drawSolidPolygonSlot( transform.p.x, transform.p.y, transform.q.c, transform.q.s, (void*)vertices, vertexCount,
								radius, (int)color, context );
}

static void b2vol_drawCircleThunk( b2Pos center, float radius, b2HexColor color, void* context )
{
	if ( b2vol_drawCircleSlot == 0 )
	{
		return;
	}
	b2vol_drawCircleSlot( center.x, center.y, radius, (int)color, context );
}

static void b2vol_drawSolidCircleThunk( b2WorldTransform transform, b2Vec2 center, float radius, b2HexColor color,
										void* context )
{
	if ( b2vol_drawSolidCircleSlot == 0 )
	{
		return;
	}
	b2vol_drawSolidCircleSlot( transform.p.x, transform.p.y, transform.q.c, transform.q.s, center.x, center.y, radius,
							   (int)color, context );
}

static void b2vol_drawSolidCapsuleThunk( b2Pos p1, b2Pos p2, float radius, b2HexColor color, void* context )
{
	if ( b2vol_drawSolidCapsuleSlot == 0 )
	{
		return;
	}
	b2vol_drawSolidCapsuleSlot( p1.x, p1.y, p2.x, p2.y, radius, (int)color, context );
}

static void b2vol_drawLineThunk( b2Pos p1, b2Pos p2, b2HexColor color, void* context )
{
	if ( b2vol_drawLineSlot == 0 )
	{
		return;
	}
	b2vol_drawLineSlot( p1.x, p1.y, p2.x, p2.y, (int)color, context );
}

static void b2vol_drawTransformThunk( b2WorldTransform transform, void* context )
{
	if ( b2vol_drawTransformSlot == 0 )
	{
		return;
	}
	b2vol_drawTransformSlot( transform.p.x, transform.p.y, transform.q.c, transform.q.s, context );
}

static void b2vol_drawPointThunk( b2Pos p, float size, b2HexColor color, void* context )
{
	if ( b2vol_drawPointSlot == 0 )
	{
		return;
	}
	b2vol_drawPointSlot( p.x, p.y, size, (int)color, context );
}

static void b2vol_drawStringThunk( b2Pos p, const char* s, b2HexColor color, void* context )
{
	if ( b2vol_drawStringSlot == 0 )
	{
		return;
	}
	b2vol_drawStringSlot( p.x, p.y, (void*)s, (int)color, context );
}

static void b2vol_drawBoundsThunk( b2AABB aabb, b2HexColor color, void* context )
{
	if ( b2vol_drawBoundsSlot == 0 )
	{
		return;
	}
	b2vol_drawBoundsSlot( aabb.lowerBound.x, aabb.lowerBound.y, aabb.upperBound.x, aabb.upperBound.y, (int)color,
						  context );
}

// ---- debug draw field installers
static inline void b2vol_debugDraw_setDrawPolygonFcn( b2DebugDraw* draw, b2volDrawPolygonFcn fcn )
{
	b2vol_drawPolygonSlot = fcn;
	draw->DrawPolygonFcn = fcn != 0 ? b2vol_drawPolygonThunk : 0;
}

static inline void b2vol_debugDraw_setDrawSolidPolygonFcn( b2DebugDraw* draw, b2volDrawSolidPolygonFcn fcn )
{
	b2vol_drawSolidPolygonSlot = fcn;
	draw->DrawSolidPolygonFcn = fcn != 0 ? b2vol_drawSolidPolygonThunk : 0;
}

static inline void b2vol_debugDraw_setDrawCircleFcn( b2DebugDraw* draw, b2volDrawCircleFcn fcn )
{
	b2vol_drawCircleSlot = fcn;
	draw->DrawCircleFcn = fcn != 0 ? b2vol_drawCircleThunk : 0;
}

static inline void b2vol_debugDraw_setDrawSolidCircleFcn( b2DebugDraw* draw, b2volDrawSolidCircleFcn fcn )
{
	b2vol_drawSolidCircleSlot = fcn;
	draw->DrawSolidCircleFcn = fcn != 0 ? b2vol_drawSolidCircleThunk : 0;
}

static inline void b2vol_debugDraw_setDrawSolidCapsuleFcn( b2DebugDraw* draw, b2volDrawSolidCapsuleFcn fcn )
{
	b2vol_drawSolidCapsuleSlot = fcn;
	draw->DrawSolidCapsuleFcn = fcn != 0 ? b2vol_drawSolidCapsuleThunk : 0;
}

static inline void b2vol_debugDraw_setDrawLineFcn( b2DebugDraw* draw, b2volDrawLineFcn fcn )
{
	b2vol_drawLineSlot = fcn;
	draw->DrawLineFcn = fcn != 0 ? b2vol_drawLineThunk : 0;
}

static inline void b2vol_debugDraw_setDrawTransformFcn( b2DebugDraw* draw, b2volDrawTransformFcn fcn )
{
	b2vol_drawTransformSlot = fcn;
	draw->DrawTransformFcn = fcn != 0 ? b2vol_drawTransformThunk : 0;
}

static inline void b2vol_debugDraw_setDrawPointFcn( b2DebugDraw* draw, b2volDrawPointFcn fcn )
{
	b2vol_drawPointSlot = fcn;
	draw->DrawPointFcn = fcn != 0 ? b2vol_drawPointThunk : 0;
}

static inline void b2vol_debugDraw_setDrawStringFcn( b2DebugDraw* draw, b2volDrawStringFcn fcn )
{
	b2vol_drawStringSlot = fcn;
	draw->DrawStringFcn = fcn != 0 ? b2vol_drawStringThunk : 0;
}

static inline void b2vol_debugDraw_setDrawBoundsFcn( b2DebugDraw* draw, b2volDrawBoundsFcn fcn )
{
	b2vol_drawBoundsSlot = fcn;
	draw->DrawBoundsFcn = fcn != 0 ? b2vol_drawBoundsThunk : 0;
}

// ---- world definition function pointer fields
static inline void b2vol_worldDef_setFrictionCallback( b2WorldDef* def, b2FrictionCallbackFcn* fcn )
{
	def->frictionCallback = fcn;
}

static inline b2FrictionCallbackFcn* b2vol_worldDef_getFrictionCallback( const b2WorldDef* def )
{
	return def->frictionCallback;
}

static inline void b2vol_worldDef_setRestitutionCallback( b2WorldDef* def, b2RestitutionCallbackFcn* fcn )
{
	def->restitutionCallback = fcn;
}

static inline b2RestitutionCallbackFcn* b2vol_worldDef_getRestitutionCallback( const b2WorldDef* def )
{
	return def->restitutionCallback;
}

static inline void b2vol_worldDef_setEnqueueTask( b2WorldDef* def, b2EnqueueTaskCallbackFcn* fcn )
{
	def->enqueueTask = fcn;
}

static inline b2EnqueueTaskCallbackFcn* b2vol_worldDef_getEnqueueTask( const b2WorldDef* def )
{
	return def->enqueueTask;
}

static inline void b2vol_worldDef_setFinishTask( b2WorldDef* def, b2FinishTaskCallbackFcn* fcn )
{
	def->finishTask = fcn;
}

static inline b2FinishTaskCallbackFcn* b2vol_worldDef_getFinishTask( const b2WorldDef* def )
{
	return def->finishTask;
}

// ---------------------------------------------------------------------------
// 3. out-scalar shims
// ---------------------------------------------------------------------------

static uint64_t b2vol_ticksSlot = 0;

static inline float b2vol_getMillisecondsAndReset( void )
{
	return b2GetMillisecondsAndReset( &b2vol_ticksSlot );
}

static inline int64_t b2vol_getResetTicks( void )
{
	return (int64_t)b2vol_ticksSlot;
}

static float b2vol_ctHertz = 0.0f;
static float b2vol_ctDamping = 0.0f;
static float b2vol_ctSpeed = 0.0f;

static inline void b2vol_world_getContactTuning( b2WorldId worldId )
{
	b2World_GetContactTuning( worldId, &b2vol_ctHertz, &b2vol_ctDamping, &b2vol_ctSpeed );
}

static inline float b2vol_ct_hertz( void ) { return b2vol_ctHertz; }
static inline float b2vol_ct_damping( void ) { return b2vol_ctDamping; }
static inline float b2vol_ct_speed( void ) { return b2vol_ctSpeed; }

static float b2vol_jHertz = 0.0f;
static float b2vol_jDamping = 0.0f;

static inline void b2vol_joint_getConstraintTuning( b2JointId jointId )
{
	b2Joint_GetConstraintTuning( jointId, &b2vol_jHertz, &b2vol_jDamping );
}

static inline float b2vol_jt_hertz( void ) { return b2vol_jHertz; }
static inline float b2vol_jt_damping( void ) { return b2vol_jDamping; }

static float b2vol_djLowerForce = 0.0f;
static float b2vol_djUpperForce = 0.0f;

static inline void b2vol_distanceJoint_getSpringForceRange( b2JointId jointId )
{
	b2DistanceJoint_GetSpringForceRange( jointId, &b2vol_djLowerForce, &b2vol_djUpperForce );
}

static inline float b2vol_dj_lowerForce( void ) { return b2vol_djLowerForce; }
static inline float b2vol_dj_upperForce( void ) { return b2vol_djUpperForce; }

static float b2vol_lenSlot = 0.0f;

static inline b2Vec2 b2vol_getLengthAndNormalize( b2Vec2 a )
{
	return b2GetLengthAndNormalize( &b2vol_lenSlot, a );
}

static inline float b2vol_lengthSlot( void ) { return b2vol_lenSlot; }

// ---------------------------------------------------------------------------
// 4. field accessors
// ---------------------------------------------------------------------------

// --- b2BodyDef (b2BodyType type / const char* name / void* userData)
static inline int b2vol_bodyDef_getType( const b2BodyDef* def ) { return (int)def->type; }
static inline void b2vol_bodyDef_setType( b2BodyDef* def, int value ) { def->type = (b2BodyType)value; }
static inline void b2vol_bodyDef_setName( b2BodyDef* def, const char* name ) { def->name = b2vol_storeName( name ); }
static inline void* b2vol_bodyDef_getName( const b2BodyDef* def ) { return (void*)def->name; }
static inline void* b2vol_bodyDef_getUserData( const b2BodyDef* def ) { return def->userData; }
static inline void b2vol_bodyDef_setUserData( b2BodyDef* def, void* value ) { def->userData = value; }

// --- b2ShapeDef userData
static inline void* b2vol_shapeDef_getUserData( const b2ShapeDef* def ) { return def->userData; }
static inline void b2vol_shapeDef_setUserData( b2ShapeDef* def, void* value ) { def->userData = value; }

// --- b2ChainDef userData / points / materials
static inline void* b2vol_chainDef_getUserData( const b2ChainDef* def ) { return def->userData; }
static inline void b2vol_chainDef_setUserData( b2ChainDef* def, void* value ) { def->userData = value; }
static inline void* b2vol_chainDef_getPoints( const b2ChainDef* def ) { return (void*)def->points; }
static inline void b2vol_chainDef_setPoints( b2ChainDef* def, void* value ) { def->points = (const b2Vec2*)value; }
static inline void* b2vol_chainDef_getMaterials( const b2ChainDef* def ) { return (void*)def->materials; }
static inline void b2vol_chainDef_setMaterials( b2ChainDef* def, void* value )
{
	def->materials = (const b2SurfaceMaterial*)value;
}

// --- b2WorldDef pointer fields
static inline void* b2vol_worldDef_getUserTaskContext( const b2WorldDef* def ) { return def->userTaskContext; }
static inline void b2vol_worldDef_setUserTaskContext( b2WorldDef* def, void* value ) { def->userTaskContext = value; }
static inline void* b2vol_worldDef_getUserData( const b2WorldDef* def ) { return def->userData; }
static inline void b2vol_worldDef_setUserData( b2WorldDef* def, void* value ) { def->userData = value; }

// --- b2JointDef userData
static inline void* b2vol_jointDef_getUserData( const b2JointDef* def ) { return def->userData; }
static inline void b2vol_jointDef_setUserData( b2JointDef* def, void* value ) { def->userData = value; }

// --- b2DebugDraw context
static inline void* b2vol_debugDraw_getContext( const b2DebugDraw* draw ) { return draw->context; }
static inline void b2vol_debugDraw_setContext( b2DebugDraw* draw, void* value ) { draw->context = value; }

// --- b2BodyMoveEvent userData
static inline void* b2vol_bodyMoveEvent_getUserData( const b2BodyMoveEvent* e ) { return e->userData; }
static inline void b2vol_bodyMoveEvent_setUserData( b2BodyMoveEvent* e, void* value ) { e->userData = value; }

// --- b2JointEvent userData
static inline void* b2vol_jointEvent_getUserData( const b2JointEvent* e ) { return e->userData; }
static inline void b2vol_jointEvent_setUserData( b2JointEvent* e, void* value ) { e->userData = value; }

// --- b2Polygon vertices[8] / normals[8]
static inline b2Vec2 b2vol_polygon_getVertex( const b2Polygon* p, int index ) { return p->vertices[index]; }
static inline void b2vol_polygon_setVertex( b2Polygon* p, int index, b2Vec2 value ) { p->vertices[index] = value; }
static inline b2Vec2 b2vol_polygon_getNormal( const b2Polygon* p, int index ) { return p->normals[index]; }
static inline void b2vol_polygon_setNormal( b2Polygon* p, int index, b2Vec2 value ) { p->normals[index] = value; }

// --- b2Hull points[8]
static inline b2Vec2 b2vol_hull_getPoint( const b2Hull* h, int index ) { return h->points[index]; }
static inline void b2vol_hull_setPoint( b2Hull* h, int index, b2Vec2 value ) { h->points[index] = value; }

// --- b2ShapeProxy points[8]
static inline b2Vec2 b2vol_shapeProxy_getPoint( const b2ShapeProxy* p, int index ) { return p->points[index]; }
static inline void b2vol_shapeProxy_setPoint( b2ShapeProxy* p, int index, b2Vec2 value ) { p->points[index] = value; }

// --- b2Manifold points[2]
static inline b2ManifoldPoint b2vol_manifold_getPoint( const b2Manifold* m, int index ) { return m->points[index]; }
static inline void b2vol_manifold_setPoint( b2Manifold* m, int index, b2ManifoldPoint value )
{
	m->points[index] = value;
}

// --- b2LocalManifold points[2]
static inline b2LocalManifoldPoint b2vol_localManifold_getPoint( const b2LocalManifold* m, int index )
{
	return m->points[index];
}
static inline void b2vol_localManifold_setPoint( b2LocalManifold* m, int index, b2LocalManifoldPoint value )
{
	m->points[index] = value;
}

// --- b2Counters colorCounts[24]
static inline int b2vol_counters_getColorCount( const b2Counters* c, int index ) { return c->colorCounts[index]; }
static inline void b2vol_counters_setColorCount( b2Counters* c, int index, int value ) { c->colorCounts[index] = value; }

// --- b2SimplexCache indexA[3] / indexB[3]
static inline int b2vol_simplexCache_getIndexA( const b2SimplexCache* c, int index ) { return (int)c->indexA[index]; }
static inline void b2vol_simplexCache_setIndexA( b2SimplexCache* c, int index, int value )
{
	c->indexA[index] = (uint8_t)value;
}
static inline int b2vol_simplexCache_getIndexB( const b2SimplexCache* c, int index ) { return (int)c->indexB[index]; }
static inline void b2vol_simplexCache_setIndexB( b2SimplexCache* c, int index, int value )
{
	c->indexB[index] = (uint8_t)value;
}

// --- b2TOIOutput state (b2TOIState)
static inline int b2vol_toiOutput_getState( const b2TOIOutput* o ) { return (int)o->state; }
static inline void b2vol_toiOutput_setState( b2TOIOutput* o, int value ) { o->state = (b2TOIState)value; }

// --- b2ReplayQueryInfo type (b2ReplayQueryType)
static inline int b2vol_replayQueryInfo_getType( const b2ReplayQueryInfo* i ) { return (int)i->type; }
static inline void b2vol_replayQueryInfo_setType( b2ReplayQueryInfo* i, int value )
{
	i->type = (b2ReplayQueryType)value;
}

// --- b2SensorEvents beginEvents / endEvents
static inline void* b2vol_sensorEvents_getBeginEvents( const b2SensorEvents* e ) { return (void*)e->beginEvents; }
static inline b2SensorBeginTouchEvent b2vol_sensorEvents_getBeginEvent( const b2SensorEvents* e, int index )
{
	return e->beginEvents[index];
}
static inline void* b2vol_sensorEvents_getEndEvents( const b2SensorEvents* e ) { return (void*)e->endEvents; }
static inline b2SensorEndTouchEvent b2vol_sensorEvents_getEndEvent( const b2SensorEvents* e, int index )
{
	return e->endEvents[index];
}

// --- b2ContactEvents beginEvents / endEvents / hitEvents
static inline void* b2vol_contactEvents_getBeginEvents( const b2ContactEvents* e ) { return (void*)e->beginEvents; }
static inline b2ContactBeginTouchEvent b2vol_contactEvents_getBeginEvent( const b2ContactEvents* e, int index )
{
	return e->beginEvents[index];
}
static inline void* b2vol_contactEvents_getEndEvents( const b2ContactEvents* e ) { return (void*)e->endEvents; }
static inline b2ContactEndTouchEvent b2vol_contactEvents_getEndEvent( const b2ContactEvents* e, int index )
{
	return e->endEvents[index];
}
static inline void* b2vol_contactEvents_getHitEvents( const b2ContactEvents* e ) { return (void*)e->hitEvents; }
static inline b2ContactHitEvent b2vol_contactEvents_getHitEvent( const b2ContactEvents* e, int index )
{
	return e->hitEvents[index];
}

// --- b2BodyEvents moveEvents
static inline void* b2vol_bodyEvents_getMoveEvents( const b2BodyEvents* e ) { return (void*)e->moveEvents; }
static inline b2BodyMoveEvent b2vol_bodyEvents_getMoveEvent( const b2BodyEvents* e, int index )
{
	return e->moveEvents[index];
}

// --- b2JointEvents jointEvents
static inline void* b2vol_jointEvents_getJointEvents( const b2JointEvents* e ) { return (void*)e->jointEvents; }
static inline b2JointEvent b2vol_jointEvents_getJointEvent( const b2JointEvents* e, int index )
{
	return e->jointEvents[index];
}


// ---- debug draw getters (return the user level pointer stored in the slot)
static inline b2volDrawPolygonFcn b2vol_debugDraw_getDrawPolygonFcn( const b2DebugDraw* draw )
{
	(void)draw;
	return b2vol_drawPolygonSlot;
}

static inline b2volDrawSolidPolygonFcn b2vol_debugDraw_getDrawSolidPolygonFcn( const b2DebugDraw* draw )
{
	(void)draw;
	return b2vol_drawSolidPolygonSlot;
}

static inline b2volDrawCircleFcn b2vol_debugDraw_getDrawCircleFcn( const b2DebugDraw* draw )
{
	(void)draw;
	return b2vol_drawCircleSlot;
}

static inline b2volDrawSolidCircleFcn b2vol_debugDraw_getDrawSolidCircleFcn( const b2DebugDraw* draw )
{
	(void)draw;
	return b2vol_drawSolidCircleSlot;
}

static inline b2volDrawSolidCapsuleFcn b2vol_debugDraw_getDrawSolidCapsuleFcn( const b2DebugDraw* draw )
{
	(void)draw;
	return b2vol_drawSolidCapsuleSlot;
}

static inline b2volDrawLineFcn b2vol_debugDraw_getDrawLineFcn( const b2DebugDraw* draw )
{
	(void)draw;
	return b2vol_drawLineSlot;
}

static inline b2volDrawTransformFcn b2vol_debugDraw_getDrawTransformFcn( const b2DebugDraw* draw )
{
	(void)draw;
	return b2vol_drawTransformSlot;
}

static inline b2volDrawPointFcn b2vol_debugDraw_getDrawPointFcn( const b2DebugDraw* draw )
{
	(void)draw;
	return b2vol_drawPointSlot;
}

static inline b2volDrawStringFcn b2vol_debugDraw_getDrawStringFcn( const b2DebugDraw* draw )
{
	(void)draw;
	return b2vol_drawStringSlot;
}

static inline b2volDrawBoundsFcn b2vol_debugDraw_getDrawBoundsFcn( const b2DebugDraw* draw )
{
	(void)draw;
	return b2vol_drawBoundsSlot;
}

// ---- b2InternalAssert only exists when the static library was built with asserts.
// In a release library the symbol is absent, so the binding goes through this shim
// which degrades to a no-op exactly like the B2_ASSERT macro does.
static inline int b2vol_internalAssert( const char* condition, const char* fileName, int lineNumber )
{
#if !defined( NDEBUG ) || defined( B2_ENABLE_ASSERT )
	return b2InternalAssert( condition, fileName, lineNumber );
#else
	(void)condition;
	(void)fileName;
	(void)lineNumber;
	return 0;
#endif
}

#endif // B2VOL_H
