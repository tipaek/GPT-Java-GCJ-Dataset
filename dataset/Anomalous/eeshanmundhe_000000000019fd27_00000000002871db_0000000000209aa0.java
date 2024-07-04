import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());

        for (int testCase = 1; testCase <= testCases; testCase++) {
            String[] inputs = reader.readLine().split(" ");
            int n = Integer.parseInt(inputs[0]);
            int k = Integer.parseInt(inputs[1]);

            String result;
            int[][] matrix = new int[n][n];

            if (k % n != 0) {
                result = "IMPOSSIBLE";
            } else {
                result = "POSSIBLE";
                int value = k / n;

                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        matrix[i][(i + j) % n] = (j == 0) ? value : (matrix[i][(i + j - 1) % n] % n) + 1;
                    }
                }
            }

            System.out.println("Case #" + testCase + ": " + result);
            if ("POSSIBLE".equals(result)) {
                for (int[] row : matrix) {
                    for (int num : row) {
                        System.out.print(num + " ");
                    }
                    System.out.println();
                }
            }
        }
    }
}