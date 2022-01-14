package ProgramacionDistribuida.Practica1.src;

/*
    El constructor de la clase debe permitir asignar
    un identificador único al contenedor y configurar la cantidad de piezas que
    contiene inicialmente. Además, debe ofrecer como parte de su interfaz el método
    descargarUnaPieza(). Este método deberá decrementar en una unidad la cantidad
    de piezas existentes en el contenedor.
*/
public class Contenedor{
    private int ID;
    private int cantPiezas = 0;
    
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
        this.cantPiezas -= 1;
    }
    
    public void descargarPiezas(int n){
        this.cantPiezas -= n;
    }
}
