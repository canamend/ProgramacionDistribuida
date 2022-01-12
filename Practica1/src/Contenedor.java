package ProgramacionDistribuida.Practica1.src;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Contenedor {
    int id;
    int numPiezas;
    private ReentrantLock lock;


    public Contenedor(int numPiezas){
        this.numPiezas = numPiezas;
        this.lock = new ReentrantLock();
    }


    public boolean descargarUnaPieza() throws InterruptedException {
        this.numPiezas--;
        return lock.tryLock(250, TimeUnit.MILLISECONDS);
    }

    public boolean estaOcupado() {
        return lock.isHeldByCurrentThread();
    }

    public void liberar() throws InterruptedException {
        if (estaOcupado()) {
            lock.unlock();
        }
    }

}
