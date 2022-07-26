package io.github.aaeess2005.myrenderer.vertex;

import org.joml.Vector2f;
import org.joml.Vector3f;
import org.joml.Vector4f;

public class Vertex {
    public Vector3f position;
    public Vector4f color;
    public Vector2f uv;

    public Vertex(float x, float y, float z, float r, float g, float b, float a, float s, float t) {
        this.position = new Vector3f(x, y, z);
        this.color = new Vector4f(r, g, b, a);
        this.uv = new Vector2f(s, t);
    }

    public Vertex(Vector3f position, Vector4f color, Vector2f uv) {
        this.position = position;
        this.color = color;
        this.uv = uv;
    }
}
