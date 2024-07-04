import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int testCase = 0; testCase < testCases; testCase++) {
            int n = Integer.parseInt(scanner.nextLine());
            int[][] matrix = new int[n][n];

            int diagonalSum = 0;
            int repeatedRows = 0;
            int repeatedColumns = 0;

            for (int row = 0; row < n; row++) {
                String[] rowElements = scanner.nextLine().split(" ");
                Set<Integer> rowSet = new HashSet<>();

                for (int col = 0; col < n; col++) {
                    int value = Integer.parseInt(rowElements[col]);
                    matrix[row][col] = value;
                    if (row == col) {
                        diagonalSum += value;
                    }
                    rowSet.add(value);
                }

                if (rowSet.size() < n) {
                    repeatedRows++;
                }
            }

            for (int col = 0; col < n; col++) {
                Set<Integer> colSet = new HashSet<>();

                for (int row = 0; row < n; row++) {
                    colSet.add(matrix[row][col]);
                }

                if (colSet.size() < n) {
                    repeatedColumns++;
                }
            }

            System.out.println("case #" + (testCase + 1) + ": " + diagonalSum + " " + repeatedRows + " " + repeatedColumns);
        }
    }
}