package preparcial;
import clase3.LinkedStack;
import clase4.src.LinkedQueue;
import clase5.Dictionary.LinkedDictionary;
import clase5.List.LinkedList;

import java.util.Objects;


public class Metodos {
    public static boolean capicua(LinkedQueue<Integer> cola) {
        boolean esCapicua = false;
        LinkedQueue<Integer> aux = new LinkedQueue<>();
        LinkedStack<Integer> copia = new LinkedStack<>();

        while(!cola.isEmpty()){
            Integer elem = cola.dequeue();
            aux.enqueue(elem);
            copia.push(elem);
        }

        while (!aux.isEmpty()){

            Integer elem1 = aux.dequeue();
            Integer elem2 = copia.pop();

            if (!Objects.equals(elem1, elem2)){
                return esCapicua;
            }
        }

        esCapicua=true;

        return esCapicua;

    }

    static boolean sonIguales(LinkedDictionary<Integer, String> d1, LinkedDictionary<Integer, String> d2){
            boolean son_iguales = false;

            Iterable<Integer> keys_d1 = d1.keys();
            Iterable<Integer> keys_d2 = d2.keys();
            int cant_keys_d1 =0;
            int cant_keys_d2 =0;
            for (Integer key: keys_d1){
                cant_keys_d1++;
            }
            for ( Integer key: keys_d2){
                cant_keys_d2++;
            }

            if (cant_keys_d1 != cant_keys_d2){
                return son_iguales;
            }
            else{
                for (Integer key: keys_d1){

                    Iterable<String> values_1 = d1.get(key);
                    Iterable<String> values_2 = d2.get(key);
                    if(!iterablesIguales(values_1, values_2)|| values_2 == null){
                        return son_iguales;
                    }


                }

                son_iguales = true;

                return son_iguales;



            }

        }

        static  boolean iterablesIguales(Iterable<String> s1, Iterable<String> s2){
            boolean es_igual = true;
            LinkedList<String> lista1 = new LinkedList<>();
            LinkedList<String> lista2 = new LinkedList<>();
            for(String elemento1: s1){
                lista1.addFirst(elemento1);

            }
            for(String elemento2: s2){
                lista2.addFirst(elemento2);
            }
            if (lista1.getSize() != lista2.getSize()){
                es_igual = false;
                return es_igual;
            }
            else{
                lista1.First();

                for(int j=0; j < lista1.getSize(); j++){

                    String elem1 = lista1.getCurrent();
                    boolean se_encontro = false;

                    lista2.First();
                    for (int k=0; k < lista2.getSize() && !se_encontro ; k++){
                        String elem2 = lista2.getCurrent();

                        if (elem1.equals(elem2)){
                            se_encontro = true;
                        }
                        else{
                            lista2.advance();
                        }

                    }

                    if (!se_encontro){
                        es_igual = false;
                        return  es_igual;
                    }
                }

            }

            return es_igual;
        }


    }

