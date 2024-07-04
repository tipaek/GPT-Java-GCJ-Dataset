import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int t = 1; t <= testCases; t++) {
            int matrixSize = Integer.parseInt(scanner.nextLine());
            int[][] matrix = new int[matrixSize][matrixSize];
            int trace = 0, rowRepeats = 0, colRepeats = 0;

            for (int i = 0; i < matrixSize; i++) {
                String[] rowValues = scanner.nextLine().split(" ");
                boolean[] rowCheck = new boolean[101];
                for (int j = 0; j < matrixSize; j++) {
                    int value = Integer.parseInt(rowValues[j]);
                    matrix[i][j] = value;
                    if (rowCheck[value]) {
                        rowRepeats++;
                        rowCheck[value] = false;
                    } else {
                        rowCheck[value] = true;
                    }
                }
                trace += matrix[i][i];
            }

            for (int j = 0; j < matrixSize; j++) {
                boolean[] colCheck = new boolean[101];
                for (int i = 0; i < matrixSize; i++) {
                    int value = matrix[i][j];
                    if (colCheck[value]) {
                        colRepeats++;
                        colCheck[value] = false;
                    } else {
                        colCheck[value] = true;
                    }
                }
            }

            System.out.println("Case #" + t + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }

        scanner.close();
    }
}