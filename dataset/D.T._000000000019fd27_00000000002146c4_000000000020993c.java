import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void solve(Scanner input, int ks, int n) {
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = input.nextInt();
            }
        }

        // compute trace
        int trace = 0;
        for (int i = 0; i < n; i++) {
            trace = trace + matrix[i][i];
        }

        // check duplicate row
        int dupRow = 0;
        for (int i = 0; i < n; i++) {
            Set<Integer> set = new HashSet<Integer>();
            for (int j = 0; j < n; j++) {
                int num = matrix[i][j];
                set.add(num);
            }
            if (set.size() < n) {
                dupRow++;
            }
        }

        // check duplicate column
        int dupCol = 0;
        for (int i = 0; i < n; i++) {
            Set<Integer> set = new HashSet<Integer>();
            for (int j = 0; j < n; j++) {
                int num = matrix[j][i];
                set.add(num);
            }
            if (set.size() < n) {
                dupCol++;
            }
        }

        System.out.println("Case #" + ks + ": " + trace + " " + dupRow + " " + dupCol);
    }

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        for (int ks = 1; ks <= T; ks++) {
            int n = input.nextInt();
            solve(input, ks, n);
        }
    }
}