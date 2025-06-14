package arbol.ArbolLista;
import clase5.List.LinkedList;
import clase3.src.Node;

import java.util.Comparator;

    public class TREE<E> implements TREETDA<E> {
            private NodoTREE<E> raiz;

            public TREE(E raizValor) {
                this.raiz = new NodoTREE<>(raizValor);
            }

            @Override
            public boolean pertenece(E elemento) {
                return buscarNodo(raiz, elemento) != null;
            }

            private NodoTREE<E> buscarNodo(NodoTREE<E> nodo, E elemento) {
                if (nodo == null) return null;
                if (nodo.getElemento().equals(elemento)) return nodo;

                nodo.getHijos().First();
                while (!nodo.getHijos().atEnd()) {
                    NodoTREE<E> encontrado = buscarNodo(nodo.getHijos().getCurrent(), elemento);
                    if (encontrado != null) return encontrado;
                    nodo.getHijos().advance();
                }
                return null;
            }

            @Override
            public void insertar(E elemento, E padre) {
                NodoTREE<E> nodoPadre = buscarNodo(raiz, padre);
                if (nodoPadre != null) {
                    NodoTREE<E> nuevo = new NodoTREE<>(elemento);
                    nuevo.setPadre(nodoPadre);
                    nodoPadre.getHijos().addLast(nuevo);
                }
            }

            @Override
            public E eliminar(E elemento) {
                NodoTREE<E> nodo = buscarNodo(raiz, elemento);
                if (nodo == null || (nodo == raiz && nodo.getHijos().getSize() > 0)) return null;

                NodoTREE<E> padre = nodo.getPadre();
                if (padre != null) {
                    nodo.getHijos().First();
                    while (!nodo.getHijos().atEnd()) {
                        NodoTREE<E> hijo = nodo.getHijos().getCurrent();
                        hijo.setPadre(padre);
                        padre.getHijos().addLast(hijo);
                        nodo.getHijos().advance();
                    }
                    padre.getHijos().remove(nodo);
                } else {
                    raiz = null;
                }

                return nodo.getElemento();
            }
    }

