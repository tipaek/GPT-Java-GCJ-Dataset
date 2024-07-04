import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Scanner;

public class Solution {

    public static boolean checkArray(int n, int[] array) {
        boolean b = false;
        for (int x : array) {
            if (n == x) {
                b = true;
                break;
            }
        }
        return b;
    }


    public static void main(String[] args) {
        Scanner s = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        for (int t = 0; t < s.nextInt(); t++) {
            int n = s.nextInt();
            int[][] m = new int[n][n];
            int trace = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    m[i][j] = s.nextInt();
                }
                trace += m[i][i];
            }

            int r = -(n*n);
            int c = -(n*n);

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (checkArray(m[i][j], m[i])) {
                        r++;
                    }
                    if (checkArray(m[j][i], m[j])) {
                        c++;
                    }
                }
            }
            System.out.println("Case #" + (t+1) + ": " + trace + " " + r + " " + c);
        }
    }
}