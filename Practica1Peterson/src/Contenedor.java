package ProgramacionDistribuida.Practica1Peterson.src;

public class Contenedor{
    private int ID;
    private int cantPiezas = 0;
    private int cantPiezasInicial;
    
    public Contenedor(){
        this.cantPiezasInicial = this.cantPiezas = 50;
    }
    
    public Contenedor(int cantPiezas){
        this.cantPiezasInicial = this.cantPiezas = cantPiezas;
    }
    
    public Contenedor(int ID, int cantPiezas){
        this.ID = ID;
        this.cantPiezasInicial = this.cantPiezas = cantPiezas;
    }
    
    public void setPiezas(int cantPiezas){
        this.cantPiezasInicial = this.cantPiezas = cantPiezas;
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
