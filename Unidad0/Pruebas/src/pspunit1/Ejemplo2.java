package pspunit1;

import java.io.IOException;
import java.io.InputStream;


public class Ejemplo2 {

	public static void main(String[] args) throws IOException {
		//Se crea un proceso que ejecuta el comando "DIR" 
		//en la consola de Windows usando el ProcessBuilder. 
		
		//CMD: Indica que se va abrir la línea de comandos de Windows. 
		// /C: Le dice a la consola que ejecute el comando que sigue y 
		//luego cierre la ventana de la consola.
		//DIR: Es el comando que lista los archivos y directorios del 
		//directorio actual. 
		//Al final se llama a start, lo que inicia el proceso y devuelve 
		//un objeto Process que se almacena en la variable "p". 
		Process p =new ProcessBuilder("CMD","/C","DIR").start();
		
		//Mostramos caracter a caracter la salida generda por DIR 
		
		//Leemos lo que el comando escribió en la consola 
		
		// Se obtiene un InputStream (is), que representa la salida generada 
		//por el proceso (es decir, el resultado del comando DIR)
		
		InputStream is=p.getInputStream();
		int c;
		
		//Luego en un ciclo while, el código lee la salida caracter por 
		//caracter usando is.read(). 
		
		//is.read(): Devuelve el siguiente byte disponible como un entero. 
		//Si ya no hay más datos que leer, devuelve -1 para indicar el final de 
		//de la secuencia. 
		
		while((c=is.read())!=-1) {
			
			
			System.out.print((char)c); //Cada byte leido se convierte en un 
			//carácter usando (char) y luego se imprime en la consola. 
			
			
		}
		
		//Finalmente, se cierra el InputStream después de que se ha leído toda la salida. 
		is.close();
		
		//Comrobación de error 0 bien y -1 mal 
		int exitVal;
		
		//Recoge la salida de System.exit()
		
		try {
			exitVal=p.waitFor(); //Hace que el programa espere hasta que el proceso p
			//(el que ejecutó el comando DIR) termine. Retorna un valor entero, 0 si todo bien y -1 si ocurrió algún error. 
			System.out.println("Valor de salida: "+exitVal);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}
