import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int testCases = sc.nextInt();
        int testNum = 1;

        while (testCases > 0) {
            int trace = 0, row = 0, column = 0;
            int N = sc.nextInt();
            int[][] matrix = new int[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }

            // Calculate trace
            for (int i = 0; i < N; i++) {
                trace += matrix[i][i];
            }

            // Check rows for duplicates
            for (int i = 0; i < N; i++) {
                boolean[] rowCheck = new boolean[N];
                boolean hasDuplicate = false;
                for (int j = 0; j < N; j++) {
                    int num = matrix[i][j];
                    if (rowCheck[num - 1]) {
                        hasDuplicate = true;
                    }
                    rowCheck[num - 1] = true;
                }
                if (hasDuplicate) {
                    row++;
                }
            }

            // Check columns for duplicates
            for (int i = 0; i < N; i++) {
                boolean[] colCheck = new boolean[N];
                boolean hasDuplicate = false;
                for (int j = 0; j < N; j++) {
                    int num = matrix[j][i];
                    if (colCheck[num - 1]) {
                        hasDuplicate = true;
                    }
                    colCheck[num - 1] = true;
                }
                if (hasDuplicate) {
                    column++;
                }
            }

            System.out.println("Case #" + testNum + ": " + trace + " " + row + " " + column);
            testCases--;
            testNum++;
        }
    }
}