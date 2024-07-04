import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        // Read number of test cases
        int testCases = scanner.nextInt();
        for (int testCase = 1; testCase <= testCases; ++testCase) {

            // Read size of the square matrix
            int size = scanner.nextInt();

            // Variables to store the trace, duplicate rows count, and duplicate columns count
            int trace = 0;
            int duplicateRows = 0;
            int duplicateColumns = 0;

            // Array of sets to track unique values in each column
            Set<Integer>[] columnValues = new HashSet[size];
            for (int col = 0; col < size; col++) {
                columnValues[col] = new HashSet<>();
            }

            for (int row = 0; row < size; row++) {
                Set<Integer> rowValues = new HashSet<>();
                for (int col = 0; col < size; col++) {
                    int value = scanner.nextInt();

                    // Add value to row and column sets
                    rowValues.add(value);
                    columnValues[col].add(value);

                    // Add to trace if it's a diagonal element
                    if (row == col) {
                        trace += value;
                    }
                }

                // Check if there are duplicates in the current row
                if (rowValues.size() != size) {
                    duplicateRows++;
                }
            }

            // Check for duplicate values in each column
            for (int col = 0; col < size; col++) {
                if (columnValues[col].size() != size) {
                    duplicateColumns++;
                }
            }

            // Print the results for the current test case
            System.out.println("Case #" + testCase + ": " + trace + " " + duplicateRows + " " + duplicateColumns);
        }
    }
}