import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    protected static Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) {
        int cases = Integer.parseInt(in.nextLine());
        for (int caso = 0; caso < cases; caso++) {
            int numeroActividades = Integer.parseInt(in.nextLine());
            Actividad[] actividades = new Actividad[numeroActividades];
            for (int i = 0; i < numeroActividades; i++) {
                String[] s = in.nextLine().split(" ");
                Actividad e = new Actividad(i, Integer.valueOf(s[0]), Integer.valueOf(s[1]));
                actividades[i] = e;
            }

            Actividad juan = siguienteActividad(actividades);
            actividades = quitarActividad(actividades, juan);
            Actividad carlos = null;

            Actividad actual = juan;

            StringBuffer solucion = new StringBuffer("J");
            boolean imposible = false;
            while (actividades.length != 0){
                Actividad siguienteActividad = siguienteActividad(actividades);
                actividades = quitarActividad(actividades, siguienteActividad);
                if (solapan(actual, siguienteActividad)) {
                    if (carlos == null) {
                        solucion.append("C");
                        carlos = siguienteActividad;
                    } else {
                        if (solapan(siguienteActividad, carlos)) {
                            imposible = true;
                        } else {
                            solucion.append("C");
                            carlos = siguienteActividad;
                        }
                    }
                } else {
                    solucion.append("J");
                    juan = siguienteActividad;
                }

            }

            if (imposible) {
                System.out.printf("Case #%s: IMPOSSIBLE", caso + 1);
                System.out.println();
            } else {
                System.out.printf("Case #%s: %s", caso + 1, solucion.toString());
                System.out.println();
            }
        }
    }

    static Actividad[] quitarActividad(Actividad[] actividades, Actividad actividad) {
        Actividad[] act = new Actividad[actividades.length - 1];
        int number = 0;
        for (int i = 0; i < actividades.length; i++) {
            if (actividades[i].id != actividad.id) {
                act[number] = actividades[i];
                number++;
            }
        }
        return act;
    }

    static Actividad siguienteActividad(Actividad[] actividades) {
        Actividad resultado = actividades[0];
        for (Actividad actividad1 : actividades) {
            if (resultado.id != actividad1.id && resultado.inicio >= actividad1.inicio) {
                resultado = actividad1;
            }
        }
        return resultado;
    }

    static boolean solapan(Actividad actividad1, Actividad actividad2) {
        return (actividad1.inicio > actividad2.inicio && actividad1.inicio < actividad2.fin) ||
                (actividad2.inicio > actividad1.inicio && actividad2.inicio < actividad1.fin);
    }

    private static class Actividad {
        int id;
        int inicio;
        int fin;

        Actividad(int id, int inicio, int fin) {
            this.id = id;
            this.inicio = inicio;
            this.fin = fin;
        }
    }
}
