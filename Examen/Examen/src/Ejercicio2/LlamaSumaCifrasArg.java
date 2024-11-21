package Ejercicio2;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Scanner;

public class LlamaSumaCifrasArg {
	public static void main(String[] args) throws IOException {
		File directorio=new File(".\\bin");
		ProcessBuilder pb=new ProcessBuilder("java","Ejercicio2.SumaCifrasArg","122");
		pb.directory(directorio);
		Process p=pb.start();
		
		
		//Leer Stream de errores 
		try {
			InputStream er=p.getErrorStream();
			BufferedReader brer=new BufferedReader(new InputStreamReader(er));
			String liner=null;
			while((liner=brer.readLine())!=null) {
				System.out.println("Error >"+liner);
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		//Leer Stream de entrada 
		
		try {
			InputStream er=p.getInputStream();
			BufferedReader brer=new BufferedReader(new InputStreamReader(er));
			String liner=null;
			while((liner=brer.readLine())!=null) {
				System.out.println(liner);
			}
		}catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
		//comprbar error --> 0 bien 1 mal
		int exitVal;
		try {
			exitVal=p.waitFor();
			System.out.println("Valor salida "+exitVal);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
	}
}
