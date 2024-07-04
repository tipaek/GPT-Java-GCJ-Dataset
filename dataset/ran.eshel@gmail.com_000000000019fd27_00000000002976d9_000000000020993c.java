import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {

        Scanner s = null;
        try {
            s = new Scanner (new File("test.in"));
        } catch (FileNotFoundException e) {
            e.printStackTrace ();
        }
        if (s == null)
            return;

        int t = s.nextInt();
        for (int i = 1; i <= t; ++i) {

            int n = s.nextInt();
            int[][] m = new int[n][];
            for (int j = 0; j < n; j++) {
                m[j] = new int[n];
                for (int k = 0; k < n; k++)
                    m[j][k] = s.nextInt();
            }

            int tr = 0;
            int r = 0;
            int c = 0;

            for (int j = 0; j < n; j++)
                tr += m[j][j];

            for (int j = 0; j < n; j++) {
                boolean[] b = new boolean[n];
                for (int k = 0; k < n; k++) {
                    if (b[m[j][k] - 1]) {
                        r++;
                        break;
                    }
                    b[m[j][k] - 1] = true;
                }
            }

            for (int j = 0; j < n; j++) {
                boolean[] b = new boolean[n];
                for (int k = 0; k < n; k++) {
                    if (b[m[k][j] - 1]) {
                        c++;
                        break;
                    }
                    b[m[k][j] - 1] = true;
                }
            }

            System.out.println("Case #" + i + ": " + tr + " " + r + " " + c);
        }
    }
}

