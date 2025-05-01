package clase5.ejercicio7;

import clase3.ArrayList;
import clase5.Map.ArrayMap;
import clase5.Map.Entrada;
import clase5.Map.Entry;
import java.util.Objects;
import static clase5.ejercicio7.metodos.unir;

public class principal{
public static void main(String[] args) {
    ArrayMap<Integer,String> M1 = new ArrayMap<Integer,String>();
    ArrayMap<Integer,String> M2 = new ArrayMap<Integer,String>();
    System.out.print("Ingrese un DNI: ");
    String key = System.console().readLine();
    int keyN = Integer.parseInt(key);
    System.out.print("Ingrese la nota de la materia A (0-10): ");
    String value1 = System.console().readLine();
    String salida1 = M1.put(keyN, value1);
    System.out.print("Ingrese la nota de la materia B (0-10): ");
    String value2 = System.console().readLine();
    String salida2 = M2.put(keyN, value2);
    System.out.println("Nota materia A : "+salida1);
    System.out.println("Nota materia B : "+salida2);
    while(keyN!=-1 && !Objects.equals(value1, "-1") && !Objects.equals(value2, "-1")) {
        System.out.print("Ingrese un DNI: ");
        key = System.console().readLine();
        keyN = Integer.parseInt(key);
        System.out.print("Ingrese la nota de la materia A (0-10): ");
        value1 = System.console().readLine();
        salida1 = M1.put(keyN, value1);
        System.out.print("Ingrese la nota de la materia B (0-10): ");
        value2 = System.console().readLine();
        salida2 = M2.put(keyN, value2);
        System.out.println("Nota materia A : "+salida1);
        System.out.println("Nota materia B : "+salida2);
    }

    M1.remove(keyN);
    M2.remove(keyN);
    System.out.println("Las notas de la materia A son:");
    System.out.print("{");
    Entry<Integer,String>[] entradas1 = M1.entries();
    for(int i = 0; i<entradas1.length;i++)
        System.out.print(" ( "+entradas1[i].getKey()+" , "+entradas1[i].getValue()+" ) |");
    System.out.print("}");
    System.out.print("\n");
    System.out.println("Las notas de la materia B son:");
    System.out.print("{");
    Entry<Integer,String>[] entradas2 = M2.entries();
    for(int i = 0; i<entradas2.length;i++)
        System.out.print(" ( "+entradas2[i].getKey()+" , "+entradas2[i].getValue()+" ) |");
    System.out.print("}");

    ArrayList<Entrada<Integer, String>> union = unir(M1,M2);

    for (int i = 0; i < union.getSize(); i++) {
        Entrada<Integer, String> entrada = union.get(i);
        System.out.println(entrada.toString());
    }


}
}
