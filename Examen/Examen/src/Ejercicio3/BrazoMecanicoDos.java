package Ejercicio3;

public class BrazoMecanicoDos implements Runnable {
private Cinta c=null;
    
    public BrazoMecanicoDos(Cinta c){
           this.c=c;
    }
    public void run(){
    	double item=1.0;
            while (true){
               //Insertar producto en la cinta
            	try {
					c.insertar(item++);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                 try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                 
            }
    }
}
