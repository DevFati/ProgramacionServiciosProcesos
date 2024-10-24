package ejercicio1;

import java.io.File;

public class BucleSaludoRedireccionado {
public static void main(String[] args) {
	
	//Realiza una tercera versión en la que la salida del programa anterior 
	//se almacene en un fichero llamado saludo.txt también puedes pasar el 
	//nombre del fichero como argumento
	
	ProcessBuilder pb=new ProcessBuilder("java","ejercicio1.BucleSaludo","Hola Fatima");
	File directorio=new File(".\\bin");
	pb.directory(directorio);
	Process p=null;
	
			File salida=new File("FicheroSaludo.txt");
	//Si le pasamos el nombre del fichero como argumento: 
	
			//if (args.length < 1){
			// System.out.println("SE NECESITA UN NOMBRE DE FICHERO...");
			//System.exit(1);
			//}
			
			//String nombre=args[0];
			//File salida=new File(nombre);
			
			
	try {
		pb.redirectOutput(salida);
		p=pb.start();
	}
	catch(Exception e ) {e.printStackTrace();
	
	}
	
	//COMPROBACION DE ERROR - O BIEN 1 MAL 
	
		int exitVal;
		
		try {
			exitVal=p.waitFor();
			System.out.println("Valor de Salida "+exitVal);
			
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
}
}
