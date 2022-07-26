package io.github.aaeess2005.myrenderer.mesh;

import io.github.aaeess2005.myrenderer.texture.Texture;

import static org.lwjgl.opengl.GL33.*;

public class Mesh {
    private int vao,vbo;
    private int vertexNum;
    private Texture texture;

    protected Mesh(int vao,int vbo,int vertexNum){
        this.vao=vao;
        this.vbo=vbo;
        this.vertexNum=vertexNum;
    }

    public void bindTexture(Texture texture){
        this.texture=texture;
    }

    public void render(){
        if(texture!=null){
            glBindTexture(GL_TEXTURE_2D, texture.getId());
        }
        glBindVertexArray(vao);
        glDrawArrays(GL_TRIANGLES, 0, vertexNum);
    }
}
