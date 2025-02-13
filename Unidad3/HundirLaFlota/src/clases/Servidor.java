package clases;
import java.io.*;
import java.net.*;

public class Servidor {
    public static void main(String[] args) {
        final int PUERTO = 6000;

        try (ServerSocket servidor = new ServerSocket(PUERTO)) {
            System.out.println("Servidor esperando conexiones en el puerto " + PUERTO);

            Tablero tablero = new Tablero();

            try (Socket cliente = servidor.accept();
                 BufferedReader entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
                 PrintWriter salida = new PrintWriter(cliente.getOutputStream(), true)) {

                System.out.println("Cliente conectado");

                String mensaje;
                while ((mensaje = entrada.readLine()) != null) {
                    if (mensaje.equals("*")) {
                        salida.println("Juego terminado por el cliente.");
                        System.out.println("El cliente ha terminado el juego.");
                        break;
                    }

                    int numero = Integer.parseInt(mensaje);
                    int fila = numero / 10;
                    int columna = numero % 10;

                    String respuesta = tablero.verificarPosicion(fila, columna);
                    salida.println(respuesta);

                    tablero.imprimirTablero(); // Imprime el tablero después de cada jugada

                    if (tablero.todosHundidos()) {
                        salida.println("¡Ganaste!");
                        System.out.println("El cliente ha hundido todos los barcos. ¡Juego terminado!");
                        break;
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error en el servidor: " + e.getMessage());
        }
    }
}
