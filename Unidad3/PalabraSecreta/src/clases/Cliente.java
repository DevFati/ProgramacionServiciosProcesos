package clases;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Cliente {
    public static void main(String[] args) {
        int puerto = 6000;

        try (Socket socket = new Socket("localhost", puerto)) {
            DataInputStream entrada = new DataInputStream(socket.getInputStream());
            DataOutputStream salida = new DataOutputStream(socket.getOutputStream());
            BufferedReader entradaUsuario = new BufferedReader(new InputStreamReader(System.in));

            System.out.println(entrada.readUTF());

            while (true) {
                System.out.print("Ingresa tu adivinanza: ");
                String adivinanza = entradaUsuario.readLine();
                salida.writeUTF(adivinanza);

                String respuesta = entrada.readUTF();
                System.out.println(respuesta);

                if (respuesta.contains("¡Felicidades!") || respuesta.contains("Fin del juego")) {
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("Excepción en el cliente: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
