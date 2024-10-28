package ejemploTortugaLiebre;

public class EjemploSleep {

	public static void main(String[] args) {
		//Creo el hilo para la tortuga 
		Thread tortuga = new Thread(new Tortuga());
		
		//Creo el hilo para la liebre 
		Thread liebre= new Thread(new Liebre());
		tortuga.start();
		liebre.start();
		
	}
}
