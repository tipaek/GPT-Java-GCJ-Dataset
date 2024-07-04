import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numCases = scanner.nextInt();

        for (int caseNum = 1; caseNum <= numCases; caseNum++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            int diagonalSum = 0;

            // Reading the matrix and calculating the diagonal sum
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        diagonalSum += matrix[i][j];
                    }
                }
            }

            int maxRowDuplicates = 0;
            int maxColDuplicates = 0;

            // Calculating maximum duplicates in any row and column
            for (int i = 0; i < n; i++) {
                maxRowDuplicates = Math.max(maxRowDuplicates, countDuplicates(matrix[i]));
                maxColDuplicates = Math.max(maxColDuplicates, countColumnDuplicates(matrix, i));
            }

            // Output the results for the current case
            System.out.println("Case #" + caseNum + ": " + diagonalSum + " " + maxRowDuplicates + " " + maxColDuplicates);
        }

        scanner.close();
    }

    // Helper method to count duplicates in a row
    private static int countDuplicates(int[] row) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : row) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        int duplicates = 0;
        for (int count : frequencyMap.values()) {
            if (count > 1) {
                duplicates++;
            }
        }

        return duplicates;
    }

    // Helper method to count duplicates in a column
    private static int countColumnDuplicates(int[][] matrix, int colIndex) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int[] row : matrix) {
            int num = row[colIndex];
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        int duplicates = 0;
        for (int count : frequencyMap.values()) {
            if (count > 1) {
                duplicates++;
            }
        }

        return duplicates;
    }
}