import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            int row = 0;
            int[][] matrix = new int[n][n];
            for (int j = 0; j < n; j++) {

                String[] tmp = br.readLine().split(" ");
                for (int col = 0; col < n; col++) {
                    matrix[row][col] = Integer.parseInt(tmp[col] + "");
                }
                row++;
            }
            System.out.println("Case #"+(i+1)+": "+findFromMatrix(matrix, n));
        }
    }

    private static String findFromMatrix(int[][] matrix, int n) {
        // Find sum of diagonal
        int sum = 0;
        for (int i = 0; i < n; i++) {

            sum += matrix[i][i];

        }

        int noOfDupRows = 0;
        Set<Integer> set = new HashSet<>();
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (set.contains(matrix[row][col])) {
                    noOfDupRows++;
                    set.clear();
                    break;
                } else {
                    set.add(matrix[row][col]);
                }
            }
            set.clear();
        }

        int noOfDupCols = 0;
        set.clear();
        for (int col = 0; col < n; col++) {
            for (int row = 0; row < n; row++) {
                if (set.contains(matrix[row][col])) {
                    noOfDupCols++;
                    set.clear();
                    break;
                } else {
                    set.add(matrix[row][col]);
                }
            }
            set.clear();
        }
        return sum+" "+noOfDupRows+" "+noOfDupCols;
    }
}
