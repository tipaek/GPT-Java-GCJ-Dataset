import java.util.*;
import java.io.*;

class Solution {

    public static String vestigium(int[][] matrix, int size) {
        int trace = 0;
        int rowRepeats = 0;
        int colRepeats = 0;

        for (int i = 0; i < size; i++) {
            boolean[] rowCheck = new boolean[size];
            boolean[] colCheck = new boolean[size];
            boolean rowRepeat = false;
            boolean colRepeat = false;

            for (int j = 0; j < size; j++) {
                // Check for trace
                if (i == j) {
                    trace += matrix[i][j];
                }

                // Check for row repetitions
                if (rowCheck[matrix[i][j] - 1]) {
                    rowRepeat = true;
                } else {
                    rowCheck[matrix[i][j] - 1] = true;
                }

                // Check for column repetitions
                if (colCheck[matrix[j][i] - 1]) {
                    colRepeat = true;
                } else {
                    colCheck[matrix[j][i] - 1] = true;
                }
            }

            if (rowRepeat) {
                rowRepeats++;
            }
            if (colRepeat) {
                colRepeats++;
            }
        }

        return trace + " " + rowRepeats + " " + colRepeats;
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        
        int testCases = scanner.nextInt();

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            System.out.println("Case #" + caseNum + ": " + vestigium(matrix, size));
        }
        scanner.close();
    }
}