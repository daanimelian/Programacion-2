package preparcial;

import clase3.LinkedList;
import clase5.Dictionary.LinkedDictionary;

public class MetodosAlumnos {

    public static void ordenarEImprimir(LinkedDictionary<String, Alumno> diccionario) {
        Iterable<String> carreras = diccionario.keys();

        for (String carrera : carreras) {
            Iterable<Alumno> alumnosIterable = diccionario.get(carrera);
            int cant_Alumnos = 0;
            for(Alumno alumno:alumnosIterable){
                cant_Alumnos++;
            }
            Alumno [] alumnos = new Alumno[cant_Alumnos];
            int k=0;
            for(Alumno alumno: alumnosIterable){
                alumnos[k] = alumno;
                k++;
            }

            // Bubble Sort descendente por promedio
            for (int i = 0; i < alumnos.length; i++) {
                for (int j = 0; j < alumnos.length - 1 - i; j++) {
                    if (alumnos[j].getPromedio() < alumnos[j + 1].getPromedio()) {
                        Alumno temp = alumnos[j];
                        alumnos[j] = alumnos[j + 1];
                        alumnos[j + 1] = temp;
                    }
                }
            }

            // Mostrar por consola
            System.out.println("Carrera: " + carrera);
            for (Alumno alumno : alumnos) {
                System.out.println("  " + alumno);
            }
            System.out.println();
        }
    }

}
