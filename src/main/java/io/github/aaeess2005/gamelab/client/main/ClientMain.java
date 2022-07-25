package io.github.aaeess2005.gamelab.client.main;

import io.github.aaeess2005.gamelab.SharedConstants;
import io.github.aaeess2005.gamelab.util.DeltaUtil;
import org.lwjgl.Version;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.glfw.GLFWKeyCallback;
import org.lwjgl.glfw.GLFWKeyCallbackI;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.opengl.GL;
import org.lwjgl.system.MemoryStack;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

        GLFWErrorCallback.createPrint(System.err).set();
        if (!glfwInit()) {
            logger.error("Unable to initialize GLFW");
            throw new IllegalStateException("Unable to initialize GLFW");
        }

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

        try (MemoryStack stack = stackPush()) {
            IntBuffer pWidth = stack.mallocInt(1);
            IntBuffer pHeight = stack.mallocInt(1);

            // Get the window size passed to glfwCreateWindow
            glfwGetWindowSize(window, pWidth, pHeight);
            // Get the resolution of the primary monitor
            GLFWVidMode vidmode = glfwGetVideoMode(glfwGetPrimaryMonitor());
            // Center the window
            glfwSetWindowPos(window, (vidmode.width() - pWidth.get(0)) / 2, (vidmode.height() - pHeight.get(0)) / 2);
        } // the stack frame is popped automatically
        // Make the OpenGL context current
        glfwMakeContextCurrent(window);
        GL.createCapabilities();
        // Make the window visible
        glfwShowWindow(window);


        glClearColor(0, 1, 1, 1);
        glEnable(GL_DEPTH_TEST);
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

    public void render() {
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

        glfwSwapBuffers(window);
    }

    public void stop() {
        glfwFreeCallbacks(window);
        glfwDestroyWindow(window);
        glfwTerminate();
        glfwSetErrorCallback(null).free();
    }
}
