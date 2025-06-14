package arbol.ArbolLista;
import clase5.List.LinkedList;

public class NodoTREE<E> {
    private E elemento;
    private NodoTREE<E> padre;
    private LinkedList<NodoTREE<E>> hijos;

    public NodoTREE(E elemento) {
        this.elemento = elemento;
        this.hijos = new LinkedList<>();
    }

    public E getElemento() {
        return elemento;
    }

    public void setElemento(E elemento) {
        this.elemento = elemento;
    }

    public NodoTREE<E> getPadre() {
        return padre;
    }

    public void setPadre(NodoTREE<E> padre) {
        this.padre = padre;
    }

    public LinkedList<NodoTREE<E>> getHijos() {
        return hijos;
    }
}


