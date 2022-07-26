package io.github.aaeess2005.myrenderer.mesh;

import io.github.aaeess2005.myrenderer.vertex.Vertex;
import org.joml.Vector2f;
import org.joml.Vector3f;
import org.joml.Vector4f;
import org.lwjgl.system.MemoryUtil;

import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.opengl.GL33.*;

public class MeshBuilder {
    private List<Vertex> list=new ArrayList<>();
    public void vertex(float x,float y,float z,float r,float g,float b,float a,float s,float t){
        list.add(new Vertex(x,y,z,r,g,b,a,s,t));
    }
    public void vertex(Vector3f position, Vector4f color, Vector2f uv){
        list.add(new Vertex(position,color,uv));
    }
    public Mesh build(){
        FloatBuffer vertexBuffer=MemoryUtil.memAllocFloat((3+4+2)*list.size());
        for(Vertex vex : list){
            vertexBuffer.put(vex.position.x);
            vertexBuffer.put(vex.position.y);
            vertexBuffer.put(vex.position.z);
            vertexBuffer.put(vex.color.x);
            vertexBuffer.put(vex.color.y);
            vertexBuffer.put(vex.color.z);
            vertexBuffer.put(vex.color.w);
            vertexBuffer.put(vex.uv.x);
            vertexBuffer.put(vex.uv.y);
        }


        int vao=glGenVertexArrays(),vbo=glGenBuffers();
        glBindVertexArray(vao);
        glBindBuffer(GL_ARRAY_BUFFER, vbo);
        glBufferData(GL_ARRAY_BUFFER, vertexBuffer, GL_STATIC_DRAW);

        glVertexAttribPointer(0, 3, GL_FLOAT, false, 0, 0);
        glEnableVertexAttribArray(0);
        glVertexAttribPointer(1, 4, GL_FLOAT, false, 0, 3*4);
        glEnableVertexAttribArray(1);
        glVertexAttribPointer(2, 2, GL_FLOAT, false, 0, 7*4);
        glEnableVertexAttribArray(2);

        glBindVertexArray(0);
        return new Mesh(vao,vbo,list.size());
    }
}
