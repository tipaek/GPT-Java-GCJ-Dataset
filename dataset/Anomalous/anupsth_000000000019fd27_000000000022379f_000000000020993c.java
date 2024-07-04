import java.util.Scanner;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0;
            int rowDuplicates = 0;
            int columnDuplicates = 0;

            List<HashSet<Integer>> columns = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                columns.add(new HashSet<>(n));
            }

            for (int i = 0; i < n; i++) {
                HashSet<Integer> rowSet = new HashSet<>(n);
                for (int j = 0; j < n; j++) {
                    int value = scanner.nextInt();
                    matrix[i][j] = value;
                    rowSet.add(value);
                    columns.get(j).add(value);
                    if (i == j) {
                        trace += value;
                    }
                }
                if (rowSet.size() < n) {
                    rowDuplicates++;
                }
            }

            for (int i = 0; i < n; i++) {
                if (columns.get(i).size() < n) {
                    columnDuplicates++;
                }
            }

            System.out.println("Case #" + caseNumber + ": " + trace + " " + rowDuplicates + " " + columnDuplicates);
        }
    }
}