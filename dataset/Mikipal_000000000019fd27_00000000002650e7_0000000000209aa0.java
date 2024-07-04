
import java.util.*;
import java.io.*;

public class Solution {

    static int diag = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int matr[][] = new int[n][n];
            int k = in.nextInt();
            //in.nextLine();

            boolean trov = false;

            for (int j = 0; j < n && !trov; j++) {
                matr = genera(n, j, false);
                if (diag == k) {
                    j = n;
                    trov = true;
                }
            }

            if (!trov) {
                for (int j = 0; j < n && !trov; j++) {
                    matr = genera(n, j, true);
                    if (diag == k) {
                        j = n;
                        trov = true;
                    }
                    
                }
            }

            if (isValid(matr) && trov) {
                System.out.println("Case #" + i + ": " + "POSSIBLE");
                for (int j = 0; j < n; j++) {
                    for (int l = 0; l < n; l++) {
                        System.out.print(matr[j][l] + " ");
                    }
                    System.out.println("");
                }
            } else {
                System.out.println("Case #" + i + ": " + "IMPOSSIBLE");
            }

        }
    }

    public static int[][] genera(int n, int offs, boolean flip) {
        int mat[][] = new int[n][n];
        diag = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = ((i + j + offs) % n) + 1;
                if (i == j) {
                    diag += mat[i][j];
                }
            }
        }

        if (flip) {
            diag = 0;
            mat = flip(mat);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == j) {
                        diag += mat[i][j];
                    }
                }
            }
        }

        return mat;
    }

    public static int[][] flip(int[][] matr) {
        int temp;
        int m[][] = matr;
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length / 2; j++) {
                temp = m[i][j];
                m[i][j] = m[i][m[i].length - 1 - j];
                m[i][m[i].length - 1 - j] = temp;
            }
        }
        return m;
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
