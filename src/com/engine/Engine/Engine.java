package com.engine.Engine;
import com.engine.Callbacks.Callbacks;
import com.engine.Shader.Triangle;
import com.engine.Window.Window;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11C.*;
public class Engine {
    long id = 0;
    Window window = new Window(id);
    Triangle triangle = new Triangle();
    public void run() throws Exception {
        if (!glfwInit()) {
            glfwTerminate();
        }
        glfwWindowHint(GLFW_CONTEXT_VERSION_MAJOR, 4);
        glfwWindowHint(GLFW_CONTEXT_VERSION_MINOR, 6);
        glfwWindowHint(GLFW_OPENGL_PROFILE, GLFW_OPENGL_CORE_PROFILE);
        window.createWindow(800,600,"LGOL");
        triangle.initbuf();
        triangle.initvert();
    }

    public void update(){
        glClearColor(0.2f, 0.3f, 0.3f, 1.0f);

        glClear(GL_COLOR_BUFFER_BIT);


    }

    public void loop(){
        while (!glfwWindowShouldClose(window.getWindowId())) {

            Callbacks.processInput(window.getWindowId());

            update();

            triangle.render();

            glfwSwapBuffers(window.getWindowId());
            glfwPollEvents();
        }
        terminate();
        triangle.dealocate();
    }
    public void terminate(){
        glfwTerminate();
    }
}
