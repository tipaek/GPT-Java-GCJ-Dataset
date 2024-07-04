import java.util.Scanner;

public class Solution {

    public static void process(int[][] matrix, int matSize, int caseNumber) {
        int trace = 0;
        int rowDuplicates = 0;
        int colDuplicates = 0;

        // Calculate trace and row duplicates
        for (int i = 0; i < matSize; i++) {
            boolean[] rowSeen = new boolean[matSize + 1];
            boolean rowHasDuplicate = false;
            trace += matrix[i][i]; // Add diagonal element to trace

            for (int j = 0; j < matSize; j++) {
                if (rowSeen[matrix[i][j]]) {
                    rowHasDuplicate = true;
                }
                rowSeen[matrix[i][j]] = true;
            }

            if (rowHasDuplicate) {
                rowDuplicates++;
            }
        }

        // Calculate column duplicates
        for (int j = 0; j < matSize; j++) {
            boolean[] colSeen = new boolean[matSize + 1];
            boolean colHasDuplicate = false;

            for (int i = 0; i < matSize; i++) {
                if (colSeen[matrix[i][j]]) {
                    colHasDuplicate = true;
                }
                colSeen[matrix[i][j]] = true;
            }

            if (colHasDuplicate) {
                colDuplicates++;
            }
        }

        System.out.println("Case #" + caseNumber + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();

        for (int i = 1; i <= cases; i++) {
            int matSize = sc.nextInt();
            int[][] matrix = new int[matSize][matSize];

            for (int j = 0; j < matSize; j++) {
                for (int k = 0; k < matSize; k++) {
                    matrix[j][k] = sc.nextInt();
                }
            }

            process(matrix, matSize, i);
        }
    }
}