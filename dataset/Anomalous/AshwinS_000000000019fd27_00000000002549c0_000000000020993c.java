import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    private Scanner sc;

    public static void main(String[] args) {
        new Solution().execute();
    }

    private void execute() {
        StringBuilder output = new StringBuilder();
        sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = sc.nextInt();
        for (int i = 0; i < testCases; i++) {
            output.append("Case #").append(i + 1).append(": ");
            int n = sc.nextInt();
            if (n == 0) {
                output.append("0 0 0\n");
                continue;
            }
            int[][] matrix = new int[n][n];
            readMatrix(matrix, n);
            int trace = calculateTrace(matrix, n);
            output.append(trace).append(" ");
            int rowRepetitions = countRepeatedRows(matrix, n);
            output.append(rowRepetitions).append(" ");
            int colRepetitions = countRepeatedColumns(matrix, n);
            output.append(colRepetitions).append("\n");
        }
        sc.close();
        System.out.print(output.toString());
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
            Set<Integer> uniqueElements = new HashSet<>();
            for (int c = 0; c < n; c++) {
                if (!uniqueElements.add(matrix[r][c])) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    private int countRepeatedColumns(int[][] matrix, int n) {
        int count = 0;
        for (int c = 0; c < n; c++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int r = 0; r < n; r++) {
                if (!uniqueElements.add(matrix[r][c])) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}