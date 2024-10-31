package ejemploTortugaLiebre;

public class Liebre implements Runnable {
	private int num;

	public Liebre(int num) {
		super();
		this.num = num;
	}

	public void run() {
		int i = 0;
		System.out.println("Empieza la liebre " + num);
		while (i < 5) {
			try {
				Thread.sleep(2000);
				System.out.print("  L" + num + "  ");
			} catch (InterruptedException ex) {

			}
			i++;
			
		}
		System.out.print("\nLa liebre " + num + " llega a meta");
		System.out.println();
	}

}
