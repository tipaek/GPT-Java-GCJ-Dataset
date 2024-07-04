import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static String solve (int[][] mat, int n){
        int k = 0;
        for (int i = 0; i < n; i++) {
            k += mat[i][i];
        }
        int r = 0;
        for (int i = 0; i < n; i++) {
            HashSet<Integer> set = new HashSet<Integer>();
            for (int j = 0; j < n; j++) {
                if (set.contains(mat[i][j])) {
                    r++;
                    break;
                } else {
                    set.add(mat[i][j]);
                }
            }
        }
        int c = 0;
        for (int j = 0; j < n; j++) {
            HashSet<Integer> set = new HashSet<Integer>();
            for (int i = 0; i < n; i++) {
                if (set.contains(mat[i][j])) {
                    c++;
                    break;
                } else {
                    set.add(mat[i][j]);
                }
            }
        }
        return "" + k + " " + r + " " + c;
    }

    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        for (int i = 1; i <= t; i++) {
            int n = input.nextInt();
            int[][] mat = new int[n][n];
            for (int j = 0; j < n; j++){
                for (int k = 0; k < n; k++) {
                    mat[j][k] = input.nextInt();
                }
            }
            System.out.println();
            System.out.println("Case #" + i + ": " + solve(mat, n));
        }
        input.close();
    }
}
