package com.engine.Framebuffer;

import org.lwjgl.glfw.GLFWFramebufferSizeCallbackI;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;

public class Framebuffer {


    public static GLFWFramebufferSizeCallbackI framebuffer_size_callback(int w, int h) {
        GL.createCapabilities();
        GL11.glViewport(0,0,w,h);
        return null;
    }
}
