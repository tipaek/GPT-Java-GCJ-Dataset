import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());
        PrintWriter writer = new PrintWriter(System.out);
        StringBuilder output = new StringBuilder();

        for (int h = 1; h <= t; h++) {
            output.append("Case #").append(h).append(": ");
            String[] input = reader.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int k = Integer.parseInt(input[1]);

            boolean allSame = (k % n == 0);
            boolean allDiff = false; // This variable is never used

            if (!allSame && !allDiff) {
                output.append("IMPOSSIBLE\n");
            } else {
                output.append("POSSIBLE\n");
                int[][] matrix = new int[n + 1][n + 1];

                if (allSame) {
                    for (int i = 1; i <= n; i++) {
                        int value = k / n;
                        int count = 1;
                        int j = i;

                        while (count <= n) {
                            matrix[i][j] = value;
                            value = (value % n) + 1;
                            j = (j % n) + 1;
                            count++;
                        }
                    }
                }

                for (int i = 1; i <= n; i++) {
                    for (int j = 1; j <= n; j++) {
                        output.append(matrix[i][j]).append(" ");
                    }
                    output.append("\n");
                }
                output.append("\n");
            }
        }

        writer.print(output);
        writer.flush();
        reader.close();
    }
}