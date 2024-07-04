import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        int cnt = 1;
        int num = 1;
        while (num <= t) {
            int n = in.nextInt();
            int[][] m = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    m[i][j] = in.nextInt();
                }
            }

            int k = 0;
            int c = 0;
            int r = 0;

            for (int i = 0; i < n; i++) {
                Map<Integer, Integer> column = new HashMap<>();
                Map<Integer, Integer> row = new HashMap<>();
                k += m[i][i];
                for (int j = 0; j < n; j++) {
                    int rowI = m[i][j];
                    row.compute(rowI, (key, v) -> v == null ? 1 : ++v);
                    column.compute(m[j][i],(key, v) -> v == null ? 1 : ++v);
                }

                for(Integer rpt: row.values()) {
                    if (rpt > 1) {
                        r++;
                        break;
                    }
                }
                for(Integer rpt: column.values()) {
                    if (rpt > 1) {
                        c++;
                        break;
                    }
                }
            }

            System.out.println("Case #" + num + ": " +  k + " " + r + " " + c);
            num++;
        }

    }

}


