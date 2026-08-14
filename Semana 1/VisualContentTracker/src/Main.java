import com.academy.tracker.models.SerieAnimada;

import java.nio.file.FileSystemNotFoundException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("=== INICIANDO VISUAL TRACKER ===");

        //llamar nuestro molde SerieAnimada
        SerieAnimada miSerie = new SerieAnimada("Jujutsu Kaisen", 24);

        //ver que se heredó el metodo de mostrar detalles y titulos
        miSerie.mostrarDetalles();

        //usar el comportamiento de una serie
        miSerie.incrementarCapitulo();
        miSerie.incrementarCapitulo();

        //probar el contrato de la interfaz (actualizar la calificación)
        System.out.print("\n--- Calificando la serie ---");
        miSerie.actualizarCalificacion(9.5); //probar con número valido
        miSerie.actualizarCalificacion(15.0); //forzar error para verificar si la validacion funciona

        //ver detalles actualizados
        miSerie.mostrarDetalles();

        //probar polimorfismo
        System.out.print("\n--- Reproduciendo ---");
        miSerie.reproducir();
        }
    }
