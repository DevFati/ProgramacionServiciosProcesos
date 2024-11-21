package Ejercicio3;

public class DiaMercado {
	public static void main(String[] args) {
		int tam=6;
		//crear la lonja y los hilos
		Lonja lonja=new Lonja(tam);
		
		//Crear el pescador y lanzarlo 
		Thread p=new Thread(new Pescador(lonja));
		p.start();
		
		//Crear 3 compradores y lanzarlos 
		
		for(int i=1;i<=3;i++) {
			Thread com=new Thread(new Comprador(lonja,i));
			com.start();
		}
				
	}
}
