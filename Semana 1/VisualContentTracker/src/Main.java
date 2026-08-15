import com.academy.tracker.models.SerieAnimada;
import com.academy.tracker.services.Catalogo;

public class Main {

    public static void main(String[] args) {

        System.out.println("=== INICIANDO VISUAL TRACKER ===");

        Catalogo miCatalogo = Catalogo.getInstancia();

        // instanciar las series
        SerieAnimada jujutsu = new SerieAnimada("Jujutsu Kaisen", 24);
        SerieAnimada mha = new SerieAnimada("My Hero Academia", 138);
        SerieAnimada naruto = new SerieAnimada("Naruto", 220);

        // usar método auxiliar para calificar
        System.out.println("\n--- Procesando Calificaciones ---");
        calificarSeguro(jujutsu, 9.5);
        calificarSeguro(mha, 8.8);
        calificarSeguro(naruto, 15.0); // asinar la calificació manualmente

        System.out.println("\n--- Guardando en la base de datos temporal ---");
        miCatalogo.agregarContenido(jujutsu);
        miCatalogo.agregarContenido(mha);
        miCatalogo.agregarContenido(naruto);

        miCatalogo.mostrarTodo();

        System.out.println("\n--- Comprobando singleton ---");
        Catalogo catalogoPantallaDos = Catalogo.getInstancia();

        if (miCatalogo == catalogoPantallaDos) {
            System.out.println("Exito: ambas variables apuntan a la misma memoria");
        }
    }

    // metodo auxiliar dry para menejar excepciones al tener una calificacion no deseado
    public static void calificarSeguro(SerieAnimada serie, double calificacion) {
        try {
            serie.actualizarCalificacion(calificacion);
            System.out.println("Calificación de " + serie.getTitulo() + " actualizada a " + calificacion);
        } catch (IllegalArgumentException e) {
            System.out.println("Alerta interceptada en '" + serie.getTitulo() + "': " + e.getMessage());
        }
    }
}