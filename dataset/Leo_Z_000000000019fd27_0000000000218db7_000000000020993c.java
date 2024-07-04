//package Google_CodeJam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = sc.nextInt();
        int[][] ansMat = new int[cases][3];
        for (int z = 0; z < cases; z++) {
            int n = sc.nextInt();
            int[][] mat = new int[n][n];
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    mat[r][c] = sc.nextInt();
                }
            }

            int rAns = 0;
            int trace = 0;
            for(int r = 0; r<n; r++){
                trace+=mat[r][r];
            }
            for (int r = 0; r < n; r++) {
                boolean[] rArr = new boolean[n];
                for (int c = 0; c < n; c++) {
                    if (rArr[mat[r][c] - 1]) {
                        rAns++;
                        break;
                    }
                    rArr[mat[r][c] - 1] = true;
                }
            }

            int cAns = 0;
            for (int c = 0; c < n; c++) {
                boolean[] cArr = new boolean[n];
                for (int r = 0; r < n; r++) {
                    if (cArr[mat[r][c] - 1]) {
                        cAns++;
                        break;
                    }
                    cArr[mat[r][c] - 1] = true;
                }
            }

            ansMat[z][0] = trace;
            ansMat[z][1] = rAns;
            ansMat[z][2] = cAns;
        }
        for (int r = 0; r < cases; r++) {
            System.out.println("Case #" + (r + 1) + " " + ansMat[r][0] + " " + ansMat[r][1] + " " + ansMat[r][2]);
        }
    }

}
