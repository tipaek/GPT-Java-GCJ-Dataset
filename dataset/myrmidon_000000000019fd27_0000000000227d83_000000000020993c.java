import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        final int t = Integer.parseInt(br.readLine());
        for (int ti = 0; ti < t; ti++) {
            final int n = Integer.parseInt(br.readLine());
            final int[][] m = new int[n][n];
            for (int i = 0; i < n; i++) {
                final String[] inputArray = br.readLine().split(" ");
                for (int j = 0; j < n; j++) {
                    m[i][j] = Integer.parseInt(inputArray[j])-1;
                }
            }
            int trace = 0;
            int r = 0;
            int c = 0;
            for (int i = 0; i < n; i++) {
                trace += m[i][i]+1;
                final int[] row = new int[n];
                final int[] col = new int[n];
                for (int j = 0; j < n; j++) {
                    row[m[i][j]]++;
                    col[m[j][i]]++;
                }
                for (int j = 0; j < n; j++) {
                    if (row[j] > 1) {
                        r++;
                        break;
                    }
                }
                for (int j = 0; j < n; j++) {
                    if (col[j]>1) {
                        c++;
                        break;
                    }
                }
            }
            System.out.println(String.format("Case #%d: %d %d %d", ti+1, trace, r, c));
        }
    }
}
