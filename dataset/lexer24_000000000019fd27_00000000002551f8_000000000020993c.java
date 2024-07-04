import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int[][] m = new int[n][n];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    m[j][k] = in.nextInt() - 1;
                }
            }

            int sum = n;
            for (int j = 0; j < n; j++) {
                sum+= m[j][j];
            }
            
            int rows = 0;
            for (int j = 0; j < n; j++) {
                int[] e = new int[n];
                for (int k = 0; k < n; k++) {
                    
                    e[m[j][k]]++;
                    if(e[m[j][k]] > 1) {
                        rows++;
                        break;
                    }
                }
            }
            int cols = 0;
            for (int j = 0; j < n; j++) {
                int[] e = new int[n];
                for (int k = 0; k < n; k++) {
                    e[m[k][j]]++;
                    if(e[m[k][j]] > 1) {
                        cols++;
                        break;
                    }
                }
            }

            System.out.println("Case #" + i + ": " + sum + " " + rows + " " + cols);
        }
        in.close();
    }

}