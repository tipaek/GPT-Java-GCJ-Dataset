import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner inp = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = inp.nextInt(); // number of test cases

        for (int i = 0; i < t; i++) {
            int N = inp.nextInt(); // size of matrix N*N
            int[][] arr = new int[N][N];
            int trace = 0; // trace of matrix
            int rowRep = 0; // number of repetitions in rows
            int colRep = 0; // number of repetitions in columns

            // Reading the matrix
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    arr[j][k] = inp.nextInt();
                }
            }

            // Calculating trace
            for (int x = 0; x < N; x++) {
                trace += arr[x][x];
            }

            // Calculating number of rows with repeated elements
            for (int j = 0; j < N; j++) {
                if (hasRepetitions(arr[j])) {
                    rowRep++;
                }
            }

            // Calculating number of columns with repeated elements
            for (int k = 0; k < N; k++) {
                if (hasRepetitions(getColumn(arr, k))) {
                    colRep++;
                }
            }

            System.out.println("Case #" + (i + 1) + ": " + trace + " " + rowRep + " " + colRep);
        }
    }

    private static boolean hasRepetitions(int[] array) {
        Set<Integer> seen = new HashSet<>();
        for (int value : array) {
            if (!seen.add(value)) {
                return true;
            }
        }
        return false;
    }

    private static int[] getColumn(int[][] matrix, int columnIndex) {
        int[] column = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            column[i] = matrix[i][columnIndex];
        }
        return column;
    }
}