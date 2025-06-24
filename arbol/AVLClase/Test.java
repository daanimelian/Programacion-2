package arbol.AVLClase;
import clase5.List.LinkedList;
import clase5.List.Node;
import clase5.Map.Entry;
import clase5.Map.LinkedMap;
import clase5.Map.Map;

import java.util.Comparator;

public class Test {

	public static void main(String[] args) {
        Comparator<Integer> d = new DefaultComparator<Integer>();
        AVL<Integer> tree = new AVL<Integer>(d);

        int[] values = {20, 10, 30, 5, 15};
        System.out.println("Insertando valores:");
        for (int v : values) {
            System.out.println("Insert: " + v);
            tree.insert(v);
        }

        System.out.print("\nLista de valores ordenados:");
        LinkedList<NodoAVL< Integer>> lista = new LinkedList<>();
        lista = tree.nodesInOrder();
        for (NodoAVL n : lista) {
                System.out.print(n.data + " ");
        }
        System.out.println("\n");

        System.out.print("Recorrido in-order: "+tree.toString());

        System.out.print("\nMap de subalturas:");
            Map<Integer, Integer> dict = new LinkedMap<>();
            dict = tree.alturasSubarboles();
            for (Entry<Integer, Integer> entry : dict.entries()) {
                    System.out.println("Elemento: " + entry.getKey() + ", altura: " + entry.getValue());
            }
            System.out.println("\n");



        /*System.out.println("\nEliminando valor 40:");
        tree.delete(40);
        System.out.print("Después de eliminar 40: "+tree.toString());
        
        System.out.println("\nInsertando valor 5:");
        tree.insert(5);
        System.out.print("Después de insertar 5: "+tree.toString());*/
    }

}
