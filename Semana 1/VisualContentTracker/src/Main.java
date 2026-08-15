import com.academy.tracker.models.SerieAnimada;
import com.academy.tracker.services.Catalogo;
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
            System.out.println("3. Salir del programa");
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
                    String titulo = teclado.nextLine(); // lee texto

                    System.out.print("¿Cuántos capítulos tiene en total?: ");
                    int capitulos = teclado.nextInt(); // lee numeros

                    // usar el molde para crear la serie con los datos que dio el usuario
                    SerieAnimada nuevaSerie = new SerieAnimada(titulo, capitulos);
                    miCatalogo.agregarContenido(nuevaSerie);
                    break; // Termina la opción 1 y vuelve a empezar el menú

                case 2:
                    // Llamamos a nuestro servicio de catálogo para que imprima todo
                    miCatalogo.mostrarTodo();
                    break;

                case 3:
                    System.out.println("\nGuardando información... ¡VUelve pronto!");
                    salir = true; // cuando es truw el ciclo while se rompe y el programa termina
                    break;

                default:
                    // el usuario tecla un numero invalido
                    System.out.println("Opción no válida. Por favor intenta de nuevo.");
                    break;
            }
        }

        // terminamos con buena practica
        teclado.close();
    }
}