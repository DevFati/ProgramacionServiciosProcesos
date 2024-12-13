package servidorClienteBinario;


import java.io.*;
import java.net.*;

public class Servidorbinario {
	public static void main(String[] args) {

		int numeroPuerto=6000;

		ServerSocket servidor=null;

		try {

			servidor=new ServerSocket(numeroPuerto);

			Socket clienteConectado=null;

			System.out.println("Esperando al cliente");

			clienteConectado=servidor.accept();

			OutputStream salida=null;

			salida=clienteConectado.getOutputStream();

			DataOutputStream flujoSalida=new DataOutputStream(salida);

			InputStream entrada=null;

			entrada=clienteConectado.getInputStream();

			DataInputStream flujoEntrada=new DataInputStream(entrada);

			 String numero="";
             int n=0;
             do {
                 // Recibir número del cliente
                 numero = flujoEntrada.readUTF();
                 System.out.println("El número recibido es: "+numero);
                 
                     // Convertir a binario
                 try {
                 	 n=Integer.parseInt(numero);
                 	
                 	if(n<0) {
                 	
                 	
                 		numero="Numero no valido";
                 	}else {
                 		numero=Integer.toBinaryString(n);
                 	}
                 	
                 }catch(Exception e) {
                 	numero="Numero no valido";
                 }
                 
                // Enviar respuesta al cliente
                     flujoSalida.writeUTF(numero);
                     System.out.println("El numero en binario es: "+numero);
                 
             	
                 
             } while (numero.equals("0"));

             System.out.println("Conexión cerrada por el cliente.");


			
			entrada.close();

			flujoEntrada.close();

			salida.close();

			flujoSalida.close();

			clienteConectado.close();

			servidor.close();

		} catch (IOException e) {

			e.printStackTrace();

		}

	}
}