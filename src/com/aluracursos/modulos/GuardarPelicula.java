package com.aluracursos.modulos;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;


public class GuardarPelicula {

    public void generarArchivo(Pelicula pelicula) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter escritura = new FileWriter(pelicula.getTitulo()+".json");
        escritura.write(gson.toJson(pelicula));
        escritura.close();
    }
}
