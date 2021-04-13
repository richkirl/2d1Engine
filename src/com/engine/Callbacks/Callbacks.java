package com.engine.Callbacks;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.glfw.GLFW.glfwSetWindowShouldClose;

public class Callbacks {
    public static void processInput(long id) {
        if(glfwGetKey(id,GLFW_KEY_ESCAPE)== GLFW_PRESS){
            glfwSetWindowShouldClose(id,true);
        }
        if(glfwGetKey(id,GLFW_KEY_ESCAPE)== GLFW_PRESS){

        }
}}
