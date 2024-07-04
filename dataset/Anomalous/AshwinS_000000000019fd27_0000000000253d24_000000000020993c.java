import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    private Scanner sc;

    public static void main(String[] args) {
        new Solution().findSolution();
    }

    private void findSolution() {
        StringBuilder output = new StringBuilder();
        sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = sc.nextInt();
        for (int i = 1; i <= testCases; i++) {
            output.append("Case #").append(i).append(": ");
            int n = sc.nextInt();
            if (n == 0) {
                output.append("0 0 0").append("\n");
                continue;
            }
            int[][] matrix = new int[n][n];
            readMatrix(matrix, n);
            int trace = calculateTrace(matrix, n);
            output.append(trace).append(" ");
            int repeatedRows = countRepeatedRows(matrix, n);
            output.append(repeatedRows).append(" ");
            int repeatedCols = countRepeatedCols(matrix, n);
            output.append(repeatedCols).append("\n");
            System.out.println(output.toString());
            output.setLength(0);
        }
        sc.close();
    }

    private void readMatrix(int[][] matrix, int n) {
        sc.nextLine();
        for (int r = 0; r < n; r++) {
            String[] numbers = sc.nextLine().split(" ");
            for (int c = 0; c < n; c++) {
                matrix[r][c] = Integer.parseInt(numbers[c]);
            }
        }
    }

    private int calculateTrace(int[][] matrix, int n) {
        int trace = 0;
        for (int i = 0; i < n; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private int countRepeatedRows(int[][] matrix, int n) {
        int count = 0;
        for (int r = 0; r < n; r++) {
            Set<Integer> rowElements = new HashSet<>();
            for (int c = 0; c < n; c++) {
                if (!rowElements.add(matrix[r][c])) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    private int countRepeatedCols(int[][] matrix, int n) {
        int count = 0;
        for (int c = 0; c < n; c++) {
            Set<Integer> colElements = new HashSet<>();
            for (int r = 0; r < n; r++) {
                if (!colElements.add(matrix[r][c])) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}