package ProgramacionDistribuida.Practica1.src;

public class Contenedor{
    private int ID;
    private int cantPiezas = 0;
    private int cantPiezasInicial;
    
    public Contenedor(){
        this.cantPiezas = 50;
    }
    
    public Contenedor(int cantPiezas){
        this.cantPiezas = cantPiezas;
    }
    
    public Contenedor(int ID, int cantPiezas){
        this.ID = ID;
        this.cantPiezas = cantPiezas;
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
        if(this.cantPiezas>0){
            this.cantPiezas -= 1;
        }
    }
    
    public void descargarPiezas(int n){
        this.cantPiezas -= n;
    }
    
    public int numPiezasExtraidas(){
        return this.cantPiezasInicial-this.cantPiezas;
    }
}