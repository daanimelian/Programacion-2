package clase2.src;

public class Equipo {

    //Atributos
    private String nombre;
    private Jugador capitan;
    private Integer pG=0;
    private Integer pE=0;
    private Integer pP=0;
    private Integer gFavor=0;
    private Integer gContra=0;

    //Constructor

    public Equipo(String nom, Jugador cap) {
        nombre = nom;
        capitan = cap;
    }

    //Comandos

    public void incrementarPG(boolean jugoElCap){
        if(jugoElCap){
            capitan.aumentarUnPartido();
        }
        pG++;
    }
    public void incrementarPE(boolean jugoElCap){
        if(jugoElCap){
            capitan.aumentarUnPartido();
        }
        pE++;
    }
    public void incrementarpP(boolean jugoElCap){
        if(jugoElCap){
            capitan.aumentarUnPartido();
        }
        pP++;
    }

    public void aumentarGfavor(Integer total, Integer delCap){
        gFavor+=total;

        if(delCap>0){
            capitan.aumentarGoles(delCap);
        }

    }
    public void aumentarGContra(Integer total){
        gContra+=total;
    }

    // Consultas

    public Integer partidos(){
        return pG+pE+pP;
    }

    public Integer puntos(){
        Integer total = (pG*3)+pE;

        return total;
    }

    public Equipo mejorPuntaje(Equipo equipo1, Equipo equipo2){
        Equipo equipo_ganador = equipo2;

        if (equipo1.puntos() > equipo2.puntos()) {
            equipo_ganador = equipo1;
        }

        return equipo_ganador;

    }

    public Jugador capitanConMasGoles(Equipo e){

        return capitan.jugConMasGoles(e.capitan);
    }

    public String getNombre() {
        return nombre;
    }

    public Jugador getCapitan() {
        return capitan;
    }

    public Integer getpG() {
        return pG;
    }

    public Integer getpE() {
        return pE;
    }

    public Integer getpP() {
        return pP;
    }

    public Integer getgContra() {
        return gContra;
    }

    public Integer getgFavor() {
        return gFavor;
    }
}
