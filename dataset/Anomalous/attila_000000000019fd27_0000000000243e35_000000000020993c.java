import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int testCases = Integer.parseInt(scanner.nextLine());
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = Integer.parseInt(scanner.nextLine());
            int[][] matrix = new int[n][n];
            boolean[][] rowTracker = new boolean[n][n + 1];
            boolean[][] colTracker = new boolean[n][n + 1];
            Set<Integer> duplicateRows = new HashSet<>();
            Set<Integer> duplicateCols = new HashSet<>();

            for (int i = 0; i < n; i++) {
                String[] rowData = scanner.nextLine().split(" ");
                for (int j = 0; j < n; j++) {
                    int value = Integer.parseInt(rowData[j]);
                    matrix[i][j] = value;

                    if (rowTracker[i][value]) {
                        duplicateRows.add(i);
                    } else {
                        rowTracker[i][value] = true;
                    }

                    if (colTracker[j][value]) {
                        duplicateCols.add(j);
                    } else {
                        colTracker[j][value] = true;
                    }
                }
            }

            int diagonalSum = 0;
            for (int i = 0; i < n; i++) {
                diagonalSum += matrix[i][i];
            }

            System.out.println("Case #" + testCase + ": " + diagonalSum + " " + duplicateRows.size() + " " + duplicateCols.size());
        }
    }
}