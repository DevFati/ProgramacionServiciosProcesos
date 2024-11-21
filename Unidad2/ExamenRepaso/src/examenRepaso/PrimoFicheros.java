package examenRepaso;

import java.io.File;
import java.io.IOException;

public class PrimoFicheros {

	public static void main(String[] args) throws IOException {
		File directorio=new File(".\\bin");
		ProcessBuilder pb=new ProcessBuilder("java","examenRepaso.Primo");
		pb.directory(directorio);
		File fInput=new File("numero.txt");
		File fOut=new File("salida.txt");
		File fErr=new File("error.txt");
		pb.redirectInput(fInput);
		pb.redirectOutput(fOut);
		pb.redirectError(fErr);
		pb.start();
		
	}
}
