import java.util.Scanner;
import java.util.HashSet;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfTests = scanner.nextInt();

        for (int test = 1; test <= numberOfTests; test++) {
            int arraySize = scanner.nextInt();
            int[][] matrix = new int[arraySize][arraySize];

            for (int i = 0; i < arraySize; i++) {
                for (int j = 0; j < arraySize; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            int trace = 0;
            for (int i = 0; i < arraySize; i++) {
                trace += matrix[i][i];
            }

            int repeatedRows = 0;
            int repeatedColumns = 0;

            for (int i = 0; i < arraySize; i++) {
                HashSet<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < arraySize; j++) {
                    if (!rowSet.add(matrix[i][j])) {
                        repeatedRows++;
                        break;
                    }
                }
            }

            for (int j = 0; j < arraySize; j++) {
                HashSet<Integer> colSet = new HashSet<>();
                for (int i = 0; i < arraySize; i++) {
                    if (!colSet.add(matrix[i][j])) {
                        repeatedColumns++;
                        break;
                    }
                }
            }

            System.out.printf("Case #%d: %d %d %d%n", test, trace, repeatedRows, repeatedColumns);
        }

        scanner.close();
    }
}