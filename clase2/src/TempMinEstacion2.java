package clase2.src;
import java.util.Objects;

/*Defina una clase TempMinEstacion que encapsule la representación de las temperaturas
mínimas registradas en una estación meteorológica y brinde operaciones para:
• Retornar la mayor temperatura registrada
• Calcular el promedio de las temperaturas
• Contar cuántos días heló
• Decidir si hubo heladas
• Retornar la primera temperatura mayor a una dada; si no existe devolver el
mismo valor recibido.
• Decidir si las temperaturas registradas se produjeron en orden creciente*/
public class TempMinEstacion2 {
    private LinkedList S;

    // Constructor: inicializa la lista vacía
    public TempMinEstacion2() {
        S = new LinkedList();
    }

    // Agrega una nueva temperatura mínima al registro (al inicio)
    public void establecerTempMin(Float elem) {
        S.addFirst(elem);
    }

    // Retorna la mayor temperatura registrada
    public Float mayorTempMin() {
        if (S.getHead() == null) {
            throw new MyException("No hay temperaturas registradas");
        }
        Float tempMax = (Float) S.getHead().data;
        for (Node aux = S.getHead().getNext(); aux != null; aux = aux.getNext()) {
            Float valor = (Float) aux.data;
            if (valor > tempMax) {
                tempMax = valor;
            }
        }
        return tempMax;
    }

    // Calcula el promedio de las temperaturas mínimas
    public Float promedioTempMin() {
        if (S.getHead() == null) {
            throw new MyException("No hay temperaturas registradas");
        }
        float suma = 0f;
        int count = 0;
        for (Node aux = S.getHead(); aux != null; aux = aux.getNext()) {
            suma += (Float) aux.data;
            count++;
        }
        return suma / count;
    }

    // Cuenta cuántos días heló (temp < 0)
    public int cantHeladas() {
        int heladas = 0;
        for (Node aux = S.getHead(); aux != null; aux = aux.getNext()) {
            if ((Float) aux.data < 0) {
                heladas++;
            }
        }
        return heladas;
    }

    // Decide si hubo al menos una helada
    public boolean huboHeladas() {
        return cantHeladas() > 0;
    }

    // Retorna la primera temperatura mayor que t; si no hay, devuelve t
    public Float primeroMayor(Float t) {
        for (Node aux = S.getHead(); aux != null; aux = aux.getNext()) {
            Float valor = (Float) aux.data;
            if (valor > t) {
                return valor;
            }
        }
        return t;
    }

    // Verifica si las temperaturas están en orden creciente
    public boolean ordenadoCreciente() {
        if (S.getHead() == null || S.getHead().getNext() == null) {
            return true;
        }
        for (Node aux = S.getHead(); aux.getNext() != null; aux = aux.getNext()) {
            Float actual = (Float) aux.data;
            Float siguiente = (Float) aux.getNext().data;
            if (actual > siguiente) {
                return false;
            }
        }
        return true;
    }

    /*Extienda la definición de la clase TemperaturasEstacion presentada en clase
incorporando los siguientes servicios:
• float menorTemperatura(): Retornar la menor temperatura registrada
• int posMenorTemperatura(): Retornar la posición de la menor temperatura
• boolean todosPositivos(): Determinar si todas las temperaturas son positivas
• int contarCoincidencias(TemperaturasEstacion s): Calcular en cuántos días dos
estaciones meteorológicas coincidieron en la temperatura mínima, es decir
cuántas componentes coinciden en valor y posición respecto a un objeto de la
misma clase recibido como parámetro. Se asume que se han registrado los
valores de una misma cantidad de días.
• TemperaturasEstacion invertir(): Generar un objeto de clase
TemperaturasEstacion con las mismas componentes que la tabla que recibe el
mensaje, pero almacenadas en orden inverso.
• void reemplazar(float val1,val2): Reemplazar toda aparición del valor val1 por
val2
• String intercambiar(int pos1, pos2): Intercambiar las componentes de las
posiciones pos1 y pos2, verificando que ambas existan. Si pudo hacer el
intercambio devuelve una cadenavacía, sino un mensaje de error.
• void invertirMe(): invierte los elementos de la tabla receptora del mensaje
• OPCIONAL void ordenar(): Ordena las temperaturas de mayor a menor. Investigar
métodos de ordenamiento Bubble Sort, Quick Sort, Merge Sort y Búsqueda
Binaria (implementar este último)*/

    public float menorTemperatura(){
        float menor_temperatura = S.getFirst();
        Node aux = this.S.getHead().getNext();
        for(int i=0; i<S.getSize() && aux != null;i++){
            if(aux.data < menor_temperatura){
                menor_temperatura = aux.data;
            }
            aux = aux.getNext();
        }
        return menor_temperatura;
    }

    public int posMenorTemperatura(){
        float menor_temperatura = S.getFirst();
        int pos = 0;
        Node aux = this.S.getHead().getNext();
        for(int i=0; i<S.getSize() && aux != null ;i++){
            if(aux.data < menor_temperatura){
                menor_temperatura = aux.data;
                pos = i;
            }
            aux = aux.getNext();
        }
        return pos;
    }

    public boolean todosPositivos(){
        boolean positivos = true;
        Node aux = this.S.getHead();
        for(int i=0; i<S.getSize() && aux != null;i++){
            if(aux.data<0){
                positivos = false;
            }
            aux = aux.getNext();
        }
        return positivos;
    }

    public int contarCoincidencias(TempMinEstacion2 temp_estacion_2){
        int contador = 0;
        int largo = S.getSize();
        if (S.getSize() > temp_estacion_2.S.getSize()){
            largo = temp_estacion_2.S.getSize();
        }
        Node aux = this.S.getHead();
        Node aux2 = temp_estacion_2.S.getHead();
        for(int i=0; i<largo; i++){
            if(Objects.equals(aux.data, aux2.data)){
                contador++;
            }
            aux2 = aux2.getNext();
            aux = aux.getNext();
        }

        return contador;

    }

    public void reemplazar(float val1, float val2) {
        for (Node aux = S.getHead(); aux != null; aux = aux.getNext()) {
            if ((Float) aux.data == val1) {
                aux.data = val2;
            }
        }
    }

    /**
     * Intercambia los valores en las posiciones pos1 y pos2.
     * Devuelve mensaje de error si alguna posición es inválida.
     */
    public void intercambiar(int pos1, int pos2) {
        int size = S.getSize();
        if (pos1 < 0 || pos1 >= size || pos2 < 0 || pos2 >= size) {
            throw new MyException( "Las posiciones de intercambio no son válidas.");
        }
        Node n1 = S.getHead();
        for (int i = 0; i < pos1; i++) {
            n1 = n1.getNext();
        }
        Node n2 = S.getHead();
        for (int i = 0; i < pos2; i++) {
            n2 = n2.getNext();
        }
        Float temp = (Float) n1.data;
        n1.data = n2.data;
        n2.data = temp;
    }

    /**
     * Invierte el contenido de la lista (voltea todos los elementos).
     */
    public void invertirMe() {
        int size = S.getSize();
        if (size < 2) return;

        for (int i = 0; i < size / 2; i++) {
            Node left = S.getNodeByIndex(i);
            Node right = S.getNodeByIndex(size - 1 - i);

            Float temp = (Float) left.data;
            left.data = right.data;
            right.data = temp;
        }
    }

    /**
     * Ordena la lista enlazada en orden creciente usando bubble sort.
     */
    public void ordenar() {
        if (S.getHead() == null || S.getHead().getNext() == null) return;
        boolean swapped;
        do {
            swapped = false;
            Node current = S.getHead();
            while (current.getNext() != null) {
                Node next = current.getNext();
                if ((Float) current.data > (Float) next.data) {
                    Float temp = (Float) current.data;
                    current.data = next.data;
                    next.data = temp;
                    swapped = true;
                }
                current = next;
            }
        } while (swapped);
    }

    public Float getTempByIndex(int index) {
        Node aux;
        aux = S.getNodeByIndex(index);
        return aux.data;
    }

    public void imprimir() {
        for (Node aux = S.getHead(); aux != null; aux = aux.getNext()) {
            System.out.println(aux.data);
        }
    }

}
