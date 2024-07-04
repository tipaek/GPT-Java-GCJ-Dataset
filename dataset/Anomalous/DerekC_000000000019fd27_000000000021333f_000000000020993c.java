import java.util.*;
import java.io.*;

class Solution {

    public static String vestigium(int[][] matrix, int size) {
        int trace = 0;
        int rowRepeats = 0;
        int colRepeats = 0;

        for (int i = 0; i < size; i++) {
            boolean[] rowSeen = new boolean[size];
            boolean[] colSeen = new boolean[size];
            boolean rowHasRepeat = false;
            boolean colHasRepeat = false;

            for (int j = 0; j < size; j++) {
                // Check row for repeats
                if (rowSeen[matrix[i][j] - 1]) {
                    rowHasRepeat = true;
                }
                rowSeen[matrix[i][j] - 1] = true;

                // Check column for repeats
                if (colSeen[matrix[j][i] - 1]) {
                    colHasRepeat = true;
                }
                colSeen[matrix[j][i] - 1] = true;

                // Calculate trace
                if (i == j) {
                    trace += matrix[i][j];
                }
            }

            if (rowHasRepeat) {
                rowRepeats++;
            }
            if (colHasRepeat) {
                colRepeats++;
            }
        }

        return trace + " " + rowRepeats + " " + colRepeats;
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            System.out.println("Case #" + testCase + ": " + vestigium(matrix, size));
        }
        scanner.close();
    }
}