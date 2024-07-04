import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int[][] rows = new int[n][n];
            int[][] columns = new int[n][n];
            int trace = 0;
            for (int j = 0; j <= n - 1; j++) {
                for (int k = 0; k <= n - 1; k++) {
                    int current = in.nextInt();
                    rows[j][k] = current;
                    columns[k][j] = current;
                    if (k == j) {
                        trace += current;
                    }
                }
            }
            int r = 0;
            int c = 0;
            for (int j = 0; j <= n - 1; j++) {
                boolean rDuplicatedFound = false;
                boolean cDuplicatedFound = false;
                Arrays.sort(rows[j]);
                Arrays.sort(columns[j]);
                if (rows[j][0] != 1) {
                    r++;
                    rDuplicatedFound = true;
                }
                if (columns[j][0] != 1) {
                    c++;
                    cDuplicatedFound = true;
                }
                for (int k = 1; k <= n - 1 && (!rDuplicatedFound || !cDuplicatedFound); k++) {
                    if (rows[j][k] != k + 1 && !rDuplicatedFound) {
                        r++;
                        rDuplicatedFound = true;
                    }
                    if (columns[j][k] != k + 1 && !cDuplicatedFound) {
                        c++;
                        cDuplicatedFound = true;
                    }
                }
            }
            System.out.println("Case #" + i + ": " + trace + " " + r + " " + c);
        }
    }

}