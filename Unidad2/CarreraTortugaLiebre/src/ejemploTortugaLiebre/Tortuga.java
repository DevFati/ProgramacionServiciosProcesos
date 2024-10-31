package ejemploTortugaLiebre;

public class Tortuga implements Runnable {
	private int num;

	public Tortuga(int num) {
		super();
		this.num = num;
	}

	public void run() {
		int i = 0;
		System.out.println("Empieza la tortuga " + num);
		while (i < 5) {
			try {
				Thread.sleep(5000);
				System.out.print("  T" + num + "  ");
			} catch (InterruptedException ex) {

			}
			i++;
			
			
		}
		System.out.print("\nLa tortuga " + num + " llega a meta");
		System.out.println();
	}

}