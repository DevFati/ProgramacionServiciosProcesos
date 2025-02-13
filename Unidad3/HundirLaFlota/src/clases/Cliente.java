package clases;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        final String HOST = "localhost";
        final int PUERTO = 6000;

        try (Socket servidor = new Socket(HOST, PUERTO);
             BufferedReader entrada = new BufferedReader(new InputStreamReader(servidor.getInputStream()));
             PrintWriter salida = new PrintWriter(servidor.getOutputStream(), true);
             Scanner scanner = new Scanner(System.in)) {

            System.out.println("Conectado al servidor");
            int intentos = 20;

            while (intentos > 0) {
                System.out.println("Ingresa un número (0-99) o * para terminar: ");
                String mensaje = scanner.nextLine();

                if (mensaje.equals("*")) {
                    salida.println(mensaje);
                    System.out.println("Has terminado el juego.");
                    break;
                }

                // Validar que la entrada sea un número entre 0 y 99
                try {
                    int numero = Integer.parseInt(mensaje);
                    if (numero < 0 || numero > 99) {
                        System.out.println("Número fuera de rango. Intenta de nuevo.");
                        continue;
                    }
                    salida.println(mensaje);
                } catch (NumberFormatException e) {
                    System.out.println("Entrada inválida. Intenta de nuevo.");
                    continue;
                }

                String respuesta = entrada.readLine();
                System.out.println("Respuesta del servidor: " + respuesta);

                if (respuesta.equals("¡Ganaste!")) {
                    System.out.println("¡Felicitaciones! Hundiste todos los barcos.");
                    break;
                }

                intentos--;
                System.out.println("Intentos restantes: " + intentos);

                if (intentos == 0) {
                    System.out.println("Se agotaron los intentos. ¡Perdiste!");
                }
            }
        } catch (IOException e) {
            System.err.println("Error en el cliente: " + e.getMessage());
        }
    }
}

