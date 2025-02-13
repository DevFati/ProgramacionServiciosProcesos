package clases;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(12345)) {
            System.out.println("Servidor TCP escuchando en el puerto 12345...");

            try (Socket clientSocket = serverSocket.accept();
                 ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
                 ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream())) {

                while (true) {
                    Numeros num = (Numeros) in.readObject();

                    if (num.getNumero() <= 0) {
                        break;
                    }

                    int numero = num.getNumero();
                    num.setCuadrado((long) numero * numero);
                    num.setCubo((long) numero * numero * numero);

                    out.writeObject(num);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
