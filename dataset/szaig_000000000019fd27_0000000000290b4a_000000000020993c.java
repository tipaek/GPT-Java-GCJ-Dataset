import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        int[][] a = new int[100][100];
        for (int qdx = 1; qdx <= t; ++qdx) {
            int n = in.nextInt();

            int k = 0;
            int c = 0;
            int r = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    a[i][j] = in.nextInt();
                    if (i == j) {
                        k += a[i][j];
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                boolean flags[] = new boolean[n];
                for (int j = 0; j < n; j++) {
                    int temp = a[i][j];
                    if (flags[temp - 1]) {
                        c++;
                        break;
                    } else {
                        flags[temp - 1] = true;
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                boolean flags[] = new boolean[n];
                for (int j = 0; j < n; j++) {
                    int temp = a[j][i];
                    if (flags[temp - 1]) {
                        r++;
                        break;
                    } else {
                        flags[temp - 1] = true;
                    }
                }
            }

            System.out.println("Case #" + qdx + ": " + k + " " + c + " " + r);
        }
    }
}