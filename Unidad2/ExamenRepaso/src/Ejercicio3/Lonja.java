package Ejercicio3;

public class Lonja {
	private int numero=0; // capacidad de la lonja
	private int[] lonja=null;
	private int echar=0,sacar=0;
	private int cont=0; //cuantos atunes hay en la lonja
	
	
	
	public Lonja(int numero) {
		this.numero=numero;
		this.lonja=new int[numero];
	}
	
	public synchronized void echarAlalonja(int numatun) throws InterruptedException {
		
		while(cont==numero) {
			// mientras la lonja está llena
			System.out.println("\tLONJA  LLENA: Esperando comprador ");
			wait();
		}
		
		lonja[echar]=numatun;
		echar=(echar+1)%numero;
		cont++;
			
		//Si no está llena se ponen a la venta
		System.out.println("**********************************");
		System.out.println("************A la venta:  "+numatun+"********");
		System.out.println("**********************************");
		notifyAll();
		
	}
	public synchronized int sacardelalonja(int numerocomprador) throws InterruptedException {
		int numatun=0;
		//mientras lonja  vacía
		while(cont==0) {
			System.out.println("*********************LONJA  VACÍA: Esperando pescador ");
			wait();
		}
			
		//Si hay atunes en la lonja	se lleva 1, 2 o 3 si hay
		int numerosAtunes=0;
		if(cont>=3) {
			numerosAtunes=3;
		}else {
			numerosAtunes=cont;
			
		}
		System.out.println("El comprador "+numerocomprador+" compra "+numerosAtunes);
			

			do {
				numatun=lonja[sacar];
				sacar=(sacar+1)%numero;
				cont--;
				System.out.println("El atún "+numatun);				
				numerosAtunes--;
			}while(numerosAtunes>0 );			
		
		notifyAll();		
		
		return numatun;
}
}
