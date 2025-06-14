package arbol.ejercicios.practica8;

import arbol.ABBClase.ABBImple;
import arbol.ABBClase.DefaultComparator;
import clase3.src.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Crear árbol ABB
        ABBImple<Integer> arbol = new ABBImple<>(new DefaultComparator<Integer>());
        arbol.insertar(10);
        arbol.insertar(5);
        arbol.insertar(15);
        arbol.insertar(3);
        arbol.insertar(7);
        arbol.insertar(12);
        arbol.insertar(18);

        // Crear clase de recorridos
        ejercicio3<Integer> recorridos = new ejercicio3<>();

        // InOrder
        ArrayList<Integer> inOrder = recorridos.elementosInOrder(arbol.getRaiz());
        System.out.print("InOrder: ");
        imprimirLista(inOrder);

        // PreOrder
        ArrayList<Integer> preOrder = recorridos.elementosPreOrder(arbol.getRaiz());
        System.out.print("PreOrder: ");
        imprimirLista(preOrder);

        // PostOrder
        ArrayList<Integer> postOrder = recorridos.elementosPostOrder(arbol.getRaiz());
        System.out.print("PostOrder: ");
        imprimirLista(postOrder);

        // Prueba del método min()
        ejercicio4<Integer> minBuscador = new ejercicio4<>();
        Integer minimo = minBuscador.min(arbol.getRaiz());
        System.out.println("Mínimo valor del árbol: " + minimo);

        // Prueba imprimir por niveles
        ejercicio5<Integer> imprimirNivel = new ejercicio5<>();
        imprimirNivel.imprimirNiveles(arbol.getRaiz());

        // Prueba de altura
        ejercicio6<Integer> ejercicio6 = new ejercicio6<>();
        System.out.println("La altura es de: " + ejercicio6.altura(arbol.getRaiz()));
    }

    private static <E> void imprimirLista(ArrayList<E> lista) {
        for (int i = 0; i < lista.getSize(); i++) {
            System.out.print(lista.get(i) + " ");
        }
        System.out.println();
    }
}
