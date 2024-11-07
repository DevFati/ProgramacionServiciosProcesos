package actividadCuenta;

public class Main {
public static void main(String[] args) {
	
    Cuenta cuenta = new Cuenta(100, 200);

    Persona p1 = new Persona("Fatima", cuenta);
    Persona p2 = new Persona("Daniel", cuenta);
    Persona p3 = new Persona("Laura", cuenta);


    p1.start();
    p2.start();
    p3.start();
}
}
