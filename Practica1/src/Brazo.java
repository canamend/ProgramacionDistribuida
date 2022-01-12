package ProgramacionDistribuida.Practica1.src;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Brazo implements Runnable{
    char id;
    int numPiezas;
    Contenedor cont;

    public Brazo(char id, int numPiezas, Contenedor cont){
        this.cont = cont;
        this.id = id;
        this.numPiezas = numPiezas;
    }


    
    @Override
    public void run() {
        while (true) {
            try {
                tomarPieza();
            } catch (Exception e) {
                System.out.println(e.getMessage()+ e);
            }
        }
    }
    
}
