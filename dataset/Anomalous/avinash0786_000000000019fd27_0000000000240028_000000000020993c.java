import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int N = scanner.nextInt();
            int[][] matrix = new int[N][N];
            int trace = 0, rowRepeats = 0, colRepeats = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            // Calculate trace
            for (int i = 0; i < N; i++) {
                trace += matrix[i][i];
            }

            // Calculate row repetitions
            for (int i = 0; i < N; i++) {
                if (hasRepetitions(matrix[i])) {
                    rowRepeats++;
                }
            }

            // Calculate column repetitions
            for (int j = 0; j < N; j++) {
                int[] column = new int[N];
                for (int i = 0; i < N; i++) {
                    column[i] = matrix[i][j];
                }
                if (hasRepetitions(column)) {
                    colRepeats++;
                }
            }

            System.out.println("Case #" + t + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }
    }

    private static boolean hasRepetitions(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (int num : array) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }
}