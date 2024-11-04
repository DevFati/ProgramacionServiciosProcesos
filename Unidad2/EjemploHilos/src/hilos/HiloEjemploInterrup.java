package hilos;

public class HiloEjemploInterrup extends Thread {

	public void run() {
		try {
			while(!isInterrupted()) {
				System.out.println("En el hilo");
				Thread.sleep(10);
			}
		}catch(InterruptedException e) {
			System.out.println("Ha ocurrido una excepción");
		}
		
		System.out.println("Fin del hilo");
	}
	
	public void interrumpir() {
		interrupt();
	}
	
	public static void main(String[] args) {
		HiloEjemploInterrup h=new HiloEjemploInterrup();
		h.start();
		for (int i = 0; i < 1000000000; i++); //No hago nada
			h.interrumpir();
		
	}
}
