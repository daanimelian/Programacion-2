package grafo;

public interface GrafoTDA<E> {
    void agregarVertice(E v); // grafo inicializado y no existe vertice
    void eliminarVertice(E v); // grafo inicializado y existe vertice
    E[] vertices(); // grafo inicializado
    void agregarArista(E v1, E v2, int peso); // grafo inicializado, no existe arista y existen ambos vertices
    void eliminarArista(E v1, E v2); // grafo inicializado y existe arista
    boolean existeArista(E v1, E v2); // grafo inicializado y existen ambos vertices
    int pesoArista(E v1, E v2); // grafo inicializado y existe arista
}
