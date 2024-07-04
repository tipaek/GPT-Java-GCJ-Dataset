import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    public static String vestigium(int[][] matrix) {
        int size = matrix.length;
        int trace = 0;
        int repeatedRows = 0;
        int repeatedCols = 0;

        // Calculate trace
        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
        }

        // Check for repeated elements in rows
        for (int i = 0; i < size; i++) {
            boolean[] seen = new boolean[size + 1];
            for (int j = 0; j < size; j++) {
                if (seen[matrix[i][j]]) {
                    repeatedRows++;
                    break;
                }
                seen[matrix[i][j]] = true;
            }
        }

        // Check for repeated elements in columns
        for (int i = 0; i < size; i++) {
            boolean[] seen = new boolean[size + 1];
            for (int j = 0; j < size; j++) {
                if (seen[matrix[j][i]]) {
                    repeatedCols++;
                    break;
                }
                seen[matrix[j][i]] = true;
            }
        }

        return trace + " " + repeatedRows + " " + repeatedCols;
    }

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int numTests = Integer.parseInt(br.readLine());

            for (int testCase = 1; testCase < numTests + 1; testCase++) {
                int size = Integer.parseInt(br.readLine());
                int[][] matrix = new int[size][size];

                for (int i = 0; i < size; i++) {
                    String[] row = br.readLine().split(" ");
                    for (int j = 0; j < size; j++) {
                        matrix[i][j] = Integer.parseInt(row[j]);
                    }
                }

                String result = vestigium(matrix);
                System.out.println("Case #" + testCase + ": " + result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}