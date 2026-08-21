public class Aldeano {
    private String nombre;
     private Herramienta herramienta;

     //ya no hacemos un new para la herramienta sino que la llamamos
     public Aldeano(String nombre,Herramienta herramientaExterna) {
         this.nombre = nombre;
         this.herramienta = herramientaExterna;
     }

     public void trabajar() {
         System.out.println(this.nombre + " dice: ");
         this.herramienta.usar();
    }
}
