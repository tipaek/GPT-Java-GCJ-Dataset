import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        for(int ks = 1; ks <= T; ks++) {
            int n = input.nextInt();
            int[][] mat = new int[n][n];
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    mat[i][j] = input.nextInt();
                }
            }
            solve(mat, n, ks);
        }
    }
    
    public static void solve(int[][] mat, int n, int ks) {
        int trace = 0;
        for(int i = 0; i < n; i++) {
            trace += mat[i][i];
        }
        int repRow = 0;
        for(int i = 0; i < n; i++) {
            for(int testNum = 1; testNum <= n; testNum++) {
                int rep = 0;
                for(int j = 0; j < n; j++) {
                    if(mat[i][j] == testNum) {
                        rep++;
                        if(rep == 2) {
                            repRow++;
                            break;
                        }
                    }
                }
            }
        }
        int repCol = 0;
        for(int i = 0; i < n; i++) {
            for(int testNum = 1; testNum <= n; testNum++) {
                int rep = 0;
                for(int j = 0; j < n; j++) {
                    if(mat[j][i] == testNum) {
                        rep++;
                        if(rep == 2) {
                            repCol++;
                            break;
                        }
                    }
                }
            }
        }
        System.out.println("Case #" + ks + ": " + trace + " " + repRow + " " + repCol);
    }
    
}