package arraylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class EjerciciosArrayList {

    private static final Random random = new Random();

    // Punto 6: Leer aleatorios hasta encontrar el 10
    public static void punto6() {
        System.out.println("\n--- PUNTO 6: Secuencia hasta el 10 ---");
        ArrayList<Integer> numeros = new ArrayList<>();
        int numero;

        do {
            numero = random.nextInt(21) - 10; // Rango [-10, 10]
            numeros.add(numero);
        } while (numero != 10);

        int suma = 0;
        for (int n : numeros) {
            suma += n;
        }
        double media = (double) suma / numeros.size();

        System.out.println("Números leídos: " + numeros);
        System.out.println("Suma total: " + suma);
        System.out.println("Media: " + media);
    }

    // Punto 7: Inserción y borrado ordenado
    public static void punto7(Scanner scanner) {
        System.out.println("\n--- PUNTO 7: ArrayList de Pares Ordenado ---");
        ArrayList<Integer> pares = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            pares.add(i * 2);
        }

        System.out.println("Lista inicial: " + pares);

        System.out.print("Ingrese un número para insertar en orden: ");
        int valorInsertar = scanner.nextInt();
        
        int posicion = 0;
        while (posicion < pares.size() && pares.get(posicion) < valorInsertar) {
            posicion++;
        }
        pares.add(posicion, valorInsertar);
        System.out.println("Lista tras inserción: " + pares);

        System.out.print("Ingrese un número para eliminar: ");
        int valorEliminar = scanner.nextInt();
        if (pares.remove(Integer.valueOf(valorEliminar))) {
            System.out.println("Valor eliminado correctamente.");
        } else {
            System.out.println("El valor no se encontraba en la lista.");
        }
        System.out.println("Lista final: " + pares);
    }

    // Punto 8: Frecuencia de aparición de números
    public static void punto8() {
        System.out.println("\n--- PUNTO 8: Frecuencias de Números ---");
        ArrayList<Integer> numeros = new ArrayList<>();
        int[] frecuencias = new int[21]; // Índices del 1 al 20

        for (int i = 0; i < 100; i++) {
            int num = random.nextInt(20) + 1; // Rango [1, 20]
            numeros.add(num);
            frecuencias[num]++;
        }

        System.out.println("Tabla de Frecuencias:");
        System.out.println("Número\tFrecuencia");
        int masRepetido = 1;
        for (int i = 1; i <= 20; i++) {
            System.out.println(i + "\t" + frecuencias[i]);
            if (frecuencias[i] > frecuencias[masRepetido]) {
                masRepetido = i;
            }
        }
        System.out.println("El número que más se repite es: " + masRepetido + " (" + frecuencias[masRepetido] + " veces)");
    }

    // Punto 9: Ordenamiento y separación de pares e impares
    public static void punto9() {
        System.out.println("\n--- PUNTO 9: Ordenamiento y Clasificación ---");
        ArrayList<Integer> numeros = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            numeros.add(random.nextInt(100) + 1); // Rango [1, 100]
        }

        System.out.println("Original: " + numeros);

        ArrayList<Integer> ascendente = new ArrayList<>(numeros);
        Collections.sort(ascendente);
        System.out.println("Menor a Mayor: " + ascendente);

        ArrayList<Integer> descendente = new ArrayList<>(numeros);
        Collections.sort(descendente, Collections.reverseOrder());
        System.out.println("Mayor a Menor: " + descendente);

        ArrayList<Integer> pares = new ArrayList<>();
        ArrayList<Integer> impares = new ArrayList<>();

        for (int num : numeros) {
            if (num % 2 == 0) pares.add(num);
            else impares.add(num);
        }

        System.out.println("Pares: " + pares);
        System.out.println("Impares: " + impares);
    }

    // Punto 10: Gestión de partidos de fútbol
    public static void punto10() {
        System.out.println("\n--- PUNTO 10: Partidos de Fútbol ---");
        ArrayList<Partido> partidos = new ArrayList<>();
        partidos.add(new Partido("Barcelona", "Real Madrid", 3, 1));
        partidos.add(new Partido("Sevilla", "Barcelona", 1, 2));
        partidos.add(new Partido("Atlético", "Valencia", 0, 0));
        partidos.add(new Partido("Betis", "Barcelona", 2, 2));
        partidos.add(new Partido("Barcelona", "Getafe", 1, 0));

        System.out.println("1. Partidos donde ganó el visitante:");
        for (Partido p : partidos) {
            if (p.ganoVisitante()) {
                System.out.println("   " + p);
            }
        }

        int victoriasBarcelona = 0;
        int victoriasLocal = 0;

        for (Partido p : partidos) {
            if ((p.getEquipoLocal().equalsIgnoreCase("Barcelona") && p.ganoLocal()) ||
                (p.getEquipoVisitante().equalsIgnoreCase("Barcelona") && p.ganoVisitante())) {
                victoriasBarcelona++;
            }
            if (p.ganoLocal()) {
                victoriasLocal++;
            }
        }

        System.out.println("2. Veces que ganó el Barcelona: " + victoriasBarcelona);
        System.out.println("3. Cantidad de partidos que ganó el equipo local: " + victoriasLocal);

       
        partidos.removeIf(p -> !p.esEmpate());
        System.out.println("4. Partidos restantes (solo empates): " + partidos);
    }
}
