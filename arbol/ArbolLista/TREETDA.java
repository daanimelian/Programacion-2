package arbol.ArbolLista;

public interface TREETDA<E> {

    //Recorre el arbol buscando el elemento E
    public boolean pertenece(E elemento);

    //Busca el elemento padre e inserta elemento en la lista de hijos
    public void insertar(E elemento, E padre);

    //Busca el elemento para eliminar, agrega sus hijos si tiene como hijos de su padre y luego se quita del arbol.
    //No se puede eleminar la raiz salco que no tenga hijos.

    public E eliminar(E elemento);
}
