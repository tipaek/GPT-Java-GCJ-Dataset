import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int testCaseNumber = 1;

        while (t-- > 0) {
            int n = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            int[][] matrix = new int[n][n];
            int trace = 0;
            Map<String, Set<Integer>> rowMap = new HashMap<>();
            Map<String, Set<Integer>> colMap = new HashMap<>();

            for (int i = 0; i < n; i++) {
                String line = scanner.nextLine();
                String[] values = line.split(" ");
                
                for (int j = 0; j < n; j++) {
                    int value = Integer.parseInt(values[j]);
                    matrix[i][j] = value;

                    if (i == j) {
                        trace += value;
                    }

                    rowMap.computeIfAbsent("row" + i, k -> new HashSet<>()).add(value);
                    colMap.computeIfAbsent("col" + j, k -> new HashSet<>()).add(value);
                }
            }

            int rowCount = 0;
            for (int i = 0; i < n; i++) {
                if (rowMap.get("row" + i).size() != n) {
                    rowCount++;
                }
            }

            int colCount = 0;
            for (int j = 0; j < n; j++) {
                if (colMap.get("col" + j).size() != n) {
                    colCount++;
                }
            }

            System.out.println("Case #" + testCaseNumber + ": " + trace + " " + rowCount + " " + colCount);
            testCaseNumber++;
        }

        scanner.close();
    }
}