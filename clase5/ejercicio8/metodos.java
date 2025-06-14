package clase5.ejercicio8;

import clase3.src.ArrayList;
import clase5.Map.ArrayMap;
import clase5.Map.Entry;
import clase5.Dictionary.LinkedDictionary;
import java.util.Objects;

public class metodos {

    public static LinkedDictionary<Integer, String> unir(ArrayList<ArrayMap<Integer, String>> M1){

        LinkedDictionary<Integer, String> union = new LinkedDictionary<>();

        // Recorremos cada diccionario de la lista M1
        for (int i = 0; i < M1.getSize(); i++) {
            ArrayMap<Integer, String> map = M1.get(i);
            // Recorremos todas las entradas del diccionario actual
            Entry<Integer, String>[] entries = map.entries();
            for (Entry<Integer, String> entry : entries) {
                Integer dni = entry.getKey();
                String nota = entry.getValue();
                union.put(dni,nota);  // Agregamos la nueva nota

            }
        }

        return union;

    }

    // cargarNotas

    public static ArrayMap<Integer, String> crearMap(){
        ArrayMap<Integer,String> notas = new ArrayMap<Integer,String>();
        System.out.print("Ingrese un DNI: ");
        String key = System.console().readLine();
        int keyN = Integer.parseInt(key);
        System.out.print("Ingrese la nota de la materia A (0-10): ");
        String value1 = System.console().readLine();
        String salida1 = notas.put(keyN, value1);
        System.out.println("Nota materia A : "+salida1);
        while(keyN!=-1 && !Objects.equals(value1, "-1")) {
            System.out.print("Ingrese un DNI: ");
            key = System.console().readLine();
            keyN = Integer.parseInt(key);
            System.out.print("Ingrese la nota de la materia A (0-10): ");
            value1 = System.console().readLine();
            salida1 = notas.put(keyN, value1);
            System.out.println("Nota materia A : "+salida1);
        }

        notas.remove(keyN);

        return notas;
    }
}
