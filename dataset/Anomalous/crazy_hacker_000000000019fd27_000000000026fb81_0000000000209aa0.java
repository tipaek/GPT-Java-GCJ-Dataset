import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());
        PrintWriter writer = new PrintWriter(System.out);
        StringBuilder result = new StringBuilder();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            result.append("Case #").append(caseNumber).append(": ");
            String[] input = reader.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int k = Integer.parseInt(input[1]);

            if (k % n == 0 && k / n <= n) {
                result.append("POSSIBLE\n");
                int[][] matrix = new int[n][n];
                int baseValue = k / n;

                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        matrix[i][(i + j) % n] = (baseValue + j) % n + 1;
                    }
                }

                for (int[] row : matrix) {
                    for (int value : row) {
                        result.append(value).append(" ");
                    }
                    result.append("\n");
                }
            } else {
                result.append("IMPOSSIBLE\n");
            }
        }

        writer.print(result);
        writer.flush();
        reader.close();
    }
}