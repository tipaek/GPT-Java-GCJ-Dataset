import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int cases = Integer.parseInt(scn.nextLine());
        for (int i = 0; i < cases; i++) {
            int N = Integer.parseInt(scn.nextLine());

            int[][] matx = new int[N][N];
            int trace = 0;
            for (int j = 0; j < N; j++) {
                String row[] = scn.nextLine().split(" ");

                for (int k = 0; k < N; k++) {
                    matx[j][k] = (int)Integer.valueOf(row[k]);
                    if (j == k) trace += matx[j][k];
                }
                
            }

            // check if rows have duplicates
            int rowdup = 0;
            for (int j = 0; j < N; j++) {
                if (hasDuplicate(matx[j])) rowdup++;
            }

            int coldup = 0;
            for (int j = 0; j < N; j++) {
                if (hasDuplicate(getjthCol(j, matx))) coldup++;
            }

            System.out.println("Case #" + (i+1) + ": " + trace + " " + rowdup + " " + coldup);
        }
    }

    private static int[] getjthCol(int j, int[][] matx) {
        int[] res = new int[matx.length];

        for (int i = 0; i < matx.length; i++) {
            for (int k = 0; k< matx[i].length; k++) {
                if (k == j) res[i] = matx[i][k];
            }
        }

        return res;
    }

    private static boolean hasDuplicate(int[] is) {
        Set<Integer> hs = new HashSet<>();

        for (int i = 0; i < is.length; i++) {
            if(!hs.add(is[i])) {
                return true;
            }
        }

        return false;
    }
}