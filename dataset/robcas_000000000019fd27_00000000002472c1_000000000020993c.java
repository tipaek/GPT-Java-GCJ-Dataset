import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matrix;
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            int n = scanner.nextInt();
            int trace = 0;
            int x = i + 1;
            int r = 0;
            int c = 0;
            matrix = new int[n][n];
            boolean[] rb = new boolean[n];
            boolean[] cb = new boolean[n];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    int val = scanner.nextInt();
                    if (j == k)
                        trace += val;
                    matrix[j][k] = val;
                    for (int l = 0; l < n; l++) {
                        if (l != k && matrix[j][l] == val)
                            rb[j] = true;
                        if (l != j && matrix[l][k] == val)
                            cb[k] = true;
                    }
                }
            }
            for (int j = 0; j < n; j++) {
                if (rb[j])
                    r++;
                if (cb[j])
                    c++;
            }
            System.out.println("Case #" + x + ": " + trace + " " + r + " " + c);
        }

    }
}
