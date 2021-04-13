package com.engine.Shader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import static org.lwjgl.opengl.ARBVertexArrayObject.*;
import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL20.*;

public class Triangle {
    public int vaoid;
    public int vboid;
    Shader  shader= new Shader();
    float[] vertices = new float[]{
            // positions         // colors
            0.5f, -0.5f, 0.0f,  1.0f, 0.0f, 0.0f,  // bottom right
            -0.5f, -0.5f, 0.0f,  0.0f, 1.0f, 0.0f,  // bottom left
            0.0f,  0.5f, 0.0f,  0.0f, 0.0f, 1.0f   // top
    };


    public void initbuf () throws Exception {
        File file = new File("C:\\JavaGameDev\\Lwjgl3-Game-Engine-Programming-Series-starting_code\\2dEngine\\src\\com\\engine\\Shader\\vsh.glsl");
        File file1 = new File("C:\\JavaGameDev\\Lwjgl3-Game-Engine-Programming-Series-starting_code\\2dEngine\\src\\com\\engine\\Shader\\fsh.glsl");
        BufferedReader vs = new BufferedReader(new FileReader(file));
        BufferedReader fs = new BufferedReader(new FileReader(file1));
        shader.createVertexShader(vs.toString());
        shader.createFragmentShader(fs.toString());
        shader.link();



        this.vaoid = glGenVertexArrays();
        this.vboid = glGenBuffers();
    }
    public void initvert(){

        glBindVertexArray(this.vaoid);
        glBindBuffer(GL_ARRAY_BUFFER,this.vboid);
        glBufferData(GL_ARRAY_BUFFER,vertices.length,1);

        glVertexAttribPointer(0,3,GL_FLOAT,false,0,0);
        glEnableVertexAttribArray(0);
        glVertexAttribPointer(1,3,GL_FLOAT,false,0,0);
        glEnableVertexAttribArray(1);
    }
    public void dealocate(){
        glDisableVertexAttribArray(0);
        glBindBuffer(GL_ARRAY_BUFFER, 0);
        glDeleteBuffers(this.vboid);
        glBindVertexArray(0);
        glDeleteVertexArrays(this.vaoid);
        shader.unbind();
    }
    public void render(){
        shader.bind();
        glBindVertexArray(this.vaoid);
        glDrawArrays(GL_TRIANGLES,0,3);
        shader.unbind();
    }

}