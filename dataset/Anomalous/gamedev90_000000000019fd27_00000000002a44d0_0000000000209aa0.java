import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());
        int originalTestCases = testCases;

        while (testCases-- > 0) {
            String[] input = reader.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int k = Integer.parseInt(input[1]);

            int[][] initialMatrix = initializeMatrix(n);
            boolean isPossible = checkPossibility(n, k, initialMatrix, 0);

            String result = isPossible ? "POSSIBLE" : "IMPOSSIBLE";
            System.out.println("Case #" + (originalTestCases - testCases) + ": " + result);
        }
    }

    private static boolean checkPossibility(int n, int k, int[][] matrix, int sum) {
        if (sum == k) {
            return true;
        }

        if (n == 0) {
            return false;
        }

        sum += matrix[n - 1][n - 1];
        n--;
        return checkPossibility(n, k, matrix, sum);
    }

    private static int[][] initializeMatrix(int size) {
        int[][] matrix = new int[size][size];
        int[] referenceArray = new int[size];

        for (int i = 0; i < size; i++) {
            referenceArray[i] = i + 1;
        }

        matrix[0] = referenceArray.clone();
        for (int i = 1; i < size; i++) {
            int[] row = new int[size];
            for (int j = 0; j < size; j++) {
                row[j] = referenceArray[(j + i) % size];
            }
            matrix[i] = row;
        }

        return matrix;
    }
}