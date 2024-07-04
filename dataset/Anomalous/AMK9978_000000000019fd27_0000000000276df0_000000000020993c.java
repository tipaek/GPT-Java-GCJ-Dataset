import java.util.HashSet;
import java.util.Scanner;

public class Problem1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        
        for (int caseNum = 1; caseNum <= t; caseNum++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];
            int diagonalSum = 0, duplicateRows = 0, duplicateColumns = 0;

            // Reading the matrix and calculating the sum of the diagonal elements
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        diagonalSum += matrix[i][j];
                    }
                }
            }

            // Checking for duplicate elements in each row
            for (int i = 0; i < size; i++) {
                HashSet<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < size; j++) {
                    if (!rowSet.add(matrix[i][j])) {
                        duplicateRows++;
                        break;
                    }
                }
            }

            // Checking for duplicate elements in each column
            for (int j = 0; j < size; j++) {
                HashSet<Integer> columnSet = new HashSet<>();
                for (int i = 0; i < size; i++) {
                    if (!columnSet.add(matrix[i][j])) {
                        duplicateColumns++;
                        break;
                    }
                }
            }

            // Printing the result for the current test case
            System.out.println("Case #" + caseNum + ": " + diagonalSum + " " + duplicateRows + " " + duplicateColumns);
        }
    }
}