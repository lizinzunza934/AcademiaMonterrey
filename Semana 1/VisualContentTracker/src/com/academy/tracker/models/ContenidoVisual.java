package com.academy.tracker.models;

import com.academy.tracker.interfaces.Clasificable;

import java.awt.*;

//Clase abstracta
public abstract class ContenidoVisual implements Clasificable {

    //inmutbilidad y modificadores de acceso
    private final String titulo;

    //encapsulación
    private double calificacion;

    //static o variable de clase
    private static int totalRegistros = 0;

    //contructores, sobrecarga de contructores
    // 1st option: cuando apenas vas a empezar a ver y aun no lo calificas
    public ContenidoVisual(String titulo){
        this.titulo = titulo;
        this.calificacion = 0.0;
        totalRegistros++; //se suma uno al contador lobal cuando creamos este object

    }

    // 2nd option: cuando terminaste de verlo y quieres guardarlo con su calificacion
    public ContenidoVisual(String titulo, double calificacion) {
        this.titulo = titulo;
        this.calificacion = calificacion;
        totalRegistros++;
    }

    //Encapsulacion (con getters)
    //dejamos que otras partes del programa pueda leer los datos, pero no cambiarlos directamente
    public  String getTitulo() {
        return titulo;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public static int getTotalRegistros(){
        return totalRegistros;
    }

    //Tomamos la Interfaz Clasificable
    //soreescribimos con override
    @Override
    public void actualizarCalificacion(double nuevaCalificacion) {
        //ordenamos imperativo, el cómo y el qué
        if (nuevaCalificacion >= 1.0 && nuevaCalificacion <= 10.0) {
            this.calificacion = nuevaCalificacion;
        } else {
            System.out.println("Error: La calificación para '" + titulo + "' debe esar entre 1 y 10.");
        }
    }
    public abstract void reproducir();
}


