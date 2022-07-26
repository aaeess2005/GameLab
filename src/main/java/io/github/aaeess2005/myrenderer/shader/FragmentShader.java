package io.github.aaeess2005.myrenderer.shader;

import org.lwjgl.system.MemoryStack;
import org.slf4j.LoggerFactory;

import java.nio.IntBuffer;

import static org.lwjgl.opengl.GL20.*;

public class FragmentShader {
    public final int id;

    public FragmentShader(String str) {
        id = glCreateShader(GL_FRAGMENT_SHADER);
        glShaderSource(id, str);
        glCompileShader(id);
        try (MemoryStack stack = MemoryStack.stackPush()) {
            IntBuffer success = stack.mallocInt(1);
            glGetShaderiv(id, GL_COMPILE_STATUS, success);
            if (success.get(0) != 1) {
                LoggerFactory.getLogger("OpenGL Debug").error(glGetShaderInfoLog(id, 512));
            }
        }
    }
}
