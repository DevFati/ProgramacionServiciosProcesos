package examenRepaso;

import java.util.Scanner;

public class Primo {

	public static void main(String[] args) {
		Scanner teclado=new Scanner(System.in);
		System.out.println("Introduce un numero: ");
		int n=teclado.nextInt();
		int c=0;
		for(int i=1;i<=n;i++) {
			if(n%i==0) {
				c++;
			}
		}
		
		if(c==2) {
			System.out.println("El número "+n+" es primo.");
		}else {
			System.out.println("El número "+n+" no es primo.");
		}
		
	}
}
