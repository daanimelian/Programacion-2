package clase4.src;
import clase2.src.MyException;

public class HospitalArray {
    public static void main(String[] args) {

        ArrayPriorityQueue<Integer, Paciente> cola = new ArrayPriorityQueue<>(10); // Tamaño máximo de 10 pacientes


        cola.insert(3, new Paciente("Juan", 3));  // Prioridad 3
        cola.insert(5, new Paciente("Maria", 5)); // Prioridad 5
        cola.insert(2, new Paciente("Luis", 2));  // Prioridad 2
        cola.insert(4, new Paciente("Ana", 4));   // Prioridad 4


        while (!cola.isEmpty()) {
            try {

                Entry<Integer, Paciente> minPaciente = cola.removeMin();
                Paciente paciente = minPaciente.getValue();
                System.out.println("Llamando al paciente: " + paciente.getNombre() + " con prioridad " + paciente.getPrioridad());
            } catch (MyException e) {
                System.out.println("Error al obtener el paciente: " + e.getMessage());
            }
        }
    }
}
