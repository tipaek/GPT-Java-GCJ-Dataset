import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            int sum = 0, rowCount = 0, colCount = 0;
            List<List<Integer>> matrix = new ArrayList<>();

            // Reading the matrix and calculating rowCount and sum
            for (int i = 0; i < n; i++) {
                List<Integer> row = new ArrayList<>();
                Set<Integer> rowSet = new HashSet<>();
                boolean hasDuplicateInRow = false;
                for (int j = 0; j < n; j++) {
                    int num = scanner.nextInt();
                    row.add(num);
                    sum += (i == j) ? num : 0; // Only add to sum when i == j (diagonal elements)
                    if (!rowSet.add(num)) {
                        hasDuplicateInRow = true;
                    }
                }
                if (hasDuplicateInRow) {
                    rowCount++;
                }
                matrix.add(row);
            }

            // Calculating colCount
            for (int j = 0; j < n; j++) {
                Set<Integer> colSet = new HashSet<>();
                boolean hasDuplicateInCol = false;
                for (int i = 0; i < n; i++) {
                    int num = matrix.get(i).get(j);
                    if (!colSet.add(num)) {
                        hasDuplicateInCol = true;
                    }
                }
                if (hasDuplicateInCol) {
                    colCount++;
                }
            }

            System.out.println("Case #" + testCase + ": " + sum + " " + rowCount + " " + colCount);
        }
        scanner.close();
    }
}