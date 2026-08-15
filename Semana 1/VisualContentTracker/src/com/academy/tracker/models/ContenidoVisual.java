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
    //soreescribimos con override agregamos excepcion throw necesaria para manejar errores
    @Override
    public void actualizarCalificacion(double nuevaCalificacion) {
        if (nuevaCalificacion >= 1.0 && nuevaCalificacion <= 10.0) {
            this.calificacion = nuevaCalificacion;
        } else {
            throw new IllegalArgumentException("Calificación inválida para '" + titulo + "'. Debe estar entre 1.0 y 10.0");
        }
    }
    public abstract void reproducir();
    public abstract void mostrarDetalles();
}


