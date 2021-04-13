package com.engine.Window;

import com.engine.Framebuffer.Framebuffer;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.glfw.GLFW.glfwSetFramebufferSizeCallback;

public class Window{
    static long id;
    Framebuffer framebuffer = new Framebuffer();


    public Window(long id){
        this.id = id;
    }


    public void createWindow(int w, int h, String title) {
        this.id = glfwCreateWindow(w, h, title, 0, 0);
        if (this.id == 0) {
            glfwTerminate();
        }
        glfwMakeContextCurrent(this.id);
        glfwSetFramebufferSizeCallback(this.id,framebuffer.framebuffer_size_callback(800,600));
    }

    public long getWindowId(){
        return this.id;
    }
}



