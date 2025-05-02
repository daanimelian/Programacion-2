package clase5.Map;

public class Principal {

	public static void main(String[] args) {
		/*ArrayMap<Integer,String> diccionario = new ArrayMap<Integer,String>();
		System.out.print("Ingrese una clave: ");
		String key = System.console().readLine();
		int keyN = Integer.parseInt(key);
		System.out.print("Ingrese un valor: ");
		String value = System.console().readLine();
		String salida = diccionario.put(keyN, value);
		System.out.println("Valor retornado: "+salida);
		while(keyN!=-1 && value!="-1") {
			System.out.print("Ingrese una clave: ");
			key = System.console().readLine();
			keyN = Integer.parseInt(key);
			System.out.print("Ingrese un valor: ");
			value = System.console().readLine();
			salida = diccionario.put(keyN, value);
			System.out.println("Valor retornado: "+salida);
		}
		diccionario.remove(-1);
		System.out.println("El diccionario creado es:");
		System.out.print("{");
		Entry<Integer,String>[] entradas = diccionario.entries();
		for(int i = 0; i<entradas.length;i++)
			System.out.print(" ( "+entradas[i].getKey()+" , "+entradas[i].getValue()+" ) |");
		System.out.print("}");
		
	}
	
	static boolean sonDiccionariosIguales(ArrayMap<Integer,String> unDiccionario, ArrayMap<Integer,String> otroDiccionario) {
		if(unDiccionario.size()!=otroDiccionario.size())
			return false;
		Entry<Integer,String>[] entradasUnDiccionario = unDiccionario.entries();
		int i =0;
		boolean sonIguales=true;
		while(i<entradasUnDiccionario.length && sonIguales) {
			sonIguales=otroDiccionario.get(entradasUnDiccionario[i].getKey()).equals(entradasUnDiccionario[i].getValue());
			i++;
		}
		return sonIguales;
	}*/

		ArrayMap<Integer, String> diccionario = new ArrayMap<>();

		diccionario.put(1, "cinco");
		diccionario.put(2, "dos");
		diccionario.put(5, "nueve");
		diccionario.put(7, "uno");
		diccionario.put(8, "cuatro");

		ArrayMap<Integer, String> diccionario2 = new ArrayMap<>();

		diccionario2.put(1, "cinco");
		diccionario2.put(3, "dos");
		diccionario2.put(5, "nueve");
		diccionario2.put(7, "uno");
		diccionario2.put(8, "cuatro");

		boolean sonIguales = ArrayMap.sonIguales(diccionario, diccionario2);

		System.out.println("\nSon iguales: " + sonIguales);
	}

}
