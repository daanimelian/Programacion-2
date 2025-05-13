package preparcial;

/*Se tiene un DiccionarioMultiple<String, Alumno> donde la clave es el nombre de la carrera y los valores son objetos de tipo Alumno
que tienen legajo (int), nombre (String) y promedio (double).

Implementar un método que reciba este diccionario y genere, para cada carrera, un listado de los alumnos ordenado por promedio de mayor a menor, usando Bubble Sort.

Mostrar por consola cada carrera con su lista ordenada de alumnos.

Indicar la complejidad temporal del algoritmo en función del número total de alumnos n y la cantidad de carreras c.*/

public class Alumno {
    private int legajo;
    private double promedio;
    private String nombre;

    public Alumno(String n, int l, double p){
        this.legajo = l;
        this.promedio = p;
        this.nombre = n;
    }

    public int getLegajo(){
        return this.legajo;
    }

    public double getPromedio(){
        return this.promedio;
    }
    public String getNombre(){
        return this.nombre;
    }

}
