import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.hasNext() ? sc.nextInt() : 0;
        for (int caseNum = 1; caseNum <= T; caseNum++) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }
            int rowCount = countDuplicateRows(matrix, n);
            int colCount = countDuplicateCols(matrix, n);
            System.out.println("Case #" + caseNum + ": " + trace + " " + rowCount + " " + colCount);
        }
        sc.close();
    }

    public static int countDuplicateRows(int[][] matrix, int n) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (hasDuplicates(matrix[i], n)) {
                count++;
            }
        }
        return count;
    }

    public static int countDuplicateCols(int[][] matrix, int n) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            int[] col = new int[n];
            for (int j = 0; j < n; j++) {
                col[j] = matrix[j][i];
            }
            if (hasDuplicates(col, n)) {
                count++;
            }
        }
        return count;
    }

    public static boolean hasDuplicates(int[] array, int length) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < length; i++) {
            if (!set.add(array[i])) {
                return true;
            }
        }
        return false;
    }
}