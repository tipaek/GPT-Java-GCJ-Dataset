import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    private static int caseNum = 0;

    public static void main(String[] arg) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();

        for(int i=0; i < t; i++) {
            int n = in.nextInt();
            int[][] mat = new int[n][n];
            for (int k = 0; k < n; k++) {
                for (int j = 0; j < n; j++) {
                    mat[k][j] = in.nextInt();
                }
            }
            solve(n, mat);
        }
    }

    private static void solve(int n, int[][] m) {
        caseNum++;

        int k = 0;
        int r = 0;
        int c = 0;

        for(int i=0;i<n;i++)
            k += m[i][i];

        for(int i=0; i<n;i++) {
            int[] found = new int[n];
            for(int j=0;j<n;j++) {
                if(found[m[i][j]-1] > 0) {
                    r++;
                    break;
                }
                found[m[i][j]-1] = 1;
            }
        }

        for(int i=0; i<n;i++) {
            int[] found = new int[n];
            for (int j = 0; j < n; j++) {
                if(found[m[j][i]-1] > 0) {
                    c++;
                    break;
                }
                found[m[j][i]-1] = 1;
            }
        }

        System.out.println("Case #" + caseNum +": " + k + " " + r +" " + c);
    }
}