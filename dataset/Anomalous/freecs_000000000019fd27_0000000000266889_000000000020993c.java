import java.util.Scanner;

public class Solution {

    public void solve(int test, Scanner sc) {
        int n = sc.nextInt();
        int[][] matrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        int trace = 0;
        for (int i = 0; i < n; i++) {
            trace += matrix[i][i];
        }

        int rowRepeats = 0;
        int colRepeats = 0;

        for (int i = 0; i < n; i++) {
            if (hasDuplicates(matrix[i])) {
                rowRepeats++;
            }
        }

        for (int j = 0; j < n; j++) {
            int[] column = new int[n];
            for (int i = 0; i < n; i++) {
                column[i] = matrix[i][j];
            }
            if (hasDuplicates(column)) {
                colRepeats++;
            }
        }

        System.out.println("Case #" + test + ": " + trace + " " + rowRepeats + " " + colRepeats);
    }

    private boolean hasDuplicates(int[] array) {
        boolean[] found = new boolean[array.length + 1];
        for (int value : array) {
            if (found[value]) {
                return true;
            }
            found[value] = true;
        }
        return false;
    }

    public Solution() {
        Scanner sc = new Scanner(System.in);
        int tests = sc.nextInt();

        for (int t = 1; t <= tests; t++) {
            solve(t, sc);
        }
    }

    public static void main(String[] args) {
        new Solution();
    }
}