package hilos;

public class hilos1a {
public static void main(String[] args) {
	System.out.println("Inicio hilo principal");
	HiloEjemplo1a t1=new HiloEjemplo1a(1);
	HiloEjemplo1a t2=new HiloEjemplo1a(2);
	t1.start();
	t2.start();
	System.out.println("fin del hilo principal");
}
}
