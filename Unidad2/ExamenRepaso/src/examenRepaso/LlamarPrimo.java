package examenRepaso;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Scanner;

public class LlamarPrimo {

	public static void main(String[] args) throws IOException {
		
		File directorio= new File(".\\bin");		
		ProcessBuilder pb=new ProcessBuilder("java","examenRepaso.Primo");
		pb.directory(directorio);
		Process p=pb.start();
		
		//Escritura
		OutputStream os=p.getOutputStream();
		Scanner teclado=new Scanner(System.in);
		System.out.println("Introduce un numero: ");
		int n=teclado.nextInt();
		
		os.write((n+"\n").getBytes());
		os.flush();
		
		//LEER STREAM DE ERRORES 
		try {
			InputStream er=p.getErrorStream();
			BufferedReader brer=new BufferedReader(new InputStreamReader(er));
			String liner=null;
			
			while((liner=brer.readLine())!=null) {
				System.out.println("ERROR>"+liner);
			}
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}
		
		
		
		//LEER STREAM DE ENTRADA 
		
		try {
			InputStream er=p.getInputStream();
			BufferedReader brer=new BufferedReader(new InputStreamReader(er));
			String liner=null;
			
			while((liner=brer.readLine())!=null) {
				System.out.println(liner);
			
		}
		}catch(

		IOException ioe)
		{
			ioe.printStackTrace();
		}	
	}
}
