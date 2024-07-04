import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

// Vestigium  Solution
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int[][] matrix = new int[n][n];
            long trace = 0, rows = 0, columns = 0;
            Set<Integer> nums = new HashSet<>();
            for (int j = 0; j < n; j++) {
                nums.clear();
                for (int k = 0; k < n; k++) {
                    matrix[j][k] = in.nextInt();
                    nums.add(matrix[j][k]);
                }
                if (nums.size() != n) {
                    rows++;
                }
                trace += matrix[j][j];
            }

            for (int j = 0; j < n; j++) {
                nums.clear();
                for (int k = 0; k < n; k++) {
                    if (!nums.add(matrix[k][j])) {
                        columns++;
                        break;
                    }
                }
            }

            StringBuffer sb = new StringBuffer("Case #");
            sb.append(i).append(": ").append(trace).append(" ").append(rows).append(" ").append(columns);
            System.out.println(sb.toString());
        }
    }
}
