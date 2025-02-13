package clases;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServer {
    public static void main(String[] args) {
        try (DatagramSocket socket = new DatagramSocket(12345)) {
            System.out.println("Servidor UDP escuchando en el puerto 12345...");

            byte[] buffer = new byte[1024];

            while (true) {
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);

                ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(packet.getData()));
                Numeros num = (Numeros) ois.readObject();

                if (num.getNumero() <= 0) {
                    break;
                }

                int numero = num.getNumero();
                num.setCuadrado((long) numero * numero);
                num.setCubo((long) numero * numero * numero);

                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ObjectOutputStream oos = new ObjectOutputStream(baos);
                oos.writeObject(num);

                byte[] responseBuffer = baos.toByteArray();
                packet = new DatagramPacket(responseBuffer, responseBuffer.length, packet.getAddress(), packet.getPort());
                socket.send(packet);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
