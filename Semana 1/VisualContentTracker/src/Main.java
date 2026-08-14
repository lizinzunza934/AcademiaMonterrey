import com.academy.tracker.models.SerieAnimada;
import com.academy.tracker.services.Catalogo;

import java.nio.file.FileSystemNotFoundException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("=== INICIANDO VISUAL TRACKER ===");

        //Instanciar el servicio de catalogo
        Catalogo miCatalogo = new Catalogo();

        //crear series usando molde SerieAnimada
        SerieAnimada jujutsu = new SerieAnimada("Jujutsu Kaisen", 24);
        jujutsu.actualizarCalificacion(9.5);
        jujutsu.incrementarCapitulo();

        SerieAnimada mha = new SerieAnimada("My Hero Academia", 138);
        mha.actualizarCalificacion(8.8);

        //Agregar los objetos al catálogo
        System.out.println("\n--- Guardando en la base de datos temporal ---");
        miCatalogo.agregarContenido(jujutsu);
        miCatalogo.agregarContenido(mha);

        //Mostrar el inventario con el metodo que recorre el ArrayList
        miCatalogo.mostrarTodo();
    }
}
