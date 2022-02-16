package ProgramacionDistribuida.Practica1.src;

public class Sistema {
    public static void main(String[] args) {
        Contenedor cont = new Contenedor(50);
        Thread brazo1 = new Thread(new Brazo(0,30,cont));
        Thread brazo2 = new Thread(new Brazo(1,30,cont));
        
        brazo1.start();
        brazo2.start();
        System.out.println("Contenedor vacío");
    }
}
