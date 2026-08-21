//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        System.out.println("- DIA 1: Mañana tranquila -");

        // generamos las dependencias
        Herramienta cana = new CanaDePescar();
        Herramienta red = new RedParaBichos();

        // le damos la caña a Canela a través de su constructor
        Aldeano canela = new Aldeano("Canela", cana);
        canela.trabajar();

        System.out.println("\n- DIA 2: Torneo de bichos -");

        Aldeano totakeke = new Aldeano("Totakeke", red);
        totakeke.trabajar();

        // aldeano 1 tambien puede cambiar herramienta
        Aldeano canelaConRed = new Aldeano("Canela", red);
        canelaConRed.trabajar();
    }
}