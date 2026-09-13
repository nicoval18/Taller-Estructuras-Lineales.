import java.util.Scanner;
import arreglos.EjerciciosArreglos;
import arraylist.EjerciciosArrayList;
import matrices.EjerciciosMatrices;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("==================================================");
        System.out.println("  TALLER DE ESTRUCTURAS LINEALES Y MATRICES (JAVA)");
        System.out.println("==================================================");

        // Sección Arreglos
        EjerciciosArreglos.punto1();
        EjerciciosArreglos.punto2();
        EjerciciosArreglos.punto3(5);
        EjerciciosArreglos.punto4();
        EjerciciosArreglos.punto5();

        // Sección ArrayList
        EjerciciosArrayList.punto6();
        EjerciciosArrayList.punto7(scanner);
        EjerciciosArrayList.punto8();
        EjerciciosArrayList.punto9();
        EjerciciosArrayList.punto10();

        // Sección Matrices
        EjerciciosMatrices.punto11(scanner);
        EjerciciosMatrices.punto12();
        EjerciciosMatrices.punto13();
        EjerciciosMatrices.punto14();
        EjerciciosMatrices.punto15(scanner);

        scanner.close();
        System.out.println("\n¡Ejecución finalizada exitosamente!");
    }
}
