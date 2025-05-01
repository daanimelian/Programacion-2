package clase5.ejercicio7;

import clase3.ArrayList;
import clase5.Map.Entrada;
import clase5.Map.ArrayMap;

import java.util.Objects;

public class metodos{

    public static ArrayList<Entrada<Integer, String>> unir(ArrayMap<Integer, String> M1, ArrayMap<Integer, String> M2){

        Object[] keys = M1.keys();
        ArrayList<Entrada<Integer, String>> union = new ArrayList<>(M1.size());


        for (int i = 0; i < keys.length; i++){

            Integer clave = (Integer) keys[i];
            String valor1 = M1.get(clave);
            String valor2 = M2.get(clave);

            System.out.println( clave + ": " + valor1+"-"+valor2);

            if (valor2 != null && !Objects.equals(valor1, valor2)) {
                union.addLast(new Entrada<>(clave, valor1));
                union.addLast(new Entrada<>(clave, valor2));
            }



            }

        return union;

    }
}
