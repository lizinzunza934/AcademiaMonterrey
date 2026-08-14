package com.academy.tracker.services;

import com.academy.tracker.models.ContenidoVisual;

import java.util.ArrayList;
import java.util.List;

public class Catalogo {
    //declarar lista dinamica
    //verificar que acepta cualquier contenido visual (series, futuras peliculas) por polimofismo
    private List<ContenidoVisual> listaContenidos;

    //Contructor, inicializar la lista vacia cuando nace el catalogo
    public Catalogo() {
        this.listaContenidos = new ArrayList<>();
    }

    //guardar cosas en la lista - metodo
    public void agregarContenido(ContenidoVisual contenido){
        listaContenidos.add(contenido);
        System.out.println("Registro exitoso: '" + contenido.getTitulo() + "' se añadió al catálogo.");
    }

    //imprimir todo usando ciclo for-each (imperativo) - metodo
    public void mostrarTodo() {
        System.out.println("\n=== MI CATALÓGO DE CONTENIDO VISUAL ===");
        if (listaContenidos.isEmpty()) {
            System.out.println("El catálogo está vacío.");
        } else {
            //cada ContenidoVisual 'c' que exista dentro de 'listaContenidos' ...
            for (ContenidoVisual c : listaContenidos) {
                c.mostrarDetalles();
            }
        }
        System.out.println("Total histórico de registros: " + ContenidoVisual.getTotalRegistros());
    }
}
