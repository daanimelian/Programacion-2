package clase5.Dictionary;

import java.util.Iterator;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Dinámico:");
		Dictionary<Integer, Integer> diccionario = new LinkedDictionary<Integer, Integer>();
		diccionario.put(1, 10);
		diccionario.put(1, 12);
		diccionario.put(1, 15);
		diccionario.put(2, 21);
		diccionario.put(2, 28);
		diccionario.put(5, 58);
		
		Iterator<Integer> misValores = diccionario.get(2).iterator();
		System.out.println("Clave 2:");
		while (misValores.hasNext()) {
			System.out.print(misValores.next() + " ");
		}
		
		System.out.println("\nElimino clave 2:");
		misValores = diccionario.remove(2).iterator();
		while (misValores.hasNext()) {
			System.out.print(misValores.next() + " ");
		}
		
		System.out.println("\nElimino clave 5 valor: " + diccionario.remove(5, 58));
		
		diccionario.put(3, 32);
		diccionario.put(4, 47);
		diccionario.put(3, 39);
		
		System.out.println("Claves: ");
		Iterator<Integer> misClaves = diccionario.keys().iterator();
		while (misClaves.hasNext()) {
			System.out.print(misClaves.next() + " ");
		}
		
		Iterator<Entrada<Integer, Iterable<Integer>>> misEntradas = diccionario.entries().iterator();
		System.out.println("\nEntradas: ");
		while (misEntradas.hasNext()) {
			Entrada<Integer, Iterable<Integer>> entrada = misEntradas.next();
			System.out.println("\nClave: " + entrada.getKey());
			Iterator<Integer> valores = entrada.getValue().iterator();
			while (valores.hasNext()) {
				System.out.print(valores.next() + " ");
			}
		}
		
		System.out.println("\n\nEstático:");
		
		Dictionary<Integer, Integer> diccionario2 = new ArrayDictionary<Integer, Integer>();
		diccionario2.put(1, 10);
		diccionario2.put(1, 12);
		diccionario2.put(1, 15);
		diccionario2.put(2, 21);
		diccionario2.put(2, 28);
		diccionario2.put(5, 58);
		
		Iterator<Integer> misValores2 = diccionario2.get(2).iterator();
		System.out.println("Clave 2:");
		while (misValores2.hasNext()) {
			System.out.print(misValores2.next() + " ");
		}
		
		System.out.println("\nElimino clave 2:");
		misValores2 = diccionario2.remove(2).iterator();
		while (misValores2.hasNext()) {
			System.out.print(misValores2.next() + " ");
		}
		
		System.out.println("\nElimino clave 5 valor: " + diccionario2.remove(5, 58));
		
		diccionario2.put(3, 32);
		diccionario2.put(4, 47);
		diccionario2.put(3, 39);
		
		System.out.println("Claves: ");
		Iterator<Integer> misClaves2 = diccionario2.keys().iterator();
		while (misClaves2.hasNext()) {
			System.out.print(misClaves2.next() + " ");
		}
		
		Iterator<Entrada<Integer, Iterable<Integer>>> misEntradas2 = diccionario2.entries().iterator();
		System.out.println("\nEntradas: ");
		while (misEntradas2.hasNext()) {
			Entrada<Integer, Iterable<Integer>> entrada2 = misEntradas2.next();
			System.out.println("\nClave: " + entrada2.getKey());
			Iterator<Integer> valores2 = entrada2.getValue().iterator();
			while (valores2.hasNext()) {
				System.out.print(valores2.next() + " ");
			}
		}
	}

}
