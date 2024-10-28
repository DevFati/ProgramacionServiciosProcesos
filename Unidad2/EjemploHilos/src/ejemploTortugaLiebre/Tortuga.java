package ejemploTortugaLiebre;

public class Tortuga implements Runnable {

	public Tortuga() {
	
	}

	public void run() {
		int i=0;
		System.out.println("Empieza la tortuga");
		while(i<5) {
			try {
				Thread.sleep(5000);
				System.out.println("  T  ");
			}catch(InterruptedException ex) {
				
			}
			i++;
		}
		System.out.println("La tortuga llega a meta");
	}
	
}
