package misioneros;

public class olla {
	private int numero=0; //capacidad de la olla 
	private int[] olla=null;
	private int echar=0,sacar=0;
	private int cont=0; //cuantos misioneros hay en la olla 
	
	public olla(int numero) {
		this.numero=numero;
		olla=new int[numero];
	}
	
	public synchronized void EcharAlaOlla(int nummisionero) throws InterruptedException {
		//Si la olla está llena
		while(cont==numero) {
			
				System.out.println("No se puede echar a la olla: OLLA  LLENA ");
				wait(); //esperamos hasta que se cree espacio 
			
		}
		
		//Si se puede cocinar habrá que echar otro 
		
		olla[echar]=nummisionero;
		echar=(echar+1)%numero; //nunca se llegara al final del array asi que nunca nos dara error 
		cont++;
		
		System.out.println("		Cocinando al misionero:  "+nummisionero);
		notifyAll(); //avisa a todos los canibales que hay comida 
		
		}
	public synchronized int SacardelaOlla(int numerocanibal) throws InterruptedException {
		int misionero;
		//Si la olla está vacía no se puede sacar
		while(cont==0) {
			System.out.println("No hay nada más que sacar: OLLA VACÍA ");
			wait();

		}
		//Si hay misioneros cocinados se podrán sacar y comer
		misionero=olla[sacar];
		sacar=(sacar+1)%numero;
		cont--;

			System.out.println("El canibal "+numerocanibal+" está comiendo "+misionero);
			notifyAll();


			return misionero;
			
		}//

}
