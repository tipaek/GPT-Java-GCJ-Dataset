import java.util.HashSet;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        StringBuilder ans = new StringBuilder();

        int t = scn.nextInt();
        for (int case_num = 1; case_num <= t; case_num++) {
            int n = scn.nextInt();
            int[][] matrix = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scn.nextInt();
                }
            }
            int rows_dup = 0;
            //rows
            for (int i = 0; i < n; i++) {
                HashSet<Integer> set = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (set.contains(matrix[i][j])) {
                        rows_dup++;
                        break;
                    } else {
                        set.add(matrix[i][j]);
                    }
                }
            }

            int col_dup = 0;
            //columns
            for (int j = 0; j < n; j++) {
                HashSet<Integer> set = new HashSet<>();
                for (int i = 0; i < n; i++) {
                    if (set.contains(matrix[i][j])) {
                        col_dup++;
                        break;
                    } else {
                        set.add(matrix[i][j]);
                    }
                }
            }

            int trace = 0;
            //trace
            for (int i = 0; i < n; i++) {
                trace += matrix[i][i];
            }

            ans.append("Case #").append(case_num).append(": ").append(trace).append(" ").append(rows_dup).append(" ").append(col_dup).append("\n");

        }

        System.out.println(ans);

    }

}