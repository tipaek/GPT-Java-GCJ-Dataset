import java.util.HashSet;
import java.util.Scanner;

class Solution {
    public static int countDuplicateColumns(int[][] matrix) {
        int duplicates = 0;
        for (int col = 0; col < matrix.length; col++) {
            HashSet<Integer> seen = new HashSet<>();
            for (int row = 0; row < matrix.length; row++) {
                if (seen.contains(matrix[row][col])) {
                    duplicates++;
                    break;
                }
                seen.add(matrix[row][col]);
            }
        }
        return duplicates;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        StringBuilder result = new StringBuilder();

        for (int t = 0; t < testCases; t++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];
            int trace = 0, rowDuplicates = 0;

            for (int row = 0; row < size; row++) {
                HashSet<Integer> seen = new HashSet<>();
                boolean hasDuplicate = false;
                for (int col = 0; col < size; col++) {
                    matrix[row][col] = scanner.nextInt();
                    if (row == col) {
                        trace += matrix[row][col];
                    }
                    if (!hasDuplicate && seen.contains(matrix[row][col])) {
                        rowDuplicates++;
                        hasDuplicate = true;
                    }
                    seen.add(matrix[row][col]);
                }
            }

            int columnDuplicates = countDuplicateColumns(matrix);
            result.append(String.format("Case #%d: %d %d %d%n", t + 1, trace, rowDuplicates, columnDuplicates));
        }

        System.out.print(result);
        scanner.close();
    }
}