import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Solution {

    static Scanner keyboard = new Scanner(System.in);
    private static void solve() {

        int C = -1;
        boolean cAvailable = true;
        int J = -1;
        boolean jAvailable = true;

        boolean imposible = false;

        ArrayList<Pareja> tareas = new ArrayList();
        int n = 1;
        n = keyboard.nextInt();
        keyboard.nextLine();
        for (int i = 0; i <n ; i++) {
            int[] pareja = Arrays.stream(keyboard.nextLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
            tareas.add(
                    new Pareja(pareja)
            );
        }

        tareas.sort( Pareja::compareTo );

        StringBuilder sb = new StringBuilder();


        for (Pareja tarea:tareas) {
            //System.out.println(tarea);
            //System.out.println(C);
            //System.out.println(J);
            if(tarea.inicio >= C){
                cAvailable = true;
            }
            if(tarea.inicio >= J){
                jAvailable = true;
            }
            
            if( tarea.inicio >= C || tarea.inicio >=  J ){
                if (cAvailable){
                    cAvailable = false;
                    C =  tarea.fin;
                    sb.append("C");
                    continue;
                }

                if (jAvailable){
                    jAvailable = false;
                    J =  tarea.fin;
                    sb.append("J");
                }
            }else{
                imposible  = true;
            }
        }

        if(imposible){
            System.out.println("IMPOSSIBLE");
        }else{
            System.out.println(
                sb.toString()
            );
        }



    }

    public static void main(String[] args) {
        int t, i = 1;
        t = keyboard.nextInt();
        keyboard.nextLine();
        while (t-->0){
            System.out.print("Case #");
            System.out.print(i);
            System.out.print(": ");
            solve();
            i++;
        }
    }



}

class Pareja implements Comparable {
    int inicio;
    int fin;

    public Pareja(int[] pareja) {
        inicio = pareja[0];
        fin = pareja[1];
    }


    @Override
    public int compareTo(Object o) {
        Pareja other = (Pareja) o;

        return inicio - other.inicio;
    }

    @Override
    public String toString() {
        return "Pareja{" +
                "inicio=" + inicio +
                ", fin=" + fin +
                '}';
    }
}
