package arbol.ABBlibro;

public class Funciones {

    // visita primero a los padres y luego a cada hijo en el mismo orden
    public static void preOrder(ABBTDA a) {
        if (!a.arbolVacio()) {
            preOrder(a.hijoIzquierdo());
            preOrder(a.hijoDerecho());
            System.out.println(a.raiz());
        }
    }

    // visita primero los padres y luego cada hijo en el mismo orden. Muestra los nodos ordenados de menor a mayor
    public static void inOrder(ABBTDA a) {
        if (!a.arbolVacio()) {
            inOrder(a.hijoIzquierdo());
            System.out.println(a.raiz());
            inOrder(a.hijoDerecho());
        }
    }

    // primero los hijos y luego la raiz.
    public static void postOrder(ABBTDA a) {
        if (!a.arbolVacio()) {
            postOrder(a.hijoIzquierdo());
            postOrder(a.hijoDerecho());
            System.out.println(a.raiz());
        }
    }

    // contar la cantidad de nodos de un ABB

    public static int contar(ABBTDA a) {
        if(a.arbolVacio()) {
            return 0;
        }
        else {
            return (1 + contar(a.hijoIzquierdo()) + contar(a.hijoDerecho()));
        }

    }

    // dado un elemento y un ABB, calcula su profundidad en el arbol

    public static int calcularProfundidad(ABBTDA t, int x){
        if(t.arbolVacio()) {
            return 0;
        }
        else if(t.raiz() == x){
            return 0;
        }
        else if (t.raiz() > x){
            return (1+ calcularProfundidad(t.hijoIzquierdo(),x));
        }
        else {
            return (1+ calcularProfundidad(t.hijoDerecho(),x));
        }

    }

    // dado un elemento, determinar si esta o no en un ABB

    public boolean existeElementoEnABB(ABBTDA t, int x){
        if(t.arbolVacio()) {
            return false;
        }
        else if(t.raiz() == x){
            return true;
        }
        else if (t.raiz() > x){
            return existeElementoEnABB(t.hijoIzquierdo(),x);
        }
        else {
            return existeElementoEnABB(t.hijoDerecho(),x);
        }
    }

}
