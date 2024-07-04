import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCases = scanner.nextInt();
        for (int k = 0; k < testCases; k++) {
            int rowDuplicates = 0;
            int colDuplicates = 0;
            int diagonalSum = 0;
            int size = scanner.nextInt();

            int[][] matrix = new int[size][size];
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
                diagonalSum += matrix[i][i];
            }

            for (int i = 0; i < size; i++) {
                boolean[] rowCheck = new boolean[100];
                for (int j = 0; j < size; j++) {
                    if (rowCheck[matrix[i][j]]) {
                        rowDuplicates++;
                        break;
                    }
                    rowCheck[matrix[i][j]] = true;
                }
            }

            for (int i = 0; i < size; i++) {
                boolean[] colCheck = new boolean[100];
                for (int j = 0; j < size; j++) {
                    if (colCheck[matrix[j][i]]) {
                        colDuplicates++;
                        break;
                    }
                    colCheck[matrix[j][i]] = true;
                }
            }

            System.out.println(diagonalSum + " " + rowDuplicates + " " + colDuplicates);
        }

        scanner.close();
    }
}