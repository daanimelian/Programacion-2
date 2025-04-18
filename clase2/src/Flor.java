package clase2.src;/*Implemente una clase Java llamada Flor que tenga tres atributos de tipo String, int
y float, que respectivamente representen el nombre de la flor, el número de
pétalos y precio. Se debe incluir un constructor que permita inicializar cada uno
de los atributos y un constructor que inicialice la flor por defecto con nombre
Margarita, número de pétalos igual a 10 y precio igual a 34.3. También se deben
proveer operaciones para modificar los atributos y obtener sus valores en
forma individual.*/

public class Flor {
    private String nombre;
    private int num_petalos;
    private float precio;

    //Constructores

    public Flor(String nombre, int num_petalos, float precio){
        nombre=nombre;
        num_petalos=num_petalos;
        precio=precio;
    }

    public Flor(){
        nombre="Margarita";
        num_petalos=10;
        precio=34.4f;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNum_petalos() {
        return num_petalos;
    }

    public void setNum_petalos(int num_petalos) {
        this.num_petalos = num_petalos;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
}
