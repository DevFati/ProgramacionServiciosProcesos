package ejerciciosBinario;

import java.util.Scanner;

public class BinarioArgs {
public static void main(String[] args) {
	int numero=0;
	if(args.length==1) {
		if(esNumero(args[0])) {
			 numero=Integer.parseInt(args[0]);
			 String binario= Integer.toBinaryString(numero);
				System.out.println(args[0]+" en  binario seria "+binario);
		}
	
	
	
	
	
	
}else {
	System.out.println("Numero de cadenas introducidas incorrecto");
	System.exit(1);
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
