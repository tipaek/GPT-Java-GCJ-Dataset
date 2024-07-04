import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine().trim());
        int caseNumber = 1;

        while (testCases-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int[][] matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int trace = 0;
            int rowRepeated = 0;
            int colRepeated = 0;

            for (int i = 0; i < n; i++) {
                trace += matrix[i][i];
                boolean[] rowCheck = new boolean[n + 1];
                boolean[] colCheck = new boolean[n + 1];
                boolean rowHasDuplicate = false;
                boolean colHasDuplicate = false;

                for (int j = 0; j < n; j++) {
                    if (!rowHasDuplicate) {
                        if (rowCheck[matrix[i][j]]) {
                            rowRepeated++;
                            rowHasDuplicate = true;
                        } else {
                            rowCheck[matrix[i][j]] = true;
                        }
                    }

                    if (!colHasDuplicate) {
                        if (colCheck[matrix[j][i]]) {
                            colRepeated++;
                            colHasDuplicate = true;
                        } else {
                            colCheck[matrix[j][i]] = true;
                        }
                    }
                }
            }

            System.out.println("Case #" + caseNumber + ": " + trace + " " + rowRepeated + " " + colRepeated);
            caseNumber++;
        }
    }
}