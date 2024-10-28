package ejemploTortugaLiebre;

public class Liebre implements Runnable{
	public Liebre() {
		
	}

	public void run() {
		int i=0;
		System.out.println("Empieza la liebre");
		while(i<5) {
			try {
				Thread.sleep(2000);
				System.out.println("  L  ");
			}catch(InterruptedException ex) {
				
			}
			i++;
		}
		System.out.println("La liebre llega a meta");
	}
	
}
