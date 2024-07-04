import java.util.Scanner;

public class Vestigium {

    public static void process(int[][] matrix, int matSize, int caseNumber) {
        int trace = 0;
        int rowDuplicates = 0;
        int colDuplicates = 0;

        for (int i = 0; i < matSize; i++) {
            boolean[] rowCheck = new boolean[matSize + 1];
            boolean rowHasDuplicate = false;
            for (int j = 0; j < matSize; j++) {
                if (rowCheck[matrix[i][j]]) {
                    rowHasDuplicate = true;
                }
                rowCheck[matrix[i][j]] = true;
                if (i == j) {
                    trace += matrix[i][j];
                }
            }
            if (rowHasDuplicate) {
                rowDuplicates++;
            }
        }

        for (int i = 0; i < matSize; i++) {
            boolean[] colCheck = new boolean[matSize + 1];
            boolean colHasDuplicate = false;
            for (int j = 0; j < matSize; j++) {
                if (colCheck[matrix[j][i]]) {
                    colHasDuplicate = true;
                }
                colCheck[matrix[j][i]] = true;
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

        sc.close();
    }
}