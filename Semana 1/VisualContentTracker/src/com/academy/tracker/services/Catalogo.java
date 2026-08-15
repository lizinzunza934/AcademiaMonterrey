package com.academy.tracker.services;

import com.academy.tracker.models.ContenidoVisual;
import java.util.ArrayList;
import java.util.List;

public class Catalogo {

    private List<ContenidoVisual> listaContenidos;

    //guardar la única instancia que existirá
    private static Catalogo instanciaUnica;

    // contructor privado para que nadie use Cataloo desde fuera
    private Catalogo() {
        this.listaContenidos = new ArrayList<>();
    }

    // metodo de acceso global para le singleton
    public static Catalogo getInstancia() {
        // Si nadie ha creado el catálogo todavía, lo creamos
        if (instanciaUnica == null) {
            instanciaUnica = new Catalogo();
        }
        // Si ya existía, simplemente lo devolvemos
        return instanciaUnica;
    }

    // mantener los metodos agregarContenido y mostrarTodo

    public void agregarContenido(ContenidoVisual contenido) {
        listaContenidos.add(contenido);
        System.out.println("✅ Registro exitoso: '" + contenido.getTitulo() + "' se añadió al catálogo.");
    }

    public void mostrarTodo() {
        System.out.println("\n=== MI CATÁLOGO DE VISUAL TRACKER ===");
        if (listaContenidos.isEmpty()) {
            System.out.println("El catálogo está vacío.");
        } else {
            for (ContenidoVisual c : listaContenidos) {
                c.mostrarDetalles();
            }
        }
        System.out.println("Total histórico de registros: " + ContenidoVisual.getTotalRegistros());
    }

    // metodo de busqueda imperativo
    public ContenidoVisual buscarPorTitulo(String tituloBuscado) {
        // recorrer la lista uno por uno
        for (ContenidoVisual c : listaContenidos) {
            // equalsIgnoreCase compara los textos ignorando si se escibieron cap letters o no
            if (c.getTitulo().equalsIgnoreCase(tituloBuscado)) {
                return c; // se encuentra y devuelve
            }
        }
        return null; // si el ciclo termina se arroja Null
    }
}