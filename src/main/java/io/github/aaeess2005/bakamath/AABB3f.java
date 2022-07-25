package io.github.aaeess2005.bakamath;

import org.joml.Vector3f;

public class AABB3f {
    public Vector3f boxMin;
    public Vector3f boxMax;

    private AABB3f(Vector3f boxMin, Vector3f boxMax) {
    }

    private AABB3f() {
    }

    public static AABB3f getAABB(Vector3f boxMin, Vector3f boxMax) {
        return new AABB3f(boxMin, boxMax);
    }
}
