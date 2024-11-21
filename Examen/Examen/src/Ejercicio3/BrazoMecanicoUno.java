package Ejercicio3;

public class BrazoMecanicoUno implements Runnable  {
	private Cinta c=null;
    
    public BrazoMecanicoUno(Cinta c){
           this.c=c;
    }
    public void run(){
    	double item = 0;
            while (true){
                //sacar producto de la cinta
            	try {
					c.extraer(item);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                   try {
   					Thread.sleep(300);
   				} catch (InterruptedException e) {
   					// TODO Auto-generated catch block
   					e.printStackTrace();
   				}
            }
    }
}
