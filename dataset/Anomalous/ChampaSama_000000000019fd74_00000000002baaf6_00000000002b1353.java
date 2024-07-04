import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        try {
            int testCases = Integer.parseInt(br.readLine());
            
            for (int caseIndex = 0; caseIndex < testCases; caseIndex++) {
                int sum = Integer.parseInt(br.readLine());
                int n = sum;
                int[][] pascalTriangle = new int[n][n];

                // Build Pascal's Triangle
                for (int row = 0; row < n; row++) {
                    for (int col = 0; col <= row; col++) {
                        if (col == 0 || col == row) {
                            pascalTriangle[row][col] = 1;
                        } else {
                            pascalTriangle[row][col] = pascalTriangle[row - 1][col - 1] + pascalTriangle[row - 1][col];
                        }
                    }
                }

                System.out.println("Case #" + (caseIndex + 1) + ": *");
                boolean leftToRight = false;

                outerLoop:
                for (int row = 0; row < n; row++) {
                    if (leftToRight) {
                        for (int col = 0; col < n; col++) {
                            if (pascalTriangle[row][col] != 0) {
                                sum--;
                                System.out.println((row + 1) + " " + (col + 1));
                                if (sum <= 0) {
                                    break outerLoop;
                                }
                            }
                        }
                    } else {
                        for (int col = n - 1; col >= 0; col--) {
                            if (pascalTriangle[row][col] != 0) {
                                sum--;
                                System.out.println((row + 1) + " " + (col + 1));
                                if (sum <= 0) {
                                    break outerLoop;
                                }
                            }
                        }
                    }
                    leftToRight = !leftToRight;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}