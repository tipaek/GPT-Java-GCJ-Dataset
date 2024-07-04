import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine().trim());

        for (int caseNum = 1; caseNum <= t; caseNum++) {
            int n = Integer.parseInt(reader.readLine().trim());
            int[][] matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(reader.readLine());
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int trace = 0, rowDuplicates = 0, colDuplicates = 0;

            // Calculate trace
            for (int i = 0; i < n; i++) {
                trace += matrix[i][i];
            }

            // Check for row duplicates
            for (int i = 0; i < n; i++) {
                boolean[] seen = new boolean[n];
                for (int j = 0; j < n; j++) {
                    if (seen[matrix[i][j] - 1]) {
                        rowDuplicates++;
                        break;
                    }
                    seen[matrix[i][j] - 1] = true;
                }
            }

            // Check for column duplicates
            for (int i = 0; i < n; i++) {
                boolean[] seen = new boolean[n];
                for (int j = 0; j < n; j++) {
                    if (seen[matrix[j][i] - 1]) {
                        colDuplicates++;
                        break;
                    }
                    seen[matrix[j][i] - 1] = true;
                }
            }

            System.out.println("Case #" + caseNum + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }
    }
}