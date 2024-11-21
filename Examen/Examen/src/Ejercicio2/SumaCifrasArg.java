package Ejercicio2;

import java.util.Scanner;

public class SumaCifrasArg {
	public static void main(String[] args) {
		if(args.length==1 ) {
			
			if(!args[0].matches("[0-9]+") || args[0].equals("")) {
				System.out.println("Introduce un numero valido");
			}else {
				int num=Integer.parseInt(args[0]);
				 num=Integer.parseInt(args[0]);
				
				String n=num+"";
				int total=0;
				
				for(int i=0;i<n.length();i++) {
					total=total+Integer.parseInt(n.charAt(i)+"");
				}
				System.out.println("La suma de las cifras es "+total);	
			}
			
		}else {
			System.out.println("Numero de argumentos incorrecto");
		}
		
		
	}
}
