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

        //por singleton ya no usamos new y usamos la global de Catalogo
        Catalogo miCatalogo = Catalogo.getInstancia();

        SerieAnimada jujutsu = new SerieAnimada("Jujutsu Kaisen", 24);
        jujutsu.actualizarCalificacion(9.5);

        SerieAnimada mha = new SerieAnimada("My Hero Academia", 138);
        mha.actualizarCalificacion(8.8);

        SerieAnimada naruto = new SerieAnimada("Naruto", 220);
        naruto.actualizarCalificacion(10.0);

        System.out.println("\n--- Guardando en la base de datos temporal ---");
        miCatalogo.agregarContenido(jujutsu);
        miCatalogo.agregarContenido(mha);
        miCatalogo.agregarContenido(naruto);

        miCatalogo.mostrarTodo();

        //para comprobar singeton
        //si tenemos que crear otro catalogo , en realidad nos devuelve el mismo que ya tiene datos
        System.out.println("\n--- Comprobando singleton ---");
        Catalogo catalogoPantallaDos = Catalogo.getInstancia();

        if (miCatalogo == catalogoPantallaDos) {
            System.out.println("Exito: ambas variables apuntan a la misma memoria");
        }
    }
}
