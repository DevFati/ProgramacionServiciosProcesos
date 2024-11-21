package Ejercicio3;

public class Comprador implements Runnable {
	private Lonja lalonja=null;
	private int atun=0; //numero de atun cogido
	    
	    public Comprador(Lonja l,int num){
	           lalonja=l;
	           atun=num;
	    }
	    public void run(){
	    	
	    	int comprador; //numero comprador
	            while (true){
	                   try {
						comprador=lalonja.sacardelalonja(atun);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	                   try {
	   					Thread.sleep(500);
	   				} catch (InterruptedException e) {
	   					// TODO Auto-generated catch block
	   					e.printStackTrace();
	   				}
	            }
	    }
		
	
}
