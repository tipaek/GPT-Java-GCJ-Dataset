import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int[][] mat = new int[n][n];
            
            for (int row = 0; row < n; row++) {
                for (int column = 0; column < n; column++) {
                    mat[row][column] = in.nextInt();
                }
            }
            
            int k = 0, r = 0, c = 0;

            // Calculate trace and row duplicates
            for (int row = 0; row < n; row++) {
                k += mat[row][row];
                Set<Integer> rowSet = new HashSet<>();
                for (int column = 0; column < n; column++) {
                    if (!rowSet.add(mat[row][column])) {
                        r++;
                        break;
                    }
                }
            }

            // Calculate column duplicates
            for (int column = 0; column < n; column++) {
                Set<Integer> colSet = new HashSet<>();
                for (int row = 0; row < n; row++) {
                    if (!colSet.add(mat[row][column])) {
                        c++;
                        break;
                    }
                }
            }

            System.out.println("Case #" + (i + 1) + ": " + k + " " + r + " " + c);
        }
    }
}