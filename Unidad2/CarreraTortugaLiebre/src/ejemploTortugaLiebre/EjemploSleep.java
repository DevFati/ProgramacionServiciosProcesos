package ejemploTortugaLiebre;

public class EjemploSleep {

	public static void main(String[] args) {
		
		for(int i=1;i<=3;i++) {
			//Creo el hilo para la tortuga 
			Thread tortuga = new Thread(new Tortuga(i));
			//Creo el hilo para la liebre 
			Thread liebre= new Thread(new Liebre(i));
			tortuga.start();
			liebre.start();
		}
		
	}
}
