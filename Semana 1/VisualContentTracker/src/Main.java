import com.academy.tracker.models.SerieAnimada;
import com.academy.tracker.services.Catalogo;
import com.academy.tracker.models.ContenidoVisual;
import java.util.Scanner; // herramienta para leer el teclado

public class Main {

    public static void main(String[] args) {

        Catalogo miCatalogo = Catalogo.getInstancia();

        // intanciar el Scanner, decirle que escuche la entrada del sistema (System.in)
        Scanner teclado = new Scanner(System.in);

        //variable que controla el bucle
        boolean salir = false;

        System.out.println("=== INICIANDO VISUAL TRACKER ===");

        // el  bucle para reptirlo
        while (!salir) {
            System.out.println("\n=== MENÚ PRINCIPAL ===");
            System.out.println("1. Agregar una nueva Serie");
            System.out.println("2. Ver todo mi Catálogo");
            System.out.println("3. Calificar una Serie");
            System.out.println("4. Registrar un capitulo visto");
            System.out.println("5. Salir del programa");
            System.out.print("Elige una opción: ");

            // el scanner espera el numero entero del usuario
            int opcion = teclado.nextInt();

            // limpiar el buffer
            teclado.nextLine();

            // el switch de la sinteracciones con el menu
            switch (opcion) {
                case 1:
                    System.out.println("\n--- NUEVO REGISTRO ---");
                    System.out.print("Escribe el nombre de la serie: ");
                    String titulo = teclado.nextLine();

                    System.out.print("¿Cuántos capítulos tiene en total?: ");
                    int capitulos = teclado.nextInt();
                    teclado.nextLine(); // limpiar el buffer

                    SerieAnimada nuevaSerie = new SerieAnimada(titulo, capitulos);
                    miCatalogo.agregarContenido(nuevaSerie);
                    break;

                case 2:
                    miCatalogo.mostrarTodo();
                    break;

                // opcion nueva para que usuario califique
                case 3:
                    System.out.println("\n--- CALIFICAR CONTENIDO ---");
                    System.out.print("Escribe el título de la serie: ");
                    String tituloBuscar = teclado.nextLine();

                    //llamamos a nuestro metodo de busqueda
                    ContenidoVisual encontrado = miCatalogo.buscarPorTitulo(tituloBuscar);

                    //si no es null seguimos
                    if (encontrado != null) {
                        System.out.print("Ingresa la nueva calificación (1.0 a 10.0): ");
                        double nuevaCalificacion = teclado.nextDouble();
                        teclado.nextLine(); //limpiar buffer de enter

                        //manejamos errores
                        try {
                            encontrado.actualizarCalificacion(nuevaCalificacion);
                            System.out.println("Calificación actualizada con éxito.");
                        } catch (IllegalArgumentException e) {
                            System.out.println("Alerta: " + e.getMessage());
                        }
                    } else {
                        System.out.println("No se encontró ninguna serie llamada '" + tituloBuscar + "'.");
                    }
                    break;

                // registrar progreso plus casting e intanceof
                case 4:
                    System.out.println("\n--- REGISTRAR CAPÍTULO VISTO ---");
                    System.out.print("Escribe el título exacto de la serie: ");
                    String tituloProgreso = teclado.nextLine();

                    // buscar contenido reutilizando codigo
                    ContenidoVisual contenidoEncontrado = miCatalogo.buscarPorTitulo(tituloProgreso);

                    if (contenidoEncontrado != null) {
                        if (contenidoEncontrado instanceof SerieAnimada) {

                            // castear para trnasformar la variable genérica a una específica
                            SerieAnimada serieParaAvanzar = (SerieAnimada) contenidoEncontrado;

                            // usamos el metodo exclusivo de la serie
                            serieParaAvanzar.incrementarCapitulo();

                        } else {
                            System.out.println("El contenido encontrado no es una serie con capítulos.");
                        }
                    } else {
                        System.out.println("No se encontró ninguna serie llamada '" + tituloProgreso + "'.");
                    }
                    break;

                case 5:
                    System.out.println("\nGuardando información en memoria... ¡Hasta pronto!");
                    salir = true;
                    break;
            }

        }

        // terminamos con buena practica
        teclado.close();
    }
}