package com.aluracursos.principal;

import com.aluracursos.modulos.GuardarPelicula;
import com.aluracursos.modulos.Pelicula;
import com.aluracursos.modulos.SwapiPelicula;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner lectura = new Scanner(System.in);

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_DASHES)
                .setPrettyPrinting()
                .create();



        while (true) {

            System.out.println(""" 
                    \n********* Busqueda Star Wars*************
                    Seleccione la Pelicula para mostrar su informacion 
                                   
                    1. A New Hope
                    2. The Empire Strikes Back
                    3. Return of the Jedi
                    4. The Phantom Menace
                    5. Attack of the Clones
                    6. Revenge of the Sith
                    7. The Force Awakens
                    0. Salir
                                   
                    ************************************
                    """);

            var busqueda = lectura.nextInt();
            if (busqueda == 0) {
                break;
            }

            var direccion = "https://swapi.py4e.com/api/films/" + busqueda + "/";

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(direccion))
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();


            //Pelicula miPelicula = gson.fromJson(json, Pelicula.class);
            SwapiPelicula swapiPelicula = gson.fromJson(json, SwapiPelicula.class);

            Pelicula miPelicula = new Pelicula(swapiPelicula);

            GuardarPelicula guardarPelicula = new GuardarPelicula();

            switch (busqueda) {
                case 1:
                    System.out.println(miPelicula);
                    guardarPelicula.generarArchivo(miPelicula);
                    break;
                case 2:
                    System.out.println(miPelicula);
                    guardarPelicula.generarArchivo(miPelicula);
                    break;
                case 3:
                    System.out.println(miPelicula);
                    guardarPelicula.generarArchivo(miPelicula);
                    break;
                case 4:
                    System.out.println(miPelicula);
                    guardarPelicula.generarArchivo(miPelicula);
                    break;
                case 5:
                    System.out.println(miPelicula);
                    guardarPelicula.generarArchivo(miPelicula);
                    break;
                case 6:
                    System.out.println(miPelicula);
                    guardarPelicula.generarArchivo(miPelicula);
                    break;
                case 7:
                    System.out.println(miPelicula);
                    guardarPelicula.generarArchivo(miPelicula);
                    break;

            }

        }

        System.out.println("Busqueda Finalizada! :)");
        System.out.println("Se generaron Json de las peliculas consultadas");

    }
}
