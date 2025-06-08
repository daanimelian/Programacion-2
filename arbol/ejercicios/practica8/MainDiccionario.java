package arbol.ejercicios.practica8;
import clase5.Dictionary.Entrada;


public class MainDiccionario {
    public static void main(String[] args) {
        // Crear diccionario múltiple
        TDADictionary<String, Integer> diccionario = new TDADictionary<>();

        // Insertar claves y múltiples valores
        diccionario.put("pares", 2);
        diccionario.put("pares", 4);
        diccionario.put("pares", 6);

        diccionario.put("impares", 1);
        diccionario.put("impares", 3);
        diccionario.put("impares", 5);

        diccionario.put("primos", 2);
        diccionario.put("primos", 3);
        diccionario.put("primos", 5);
        diccionario.put("primos", 7);

        // Obtener valores asociados a una clave
        System.out.println("Valores de la clave 'pares':");
        imprimirIterable(diccionario.get("pares"));

        System.out.println("Valores de la clave 'primos':");
        imprimirIterable(diccionario.get("primos"));

        System.out.println("Valores de la clave 'impares':");
        imprimirIterable(diccionario.get("impares"));

        // Probar remove(k, v)
        System.out.println("\nEliminando 4 de 'pares'...");
        diccionario.remove("pares", 4);
        System.out.println("Valores actualizados de 'pares':");
        imprimirIterable(diccionario.get("pares"));

        // Probar remove(k)
        System.out.println("\nEliminando clave 'impares' completa...");
        imprimirIterable(diccionario.remove("impares"));

        // Mostrar todas las entradas
        System.out.println("\nEntradas actuales del diccionario:");
        for (Entrada<String, Iterable<Integer>> e : diccionario.entries()) {
            System.out.print(e.getKey() + ": ");
            imprimirIterable(e.getValue());
        }
    }

    private static <T> void imprimirIterable(Iterable<T> it) {
        for (T elem : it) {
            System.out.print(elem + " ");
        }
        System.out.println();
    }
}
