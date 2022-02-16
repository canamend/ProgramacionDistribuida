package ProgramacionDistribuida.Practica1Peterson.src;

public class Sistema {
    static boolean banderas[] = {false,false};
    static int turno = 0;
    public static void main(String[] args) {
        Contenedor cont = new Contenedor(50);
        Thread brazo1 = new Thread(new Brazo(0,25,cont));
        Thread brazo2 = new Thread(new Brazo(1,25,cont));
        
        brazo1.start();
        brazo2.start();
    }
}

