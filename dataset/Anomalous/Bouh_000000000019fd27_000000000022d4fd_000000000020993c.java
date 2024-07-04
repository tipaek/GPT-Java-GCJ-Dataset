import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        String result = processInput(scanner);
        System.out.println(result);
    }

    public static String processInput(Scanner scanner) {
        StringBuilder result = new StringBuilder();
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            result.append("Case #").append(t).append(": ").append(analyzeMatrix(n, matrix)).append("\n");
        }

        return result.toString();
    }

    public static String analyzeMatrix(int n, int[][] matrix) {
        int trace = 0;
        for (int i = 0; i < n; i++) {
            trace += matrix[i][i];
        }

        int rowDuplicates = countDuplicates(n, matrix, true);
        int columnDuplicates = countDuplicates(n, matrix, false);

        return trace + " " + rowDuplicates + " " + columnDuplicates;
    }

    private static int countDuplicates(int n, int[][] matrix, boolean checkRows) {
        int duplicates = 0;

        for (int i = 0; i < n; i++) {
            Set<Integer> seen = new HashSet<>();
            boolean hasDuplicate = false;

            for (int j = 0; j < n; j++) {
                int value = checkRows ? matrix[i][j] : matrix[j][i];
                if (seen.contains(value)) {
                    hasDuplicate = true;
                    break;
                } else {
                    seen.add(value);
                }
            }

            if (hasDuplicate) {
                duplicates++;
            }
        }

        return duplicates;
    }
}