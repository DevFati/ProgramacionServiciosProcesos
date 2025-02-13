package clases;
import java.util.Random;

public class Tablero {
    private final int[][] tablero = new int[10][10];

    public Tablero() {
        colocarBarcos();
    }

    private void colocarBarcos() {
        Random random = new Random();
        int barcosColocados = 0;

        while (barcosColocados < 10) {
            int fila = random.nextInt(10);
            int columna = random.nextInt(10);

            if (tablero[fila][columna] == 0) {
                tablero[fila][columna] = 1; // barcoo 
                barcosColocados++;
            }
        }
    }

    public String verificarPosicion(int fila, int columna) {
        if (tablero[fila][columna] == 1) {
            tablero[fila][columna] = -1; // hundidoo
            return "Hundido";
        }
        return "Agua";
    }

    public boolean todosHundidos() {
        for (int[] fila : tablero) {
            for (int celda : fila) {
                if (celda == 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public void imprimirTablero() {
        System.out.println("Estado del tablero:");
        for (int fila = 0; fila < 10; fila++) {
            for (int columna = 0; columna < 10; columna++) {
                if (tablero[fila][columna] == 1) {
                    System.out.print(". "); // Barco no descubierto
                } else if (tablero[fila][columna] == -1) {
                    System.out.print("H "); // Barco hundido
                } else {
                    System.out.print("A "); // Agua
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
