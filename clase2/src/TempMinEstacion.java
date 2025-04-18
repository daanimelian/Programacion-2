package clase2.src;

import java.util.Arrays;

/*Defina una clase TempMinEstacion que encapsule la representación de las temperaturas
mínimas registradas en una estación meteorológica y brinde operaciones para:
• Retornar la mayor temperatura registrada
• Calcular el promedio de las temperaturas
• Contar cuántos días heló
• Decidir si hubo heladas
• Retornar la primera temperatura mayor a una dada; si no existe devolver el
mismo valor recibido.
• Decidir si las temperaturas registradas se produjeron en orden creciente*/
public class TempMinEstacion {
    private Float[] S;

    //Constructores
    public TempMinEstacion(Integer cant) {
        S = new Float[cant];
    }

    //Comandos

    public void establecerTempMin(Integer i, Float elem){
        S[i] = elem;
    }

    //Consultas

    public Float mayorTempMin(){
        Float mayor = S[0];
        for(int i=1;i<S.length;i++){
            if(S[i]>mayor){
                mayor = S[i];
            }
        }
        return mayor;
    }
    public Float promedioTempMin(){
        Float sumatoria = 0.0f;
        int i=0;
        while (i < S.length){
            sumatoria = sumatoria + S[i];
            i++;
        }
        return sumatoria/S.length;
    }
    public Integer cantHeladas(){
        Integer heladas = 0;
        for(int i=0; i<S.length;i++){
            if(S[i]<0){
                heladas++;
            }
        }
        return heladas;
    }
    public boolean huboHeladas(){
        Integer heladas = this.cantHeladas();
        if(heladas>0){
            return true;
        }
        return false;
    }
    public Float primeroMayor(Float t){
        Float mayor = t;
        int i=0;
        while(i < S.length){
            if(S[i]>t){
                mayor = S[i];
                i = S.length;
            }
            i++;
        }
        return mayor;
    }
    public boolean ordenadoCreciente(){
        boolean ordenado = true;
        int i=0;
        while(i < S.length-1 && ordenado){
            if(S[i]>S[i+1]){
                ordenado = false;
            }
            i++;
        }
        return ordenado;
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
        float menor_temperatura = S[0] ;
        for(int i=0; i<S.length;i++){
            if(S[i] < menor_temperatura){
                menor_temperatura = S[i];
            }
        }
        return menor_temperatura;
    }

    public int posMenorTemperatura(){
        float menor_temperatura = S[0];
        int pos = 0;
        for(int i=0; i<S.length;i++){
            if(S[i] < menor_temperatura){
                menor_temperatura = S[i];
                pos = i;
            }
        }
        return pos;
    }

    public boolean todosPositivos(){
        boolean positivos = true;
        for(int i=0; i<S.length;i++){
            if(S[i]<0){
                positivos = false;
            }
        }
        return positivos;
    }

    public int contarCoincidencias(TempMinEstacion temp_estacion_2){
        int contador = 0;
        int largo = S.length;
        if (S.length > temp_estacion_2.S.length){
            largo = temp_estacion_2.S.length;
        }
        for(int i=0; i<largo; i++){
            if(S[i]==temp_estacion_2.S[i]){
                contador++;
            }
        }

        return contador;

    }

    public void reemplazar(float val_1, float val_2){
        for(int i=0; i<S.length;i++){
            if(S[i]==val_1){
                S[i] = val_2;
            }
        }
    }
    public String intercambiar(int pos1, int pos2){
        String msj;
        if(pos1<S.length && pos2<S.length){
            float aux = S[pos1];
            S[pos1] = S[pos2];
            S[pos2] = aux;
            msj = "";
        }

        else{
            msj = " Las posiciones de intercambio no son validas. ";
        }
        return msj;
    }

    public void invertirMe(){

        if (S.length > 0) {
            int middle = S.length / 2;
            for (int i = 0; i < middle; i++) {
                float aux = S[i];
                S[i] = S[S.length - (i + 1)];
                S[S.length - (i + 1)] = aux;
            }
        }

    }

    public void ordenar(int[] lista) {
        for (int i = 1; i < lista.length; i++) {
            int pivot = lista[i];
            int j = i - 1;



            while (j >= 0 && lista[j] > pivot) {
                lista[j + 1] = lista[j];
                j--;


            }
            lista[j + 1] = pivot;

        }
    }



}
