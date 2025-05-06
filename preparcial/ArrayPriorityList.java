package preparcial;
import clase5.Dictionary.MyException;
import clase4.src.Entrada;
import clase3.Node;

public class ArrayPriorityList<K extends Comparable<K>, V> implements PriorityList<K,V>{

    private Entrada<K,V> [] lista;
    protected int size = 0;


    public ArrayPriorityList(int tamanio) {
        lista = (Entrada<K,V>[]) new Object[tamanio];
    }

    @Override
    public void addFirst(V newElement, K priority) {
        Entrada<K,V> entrada  = new Entrada<>(priority, newElement);
        if(size == lista.length)
            resize();
        for(int i = size; i>0; i--){

            lista[i] = lista[i-1];

            }
            lista[0] = entrada;
        size++;

    }


    @Override
    public void addLast(V newElement, K priority) {
        Entrada<K,V> entrada  = new Entrada<>(priority, newElement);

        if (size == lista.length)
            resize();

        lista[size] = entrada;
        size++;

    }

    @Override
    public void removeFirst() throws MyException {

    }

    @Override
    public void removeLast() throws MyException {

    }

    @Override
    public void remove(V element) throws MyException {

    }

    @Override
    public void First() {

    }

    @Override
    public void advance() {

    }

    @Override
    public V getCurrent() {
        return null;
    }

    @Override
    public boolean atEnd() {
        return false;
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public void removeAllPriority(K priority) {

    }

    @Override
    public V[] sortedByPriority() {
        return null;
    }

    private void resize() {
        int newSize = lista.length*2;
        Entrada<K,V> [] newlista = new Entrada[newSize];
        for(int i = 0; i < size; i++){
            newlista[i] = lista[i];
        }
        lista = newlista;
    }
}
