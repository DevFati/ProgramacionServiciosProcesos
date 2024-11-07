package actividadCuenta;

public class Cuenta {

	private double saldo; 
	private  double maximo;
	
	
	public Cuenta(double saldo, double maximo) {
		super();
		this.saldo = saldo;
		this.maximo = maximo;
	}


	public double getSaldo() {
		return saldo;
	}


	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}


	public double getMaximo() {
		return maximo;
	}


	public void setMaximo(double maximo) {
		this.maximo = maximo;
	}
	
	synchronized void ingreso(double cantidad) {
		if(saldo+cantidad>maximo) {
			System.out.println("Error: el ingreso supera el saldo máximo permitido.");
			System.exit(1);
		}else {
			saldo+=cantidad;
			System.out.println("Ingreso de "+cantidad+" realizado. Saldo actual: "+saldo);
		}
	}
	
	
	  synchronized void reintegro(double cantidad) {
	        if (saldo - cantidad < 0) {
	            System.out.println("Error: no hay suficiente saldo para el reintegro.");
	            System.exit(1); 
	        } else {
	            saldo -= cantidad;
	            System.out.println("Reintegro de " + cantidad + " realizado. Saldo actual: " + saldo);
	        }
	    }
	

	
}
