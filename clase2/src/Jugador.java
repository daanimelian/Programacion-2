package clase2.src;

public class Jugador {
    private String nombre;
    private Integer nroCamiseta;
    private Integer posicion;
    private Integer golesConvertidos;
    private Integer partidosJugados;

    //Constructor

    public Jugador(String nom) {
        nombre=nom;
        nroCamiseta=1;
        posicion=1;
        golesConvertidos=0;
        partidosJugados=0;

    }

    //Comandos

    public void aumentarGoles(Integer n) {
        golesConvertidos+=n;
    }

    public void aumentarUnPartido() {
        partidosJugados++;
    }

    //Consultas

    public Integer promedioGolesxPart(){
        return golesConvertidos/partidosJugados;

    }

    public Jugador jugConMasGoles(Jugador j1) {
        Jugador jugador_mas_goles = this;
        if (j1.golesConvertidos>this.golesConvertidos) {
            jugador_mas_goles=j1;
        }
        return jugador_mas_goles;
    }
    public boolean masGoles(Jugador j1){
        boolean masGoles= false;
        if (this.golesConvertidos > j1.golesConvertidos){
            masGoles=true;
        }
        return masGoles;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getNroCamiseta() {
        return nroCamiseta;
    }

    public Integer getPosicion() {
        return posicion;
    }

    public Integer getGolesConvertidos() {
        return golesConvertidos;
    }

    public Integer getPartidosJugados() {
        return partidosJugados;
    }
}
