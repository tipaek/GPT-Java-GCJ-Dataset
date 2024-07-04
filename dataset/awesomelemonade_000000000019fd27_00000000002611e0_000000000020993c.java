import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution {
    
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);
        int testCases = Integer.parseInt(reader.readLine());
        for (int tt = 0; tt < testCases; tt++) {
            int n = Integer.parseInt(reader.readLine());
            int[][] matrix = new int[n][n];
            for (int i = 0; i < n; i++) {
                StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Integer.parseInt(tokenizer.nextToken());
                }
            }
            int k = 0;
            for (int i = 0; i < n; i++) {
                k += matrix[i][i];
            }
            int r = 0;
            int c = 0;
            for (int i = 0; i < n; i++) {
                int[] set1 = new int[n];
                int[] set2 = new int[n];
                for (int j = 0; j < n; j++) {
                    set1[matrix[i][j] - 1]++;
                    set2[matrix[j][i] - 1]++;
                }
                for (int j = 0; j < n; j++) {
                    if (set1[j] > 1) {
                        r++;
                        break;
                    }
                }
                for (int j = 0; j < n; j++) {
                    if (set2[j] > 1) {
                        c++;
                        break;
                    }
                }
            }
            writer.printf("Case #%d: %d %d %d\n", tt + 1, k, r, c);
        }
        reader.close();
        writer.close();
    }
}