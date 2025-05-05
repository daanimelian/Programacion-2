package preparcial;
import clase2.src.MyException;
import clase4.src.Entrada;
import clase3.Node;

public class ArrayPriorityList<K extends Comparable<K>, V> implements PriorityList<K,V>{

    private Entrada<K,V> [] lista;
    protected int size = 0;
    protected Entrada<K,V> current;
    protected int currentIndex = 0;


    public ArrayPriorityList(int tamanio) {
        lista = (Entrada<K,V>[]) new Entrada[tamanio];
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

        if (size == 0){
            throw new MyException("La lista esta vacia");
        }

        for(int i = 0; i < size-1; i++){
            lista[i] = lista[i+1];
        }
        lista[size-1] = null;
        size--;

    }

    @Override
    public void removeLast() throws MyException {
        if (size == 0){
            throw new MyException("La lista esta vacia");

        }
        lista[size-1] = null;
        size--;

    }

    @Override
    public void remove(V element) throws MyException {

        if (size == 0){
            throw new MyException("La lista esta vacia");
        }

        Entrada<K,V> [] listaNueva = (Entrada<K,V>[]) new Entrada[size];
        int index = 0;
        int eliminados = 0;


        for(int i = 0; i < size; i++){
            if(!lista[i].getValue().equals(element)){
                listaNueva[index] = lista[i];
                index++;
            }
            else{
                eliminados++;
            }
        }
        lista = listaNueva;
        size-= eliminados;

    }

    @Override
    public void First() {

        if (size == 0){
            throw new MyException("La lista esta vacia");
        }
        else{
            current = lista[0];
            currentIndex = 0;
        }

    }

    @Override
    public void advance() {
        if (size == 0) {
            throw new MyException("La lista esta vacia");
        } else {
            if (currentIndex < size - 1) {
                currentIndex++;
                current = lista[currentIndex];
            } else {
                throw new MyException("Llegaste al final de la lista");
            }
        }

    }

    @Override
    public V getCurrent() {
        return current.getValue();
    }

    @Override
    public boolean atEnd() {
        return currentIndex == size-1;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void removeAllPriority(K priority) {
        if (size == 0){
            throw new MyException("La lista esta vacia");
        }
        else{
            Entrada<K,V> [] listaNueva = new Entrada[size];
            int index = 0;
            int eliminados = 0;
            for(int i = 0; i < size; i++){
                if(!lista[i].getKey().equals(priority)){
                    listaNueva[index] = lista[i];
                    index++;
                }
                else{
                    eliminados++;
                }
            }
            lista = listaNueva;
            size-= eliminados;
        }

    }

    @Override
    public V[] sortedByPriority() {
        if (size == 0) {
            throw new MyException("La lista esta vacia");
        }

        V[] sortedValues = (V[]) new Object[size];
        Entrada<K,V>[] listaNueva = (Entrada<K,V>[]) new Entrada[size];
        for (int i = 0; i < size; i++) {
            listaNueva[i] = lista[i]; // Copiamos la lista original
        }

        int sizeSorted = 0;
        int elementosRestantes = size;

        while (sizeSorted < size) {
            // Buscar la prioridad mínima en listaNueva
            K minPriority = null;
            for (int i = 0; i < elementosRestantes; i++) {
                if (listaNueva[i] != null) {
                    if (minPriority == null || listaNueva[i].getKey().compareTo(minPriority) < 0) {
                        minPriority = listaNueva[i].getKey();
                    }
                }
            }

            // Agregar los elementos con esa prioridad al resultado
            for (int i = 0; i < elementosRestantes; i++) {
                if (listaNueva[i] != null && listaNueva[i].getKey().equals(minPriority)) {
                    sortedValues[sizeSorted++] = listaNueva[i].getValue();
                    listaNueva[i] = null;
                }
            }
        }

        return sortedValues;
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
