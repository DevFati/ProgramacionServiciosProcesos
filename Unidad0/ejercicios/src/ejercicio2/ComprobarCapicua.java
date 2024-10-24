package ejercicio2;

import java.util.Scanner;

public class ComprobarCapicua {
public static void main(String[] args) {
	
	//Haz un programa java que compruebe si un número introducido por teclado es capicua 
	
	Scanner teclado=new Scanner (System.in);
	String num="";
	System.out.println("Introduce un número: ");
	num=teclado.next();

	if(esNumero(num)) {
		String numAlreves="";
		
		for(int i=num.length()-1;i>=0;i--) {
			numAlreves=numAlreves+num.charAt(i);
		
		}
		if(num.equals(numAlreves)) {
			System.out.println("El numero "+num+" es capicua");
		}else {
			System.out.println("El numero "+num+" no es capicua");
		}
		
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
