package misioneros;

public class cocinero implements Runnable{
private olla laolla=null;
    
    public cocinero(olla o){
           laolla=o;;
    }
    public void run(){
    	int misionero=0;
            while (true){
					try {
						laolla.EcharAlaOlla(++misionero);
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
