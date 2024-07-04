import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            int traceValue = calculateTrace(matrix, size);
            int rowDuplicates = countRowDuplicates(matrix, size);
            int colDuplicates = countColDuplicates(matrix, size);

            System.out.println("Case #" + t + ": " + traceValue + " " + rowDuplicates + " " + colDuplicates);
        }
    }

    private static int calculateTrace(int[][] matrix, int size) {
        int trace = 0;
        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countRowDuplicates(int[][] matrix, int size) {
        int duplicateCount = 0;
        for (int i = 0; i < size; i++) {
            Set<Integer> seen = new HashSet<>();
            for (int j = 0; j < size; j++) {
                if (!seen.add(matrix[i][j])) {
                    duplicateCount++;
                    break;
                }
            }
        }
        return duplicateCount;
    }

    private static int countColDuplicates(int[][] matrix, int size) {
        int duplicateCount = 0;
        for (int j = 0; j < size; j++) {
            Set<Integer> seen = new HashSet<>();
            for (int i = 0; i < size; i++) {
                if (!seen.add(matrix[i][j])) {
                    duplicateCount++;
                    break;
                }
            }
        }
        return duplicateCount;
    }
}