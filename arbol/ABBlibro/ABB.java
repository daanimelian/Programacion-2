package arbol.ABBlibro;

public class ABB implements ABBTDA{

    NodoABB raiz;

    public int raiz(){
        return raiz.info;
    }

    public boolean arbolVacio(){
        return (raiz==null);
    }

    public void inicializarArbol(){
        raiz = null;
    }

    public ABBTDA hijoDerecho(){
        return raiz.hijoDerecho;
    }

    public ABBTDA hijoIzquierdo(){
        return raiz.hijoIzquierdo;
    }

    public void agregarElemento(int x){
        if(raiz==null){
            raiz = new NodoABB();
            raiz.info = x;
            raiz.hijoIzquierdo = new ABB();
            raiz.hijoIzquierdo.inicializarArbol();
            raiz.hijoDerecho = new ABB();
            raiz.hijoDerecho.inicializarArbol();
        }
        else if(raiz.info > x){
            raiz.hijoIzquierdo.agregarElemento(x);
        }
        else if(raiz.info < x){
            raiz.hijoDerecho.agregarElemento(x);
        }

    }

    public void eliminarElemento(int x){
        if(raiz != null){
            if(raiz.info == x && raiz.hijoIzquierdo.arbolVacio() && raiz.hijoDerecho.arbolVacio()){
                raiz = null;
            }
            else if (raiz.info == x && !raiz.hijoIzquierdo.arbolVacio()){
                raiz.info = this.mayor(raiz.hijoIzquierdo);
                raiz.hijoIzquierdo.eliminarElemento(raiz.info);
            }
            else if (raiz.info == x && raiz.hijoIzquierdo.arbolVacio()){
                raiz.info = this.mayor(raiz.hijoDerecho);
                raiz.hijoDerecho.eliminarElemento(raiz.info);
            }
            else if (raiz.info < x){
                raiz.hijoDerecho.eliminarElemento(x);
            }
            else{
                raiz.hijoIzquierdo.eliminarElemento(x);
            }
        }
    }

    private int mayor(ABBTDA a){
        if (a.hijoDerecho().arbolVacio()){
            return a.raiz();
        }
        else{
            return mayor(a.hijoDerecho());
        }
    }

    private int menor(ABBTDA a){
        if (a.hijoIzquierdo().arbolVacio()){
            return a.raiz();
        }
        else{
            return menor(a.hijoIzquierdo());
        }
    }



}
