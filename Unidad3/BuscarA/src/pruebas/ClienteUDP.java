package pruebas;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class ClienteUDP {

    public static void main(String[] args) throws Exception {
        // Dirección y puerto del servidor
        InetAddress destino = InetAddress.getLocalHost();
        int port = 12345;

        // Leer texto desde la entrada estándar
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el texto a enviar: ");
        String texto = scanner.nextLine();

        // Preparar el mensaje a enviar
        byte[] mensaje = texto.getBytes();
        DatagramPacket envio = new DatagramPacket(mensaje, mensaje.length, destino, port);

        // Crear socket para enviar el mensaje
        DatagramSocket socket = new DatagramSocket();
        System.out.println("Enviando texto al servidor...");
        socket.send(envio);

        // Preparar para recibir la respuesta
        byte[] bufferRespuesta = new byte[1024];
        DatagramPacket respuesta = new DatagramPacket(bufferRespuesta, bufferRespuesta.length);

        // Recibir respuesta del servidor
        socket.receive(respuesta);
        String resultado = new String(respuesta.getData(), 0, respuesta.getLength());

        // Mostrar la respuesta recibida
        System.out.println("Respuesta del servidor: " + resultado);

        // Cerrar recursos
        socket.close();
        scanner.close();
    }
}
