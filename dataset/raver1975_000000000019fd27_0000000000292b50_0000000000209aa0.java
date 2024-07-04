import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        //Scanner in = null;
        //try {
        //    in = new Scanner(new File("in.txt"));
        //} catch (FileNotFoundException e) {
        //    e.printStackTrace();
        //}
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int tt = 1; tt <= t; ++tt) {
            int n = in.nextInt();
            int trace = in.nextInt();

            //cerate latin square
            int[][] square = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    square[i][j] = (((i + 1) + (j)) % n) + 1;
                }
            }

            int cnt = 0;
            int timeout = 100000;
            if (trace % n == 0) {
                while (cnt++ < timeout && calcTrace(square) != trace) {
                    //System.out.println("trace:" + calcTrace(square));
                    boolean orientation = Math.random() > 0.5d;
                    if (orientation) {
                        swapRows(square);
                    } else {
                        swapCols(square);
                    }
                }
                System.out.println("Case #" + tt + ": " + "POSSIBLE");
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        System.out.print(square[i][j]);
                        if (j < n - 1) {
                            System.out.print(" ");
                        }
                    }
                    System.out.println();
                }
            } else {
                System.out.println("Case #" + tt + ": " + "IMPOSSIBLE");
            }
//            System.out.println(Arrays.deepToString(square));
//            System.out.println(calcTrace(square));

            if (cnt == 0) {

            } else {

            }
        }
    }

    static int[] colTemp;

    private static void swapCols(int[][] square) {
        int n = square.length;
        int a = 0;
        int b = 0;
        while (a == b) {
            a = (int) (Math.random() * n);
            b = (int) (Math.random() * n);
        }
        colTemp = new int[n];
        for (int i = 0; i < n; i++) {
            colTemp[i] = square[a][i];
            square[a][i] = square[b][i];
            square[b][i] = colTemp[i];
        }

    }

    private static void swapRows(int[][] square) {
        int n = square.length;
        int a = 0;
        int b = 0;
        while (a == b) {
            a = (int) (Math.random() * n);
            b = (int) (Math.random() * n);
        }
        colTemp = new int[n];
        for (int i = 0; i < n; i++) {
            colTemp[i] = square[i][a];
            square[i][a] = square[i][b];
            square[i][b] = colTemp[i];
        }
    }

    public static int calcTrace(int[][] square) {
        int sum = 0;
        for (int i = 0; i < square.length; i++) {
            sum += square[i][i];
        }
        return sum;
    }
}

