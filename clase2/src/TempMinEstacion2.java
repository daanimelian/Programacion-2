package clase2.src;

import java.util.Objects;

public class TempMinEstacion2 {
    private LinkedList<Float> S;

    public TempMinEstacion2() {
        S = new LinkedList<>();
    }

    public void establecerTempMin(Float elem) {
        S.addFirst(elem);
    }

    public Float mayorTempMin() {
        if (S.getHead() == null) throw new MyException("No hay temperaturas registradas");
        Float tempMax = S.getHead().data;
        for (Node<Float> aux = S.getHead().getNext(); aux != null; aux = aux.getNext()) {
            Float valor = aux.data;
            if (valor > tempMax) tempMax = valor;
        }
        return tempMax;
    }

    public Float promedioTempMin() {
        if (S.getHead() == null) throw new MyException("No hay temperaturas registradas");
        float suma = 0f;
        int count = 0;
        for (Node<Float> aux = S.getHead(); aux != null; aux = aux.getNext()) {
            suma += aux.data;
            count++;
        }
        return suma / count;
    }

    public int cantHeladas() {
        int heladas = 0;
        for (Node<Float> aux = S.getHead(); aux != null; aux = aux.getNext()) {
            if (aux.data < 0) heladas++;
        }
        return heladas;
    }

    public boolean huboHeladas() {
        return cantHeladas() > 0;
    }

    public Float primeroMayor(Float t) {
        for (Node<Float> aux = S.getHead(); aux != null; aux = aux.getNext()) {
            if (aux.data > t) return aux.data;
        }
        return t;
    }

    public boolean ordenadoCreciente() {
        if (S.getHead() == null || S.getHead().getNext() == null) return true;
        for (Node<Float> aux = S.getHead(); aux.getNext() != null; aux = aux.getNext()) {
            if (aux.data > aux.getNext().data) return false;
        }
        return true;
    }

    public float menorTemperatura() {
        if (S.getHead() == null) throw new MyException("No hay temperaturas registradas");
        float menor = S.getHead().data;
        for (Node<Float> aux = S.getHead().getNext(); aux != null; aux = aux.getNext()) {
            if (aux.data < menor) menor = aux.data;
        }
        return menor;
    }

    public int posMenorTemperatura() {
        if (S.getHead() == null) throw new MyException("No hay temperaturas registradas");
        float menor = S.getHead().data;
        int pos = 0;
        int i = 0;
        for (Node<Float> aux = S.getHead(); aux != null; aux = aux.getNext(), i++) {
            if (aux.data < menor) {
                menor = aux.data;
                pos = i;
            }
        }
        return pos;
    }

    public boolean todosPositivos() {
        for (Node<Float> aux = S.getHead(); aux != null; aux = aux.getNext()) {
            if (aux.data < 0) return false;
        }
        return true;
    }

    public int contarCoincidencias(TempMinEstacion2 otra) {
        int contador = 0;
        int size1 = S.getSize();
        int size2 = otra.S.getSize();
        int limite = Math.min(size1, size2);

        Node<Float> aux1 = S.getHead();
        Node<Float> aux2 = otra.S.getHead();
        for (int i = 0; i < limite; i++) {
            if (Objects.equals(aux1.data, aux2.data)) contador++;
            aux1 = aux1.getNext();
            aux2 = aux2.getNext();
        }
        return contador;
    }

    public void reemplazar(float val1, float val2) {
        for (Node<Float> aux = S.getHead(); aux != null; aux = aux.getNext()) {
            if (aux.data == val1) aux.data = val2;
        }
    }

    public void intercambiar(int pos1, int pos2) {
        int size = S.getSize();
        if (pos1 < 0 || pos1 >= size || pos2 < 0 || pos2 >= size)
            throw new MyException("Las posiciones de intercambio no son válidas.");

        Node<Float> n1 = S.getNodeByIndex(pos1);
        Node<Float> n2 = S.getNodeByIndex(pos2);

        Float temp = n1.data;
        n1.data = n2.data;
        n2.data = temp;
    }

    public void invertirMe() {
        int size = S.getSize();
        if (size < 2) return;

        for (int i = 0; i < size / 2; i++) {
            Node<Float> left = S.getNodeByIndex(i);
            Node<Float> right = S.getNodeByIndex(size - 1 - i);

            Float temp = left.data;
            left.data = right.data;
            right.data = temp;
        }
    }

    public void ordenar() {
        if (S.getHead() == null || S.getHead().getNext() == null) return;

        boolean swapped;
        do {
            swapped = false;
            Node<Float> current = S.getHead();
            while (current.getNext() != null) {
                Node<Float> next = current.getNext();
                if (current.data > next.data) {
                    Float temp = current.data;
                    current.data = next.data;
                    next.data = temp;
                    swapped = true;
                }
                current = next;
            }
        } while (swapped);
    }

    public Float getTempByIndex(int index) {
        return S.getNodeByIndex(index).data;
    }

    public void imprimir() {
        for (Node<Float> aux = S.getHead(); aux != null; aux = aux.getNext()) {
            System.out.println(aux.data);
        }
    }
}
