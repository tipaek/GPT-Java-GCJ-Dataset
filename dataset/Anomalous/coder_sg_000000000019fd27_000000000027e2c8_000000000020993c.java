import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for (int tC = 1; tC <= t; tC++) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }

            int trace = calculateTrace(matrix, n);
            int rowRepeats = countRowRepeats(matrix, n);
            int colRepeats = countColRepeats(matrix, n);

            System.out.println("Case #" + tC + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }

        sc.close();
    }

    private static int calculateTrace(int[][] matrix, int size) {
        int trace = 0;
        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countRowRepeats(int[][] matrix, int size) {
        int rowRepeats = 0;
        for (int i = 0; i < size; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < size; j++) {
                if (set.contains(matrix[i][j])) {
                    rowRepeats++;
                    break;
                }
                set.add(matrix[i][j]);
            }
        }
        return rowRepeats;
    }

    private static int countColRepeats(int[][] matrix, int size) {
        int colRepeats = 0;
        for (int i = 0; i < size; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < size; j++) {
                if (set.contains(matrix[j][i])) {
                    colRepeats++;
                    break;
                }
                set.add(matrix[j][i]);
            }
        }
        return colRepeats;
    }
}