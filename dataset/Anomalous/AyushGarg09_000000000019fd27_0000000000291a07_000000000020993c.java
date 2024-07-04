import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {

    static String calculate(int[][] matrix) {
        StringBuilder result = new StringBuilder();
        int size = matrix.length;
        HashMap<Integer, Integer>[] rows = new HashMap[size];
        HashMap<Integer, Integer>[] columns = new HashMap[size];
        HashSet<Integer> repeatedRows = new HashSet<>();
        HashSet<Integer> repeatedColumns = new HashSet<>();

        for (int i = 0; i < size; i++) {
            rows[i] = new HashMap<>();
            columns[i] = new HashMap<>();
        }

        int trace = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int num = matrix[i][j];
                rows[i].put(num, rows[i].getOrDefault(num, 0) + 1);
                columns[j].put(num, columns[j].getOrDefault(num, 0) + 1);

                if (rows[i].get(num) > 1) repeatedRows.add(i);
                if (columns[j].get(num) > 1) repeatedColumns.add(j);

                if (i == j) trace += matrix[i][i];
            }
        }

        result.append(trace).append(" ").append(repeatedRows.size()).append(" ").append(repeatedColumns.size());
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; ++i) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];

            for (int k = 0; k < n; k++) {
                for (int j = 0; j < n; j++) {
                    matrix[k][j] = scanner.nextInt();
                }
            }

            String result = calculate(matrix);
            System.out.println("Case #" + i + ": " + result);
        }
    }
}