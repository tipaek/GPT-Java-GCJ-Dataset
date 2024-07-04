import java.util.*;
import java.io.*;

public class Solution {
    public static Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) {
        int t = scanner.nextInt();

        for (int i = 1; i <= t; ++i) {
            int n = scanner.nextInt();
            int[] result = traceMatrix(n);
            System.out.println("Case #" + i + ": " + result[0] + " " + result[1] + " " + result[2]);
        }

        scanner.close();
    }

    public static int[] traceMatrix(int n) {
        int[][] matrix = new int[n][n];
        int k = 0;
        int r = 0;
        for (int i = 0; i < n; ++i) {
            Set<Integer> set = new HashSet<Integer>();

            for (int j = 0; j < n; ++j) {
                int value = scanner.nextInt();

                matrix[i][j] = value;

                if (i == j) {
                    k += value;
                }

                set.add(value);
            }

            if (set.size() != n) {
                r++;
            }
        }

        int c = 0;
        for (int i = 0; i < n; ++i) {
            Set<Integer> set = new HashSet<Integer>();
            for (int j = 0; j < n; ++j) {
                if (set.contains(matrix[j][i])) {
                    c++;
                    break;
                }

                set.add(matrix[j][i]);
            }
        }

        return new int[] { k, r, c };
    }
}