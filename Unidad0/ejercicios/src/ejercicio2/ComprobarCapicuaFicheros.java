package ejercicio2;

import java.io.File;
import java.io.IOException;

public class ComprobarCapicuaFicheros {
public static void main(String[] args) throws IOException {
	
	File directorio=new File(".\\bin");
	ProcessBuilder pb=new ProcessBuilder("java","ejercicio2.ComprobarCapicua");
	pb.directory(directorio);
	File fInput=new File("capicua.txt");
	File fOut=new File("salidac.txt");
	File fErr=new File("errorc.txt");
	pb.redirectInput(fInput);
	pb.redirectOutput(fOut);
	pb.redirectError(fErr);
	pb.start();
}
}
