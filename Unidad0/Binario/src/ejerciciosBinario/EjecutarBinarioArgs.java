package ejerciciosBinario;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class EjecutarBinarioArgs {
public static void main(String[] args) throws IOException {
	File directorio=new File(".\\bin");
	
	ProcessBuilder pb=new ProcessBuilder("java","ejerciciosBinario.BinarioArgs","7");
	pb.directory(directorio);
	
	Process p=pb.start();
	
	
	
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
