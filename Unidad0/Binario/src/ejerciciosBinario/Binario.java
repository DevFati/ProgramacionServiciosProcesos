package ejerciciosBinario;

import java.util.Scanner;

public class Binario {
public static void main(String[] args) {

	Scanner teclado=new Scanner(System.in);
	String num="";
	System.out.println("Introduce un numero: ");
	num=teclado.next();
	if(esNumero(num)) {
		int numero=Integer.parseInt(num);
		
		//de decimal a binario 
		String binario= Integer.toBinaryString(numero);
		System.out.println(num+" en  binario seria "+binario);	
		
	}
	
	
	
	
}

//Método para verificar si la cadena es un número válido
private static boolean esNumero(String numero) {
    //Si la cadena contiene solo dígitos del 0 al 9 devuelve true
    if (numero.matches("[0-9]+")) {
        return true;
    } else {
        //Si la cadena no es número válido, muestra un numero de error
        System.out.println("Introduce un número válido!");
        return false;
    }
}
}
