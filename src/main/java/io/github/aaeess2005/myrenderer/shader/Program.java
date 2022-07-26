package io.github.aaeess2005.myrenderer.shader;

import static org.lwjgl.opengl.GL33.*;

public class Program {
    public final int id;

    public Program(VertexShader[] vsh, FragmentShader[] fsh) {
        id = glCreateProgram();
        for (VertexShader i : vsh) {
            glAttachShader(id, i.id);
        }
        for (FragmentShader i : fsh) {
            glAttachShader(id, i.id);
        }
        glLinkProgram(id);
        for (VertexShader i : vsh) {
            glDeleteShader(i.id);
        }
        for (FragmentShader i : fsh) {
            glDeleteShader(i.id);
        }
    }

    public void use() {
        glUseProgram(id);
    }

    public void delete() {
        glDeleteProgram(id);
    }
}
