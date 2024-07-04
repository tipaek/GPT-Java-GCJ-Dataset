import java.util.HashSet;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int n = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character after the integer input.

            String[][] matrix = new String[n][n];
            int trace = 0, duplicateRows = 0, duplicateCols = 0;

            // Read the matrix and calculate the trace.
            for (int i = 0; i < n; i++) {
                String[] row = scanner.nextLine().split(" ");
                matrix[i] = row;
                trace += Integer.parseInt(row[i]);
            }

            // Check for duplicate elements in rows.
            for (int i = 0; i < n; i++) {
                HashSet<String> rowSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (!rowSet.add(matrix[i][j])) {
                        duplicateRows++;
                        break;
                    }
                }
            }

            // Check for duplicate elements in columns.
            for (int j = 0; j < n; j++) {
                HashSet<String> colSet = new HashSet<>();
                for (int i = 0; i < n; i++) {
                    if (!colSet.add(matrix[i][j])) {
                        duplicateCols++;
                        break;
                    }
                }
            }

            System.out.println("Case #" + caseNum + ": " + trace + " " + duplicateRows + " " + duplicateCols);
        }

        scanner.close();
    }
}