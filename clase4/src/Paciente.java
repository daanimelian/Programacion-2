package clase4.src;

public class Paciente  {
    private String nombre;
    private Integer priodidad;
    public Paciente(String nombre, Integer priodidad) {
        this.nombre = nombre;
        this.priodidad = priodidad;
    }
    public String getNombre() {
        return this.nombre;
    }
    public Integer getPrioridad() {
        return this.priodidad;
    }

}
