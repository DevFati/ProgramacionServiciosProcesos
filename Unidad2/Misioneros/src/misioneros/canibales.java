package misioneros;

public class canibales implements Runnable {
	private olla laolla=null;
	private int numero=0; //numero de canibal
	    
	    public canibales(olla o,int num){
	           laolla=o;
	           numero=num;
	    }
	    public void run(){
	    	
	    	int canibal; //numero de misionero comido
	            while (true){
	                   try {
						canibal=laolla.SacardelaOlla(numero);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	                   try {
	   					Thread.sleep(400);
	   				} catch (InterruptedException e) {
	   					// TODO Auto-generated catch block
	   					e.printStackTrace();
	   				}
	            }
	    }

}
