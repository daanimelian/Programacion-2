package clase2.src;
import java.util.Arrays;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

                /*// Creación de jugadores
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

        *//*
           IMPORTANTE: Los atributos de estadística en Equipo (pG, pE, pP, gFavor, gContra)
           no están inicializados en el constructor. Para efectos de test,
           asumiremos que se inicializan en 0. Si no es así, se recomienda inicializarlos
           en el constructor o mediante métodos setters.
         *//*

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
                System.out.println("El capitán con más goles es: " + capitanMejor.getNombre());*/

               /* TempMinEstacion lista = new TempMinEstacion(10);

                int[] para_ordenar = {2,4,1,9,0,6,8,25};
                System.out.println(Arrays.toString(para_ordenar));

                lista.ordenar(para_ordenar);*/

        TempMinEstacion2 est = new TempMinEstacion2();
        System.out.println("--- Pruebas de TempMinEstacion2 ---");

        // 1. Llamar métodos sobre lista vacía
        try {
            System.out.println("Mayor temperatura (vacía): " + est.mayorTempMin());
        } catch (Exception e) {
            System.out.println("Excepción en mayorTempMin() lista vacía: " + e.getMessage());
        }
        try {
            System.out.println("Promedio temperatura (vacía): " + est.promedioTempMin());
        } catch (Exception e) {
            System.out.println("Excepción en promedioTempMin() lista vacía: " + e.getMessage());
        }

        // 2. Agregar temperaturas
        System.out.println("Agregando temperaturas: 5.0, -2.5, 7.3, 0.0");
        est.establecerTempMin(5.0f);
        est.establecerTempMin(-2.5f);
        est.establecerTempMin(7.3f);
        est.establecerTempMin(0.0f);

        // 3. Consultas principales
        System.out.println("Mayor temperatura: " + est.mayorTempMin());
        System.out.println("Promedio temperatura: " + est.promedioTempMin());
        System.out.println("Cantidad de heladas: " + est.cantHeladas());
        System.out.println("Hubo heladas: " + est.huboHeladas());
        System.out.println("Primera > 6.0: " + est.primeroMayor(6.0f));
        System.out.println("Primera > 8.0: " + est.primeroMayor(8.0f));
        System.out.println("¿Orden creciente?: " + est.ordenadoCreciente());

        // 4. Métodos extendidos
        System.out.println("Menor temperatura: " + est.menorTemperatura());
        System.out.println("Posición menor temperatura: " + est.posMenorTemperatura());
        System.out.println("Todos positivos?: " + est.todosPositivos());

        // 5. Contar coincidencias con otra estación
        TempMinEstacion2 otra = new TempMinEstacion2();
        otra.establecerTempMin(5.0f);
        otra.establecerTempMin(-2.5f);
        otra.establecerTempMin(7.3f);
        otra.establecerTempMin(1.0f);
        System.out.println("Coincidencias con otra estación: " + est.contarCoincidencias(otra));

        // 6. Reemplazar y verificar
        System.out.println("Reemplazar 7.3 por 9.9");
        est.reemplazar(7.3f, 9.9f);
        System.out.println("Mayor temperatura tras reemplazo: " + est.mayorTempMin());

        // 7. Intercambiar posiciones
        est.imprimir();
        est.intercambiar(0,3);
        System.out.println("Intercambiar pos 0 y 3, resultado mensaje: '");
        est.imprimir();
        System.out.println("¿Orden creciente tras intercambio?: " + est.ordenadoCreciente());

        // 8. Invertir in situ
        est.invertirMe();
        System.out.println("¿Orden creciente tras invertirMe?: " + est.ordenadoCreciente());

        // 9. Ordenar (bubble sort) y verificar
        est.ordenar();
        System.out.println("¿Orden creciente tras ordenar?: " + est.ordenadoCreciente());

        float temp = est.getTempByIndex(0);

        System.out.println("Temperatura: " + temp);

            }
        }