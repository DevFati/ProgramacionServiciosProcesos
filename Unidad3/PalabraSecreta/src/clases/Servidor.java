package clases;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) {
        String palabraSecreta = "gato";
        int intentos = 4;
        int puerto = 6000;

        try (ServerSocket servidorSocket = new ServerSocket(puerto)) {
            System.out.println("El servidor está escuchando en el puerto " + puerto + "...");

            Socket socket = servidorSocket.accept();
            System.out.println("Cliente conectado: " + socket.getInetAddress());

            DataInputStream entrada = new DataInputStream(socket.getInputStream());
            DataOutputStream salida = new DataOutputStream(socket.getOutputStream());

            salida.writeUTF("Tienes " + intentos + " intentos para adivinar la palabra secreta.");

            while (intentos > 0) {
                String adivinanzaCliente = entrada.readUTF();

                if (adivinanzaCliente.equalsIgnoreCase(palabraSecreta)) {
                    salida.writeUTF("¡Felicidades! ¡Has adivinado la palabra secreta!");
                    System.out.println("El cliente adivinó la palabra correctamente. Fin del juego.");
                    break;
                } else {
                    intentos--;
                    if (intentos > 0) {
                        salida.writeUTF("Respuesta incorrecta. Te quedan " + intentos + " intentos.");
                    } else {
                        salida.writeUTF("Fin del juego. Has agotado todos los intentos. La palabra secreta era 'gato'.");
                        System.out.println("El cliente no adivinó la palabra.Gana el servidor.Adios!.");
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Excepción en el servidor: " + e.getMessage());
            e.printStackTrace();
        }
    }
}