import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Vestigium {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int caseNumber = 1;

        while (testCases-- > 0) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];

            // Input matrix
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            // Calculate trace
            int trace = 0;
            for (int i = 0; i < size; i++) {
                trace += matrix[i][i];
            }

            // Calculate row and column duplicates
            int rowDuplicates = 0;
            int columnDuplicates = 0;

            for (int i = 0; i < size; i++) {
                if (hasDuplicates(matrix[i])) {
                    rowDuplicates++;
                }
            }

            for (int j = 0; j < size; j++) {
                int[] column = new int[size];
                for (int i = 0; i < size; i++) {
                    column[i] = matrix[i][j];
                }
                if (hasDuplicates(column)) {
                    columnDuplicates++;
                }
            }

            System.out.println("Case #" + caseNumber + ": " + trace + " " + rowDuplicates + " " + columnDuplicates);
            caseNumber++;
        }
    }

    private static boolean hasDuplicates(int[] array) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int value : array) {
            countMap.put(value, countMap.getOrDefault(value, 0) + 1);
        }
        for (int count : countMap.values()) {
            if (count > 1) {
                return true;
            }
        }
        return false;
    }
}