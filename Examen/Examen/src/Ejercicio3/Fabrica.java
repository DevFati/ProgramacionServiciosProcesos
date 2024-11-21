package Ejercicio3;

public class Fabrica {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ranuras=10;
		Cinta cinta=new Cinta(ranuras);
		//crear la cintatransportadora y los hilos m
		Thread p=new Thread(new BrazoMecanicoUno(cinta));
		p.start();
		Thread p1=new Thread(new BrazoMecanicoDos(cinta));
		p1.start();

		
	}

}
