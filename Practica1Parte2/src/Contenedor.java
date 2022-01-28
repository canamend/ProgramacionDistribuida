package ProgramacionDistribuida.Practica1Parte2.src;

public class Contenedor{
    private int ID,cantPiezasInicial;
    private int cantPiezas = 0;
    
    public Contenedor(){
        this.cantPiezas = 50;
    }
    
    public Contenedor(int cantPiezas){
        this.cantPiezas = cantPiezas;
        this.cantPiezasInicial = cantPiezas;
    }
    
    public Contenedor(int ID, int cantPiezas){
        this.ID = ID;
        this.cantPiezas = cantPiezas;
        this.cantPiezasInicial = cantPiezas;
    }
    
    public void setPiezas(int cantPiezas){
        this.cantPiezas = cantPiezas;
    }
    
    public void setId(int ID){
        this.ID = ID;
    }
    
    public int getCantPiezas(){
        return this.cantPiezas;
    }
    
    public synchronized void descargarUnaPieza(){
        this.cantPiezas -= 1;
    }
    
    public void descargarPiezas(int n){
        this.cantPiezas -= n;
    }
    
    public int numPiezasExtraidas(){
        return this.cantPiezasInicial-this.cantPiezas;
    }
}
