package arbol.AVLClase;

import arbol.ABBClase.NodoABB;

public class NodoAVL<E> {
    E data;
    NodoAVL<E> left, right;
    int height;

    public NodoAVL(E data) {
        this.data = data;
        this.left = null;
        this.right = null;
        this.height = 1;
    }

    public E getElemento() { return data;}
    public NodoAVL<E> getIzq() { return left;}
    public NodoAVL<E> getDer() { return right;}
    public void setElemento(E element){this.data = element;}
    public void setIzq(NodoAVL<E> izq){this.left = izq;}
    public void setDer(NodoAVL<E> der){this.right = der;}
}
