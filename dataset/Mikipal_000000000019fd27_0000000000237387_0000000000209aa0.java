import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int matr[][] = new int[n][n];
            int k = in.nextInt();
            //in.nextLine();

            if (k % n == 0  && k/n <= n) {
                for (int j = 0; j < n; j++) {
                    matr[j][j] = k / n;
                }
                matr = genera(matr).clone();
            }

            if (isValid(matr)) {
                System.out.println("Case #" + i + ": " + "POSSIBLE");
                for (int j = 0; j < n; j++) {
                    for (int l = 0; l < n; l++) {
                        System.out.print(matr[j][l] + ((l + 1) < n ? " " : ""));
                    }
                    System.out.println("");
                }
            } else {
                System.out.println("Case #" + i + ": " + "IMPOSSIBLE");
            }

        }
    }

    public static int[][] genera(int matr[][]) {
        int res[][] = matr.clone();
        for (int i = 0; i < matr.length; i++) {
            for (int j = sumone(i, matr.length); j != i; j = sumone(j, matr.length)) {
                //i = colonna, j = riga
                res[i][j] = sumone(matr[i][subone(j, matr.length)], matr.length);
            }
        }

        return res;
    }

    public static int sumone(int n, int max) {
        return ((n + 1) >= max ? 0 : n + 1);
    }

    public static int subone(int n, int max) {
        return ((n - 1) < 0 ? max - 1 : n - 1);
    }

    public static boolean isValid(int matr[][]) {
        int somma = 0;
        for (int i = 0; i < matr.length; i++) {
            for (int j = 0; j < matr.length; j++) {
                somma += matr[i][j];
            }
        }

        return somma != 0;
    }

}