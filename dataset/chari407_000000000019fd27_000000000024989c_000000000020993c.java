import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int test = 1; test <= t; test++) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }

            int trace = 0;
            int rowDupes = 0;
            for (int i = 0; i < n; i++) {

                int[] hash = new int[n + 1];
                boolean dupe = false;
                Arrays.fill(hash, 0);

                for (int j = 0; j < n; j++) {
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                    hash[matrix[i][j]]++;
                }

                for (int j = 1; j <=n; j++) {
                    if (hash[j] != 1) {
                        dupe = true;
                    }
                }

                if(dupe)
                {
                    rowDupes++;
                }
            }

            int colDupes = 0;
            for (int j = 0; j < n; j++) {
                int[] hash = new int[n + 1];
                Arrays.fill(hash, 0);
                boolean dupe = false;

                for (int i = 0; i < n; i++) {
                    hash[matrix[i][j]]++;
                }

                for (int i = 1; i <=n; i++) {
                    if (hash[i] != 1) {
                        dupe = true;
                    }
                }

                if(dupe)
                {
                    colDupes++;
                }
            }

            System.out.printf("Case #%d: %d %d %d\n", test, trace, rowDupes, colDupes);
        }
    }
}
