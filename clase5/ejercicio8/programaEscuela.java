package clase5.ejercicio8;
import clase3.ArrayList;
import clase5.Dictionary.LinkedDictionary;
import clase5.Map.ArrayMap;
import clase5.Map.Entry;

import java.util.Objects;
import java.util.Scanner;

import static clase5.ejercicio8.metodos.unir;

public class programaEscuela {
            private static Scanner scanner = new Scanner(System.in);
            static ArrayList<ArrayMap<Integer, String>> maps = new ArrayList<>(1000);
            static LinkedDictionary<Integer, String> resultado = new LinkedDictionary<>();

            public static void main(String[] args) {
                boolean continuar = true;

                while (continuar) {
                    mostrarMenu();
                    int opcion = scanner.nextInt();
                    scanner.nextLine(); // Limpiar el buffer de la entrada

                    switch (opcion) {
                        case 1: cargarMapeo(); break;
                        case 2: mostrarUltimoMapeo(); break;
                        case 3: agregarAlDiccionarioGeneral(); break;
                        case 4: agregarNota(); break;
                        case 5: quitarNota(); break;
                        case 6: quitarAlumno(); break;
                        case 7: mostrarNotasAlumno(); break;
                        case 8: mostrarTodosLosAlumnos(); break;
                        case 9: verPromedios(); break;
                        case 0: continuar = false; break;
                        default: System.out.println("Opción no válida.");
                    }
                }
            }

            // Mostrar el menú
            public static void mostrarMenu() {
                System.out.println("\n--- Menú de Opciones ---");
                System.out.println("1. Cargar un mapeo con notas de una materia");
                System.out.println("2. Mostrar el último mapeo cargado");
                System.out.println("3. Agregar el último mapeo cargado al Diccionario general");
                System.out.println("4. Agregar una nota para un DNI específico");
                System.out.println("5. Quitar una nota para un DNI específico");
                System.out.println("6. Quitar un alumno");
                System.out.println("7. Mostrar las notas de un alumno");
                System.out.println("8. Mostrar todos los alumnos");
                System.out.println("9. Mostrar todos los promedios de los alumnos");
                System.out.println("0. Salir");
                System.out.print("Elige una opción: ");
            }

            // Cargar un mapeo
            public static void cargarMapeo() {
                ArrayMap<Integer,String> notas = new ArrayMap<Integer,String>();
                System.out.print("Ingrese un DNI: ");
                String key = System.console().readLine();
                int keyN = Integer.parseInt(key);
                System.out.print("Ingrese la nota de la materia A (0-10): ");
                String value1 = System.console().readLine();
                String salida1 = notas.put(keyN, value1);
                System.out.println("Nota materia A : "+salida1);
                while(keyN!=-1 && !Objects.equals(value1, "-1")) {
                    System.out.print("Ingrese un DNI: ");
                    key = System.console().readLine();
                    keyN = Integer.parseInt(key);
                    System.out.print("Ingrese la nota de la materia A (0-10): ");
                    value1 = System.console().readLine();
                    salida1 = notas.put(keyN, value1);
                    System.out.println("Nota materia A : "+salida1);
                }

                notas.remove(keyN);
                // Agregar el mapeo a la lista de mapeos
                maps.addLast(notas);
                System.out.println("Mapeo cargado exitosamente.");
            }

            // Mostrar el último mapeo cargado
            public static void mostrarUltimoMapeo() {
                if (maps.getLast().isEmpty()) {
                    System.out.println("No hay mapeos cargados.");
                    return;
                }
                ArrayMap<Integer, String> ultimoMapeo = maps.getLast();
                System.out.println("\nÚltimo mapeo cargado:");
                System.out.println("Las notas de la ultima materia cargada son:");
                System.out.print("{");
                Entry<Integer,String>[] entradas1 = ultimoMapeo.entries();
                for(int i = 0; i<entradas1.length;i++)
                    System.out.print(" ( "+entradas1[i].getKey()+" , "+entradas1[i].getValue()+" ) |");
                System.out.print("}");
                System.out.print("\n");
            }

            // Agregar el último mapeo al Diccionario general
            public static void agregarAlDiccionarioGeneral() {
                if (maps.getSize() == 0) {
                    System.out.println("No hay mapeos para agregar.");
                    return;
                }
                resultado = unir(maps);
                System.out.println("Mapeo agregado al diccionario general.");
            }

            // Agregar una nota para un DNI específico
            public static void agregarNota() {
                System.out.print("Ingrese el DNI: ");
                int dni = scanner.nextInt();
                System.out.print("Ingrese la nota: ");
                String nota = scanner.next();
                resultado.put(dni, nota);
                System.out.println("Nota agregada.");
            }

            // Quitar una nota para un DNI específico
            public static void quitarNota() {
                System.out.print("Ingrese el DNI: ");
                int dni = scanner.nextInt();
                if (resultado.remove(dni) != null) {
                    System.out.println("Nota eliminada.");
                } else {
                    System.out.println("No se encontró el DNI.");
                }
            }

            // Quitar un alumno
            public static void quitarAlumno() {
                System.out.print("Ingrese el DNI del alumno: ");
                int dni = scanner.nextInt();
                if (resultado.get(dni) != null) {
                    resultado.remove(dni);
                    System.out.println("Alumno eliminado.");
                } else {
                    System.out.println("No se encontró el DNI.");
                }
            }

            // Mostrar las notas de un alumno
            public static void mostrarNotasAlumno() {
                System.out.print("Ingrese el DNI del alumno: ");
                int dni = scanner.nextInt();
                Iterable<String> notas = resultado.get(dni);

                if (notas != null) {
                    System.out.println("Notas de " + dni + ":");
                    for (String nota : notas) {
                        System.out.println("- " + nota);
                    }
                } else {
                    System.out.println("No se encontró el DNI.");
                }
            }

            // Mostrar todos los alumnos
            public static void mostrarTodosLosAlumnos() {
                if (resultado.isEmpty()) {
                    System.out.println("No hay alumnos registrados.");
                    return;
                }
                System.out.println("\nAlumnos registrados:");
                for (Integer keys : resultado.keys()) {
                    System.out.println("DNI: " + keys);
                }
            }

            public static void verPromedios() {

                if (resultado.isEmpty()) {
                    System.out.println("No hay alumnos registrados.");
                    return;
                }
                System.out.println("\nLos promedios son:");
                for (Integer dni : resultado.keys()) {
                    Iterable<String> notas = resultado.get(dni);
                    double promedio = 0;
                    int sum = 0;
                    int cantidad = 0;
                    for (String nota : notas) {
                        sum += Integer.parseInt(nota);
                        cantidad++;
                    }
                    promedio = sum/cantidad;
                    System.out.println("DNI: " + dni + " | Promedio: " + promedio);
                }

            }

}

