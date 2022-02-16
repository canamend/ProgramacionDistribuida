package ProgramacionDistribuida.Practica1Parte2.src;

public class Brazo implements Runnable{
    private int iD,numPiezas,numPiezasExtraidas;
    private Contenedor contenedor1, contenedor2;
    private int contPiezas;
    
    public Brazo(int iD,int numPiezas, Contenedor cont1, Contenedor cont2){
        this.iD = iD;
        this.numPiezas = numPiezas;
        this.contenedor1 = cont1;
        this.contenedor2 = cont2;
        this.numPiezasExtraidas = 0;
    }
    /*Aquí intenté usar el método synchronized para ver su funcionamiento, sin embargo no vi un 
    cambio en su funcionamiento, llama en un loop al método extraer para crear la condición
    de competencia.*/
    public void run(){
        
        System.out.println("Entra "+this.iD);
        while(this.numPiezas>this.numPiezasExtraidas){
            //Algoritmo de Peterson
            Sistema.banderasCont1[this.iD] = true;
            if(this.iD==0)           
                Sistema.turnoC1 = 1;
            else
                Sistema.turnoC1 = 0;
            if(this.iD == 0){
                Sistema.turnoC1 = 1;
                while(Sistema.banderasCont1[Sistema.turnoC1] && Sistema.turnoC1!=this.iD){
                    //Proceso dormido
                    try{
                        Thread.sleep(500);
                    }catch(InterruptedException e){
                        System.out.println("Proceso interrumpido");
                    }
                }
                //Acceso a la memoria crítica
                this.contenedor1.descargarUnaPieza();
                System.out.println("Brazo "+this.iD+": extrajo una pieza del contenedor A");
                this.numPiezasExtraidas += 1;
                if(this.contenedor1.getCantPiezas()<=0){
                    System.out.println("No hay piezas restantes");
                    break;
                }
                try{
                    Thread.sleep(50);
                }catch(InterruptedException e){
                    System.out.println("Proceso interrumpido");
                }
                Sistema.banderasCont1[this.iD]=false;
                Sistema.turnoC2 = 1;
                while(Sistema.banderasCont2[Sistema.turnoC2] && Sistema.turnoC2!=this.iD){
                    //Proceso dormido
                    try{
                        Thread.sleep(500);
                    }catch(InterruptedException e){
                        System.out.println("Proceso interrumpido");
                    }
                }
                //Acceso a la memoria crítica
                this.contenedor2.descargarUnaPieza();
                System.out.println("Brazo "+this.iD+": extrajo una pieza del contenedor B");
                this.numPiezasExtraidas += 1;
                this.contPiezas +=1;
                System.out.println("El Brazo "+this.iD+" ha montado su producto "+this.contPiezas+" de "+this.numPiezas/2);
                if(this.contenedor2.getCantPiezas()<=0){
                    System.out.println("No hay piezas restantes");
                    break;
                }
                try{
                    Thread.sleep(50);
                }catch(InterruptedException e){
                    System.out.println("Proceso interrumpido");
                }
                Sistema.banderasCont2[this.iD]=false;
            }else{
                Sistema.turnoC2 = 0;
                while(Sistema.banderasCont2[Sistema.turnoC2] && Sistema.turnoC2!=this.iD){
                    //Proceso dormido
                    try{
                        Thread.sleep(500);
                    }catch(InterruptedException e){
                        System.out.println("Proceso interrumpido");
                    }
                }
                //Acceso a la memoria crítica
                this.contenedor2.descargarUnaPieza();
                
                
                System.out.println("Brazo "+this.iD+": extrajo una pieza del contenedor B");
                this.numPiezasExtraidas += 1;
                if(this.contenedor2.getCantPiezas()<=0){
                    System.out.println("No hay piezas restantes");
                    break;
                }
                try{
                    Thread.sleep(50);
                }catch(InterruptedException e){
                    System.out.println("Proceso interrumpido");
                }
                Sistema.banderasCont2[this.iD]=false;
                Sistema.turnoC1 = 0;
                while(Sistema.banderasCont1[Sistema.turnoC1] && Sistema.turnoC1!=this.iD){
                    //Proceso dormido
                    try{
                        Thread.sleep(500);
                    }catch(InterruptedException e){
                        System.out.println("Proceso interrumpido");
                    }
                }
                //Acceso a la memoria crítica
                this.contenedor1.descargarUnaPieza();
                System.out.println("Brazo "+this.iD+": extrajo una pieza del contenedor A");
                this.numPiezasExtraidas += 1;
                this.contPiezas += 1;
                System.out.println("El Brazo "+this.iD+" ha montado su producto "+this.contPiezas+" de "+this.numPiezas/2);
                
                if(this.contenedor1.getCantPiezas()<=0){
                    System.out.println("No hay piezas restantes");
                    break;
                }
                try{
                    Thread.sleep(50);
                }catch(InterruptedException e){
                    System.out.println("Proceso interrumpido");
                }
                Sistema.banderasCont1[this.iD]=false;
                
                
            }
            
        }
    }
    public void extraer(){
        if(this.contenedor1.getCantPiezas()>0){
            this.contenedor1.descargarUnaPieza();
            System.out.print("Brazo "+this.iD+": extrajo una pieza, restan "+contenedor1.getCantPiezas()+" Piezas\n");
            try{
                Thread.sleep(3000);
            }catch(InterruptedException e){
                System.out.println("Brazo "+this.iD+" interrumpido");
            }
       }else{
           System.out.println("Brazo "+this.iD+": No hay piezas por extraer");
       }
        
    }
       
}
