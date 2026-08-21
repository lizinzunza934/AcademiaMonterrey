package AldeanoMalo;

public class AldeanoMalo {
    private String nombre;
    private CanaDePescar herramienta;

    public AldeanoMalo(String nombre) {
        this.nombre = nombre;
        // el aldeano hace su propia caña lo que es el problema
        this.herramienta = new CanaDePescar();
    }

    public void trabajar() {
        System.out.print(this.nombre + " dice: ");
        this.herramienta.usar();
    }
}
