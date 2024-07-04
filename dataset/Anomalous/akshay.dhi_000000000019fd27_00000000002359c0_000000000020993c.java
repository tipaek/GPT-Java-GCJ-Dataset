import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine().trim());
        int caseNumber = 1;

        while (testCases-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int[][] matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                StringTokenizer str = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Integer.parseInt(str.nextToken());
                }
            }

            int trace = 0;
            int rowRepeated = 0;
            int colRepeated = 0;

            for (int i = 0; i < n; i++) {
                trace += matrix[i][i];
                if (hasDuplicates(matrix[i])) {
                    rowRepeated++;
                }
                if (hasDuplicates(getColumn(matrix, i))) {
                    colRepeated++;
                }
            }

            System.out.println("Case #" + caseNumber + ": " + trace + " " + rowRepeated + " " + colRepeated);
            caseNumber++;
        }
    }

    private static boolean hasDuplicates(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (int value : array) {
            if (!set.add(value)) {
                return true;
            }
        }
        return false;
    }

    private static int[] getColumn(int[][] matrix, int columnIndex) {
        int[] column = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            column[i] = matrix[i][columnIndex];
        }
        return column;
    }
}