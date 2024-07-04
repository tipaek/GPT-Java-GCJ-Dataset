import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.

        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();

            int trace = 0; //trace of the matrix
            int r = 0; //rows of the matrix that contain repeated elements
            int c = 0; //columns of the matrix that contain repeated elements
            int[][] mat = new int[n][n];

            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    int m = in.nextInt();
                    if(j==k)
                        trace += m;
                    mat[j][k] = m;
                }
            }

            // check row
            boolean isBreak = false;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n-1; k++) {
                    for (int l = k+1; l < n; l++) {
                        if(mat[j][k]==mat[j][l]) {
                            r++;
                            isBreak = true;
                            break;
                        }
                    }
                    if(isBreak) {
                        isBreak = false;
                        break;
                    }
                }
            }

            // check column
            isBreak = false;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n-1; k++) {
                    for (int l = k+1; l < n; l++) {
                        if(mat[k][j]==mat[l][j]) {
                            c++;
                            isBreak = true;
                            break;
                        }
                    }
                    if(isBreak) {
                        isBreak = false;
                        break;
                    }
                }
            }

            System.out.println("Case #" + i + ": " + trace + " " + r + " " + c);
        }
    }
}