import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        int[] b = new int[150];

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int m = Integer.parseInt(reader.readLine());
            int[][] matrix = new int[m][m];
            int t = 0;
            int r = 0;
            boolean add = false;
            for (int j = 0; j < m; j++) {
                String[] split = reader.readLine().split(" ");
                for (int k = 0; k < m; k++) {
                    matrix[j][k] = Integer.parseInt(split[k]);
                    if (j == k) {
                        t += matrix[j][k];
                    }
                    if (b[matrix[j][k]] == 1) {
                        add = true;
                    }
                    b[matrix[j][k]]++;
                }
                if (add) {
                    r++;
                    add = false;
                }
                Arrays.fill(b, 0);
            }
            result.append("Case #").append(i + 1).append(": ");
            result.append(t).append(" ");

            int c = 0;
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < m; k++) {
                    if (b[matrix[k][j]] == 1) {
                        add = true;
                    }
                    b[matrix[k][j]]++;
                }
                if (add) {
                    c++;
                    add = false;
                }
                Arrays.fill(b, 0);
            }
            result.append(r).append(" ").append(c).append("\n");
        }
        System.out.print(result);
    }
}
