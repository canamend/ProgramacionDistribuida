package ProgramacionDistribuida.Practica1Parte2.src;

public class Sistema {
    static boolean banderasCont1[] = {false,false};
    static int turnoC1 = 0;
    static boolean banderasCont2[] = {false,false};
    static int turnoC2 = 0;
    public static void main(String[] args) {
        Contenedor cont = new Contenedor(50);
        Contenedor cont2 = new Contenedor(50);
        Thread brazo1 = new Thread(new Brazo(0,50,cont,cont2));
        Thread brazo2 = new Thread(new Brazo(1,50,cont,cont2));
        
        brazo1.start();
        brazo2.start();
        System.out.println("Contenedor vacío");
    }
}

