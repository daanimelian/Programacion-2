package TPO.Clase4Ejercicio4.src.main;


import TPO.Clase4Ejercicio4.src.PilaEnlazada.Pila;
import TPO.Clase4Ejercicio4.src.cola.Cola;

public class Main {

	public static void main(String[] args) throws Exception {
		Pila<Cola<Integer>> P1 = new Pila<Cola<Integer>> ();
		Pila<Cola<Integer>> P2 = new Pila<Cola<Integer>> ();
		
		// P1
				Cola<Integer> c1 = new Cola<>();
				c1.enqueue(5);
				P1.push(c1);

				Cola<Integer> c2 = new Cola<>();
				c2.enqueue(1);
				c2.enqueue(3);
				P1.push(c2);

				Cola<Integer> c3 = new Cola<>();
				c3.enqueue(7);
				c3.enqueue(8);
				c3.enqueue(9);
				c3.enqueue(10);
				P1.push(c3);

				Cola<Integer> c9 = new Cola<>();
		c9.enqueue(15);
		c9.enqueue(16);
		c9.enqueue(17);
		c9.enqueue(18);
		c9.enqueue(19);
				P1.push(c9);

				// P2
				Cola<Integer> c4 = new Cola<>();
				c4.enqueue(6);
				P2.push(c4);

				Cola<Integer> c5 = new Cola<>();
				c5.enqueue(2);
				c5.enqueue(4);
				c5.enqueue(6);
				P2.push(c5);

				Cola<Integer> c6 = new Cola<>();
				c6.enqueue(10);
				c6.enqueue(11);
				c6.enqueue(12);
				c6.enqueue(13);
				c6.enqueue(14);
				P2.push(c6);

				
		Pila<Cola<Integer>> Pout = Ejercicio(P1,P2);
		System.out.println("COLA DE PILAS 1");
		while(!P1.isEmpty()) {
			Cola<Integer> Cout = P1.pop();
			while(!Cout.isEmpty()) {
				System.out.print(Cout.dequeue());
			}
			System.out.print("\n");
		}
		System.out.println("COLA DE PILAS 2");
		while(!P2.isEmpty()) {
			Cola<Integer> Cout = P2.pop();
			while(!Cout.isEmpty()) {
				System.out.print(Cout.dequeue());
			}
			System.out.print("\n");
		}

		while(!Pout.isEmpty()) {
			Cola<Integer> Cout = Pout.pop();
			while(!Cout.isEmpty()) {
				System.out.print(Cout.dequeue());				
			}
			System.out.print("\n");		
		}
		
		
	}
	
	private static Pila<Cola<Integer>> Ejercicio(Pila<Cola<Integer>> P1, Pila<Cola<Integer>> P2){
		Pila<Cola<Integer>> Pout = new Pila<Cola<Integer>> ();
		Pila<Cola<Integer>> P1AUX = new Pila<Cola<Integer>> ();
		Pila<Cola<Integer>> P2AUX = new Pila<Cola<Integer>> ();
		
		
		while(!P1.isEmpty()) {
			P1AUX.push(P1.pop());			
		}
		
		while(!P2.isEmpty()) {
			P2AUX.push(P2.pop());			
		}
		
	   while (!P1AUX.isEmpty() || !P2AUX.isEmpty()) {
	        Cola<Integer> C1 = P1AUX.top();
	        Cola<Integer> C2 = P2AUX.top();

	        if (C1 == null) {
	            Pout.push(P2AUX.pop());
	        } else if (C2 == null) {
	            Pout.push(P1AUX.pop());
	        } else if (C1.size() <= C2.size()) {
	            Pout.push(P1AUX.pop());
	        } else {
	            Pout.push(P2AUX.pop());
	        }
	    }
		
		return Pout;
	}

	private static Pila<Cola<Integer>> unirPilasOrdenadas(Pila<Cola<Integer>> P1, Pila<Cola<Integer>> P2) {
		Pila<Cola<Integer>> Pout = new Pila<>();
		Pila<Cola<Integer>> P1AUX = new Pila<>();
		Pila<Cola<Integer>> P2AUX = new Pila<>();

		// Dar vuelta las pilas originales para poder recorrerlas de menor a mayor
		while (!P1.isEmpty()) {
			P1AUX.push(P1.pop());
		}
		while (!P2.isEmpty()) {
			P2AUX.push(P2.pop());
		}

		// Merge de ambas pilas en orden de tamaño creciente
		while (!P1AUX.isEmpty() && !P2AUX.isEmpty()) {
			Cola<Integer> C1 = P1AUX.top();
			Cola<Integer> C2 = P2AUX.top();

			if (C1.size() <= C2.size()) {
				Pout.push(P1AUX.pop());
			} else {
				Pout.push(P2AUX.pop());
			}
		}

		// Agregar lo que quedó
		while (!P1AUX.isEmpty()) {
			Pout.push(P1AUX.pop());
		}

		while (!P2AUX.isEmpty()) {
			Pout.push(P2AUX.pop());
		}

		return Pout;
	}


}
