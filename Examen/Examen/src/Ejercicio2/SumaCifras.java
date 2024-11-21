package Ejercicio2;

import java.util.Scanner;

public class SumaCifras {

	public static void main(String[] args) {
		Scanner teclado=new Scanner(System.in);
		System.out.println("Introduce un numero entero: ");
		int num=teclado.nextInt();
		
		String n=num+"";
		int total=0;
		
		for(int i=0;i<n.length();i++) {
			total=total+Integer.parseInt(n.charAt(i)+"");
		}
		System.out.println("La suma de las cifras es "+total);
		
	}
}
