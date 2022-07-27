package io.github.aaeess2005.gamelab.client.main;

import io.github.aaeess2005.gamelab.SharedConstants;
import io.github.aaeess2005.gamelab.util.DeltaUtil;
import io.github.aaeess2005.gamelab.util.ResourceUtil;
import io.github.aaeess2005.myrenderer.mesh.Mesh;
import io.github.aaeess2005.myrenderer.mesh.MeshBuilder;
import io.github.aaeess2005.myrenderer.shader.FragmentShader;
import io.github.aaeess2005.myrenderer.shader.Program;
import io.github.aaeess2005.myrenderer.shader.VertexShader;
import io.github.aaeess2005.myrenderer.texture.Texture;
import io.github.aaeess2005.myrenderer.texture.TextureBuilder;
import org.lwjgl.Version;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.opengl.GL;
import org.lwjgl.stb.STBImage;
import org.lwjgl.system.MemoryStack;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.IntBuffer;

import static org.lwjgl.glfw.Callbacks.glfwFreeCallbacks;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL33.*;
import static org.lwjgl.system.MemoryStack.stackPush;
import static org.lwjgl.system.MemoryUtil.NULL;

public class ClientMain implements Runnable {
    private static final Logger logger = LoggerFactory.getLogger("Client");
    private long window;
    private int width, height;

    public ClientMain(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public void run() {
        initClient();
        inputCallback();
        while (!glfwWindowShouldClose(window)) {
            input();
            render();
            glfwPollEvents();
            DeltaUtil.resetDelta();
        }
        stop();
    }

    public void initClient() {
        logger.info("LWJGL Version" + Version.getVersion());

        setErrorCallback();
        createWindow();
        centerWindow();
        makeGLContext();
        glfwShowWindow(window);
        glInit();
    }

    public void inputCallback() {
        glfwSetKeyCallback(window, (window, key, scancode, action, mods) -> {
            if (key == GLFW_KEY_ESCAPE && action == GLFW_RELEASE) {
                glfwSetWindowShouldClose(window, true);
            }
            if (key == GLFW_KEY_ESCAPE && action == GLFW_RELEASE) {
                glfwSetWindowShouldClose(window, true);
            }
        });
    }

    public void input() {
    }
    Texture t;
    public void render() {
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT | GL_STENCIL_BUFFER_BIT);

        ////////For Testing
        try {
            new Program(new VertexShader[]{new VertexShader(new String(ResourceUtil.getResourceAsBytes("gamelab/render/shader/begin.vsh")))},
                    new FragmentShader[]{new FragmentShader(new String(ResourceUtil.getResourceAsBytes("gamelab/render/shader/begin.fsh")))}
            ).use();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            t = new TextureBuilder().build(ResourceUtil.getResourceAsByteBuffer("gamelab/render/texture/noise.png"),GL_MIRRORED_REPEAT,GL_MIRRORED_REPEAT,GL_NEAREST,GL_NEAREST);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        MeshBuilder mesh = new MeshBuilder();
        mesh.vertex(0, 0.5f, 0.5f, 1, 0, 0, 1, 0, 0);
        mesh.vertex(-0.4f, -0.5f, 0.5f, 0, 1, 0, 1, 1, 0);
        mesh.vertex(0.4f, -0.5f, 0.5f, 0, 0, 1, 1, 1, 1);
        Mesh m=mesh.build();
        m.bindTexture(t);
        m.render();
        ////////

        glfwSwapBuffers(window);
    }

    public void stop() {
        glfwFreeCallbacks(window);
        glfwDestroyWindow(window);
        glfwTerminate();
        glfwSetErrorCallback(null).free();
    }

    private void setErrorCallback() {
        GLFWErrorCallback.createPrint(System.err).set();
        if (!glfwInit()) {
            logger.error("Unable to initialize GLFW");
            throw new IllegalStateException("Unable to initialize GLFW");
        }
    }

    private void createWindow() {
        glfwWindowHint(GLFW_CONTEXT_VERSION_MAJOR, 3);
        glfwWindowHint(GLFW_CONTEXT_VERSION_MINOR, 3);
        glfwWindowHint(GLFW_OPENGL_PROFILE, GLFW_OPENGL_CORE_PROFILE);
        glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE);
        glfwWindowHint(GLFW_RESIZABLE, GLFW_FALSE);

        String title = "GameLab  " + SharedConstants.versionName;
        window = glfwCreateWindow(width, height, title, NULL, NULL);
        if (window == NULL) {
            logger.error("Failed to create the GLFW window");
            throw new RuntimeException("Failed to create the GLFW window");
        }
    }

    private void centerWindow() {
        try (MemoryStack stack = stackPush()) {
            IntBuffer pWidth = stack.mallocInt(1);
            IntBuffer pHeight = stack.mallocInt(1);

            glfwGetWindowSize(window, pWidth, pHeight);
            GLFWVidMode vidmode = glfwGetVideoMode(glfwGetPrimaryMonitor());
            glfwSetWindowPos(window, (vidmode.width() - pWidth.get(0)) / 2, (vidmode.height() - pHeight.get(0)) / 2);
        }
    }

    private void makeGLContext() {
        glfwMakeContextCurrent(window);
        GL.createCapabilities();
    }

    private void glInit() {
        glClearColor(0, 1, 1, 1);
        glEnable(GL_DEPTH_TEST);
        glEnable(GL_STENCIL_TEST);
        glEnable(GL_CULL_FACE);
        glCullFace(GL_BACK);
        glFrontFace(GL_CCW);
    }
}
