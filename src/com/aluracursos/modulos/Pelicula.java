package com.aluracursos.modulos;

public class Pelicula {

    private String titulo;
    private int episodio;

    private String fechaDeLanzamiento;
    private String director;
    private String productores;

    public Pelicula(SwapiPelicula swapiPelicula) {
        this.titulo = swapiPelicula.title();
        this.episodio = Integer.valueOf(swapiPelicula.episode_id());
        this.fechaDeLanzamiento = swapiPelicula.release_date();

        this.director = swapiPelicula.director();
        this.productores = swapiPelicula.producer();
    }

    //*************GET y SET********************
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }


    public String getFechaDeLanzamiento() {
        return fechaDeLanzamiento;
    }

    public void setFechaDeLanzamiento(String fechaDeLanzamiento) {
        this.fechaDeLanzamiento = fechaDeLanzamiento;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getProductores() {
        return productores;
    }

    public void setProductores(String productores) {
        this.productores = productores;
    }

    @Override
    public String toString() {
        return "Pelicula: {" +
                "titulo: '" + titulo + '\'' +
                ", episodio: " + episodio +
                ", fechaDeLanzamiento: " + fechaDeLanzamiento +
                ", director: '" + director + '\'' +
                ", productores: '" + productores + '\'' +
                '}';
    }
}
