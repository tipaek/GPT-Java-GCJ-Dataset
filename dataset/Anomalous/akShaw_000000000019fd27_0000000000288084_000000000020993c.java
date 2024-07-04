import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        String[] results = new String[t];

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];

            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    matrix[j][k] = sc.nextInt();
                }
            }

            results[i] = calculateResult(matrix, n, i);
        }

        for (String result : results) {
            System.out.println(result);
        }
    }

    private static String calculateResult(int[][] matrix, int n, int caseIndex) {
        int trace = 0;
        int rowRepeats = 0;
        int columnRepeats = 0;

        for (int i = 0; i < n; i++) {
            trace += matrix[i][i];
            rowRepeats += hasDuplicates(matrix[i]) ? 1 : 0;

            int[] column = new int[n];
            for (int j = 0; j < n; j++) {
                column[j] = matrix[j][i];
            }
            columnRepeats += hasDuplicates(column) ? 1 : 0;
        }

        return "Case #" + (caseIndex + 1) + ": " + trace + " " + rowRepeats + " " + columnRepeats;
    }

    private static boolean hasDuplicates(int[] array) {
        Set<Integer> uniqueElements = new HashSet<>();
        for (int value : array) {
            if (!uniqueElements.add(value)) {
                return true;
            }
        }
        return false;
    }
}