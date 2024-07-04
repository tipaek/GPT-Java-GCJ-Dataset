import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());

        for (int testCase = 1; testCase <= testCases; testCase++) {
            String[] input = reader.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int k = Integer.parseInt(input[1]);
            int[][] matrix = new int[n][n];
            String result;

            if (k % n != 0) {
                result = "IMPOSSIBLE";
            } else {
                result = "POSSIBLE";
                int value = k / n;

                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        matrix[i][(i + j) % n] = (j < value) ? 1 : 0;
                    }
                }
            }

            System.out.println("Case #" + testCase + ": " + result);
            if (result.equals("POSSIBLE")) {
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