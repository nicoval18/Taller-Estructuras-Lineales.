package arreglos;

import java.util.Random;

public class EjerciciosArreglos {

    private static final Random random = new Random();

    // Punto 1: Imprimir 10 primeros primos
    public static void punto1() {
        System.out.println("--- PUNTO 1: Números Primos ---");
        int[] primos = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
        imprimirArreglo(primos);
    }

    // Punto 2: 100 primeros números pares
    public static void punto2() {
        System.out.println("\n--- PUNTO 2: 100 Primeros Pares ---");
        int[] pares = new int[100];
        for (int i = 0; i < pares.length; i++) {
            pares[i] = (i + 1) * 2;
        }

        System.out.println("Impresión en una sola línea:");
        imprimirArreglo(pares);

        System.out.println("\nImpresión en 10 líneas:");
        for (int i = 0; i < pares.length; i++) {
            System.out.print(pares[i] + "\t");
            if ((i + 1) % 10 == 0) {
                System.out.println(" -> (Línea " + ((i / 10) + 1) + ")");
            }
        }
    }

    // Punto 3: Factoriales de n aleatorios
    public static void punto3(int n) {
        System.out.println("\n--- PUNTO 3: Factoriales ---");
        int[] numeros = generarAleatorios(n, 1, 12); // Limitado a 12 para evitar overflow de long
        long[] factoriales = new long[n];

        for (int i = 0; i < n; i++) {
            factoriales[i] = calcularFactorial(numeros[i]);
        }

        System.out.print("Números iniciales: ");
        imprimirArreglo(numeros);
        System.out.print("Factoriales:       ");
        imprimirArregloLong(factoriales);
    }

    // Punto 4: Menor y mayor entre -50 y 50
    public static void punto4() {
        System.out.println("\n--- PUNTO 4: Menor y Mayor ---");
        int[] numeros = generarAleatorios(25, -50, 50);
        
        System.out.print("Arreglo: ");
        imprimirArreglo(numeros);

        int menor = numeros[0];
        int mayor = numeros[0];

        for (int num : numeros) {
            if (num < menor) menor = num;
            if (num > mayor) mayor = num;
        }

        System.out.println("Número menor: " + menor);
        System.out.println("Número mayor: " + mayor);
    }

    // Punto 5: Invertir 20 números aleatorios
    public static void punto5() {
        System.out.println("\n--- PUNTO 5: Invertir Números ---");
        int[] numeros = generarAleatorios(20, 10, 999);
        int[] invertidos = new int[20];

        for (int i = 0; i < numeros.length; i++) {
            invertidos[i] = invertirNumero(numeros[i]);
        }

        System.out.print("Originales: ");
        imprimirArreglo(numeros);
        System.out.print("Invertidos: ");
        imprimirArreglo(invertidos);
    }

    // ==========================================
    // MÉTODOS REUTILIZABLES (Principios DRY & Clean Code)
    // ==========================================

    private static int[] generarAleatorios(int cantidad, int min, int max) {
        int[] arreglos = new int[cantidad];
        for (int i = 0; i < cantidad; i++) {
            arreglos[i] = random.nextInt(max - min + 1) + min;
        }
        return arreglos;
    }

    private static long calcularFactorial(int num) {
        long factorial = 1;
        for (int i = 1; i <= num; i++) {
            factorial *= i;
        }
        return factorial;
    }

    private static int invertirNumero(int num) {
        int invertido = 0;
        int signo = num < 0 ? -1 : 1;
        num = Math.abs(num);

        while (num > 0) {
            invertido = (invertido * 10) + (num % 10);
            num /= 10;
        }
        return invertido * signo;
    }

    private static void imprimirArreglo(int[] arreglo) {
        for (int num : arreglo) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    private static void imprimirArregloLong(long[] arreglo) {
        for (long num : arreglo) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}