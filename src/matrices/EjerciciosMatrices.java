package matrices;

import java.util.Random;
import java.util.Scanner;

public class EjerciciosMatrices {

    private static final Random random = new Random();

    // Punto 11: Búsqueda de primera ocurrencia
    public static void punto11(Scanner scanner) {
        System.out.println("\n--- PUNTO 11: Búsqueda en Matriz ---");
        int m = 3, n = 4;
        int[][] matriz = generarMatriz(m, n, 1, 20);
        imprimirMatriz(matriz);

        System.out.print("Ingrese el número a buscar: ");
        int objetivo = scanner.nextInt();

        boolean encontrado = false;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matriz[i][j] == objetivo) {
                    System.out.println("Número encontrado en Fila " + i + ", Columna " + j);
                    encontrado = true;
                    break;
                }
            }
            if (encontrado) break;
        }

        if (!encontrado) {
            System.out.println("El número no se encuentra en la matriz.");
        }
    }

    // Punto 12: Sumatoria de la diagonal opuesta
    public static void punto12() {
        System.out.println("\n--- PUNTO 12: Diagonal Secundaria ---");
        int n = 4;
        int[][] matriz = generarMatriz(n, n, -50, 50);
        imprimirMatriz(matriz);

        int sumaDiagonal = 0;
        for (int i = 0; i < n; i++) {
            sumaDiagonal += matriz[i][n - 1 - i];
        }

        System.out.println("Suma de la diagonal opuesta/secundaria: " + sumaDiagonal);
    }

    // Punto 13: Matriz simétrica y esquinas
    public static void punto13() {
        System.out.println("\n--- PUNTO 13: Simetría y Esquinas ---");
        int n = 3;
        int[][] matriz = generarMatriz(n, n, 1, 10);
        imprimirMatriz(matriz);

        boolean esSimetrica = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matriz[i][j] != matriz[j][i]) {
                    esSimetrica = false;
                    break;
                }
            }
            if (!esSimetrica) break;
        }

        System.out.println("¿Es simétrica?: " + (esSimetrica ? "Sí" : "No"));
        System.out.println("Esquinas:");
        System.out.println("Superior Izquierda: " + matriz[0][0] + " | Superior Derecha: " + matriz[0][n - 1]);
        System.out.println("Inferior Izquierda: " + matriz[n - 1][0] + " | Inferior Derecha: " + matriz[n - 1][n - 1]);
    }

    // Punto 14: Matriz Transpuesta
    public static void punto14() {
        System.out.println("\n--- PUNTO 14: Matriz Transpuesta ---");
        int m = 3, n = 2;
        int[][] matriz = {{1, 2}, {3, 4}, {5, 6}};

        System.out.println("Matriz Inicial:");
        imprimirMatriz(matriz);

        int[][] transpuesta = new int[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                transpuesta[j][i] = matriz[i][j];
            }
        }

        System.out.println("Matriz Transpuesta:");
        imprimirMatriz(transpuesta);
    }

    // Punto 15: Intercambio de las dos primeras filas
    public static void punto15(Scanner scanner) {
        System.out.println("\n--- PUNTO 15: Intercambio de Filas ---");
        System.out.print("Ingrese número de filas (m >= 2): ");
        int m = scanner.nextInt();
        System.out.print("Ingrese número de columnas (n): ");
        int n = scanner.nextInt();

        int[][] matriz = generarMatriz(m, n, 1, 50);
        System.out.println("Matriz Original:");
        imprimirMatriz(matriz);

        int[] temp = matriz[0];
        matriz[0] = matriz[1];
        matriz[1] = temp;

        System.out.println("Matriz tras intercambiar Fila 0 con Fila 1:");
        imprimirMatriz(matriz);
    }

    
    private static int[][] generarMatriz(int m, int n, int min, int max) {
        int[][] matriz = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matriz[i][j] = random.nextInt(max - min + 1) + min;
            }
        }
        return matriz;
    }

    private static void imprimirMatriz(int[][] matriz) {
        for (int[] fila : matriz) {
            for (int valor : fila) {
                System.out.print(valor + "\t");
            }
            System.out.println();
        }
    }
}
