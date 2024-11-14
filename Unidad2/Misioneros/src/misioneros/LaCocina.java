package misioneros;

public class LaCocina {

	public static void main(String[] args) {
		int tamaño=5;//tamaño de la olla
		olla laolla=new olla(tamaño);
	//Crear el cocinero y lanzarlo
		Thread c = new Thread(new cocinero(laolla));
		c.start();
	//Crear 3 caníbales y lanzarlos
	for(int i=1;i<=3;i++) {
		Thread can=new Thread(new canibales(laolla, i));
		can.start();
	}
	
	
	
	}

}
