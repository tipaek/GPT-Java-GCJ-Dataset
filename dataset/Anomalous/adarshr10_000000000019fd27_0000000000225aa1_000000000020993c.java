import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int x = 1; x <= t; ++x) {
            int n = in.nextInt();
            int[][] matrix = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[j][i] = in.nextInt();
                }
            }
            String sol = solve(matrix);
            System.out.println("Case #" + x + ": " + sol.charAt(0) + " " + sol.charAt(1) + " " + sol.charAt(2));
        }
    }

    public static String solve(int[][] input) {
        int n = input.length;
        int trace = 0;
        int rowDuplicates = 0;
        int colDuplicates = 0;

        for (int i = 0; i < n; i++) {
            trace += input[i][i];
        }

        for (int i = 0; i < n; i++) {
            Set<Integer> rowSet = new HashSet<>();
            Set<Integer> colSet = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if (!rowSet.add(input[i][j])) {
                    rowDuplicates++;
                    break;
                }
                if (!colSet.add(input[j][i])) {
                    colDuplicates++;
                    break;
                }
            }
        }

        return trace + "" + rowDuplicates + "" + colDuplicates;
    }
}