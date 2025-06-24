package grafo;
import clase5.List.LinkedList;
import clase3.src.LinkedStack;
import clase3.src.List;
import clase5.Map.MyException;

public class GrafoDin<E> implements GrafoTDA<E> {
	private NodoVertice<E> origen;
	private int vertices;
	
	public GrafoDin() {
		origen = null;
	}
	
	public void agregarVertice(E v) { //El vértice se inserta al inicio de la lista de nodos
		NodoVertice<E> aux = new NodoVertice<E>();
		aux.setVertice(v);
		aux.setAristas(null);
		aux.setSigVertice(origen);
		origen = aux;
		vertices++;
	}
	
	
	
	public void eliminarVertice(E v) {
		if (origen.getVertice().equals(v)) //Es el origen
			origen = origen.getSigVertice(); //Se elimina el origen
		NodoVertice<E> aux = origen; //No es el origen; hay que buscarlo
		while (aux != null) { //Eliminamos aristas hacia v
			this.eliminarAristaNodo(aux, v);
			if (aux.getSigVertice() != null && aux.getSigVertice().getVertice().equals(v)) {
				aux.setSigVertice(aux.getSigVertice().getSigVertice()); //Si es el nodo, lo elimina
				vertices--;
			}
			aux = aux.getSigVertice(); //Sigue eliminando aristas
		}
		
	}
	
	private void eliminarAristaNodo(NodoVertice<E> nodo, E v) {
		NodoArista<E> aux = nodo.getAristas(); //Elimina de nodo las aristas hacia v
		if (aux != null) {
			if (aux.getVerticeDestino().getVertice().equals(v)) { //Hay que eliminar la primera arista
				nodo.setAristas(aux.getSigArista());
			} 
			else { //No es la primera; la buscamos
				while (aux.getSigArista() != null && !aux.getSigArista().getVerticeDestino().getVertice().equals(v))
					aux = aux.getSigArista();
				if (aux.getSigArista() != null) { //Eliminamos la arista
					aux.setSigArista(aux.getSigArista().getSigArista());
				}
			}
		}
	}
	
	public E[] vertices() {
		@SuppressWarnings("unchecked")
		E[] salida = (E[])new Object[vertices];
		NodoVertice<E> aux = origen;
		int i = 0;
		while (aux != null) {
			salida[i]=aux.getVertice();
			i++;
			aux = aux.getSigVertice();
		}
		return salida;
	}

	public E[] verticesAislados(){
		E[] salida = (E[])new Object[vertices];
		NodoVertice<E> aux = origen;
		int i = 0;
		while (aux != null) {
			if (aux.getAristas() == null) {
				salida[i] = aux.getVertice();
				i++;
				aux = aux.getSigVertice();
			}

		}
		return salida;
	}
	
	public void agregarArista(E v1, E v2, int peso ) {
		NodoVertice<E> n1 = vert2Nodo(v1); //Buscamos el nodo origen...
		NodoVertice<E> n2 = vert2Nodo(v2); //... y el nodo destino
		NodoArista<E> aux = new NodoArista<E>(); //La arista va al inicio de la lista...
		aux.setPeso(peso); //... de aristas salientes de v1
		aux.setVerticeDestino(n2);
		aux.setSigArista(n1.getAristas());
		n1.setAristas(aux);
	}


	private NodoVertice<E> vert2Nodo(E v) { //Dado un valor, busca el nodo correspondiente
		NodoVertice<E> aux = origen;
		while (aux != null && !aux.getVertice().equals(v))
			aux = aux.getSigVertice();
		return aux;
	}
	
	public void eliminarArista(E v1, E v2) {
		NodoVertice<E> n1 = vert2Nodo(v1);
		eliminarAristaNodo(n1, v2);
	}
	
	public boolean existeArista(E v1, E v2) {
		NodoVertice<E> n1 = vert2Nodo(v1);
		NodoArista<E> aux = n1.getAristas();
		while (aux != null && !aux.getVerticeDestino().getVertice().equals(v2)) {
			aux = aux.getSigArista();
		}
		//Solo si se encontro la arista buscada, aux no es null
		return aux != null;
	}
	
	public int pesoArista(E v1, E v2) {
		NodoVertice<E> n1 = vert2Nodo(v1);
		NodoArista<E> aux = n1.getAristas();
		while (!aux.getVerticeDestino().getVertice().equals(v2))
			aux = aux.getSigArista(); //Buscamos la arista
		return aux.getPeso();
	}

	public E[] puentesEntre(E v1, E v2) {
		NodoVertice<E> nodoV1 = vert2Nodo(v1);
		if (nodoV1 == null) return (E[]) new Object[0]; // v1 no existe

		// Asumo que como máximo puede haber 'vertices' puentes
		E[] salida = (E[]) new Object[vertices];
		int i = 0;

		NodoArista<E> aristaDesdeV1 = nodoV1.getAristas();
		while (aristaDesdeV1 != null) {
			NodoVertice<E> posiblePuente = aristaDesdeV1.getVerticeDestino();
			NodoArista<E> aristaDesdeP = posiblePuente.getAristas();
			boolean esPuente = false;

			while (aristaDesdeP != null) {
				if (aristaDesdeP.getVerticeDestino().getVertice().equals(v2)) {
					esPuente = true; // si se confirma como puente
				}
				aristaDesdeP = aristaDesdeP.getSigArista();
			}

			if (esPuente) {
				salida[i] = posiblePuente.getVertice();
				i++;
			}

			aristaDesdeV1 = aristaDesdeV1.getSigArista();
		}

		// Redimensionar el arreglo si hay menos de 'vertices' encontrados
		E[] resultadoFinal = (E[]) new Object[i];
		for (int j = 0; j < i; j++) {
			resultadoFinal[j] = salida[j];
		}

		return resultadoFinal;
	}


	public E[] algoritmoDFS(E origenDFS) {
		//Pila de nodos vertice por visitar
		LinkedStack<NodoVertice<E>> stack = new LinkedStack<>();

		//Pila de vertices visitados
		E[] visitados = (E[]) new Object[vertices];

		//Cantidad de vertices visitados
		int count = 0;

		//Agarro el nodo del vertice
		NodoVertice<E> nodoOrigen = vert2Nodo(origenDFS);

		//Si es null, termina la ejecucion
		if (nodoOrigen == null) throw new MyException("No existe el nodo de origen.");

		//Lo agrego a la pila de nodos por visitar
		stack.push(nodoOrigen);

		// Si la pila tiene elementos entro al while
		while (!stack.isEmpty()) {
			// saco el nodo
			NodoVertice<E> actual = stack.pop();
			//Si el nodo no fue visitado
			if (!estaEnArreglo(actual.getVertice(), visitados, count)) {
				//Lo imprimo por pantalla, lo agrego al arreglo de visitados y sumo el contador
				System.out.println(actual.getVertice());
				visitados[count] = actual.getVertice();
				count++;

				// Agregamos todos los nodos "vecinos" al stack y vuelvo a arrancar el while
				NodoArista<E> arista = actual.getAristas();
				while (arista != null) {
					stack.push(arista.getVerticeDestino());
					arista = arista.getSigArista();
				}
			}
		}
		return visitados;
	}

	public boolean hayCiclos() {
		LinkedList<E> visitados = new LinkedList<>();
		LinkedList<E> enRecorrido = new LinkedList<>();

		E[] vertices = vertices();
		for (int i = 0; i < vertices.length; i++) {
			E vertice = vertices[i];
			if (!contiene(visitados, vertice)) {
				if (dfsTieneCicloDirigido(vertice, visitados, enRecorrido)) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean dfsTieneCicloDirigido(E actual, LinkedList<E> visitados, LinkedList<E> enRecorrido) {
		visitados.addLast(actual);
		enRecorrido.addLast(actual);

		NodoVertice<E> nodo = vert2Nodo(actual);
		NodoArista<E> arista = nodo.getAristas();

		while (arista != null) {
			E destino = arista.getVerticeDestino().getVertice();

			if (!contiene(visitados, destino)) {
				if (dfsTieneCicloDirigido(destino, visitados, enRecorrido)) {
					return true;
				}
			} else if (contiene(enRecorrido, destino)) {
				return true; // hay ciclo
			}

			arista = arista.getSigArista();
		}

		eliminar(enRecorrido, actual); // al salir del nodo actual, lo quito del recorrido
		return false;
	}

	private boolean contiene(LinkedList<E> lista, E elem) {
		for (int i = 0; i < lista.getSize(); i++) {
			if (lista.elementAt(i).equals(elem)) {
				return true;
			}
		}
		return false;
	}
	private void eliminar(LinkedList<E> lista, E elem) {
		try {
			lista.remove(elem);
		} catch (MyException e) {
			// No pasa nada si no está: no hay que eliminar
		}
	}



	private boolean estaEnArreglo(E vertice, E[] arreglo, int count) {
		// recorre el arreglo para saber si el vertice esta
		boolean esta=false;
		for (int i = 0; i < count; i++) {
			if (arreglo[i].equals(vertice)) {
				esta = true;
				i=count;
			}
		}
		return esta;
	}




}
