package arbol.ABBlibro;

public interface ABBTDA {

    // siempre que el arbol este inicializando y no este vacio
    int raiz();

    // siempre que el arbol este inicializado y no este vacio
    ABBTDA hijoIzquierdo();

    // siempre que el arbol este incializado y no este vacio
    ABBTDA hijoDerecho();

    // siempre que el arbol este inicializado
    boolean arbolVacio();

    void inicializarArbol();

    // siempre que el arbol este inicializado
    void agregarElemento(int x);

    // siempre que el arbol este inicializado
    void eliminarElemento(int x);
}
