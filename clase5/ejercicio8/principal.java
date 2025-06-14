package clase5.ejercicio8;
import clase3.src.ArrayList;
import clase5.Map.ArrayMap;
import clase5.Dictionary.LinkedDictionary;

import static clase5.ejercicio8.metodos.unir;


public class principal {
    public static void main(String[] args) {
        ArrayMap<Integer, String> map1 = new ArrayMap<>();
        map1.put(12345, "8");
        map1.put(23456, "9");
        map1.put(34567, "7");

        ArrayMap<Integer, String> map2 = new ArrayMap<>();
        map2.put(12345, "7");
        map2.put(23456, "9");
        map2.put(45678, "6");

        ArrayMap<Integer, String> map3 = new ArrayMap<>();
        map3.put(12345, "8");
        map3.put(23456, "8");
        map3.put(34567, "7");

        int tamanio = map1.size() + map2.size() + map3.size();

        ArrayList<ArrayMap<Integer, String>> maps = new ArrayList<>(tamanio);

        maps.addLast(map1);
        maps.addLast(map2);
        maps.addLast(map3);

        LinkedDictionary<Integer, String> resultado = unir(maps);

        // Imprimir resultados
        for (Integer clave : resultado.keys()) {
            Iterable<String> notas = resultado.get(clave);
            for (String nota : notas) {
                System.out.println("DNI: " + clave + " - Nota: " + nota);
            }
        }
    }
}
