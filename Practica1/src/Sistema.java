package ProgramacionDistribuida.Practica1.src;

public class Sistema {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Estableciendo contenedor...");
        Contenedor contenedor = new Contenedor(50);
        Brazo brazoA = new Brazo('A',25, contenedor);
        Brazo brazoB = new Brazo('B',25, contenedor);
        //Thread sistema = new Thread(brazoA);

        brazoA.run();
        brazoB.run();
    }
}
