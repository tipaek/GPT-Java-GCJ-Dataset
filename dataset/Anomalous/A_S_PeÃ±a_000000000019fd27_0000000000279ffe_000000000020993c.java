import java.util.*;

public class Solution {

    private static final Scanner SCANNER = new Scanner(System.in);

    private static int[] analyzeMatrix(int[][] matrix, int size) {
        int[] result = new int[3];

        // Calculate the sum of the main diagonal
        for (int i = 0; i < size; i++) {
            result[0] += matrix[i][i];
        }

        // Check for duplicate elements in each row
        for (int i = 0; i < size; i++) {
            Set<Integer> rowSet = new HashSet<>();
            for (int j = 0; j < size; j++) {
                if (!rowSet.add(matrix[i][j])) {
                    result[1]++;
                    break;
                }
            }
        }

        // Check for duplicate elements in each column
        for (int j = 0; j < size; j++) {
            Set<Integer> colSet = new HashSet<>();
            for (int i = 0; i < size; i++) {
                if (!colSet.add(matrix[i][j])) {
                    result[2]++;
                    break;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int testCases = SCANNER.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int size = SCANNER.nextInt();
            int[][] matrix = new int[size][size];

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = SCANNER.nextInt();
                }
            }

            int[] result = analyzeMatrix(matrix, size);
            System.out.printf("Case #%d: %d %d %d%n", t, result[0], result[1], result[2]);
        }

        SCANNER.close();
    }
}