package Ejercicio3;

public class Pescador implements Runnable{
private Lonja lalonja=null;
    
    public Pescador(Lonja l){
           lalonja=l;
    }
    public void run(){
    	int atun=0;
            while (true){
                try {
					lalonja.echarAlalonja(++atun);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                 try {
                	 //podemos probar a poner 10 en vez de 100 para ver cuando se llena 
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                 
            }
    }
}
