package clase2.src;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

                // Creación de jugadores
                Jugador jugador1 = new Jugador("Lionel Messi");
                Jugador jugador2 = new Jugador("Cristiano Ronaldo");

                // Actualizamos algunos datos de los jugadores
                jugador1.aumentarGoles(3);       // Messi convierte 3 goles
                jugador1.aumentarUnPartido();    // Jugó 1 partido

                jugador2.aumentarGoles(5);       // Ronaldo convierte 5 goles
                jugador2.aumentarUnPartido();    // Jugó 1 partido

                // Comparar jugadores usando el método jugConMasGoles
                Jugador mejorJugador = jugador1.jugConMasGoles(jugador2);
                System.out.println("El jugador con más goles es: " + mejorJugador.getNombre());

                // Creación de equipos, pasando el nombre y el capitán (Jugador)
                Equipo equipo1 = new Equipo("FC Barcelona", jugador1);
                Equipo equipo2 = new Equipo("Juventus", jugador2);

        /*
           IMPORTANTE: Los atributos de estadística en Equipo (pG, pE, pP, gFavor, gContra)
           no están inicializados en el constructor. Para efectos de test,
           asumiremos que se inicializan en 0. Si no es así, se recomienda inicializarlos
           en el constructor o mediante métodos setters.
         */

                // Simulamos incrementar resultados para el equipo1
                equipo1.incrementarPG(true);     // Incrementa partidos ganados; el capitán también juega.
                equipo1.incrementarPE(false);    // Incrementa partidos empatados.
                equipo1.aumentarGfavor(2, 1);      // Anota 2 goles; 1 gol es del capitán.
                equipo1.aumentarGContra(1);        // Encaja 1 gol.

                // Simulamos incrementar resultados para el equipo2
                equipo2.incrementarpP(true);     // Incrementa partidos perdidos; el capitán juega.
                equipo2.aumentarGfavor(3, 0);      // Anota 3 goles; ninguno es del capitán.
                equipo2.aumentarGContra(2);        // Encaja 2 goles.

                // Consultas de partidos jugados y puntos obtenidos
                System.out.println(equipo1.getNombre() + " - Partidos jugados: " + equipo1.partidos() + ", Puntos: " + equipo1.puntos());
                System.out.println(equipo2.getNombre() + " - Partidos jugados: " + equipo2.partidos() + ", Puntos: " + equipo2.puntos());

                // Comparación de equipos: se determina cuál tiene mayor puntaje
                Equipo mejorEquipo = equipo1.mejorPuntaje(equipo1, equipo2);
                System.out.println("El equipo con mejor puntaje es: " + mejorEquipo.getNombre());

                // Comparación de capitanes: se obtiene el capitan que tiene más goles
                Jugador capitanMejor = equipo1.capitanConMasGoles(equipo2);
                System.out.println("El capitán con más goles es: " + capitanMejor.getNombre());
            }
        }