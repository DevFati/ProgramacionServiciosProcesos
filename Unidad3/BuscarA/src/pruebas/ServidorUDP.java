package pruebas;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ServidorUDP {

    public static void main(String[] args) throws Exception {
        // Crear un buffer para recibir datos
        byte[] buffer = new byte[1024];

        // Crear socket para escuchar en el puerto 12345
        DatagramSocket socket = new DatagramSocket(12345);
        System.out.println("Servidor UDP escuchando en el puerto 12345...");

        // Recibir mensaje del cliente
        DatagramPacket recibo = new DatagramPacket(buffer, buffer.length);
        socket.receive(recibo);
        String textoRecibido = new String(recibo.getData(), 0, recibo.getLength());
        System.out.println("Texto recibido: " + textoRecibido);

        // Contar apariciones de la letra 'a' (minúscula)
        long contador = textoRecibido.chars().filter(ch -> ch == 'a').count();

        // Preparar la respuesta
        String respuesta = "El texto contiene " + contador + " apariciones de la letra 'a'.";
        byte[] respuestaBytes = respuesta.getBytes();
        DatagramPacket envio = new DatagramPacket(
            respuestaBytes, respuestaBytes.length, recibo.getAddress(), recibo.getPort()
        );

        // Enviar la respuesta al cliente
        socket.send(envio);

        // Cerrar el socket después de enviar la respuesta
        System.out.println("Respuesta enviada. Cerrando el servidor...");
        socket.close();
    }
}

