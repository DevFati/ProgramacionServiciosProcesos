package Ejercicio3;

import java.util.ArrayList;

public class Cinta {
	private int dimension=0; //numero de productos limite
	private double[] cintatransportadora=null;
	private int echar=0;
	private int sacar=0;
	private int cont=0; //cuanto producto hay en la cinta 
	
	public Cinta(int dimension) {
		this.dimension=dimension;
		this.cintatransportadora=new double[dimension];
	}
	
	public synchronized void insertar(double valor) throws InterruptedException {
		 //cintatransportadora llena
		while(cont==dimension) {
			System.out.println("\t CINTA TRANSPORTADORA LLENA");
			wait();
		}
		cintatransportadora[echar]=valor;
		echar=(echar+1)%dimension;
		cont++;
		
		//Si hay hueco en la cinta	

		System.out.println("NUEVA PIEZA EN LA CINTA "+valor);
		notifyAll();


	}
	public synchronized double extraer(double item) throws InterruptedException {
		double valor=item;
		while(cont==0) {
			//cintatransportadora vac o
			System.out.println("\t CINTA TRANSPORTADORA VAC A ");
			wait();
		
		}
		
		valor=cintatransportadora[sacar];
		sacar=(sacar+1)%dimension;
		cont--;
		


		//Si hay producto lo saca y lo pasa a la cadena de montaje
		
		System.out.println("\t "+valor+" PASA A LA CADENA DE MONTAJE");

		notifyAll();
	
		return valor;
			
		}//
	}//cintatransportadora
