import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        StringBuilder output = new StringBuilder();

        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            output.append("Case #").append(t).append(": ").append(analyzeMatrix(n, matrix)).append("\n");
        }
        System.out.print(output);
    }

    private static String analyzeMatrix(int n, int[][] matrix) {
        int trace = 0;
        int rowDuplicates = 0;
        int colDuplicates = 0;

        for (int i = 0; i < n; i++) {
            Set<Integer> rowSet = new HashSet<>();
            Set<Integer> colSet = new HashSet<>();
            boolean rowUnique = true;
            boolean colUnique = true;

            for (int j = 0; j < n; j++) {
                if (rowUnique) rowUnique = rowSet.add(matrix[i][j]);
                if (colUnique) colUnique = colSet.add(matrix[j][i]);
                if (i == j) trace += matrix[i][j];
            }

            if (rowSet.size() < n) rowDuplicates++;
            if (colSet.size() < n) colDuplicates++;
        }

        return trace + " " + rowDuplicates + " " + colDuplicates;
    }
}