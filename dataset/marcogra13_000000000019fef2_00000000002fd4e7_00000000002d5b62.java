import java.util.*;
import java.io.*;

public class Solution {

    static void print(int caso, boolean possible, String solution) {
        if (possible) {
            System.out.println("Case #" + (caso + 1) + ": " + solution);
        } else {
            System.out.println("Case #" + (caso + 1) + ": IMPOSSIBLE");
        }
    }

    static String muovi(long[] position, long[] destination, boolean arrivato, long distanza) {
        double maxMosse = Math.ceil(Math.sqrt(distanza));
        //System.out.println("Maxmoesse: " + maxMosse);
        String soluzione = "";
        Random rand = new Random();
        while (!arrivato) {
            long tempPosition[] = { position[0], position[1] };
            soluzione = "";
            for (long i = 0; i < maxMosse; i++) {
                int mossa = rand.nextInt(4);
                switch (mossa) {
                    case 0:
                        tempPosition[1] += Math.pow(2, i);// Nord
                        soluzione += "N";
                        break;
                    case 1:
                        tempPosition[1] -= Math.pow(2, i);// Sud
                        soluzione += "S";
                        break;
                    case 2:
                        tempPosition[0] += Math.pow(2, i);// Est
                        soluzione += "E";
                        break;
                    case 3:
                        tempPosition[0] -= Math.pow(2, i);// Ovest
                        soluzione += "W";
                        break;
                }
                //System.out.println(tempPosition[0] + " " + tempPosition[1]);
                if (tempPosition[0] == destination[0] && tempPosition[1] == destination[1]) {
                    arrivato = true;
                    break;
                }
            }
        }
        return soluzione;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int cases = input.nextInt();

        for (int i = 0; i < cases; i++) {
            long start[] = { 0, 0 };
            long finish[] = new long[2];
            finish[0] = input.nextInt();
            finish[1] = input.nextInt();
            boolean possible = true;
            boolean arrivato = false;
            String solution = "";
            long currDistance = Math.abs(start[0] - finish[0]) + Math.abs(start[1] - finish[1]);
            // Numero di mosse <= distanza
            if (currDistance % 2 == 0) {
                possible = false;
            } else { // It can be done
                solution += Solution.muovi(start, finish, arrivato, currDistance);
            }
            Solution.print(i, possible, solution);
        }
    }
}