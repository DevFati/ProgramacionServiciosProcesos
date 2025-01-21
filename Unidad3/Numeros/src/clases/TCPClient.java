package clases;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;


class TCPClient {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 12345);
             ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
             ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
             Scanner scanner = new Scanner(System.in)) {

            while (true) {
                System.out.print("Introduce un número (<= 0 para salir): ");
                int numero = scanner.nextInt();

                Numeros num = new Numeros();
                num.setNumero(numero);

                out.writeObject(num);

                if (numero <= 0) {
                    break;
                }

                Numeros respuesta = (Numeros) in.readObject();
                System.out.println("Cuadrado: " + respuesta.getCuadrado() + ", Cubo: " + respuesta.getCubo());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
