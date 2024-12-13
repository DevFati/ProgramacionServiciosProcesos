package servidorClienteBinario;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ClienteBinario {
	public static void main(String[] args) {

		String host="localhost";

		int puerto=6000;

		System.out.println("PROGRAMA CLIENTE INICIADO...");

		try {

			Socket cliente=new Socket(host,puerto);

			DataOutputStream flujoSalida=new DataOutputStream(cliente.getOutputStream());

			DataInputStream flujoEntrada=new DataInputStream(cliente.getInputStream());
			Scanner teclado=new Scanner(System.in);

			
			String numero;
            do {
                System.out.print("Introduce un número (0 para salir): ");
                	numero = teclado.next();
                             

                // Enviar el número al servidor
                flujoSalida.writeUTF(numero);     
                
                    String binario = flujoEntrada.readUTF();
                    System.out.println("El número en binario es: " + binario);
                numero=binario;

            } while (!numero.equals("0"));

            System.out.println("Conexión terminada.");


			

			flujoEntrada.close();

			flujoSalida.close();

			cliente.close();

		} catch (UnknownHostException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}

		

	}
}
