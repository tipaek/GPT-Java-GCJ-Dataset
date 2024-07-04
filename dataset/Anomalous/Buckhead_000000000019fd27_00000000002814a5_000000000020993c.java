import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {

    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(reader.readLine());
            int[][] results = new int[n][3];

            for (int i = 0; i < n; i++) {
                int m = Integer.parseInt(reader.readLine());
                int[][] matrix = new int[m][m];

                for (int j = 0; j < m; j++) {
                    StringTokenizer tokenizer = new StringTokenizer(reader.readLine().trim(), " ");
                    for (int k = 0; k < m; k++) {
                        matrix[j][k] = Integer.parseInt(tokenizer.nextToken());
                    }
                }

                int trace = 0, rowRepeats = 0, colRepeats = 0;

                // Check rows for duplicates and calculate trace
                for (int j = 0; j < m; j++) {
                    boolean[] seen = new boolean[m];
                    for (int k = 0; k < m; k++) {
                        if (seen[matrix[j][k] - 1]) {
                            rowRepeats++;
                            break;
                        }
                        seen[matrix[j][k] - 1] = true;
                    }
                    trace += matrix[j][j];
                }

                // Check columns for duplicates
                for (int j = 0; j < m; j++) {
                    boolean[] seen = new boolean[m];
                    for (int k = 0; k < m; k++) {
                        if (seen[matrix[k][j] - 1]) {
                            colRepeats++;
                            break;
                        }
                        seen[matrix[k][j] - 1] = true;
                    }
                }

                results[i][0] = trace;
                results[i][1] = rowRepeats;
                results[i][2] = colRepeats;
            }

            for (int i = 0; i < n; i++) {
                System.out.println("Case #" + (i + 1) + ": " + results[i][0] + " " + results[i][1] + " " + results[i][2]);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}