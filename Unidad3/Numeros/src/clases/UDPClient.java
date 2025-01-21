package clases;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UDPClient {
    public static void main(String[] args) {
        try (DatagramSocket socket = new DatagramSocket();
             Scanner scanner = new Scanner(System.in)) {

            InetAddress serverAddress = InetAddress.getByName("localhost");

            while (true) {
                System.out.print("Introduce un número (<= 0 para salir): ");
                int numero = scanner.nextInt();

                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ObjectOutputStream oos = new ObjectOutputStream(baos);

                Numeros num = new Numeros();
                num.setNumero(numero);
                oos.writeObject(num);

                byte[] buffer = baos.toByteArray();
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length, serverAddress, 12345);
                socket.send(packet);

                if (numero <= 0) {
                    break;
                }

                buffer = new byte[1024];
                packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);

                ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(packet.getData()));
                Numeros respuesta = (Numeros) ois.readObject();
                System.out.println("Cuadrado: " + respuesta.getCuadrado() + ", Cubo: " + respuesta.getCubo());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
