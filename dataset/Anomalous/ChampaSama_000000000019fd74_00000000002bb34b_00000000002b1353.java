import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Solution {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        try {
            int testCases = Integer.parseInt(br.readLine());
            for (int cases = 0; cases < testCases; cases++) {
                int sum = Integer.parseInt(br.readLine());
                int n = sum;
                int[][] pascalTriangle = generatePascalTriangle(n);

                System.out.println("Case #" + (cases + 1) + ": ");
                printCoordinates(sum, n, pascalTriangle);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int[][] generatePascalTriangle(int n) {
        int[][] pascalTriangle = new int[n][n];
        for (int line = 0; line < n; line++) {
            for (int i = 0; i <= line; i++) {
                if (line == i || i == 0)
                    pascalTriangle[line][i] = 1;
                else
                    pascalTriangle[line][i] = pascalTriangle[line - 1][i - 1] + pascalTriangle[line - 1][i];
            }
        }
        return pascalTriangle;
    }

    private static void printCoordinates(int sum, int n, int[][] pascalTriangle) {
        boolean flag = false;
        outerLoop:
        for (int i = 0; i < n; i++) {
            if (flag) {
                for (int j = 0; j < n; j++) {
                    if (pascalTriangle[i][j] != 0) {
                        sum--;
                        System.out.println((i + 1) + " " + (j + 1));
                    }
                    if (sum <= 0) {
                        break outerLoop;
                    }
                }
            } else {
                for (int j = n - 1; j >= 0; j--) {
                    if (pascalTriangle[i][j] != 0) {
                        sum--;
                        System.out.println((i + 1) + " " + (j + 1));
                    }
                    if (sum <= 0) {
                        break outerLoop;
                    }
                }
            }
            flag = !flag;
        }
    }
}