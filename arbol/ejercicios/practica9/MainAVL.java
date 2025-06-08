package arbol.ejercicios.practica9;

import arbol.AVLClase.AVL;
import arbol.AVLClase.DefaultComparator;
import arbol.AVLClase.NodoAVL;
import java.util.Comparator;
import java.util.Scanner;

public class MainAVL {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Comparator<Integer> d = new DefaultComparator<Integer>();
        AVL<Integer> arbol = new AVL<Integer>(d);

        System.out.println("Ingrese números para el AVL ('.' para terminar):");

        while (true) {
            String entrada = sc.nextLine().trim();
            if (entrada.equals(".")) break;
            try {
                int valor = Integer.parseInt(entrada);
                arbol.insert(valor);
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Ingrese un número o '.' para terminar.");
            }
        }

        NodoAVL<Integer> raiz = arbol.getRoot();

        System.out.println("\nÁrbol por niveles:");
        ejercicio4<Integer> ej4 = new ejercicio4<>();
        ej4.imprimirPorNiveles(arbol);

        ejercicio5<Integer> ej5 = new ejercicio5<>();
        System.out.println("\nAltura del AVL: " + ej5.altura(arbol));

        ejercicio3<Integer> ej3 = new ejercicio3<>();
        Integer minimoElemento = ej3.minimo(arbol);
        System.out.println("\nMinimo elemento: " + minimoElemento);
    }
}
