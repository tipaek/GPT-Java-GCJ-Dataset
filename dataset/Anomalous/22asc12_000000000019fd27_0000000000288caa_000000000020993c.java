import java.util.Scanner;

public class Solution {
    public static void process(int[][] matrix, int matSize, int caseNum) {
        int trace = 0;
        int rowEmpty = 0;
        int colEmpty = 0;

        // Calculate trace and rowEmpty
        for (int i = 0; i < matSize; i++) {
            boolean isRowEmpty = true;
            for (int j = 0; j < matSize; j++) {
                if (i == j) {
                    trace += matrix[i][j];
                }
                if (j > 0 && matrix[i][j] != matrix[i][j - 1]) {
                    isRowEmpty = false;
                }
            }
            if (isRowEmpty) {
                rowEmpty++;
            }
        }

        // Calculate colEmpty
        for (int j = 0; j < matSize; j++) {
            boolean isColEmpty = true;
            for (int i = 0; i < matSize; i++) {
                if (i > 0 && matrix[i][j] != matrix[i - 1][j]) {
                    isColEmpty = false;
                }
            }
            if (isColEmpty) {
                colEmpty++;
            }
        }

        System.out.println("Case #" + caseNum + ": " + trace + " " + rowEmpty + " " + colEmpty);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();

        for (int i = 0; i < cases; i++) {
            int matSize = sc.nextInt();
            int[][] matrix = new int[matSize][matSize];

            for (int j = 0; j < matSize; j++) {
                for (int k = 0; k < matSize; k++) {
                    matrix[j][k] = sc.nextInt();
                }
            }

            process(matrix, matSize, i + 1);
        }

        sc.close();
    }
}