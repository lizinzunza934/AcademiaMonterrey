package com.academy.tracker.models;

import java.nio.file.FileSystemNotFoundException;

//Herencia (Relacion Is-A)
public class SerieAnimada extends ContenidoVisual {

    //atributos exclusivos de ua serie
    private int capitulosVistos;
    private int totalCapitulos;

    //constructor
    public SerieAnimada(String titulo, int totalCapitulos) {
        //super llama al construcotr de la clase pasre (contenidoVisual) oara que guarde el título
        super(titulo);
        this.capitulosVistos = 0; //todas las series empiezan en cap 0
        this.totalCapitulos = totalCapitulos;
    }

    //metodo especifico de una clase
    public void incrementarCapitulo() {
        if (capitulosVistos < totalCapitulos){
            capitulosVistos++;
            //uso getTitulo() que se hereda del padre, porque nuestro titulo original es private
            System.out.println("Viendo el capitulo " + capitulosVistos + " de " + getTitulo());
        } else {
                System.out.println("Ya terminaste de ver " + getTitulo() + "!");
        }
    }

    //polimorfismo en metodo reporducir
    @Override
    public void reproducir() {
        System.out.println("Reproduciendo intro y preparando el siguiente capítulo de " + getTitulo());
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Serie: " + getTitulo() + " | Progreso: " + capitulosVistos + "/" + totalCapitulos + " | Calificación: " + getCalificacion());
    }

}
