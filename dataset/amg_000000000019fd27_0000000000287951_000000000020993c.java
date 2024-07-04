import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();

            int[][] mat = new int[n][n];
            
            for(int j = 0; j < n; j++) {
                for(int k = 0; k < n; k++) {
                    mat[j][k] = in.nextInt();
                }
            }

            solve(mat, i);
        }
    }

    public static void solve(int[][] mat, int testNum) {
        int trace = 0;

        for(int i = 0; i < mat.length; i++) {
            trace += mat[i][i];
        }

        int[] counts = new int[mat.length];
        int r = 0;
        int c = 0;

        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat.length; j++) {
                counts[mat[i][j] - 1]++;
                if(counts[mat[i][j] - 1] == 2) {
                    r++;
                    break;
                }
            }

            for(int z = 0; z < mat.length; z++) {
                counts[z] = 0;
            }
        }

        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat.length; j++) {
                counts[mat[j][i] - 1]++;
                if(counts[mat[j][i] - 1] == 2) {
                    c++;
                    break;
                }
            }

            for(int z = 0; z < mat.length; z++) {
                counts[z] = 0;
            }
        }

        System.out.println("Case #" + testNum + ": " + trace + " " + r + " " + c);
    }
}