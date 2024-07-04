import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CJ1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numTests = input.nextInt();

        for (int testCase = 0; testCase < numTests; testCase++) {
            int size = input.nextInt();
            int trace = 0, duplicateRows = 0, duplicateCols = 0;
            Integer[][] matrix = new Integer[size][size];

            // Read the matrix and calculate the trace
            for (int row = 0; row < size; row++) {
                for (int col = 0; col < size; col++) {
                    int value = input.nextInt();
                    matrix[row][col] = value;
                    if (row == col) {
                        trace += value;
                    }
                }
            }

            // Check for duplicate values in rows
            for (int row = 0; row < size; row++) {
                if (hasDuplicates(matrix[row])) {
                    duplicateRows++;
                }
            }

            // Check for duplicate values in columns
            for (int col = 0; col < size; col++) {
                Integer[] column = new Integer[size];
                for (int row = 0; row < size; row++) {
                    column[row] = matrix[row][col];
                }
                if (hasDuplicates(column)) {
                    duplicateCols++;
                }
            }

            // Print the result for the current test case
            System.out.println("Case #" + (testCase + 1) + ": " + trace + " " + duplicateRows + " " + duplicateCols);
        }
    }

    private static boolean hasDuplicates(Integer[] array) {
        Set<Integer> set = new HashSet<>(Arrays.asList(array));
        return array.length != set.size();
    }
}