import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCases = scanner.nextInt();
            for (int i = 1; i <= testCases; i++) {
                int[][] matrix = readMatrix(scanner);
                String[] result = analyzeMatrix(matrix);
                System.out.println("Case #" + i + ": " + String.join(" ", result));
            }
        }
    }

    private static int[][] readMatrix(Scanner scanner) {
        int size = scanner.nextInt();
        scanner.nextLine();
        int[][] matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            String[] line = scanner.nextLine().split(" ");
            matrix[i] = Arrays.stream(line).mapToInt(Integer::parseInt).toArray();
        }
        return matrix;
    }

    private static String[] analyzeMatrix(int[][] matrix) {
        int trace = 0, duplicateRows = 0, duplicateColumns = 0;
        int size = matrix.length;

        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
            duplicateColumns += hasDuplicates(matrix, i, true) ? 1 : 0;
            duplicateRows += hasDuplicates(matrix, i, false) ? 1 : 0;
        }

        return new String[]{String.valueOf(trace), String.valueOf(duplicateRows), String.valueOf(duplicateColumns)};
    }

    private static boolean hasDuplicates(int[][] matrix, int index, boolean isColumn) {
        HashSet<Integer> seen = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            int value = isColumn ? matrix[i][index] : matrix[index][i];
            if (!seen.add(value)) {
                return true;
            }
        }
        return false;
    }
}