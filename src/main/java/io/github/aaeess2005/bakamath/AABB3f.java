package io.github.aaeess2005.bakamath;

import org.joml.Vector3f;

public class AABB3f {
    public Vector3f boxMin;
    public Vector3f boxMax;

    public AABB3f(Vector3f boxMin, Vector3f boxMax) {
        this.boxMin = boxMin;
        this.boxMax = boxMax;
    }

    public AABB3f() {
        boxMin = new Vector3f(0, 0, 0);
        boxMax = new Vector3f(0, 0, 0);
    }
}
