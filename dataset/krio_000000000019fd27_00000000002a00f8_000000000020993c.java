import java.util.*;
import java.io.*;

public class Vestigium {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int N = in.nextInt();
            int[][] M = new int[N][N];
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    M[j][k] = in.nextInt();
                }
            }
            System.out.println("Case #" + i + ": " + solve(M, N));
        }
    }

    private static String solve(int[][] M, int N) {
        int r = 0, c = 0, k = 0;
        for (int i = 0; i < N; i++) {
            if (hasDuplicatesRow(M, i, N)) r++;

            if (hasDuplicatesColumn(M, i, N)) c++;

            k += M[i][i];
        }

        return k + " " + r + " " + c;
    }

    private static boolean hasDuplicatesRow(int[][] M, int row, int N) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            if (!set.add(M[row][i])) {
                return true;
            }
        }
        return false;
    }

    private static boolean hasDuplicatesColumn(int[][] M, int column, int N) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            if (!set.add(M[i][column])) {
                return true;
            }
        }
        return false;
    }

}