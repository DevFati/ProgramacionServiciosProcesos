package actividadCuenta;

public class Persona extends Thread {

	  private  Cuenta cuenta;
	    private  String nombre;
	   

	    public Persona(String nombre, Cuenta cuenta) {
	        this.nombre = nombre;
	        this.cuenta = cuenta;
}
	    
	    
	    @Override
	    public void run() {
	        try {
	            while (true) {
	              
	                double ingreso =(int)(Math.random()*500 + 1);
	                System.out.println(nombre + " intenta ingresar " + ingreso);
	                cuenta.ingreso(ingreso);

	   
	                Thread.sleep(200);

	                double reintegro =(int)( Math.random()*500+ 1);
	                System.out.println(nombre + " intenta retirar " + reintegro);
	                cuenta.reintegro(reintegro);

	        
	                Thread.sleep(200);
	            }
	        } catch (InterruptedException e) {
	            System.out.println(nombre + " ha sido interrumpido.");
	        }
	    }
	    
	    
	    
	    
}
