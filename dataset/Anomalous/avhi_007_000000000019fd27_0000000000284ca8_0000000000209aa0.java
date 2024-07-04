import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();

        for (int i = 1; i <= t; i++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            String result = "IMPOSSIBLE";
            int[][] ans = new int[n][n];

            if (n == 2) {
                if (k == 2) {
                    result = "POSSIBLE";
                    ans[0] = new int[]{1, 2};
                    ans[1] = new int[]{2, 1};
                }
            } else if (n == 3) {
                if (k == 6) {
                    result = "POSSIBLE";
                    ans[0] = new int[]{1, 2, 3};
                    ans[1] = new int[]{2, 3, 1};
                    ans[2] = new int[]{3, 1, 2};
                } else if (k == 3) {
                    result = "POSSIBLE";
                    ans[0] = new int[]{1, 2, 3};
                    ans[1] = new int[]{3, 1, 2};
                    ans[2] = new int[]{2, 3, 1};
                } else if (k == 9) {
                    result = "POSSIBLE";
                    ans[0] = new int[]{3, 1, 2};
                    ans[1] = new int[]{2, 3, 1};
                    ans[2] = new int[]{2, 3, 1};
                }
            } else if (n == 4) {
                result = handleFourByFour(k, ans);
            } else if (n == 5) {
                result = handleFiveByFive(k, ans);
            }

            System.out.println("Case #" + i + ": " + result);
            if ("POSSIBLE".equals(result)) {
                printMatrix(ans);
            }
        }
    }

    private static String handleFourByFour(int k, int[][] ans) {
        String result = "IMPOSSIBLE";
        switch (k) {
            case 10:
                result = "POSSIBLE";
                ans[0] = new int[]{4, 1, 2, 3};
                ans[1] = new int[]{1, 4, 3, 2};
                ans[2] = new int[]{2, 3, 1, 4};
                ans[3] = new int[]{3, 2, 4, 1};
                break;
            case 16:
                result = "POSSIBLE";
                ans[0] = new int[]{4, 2, 3, 1};
                ans[1] = new int[]{1, 4, 2, 3};
                ans[2] = new int[]{3, 1, 4, 2};
                ans[3] = new int[]{2, 3, 1, 4};
                break;
            case 12:
                result = "POSSIBLE";
                ans[0] = new int[]{3, 1, 2, 4};
                ans[1] = new int[]{4, 3, 1, 2};
                ans[2] = new int[]{2, 4, 3, 1};
                ans[3] = new int[]{1, 2, 4, 3};
                break;
            case 8:
                result = "POSSIBLE";
                ans[0] = new int[]{2, 1, 3, 4};
                ans[1] = new int[]{1, 2, 4, 3};
                ans[2] = new int[]{4, 3, 2, 1};
                ans[3] = new int[]{3, 4, 1, 2};
                break;
            case 11:
                result = "POSSIBLE";
                ans[0] = new int[]{1, 2, 3, 4};
                ans[1] = new int[]{3, 4, 2, 1};
                ans[2] = new int[]{2, 1, 4, 3};
                ans[3] = new int[]{4, 3, 1, 2};
                break;
            case 7:
                result = "POSSIBLE";
                ans[0] = new int[]{3, 2, 4, 1};
                ans[1] = new int[]{4, 1, 2, 3};
                ans[2] = new int[]{2, 3, 1, 4};
                ans[3] = new int[]{1, 4, 3, 2};
                break;
            case 4:
                result = "POSSIBLE";
                ans[0] = new int[]{1, 2, 3, 4};
                ans[1] = new int[]{4, 1, 2, 3};
                ans[2] = new int[]{3, 4, 1, 2};
                ans[3] = new int[]{2, 3, 4, 1};
                break;
            case 9:
                result = "POSSIBLE";
                ans[0] = new int[]{1, 2, 3, 4};
                ans[1] = new int[]{4, 3, 1, 2};
                ans[2] = new int[]{2, 1, 4, 3};
                ans[3] = new int[]{3, 4, 2, 1};
                break;
        }
        return result;
    }

    private static String handleFiveByFive(int k, int[][] ans) {
        String result = "IMPOSSIBLE";
        switch (k) {
            case 5:
                result = "POSSIBLE";
                ans[0] = new int[]{1, 2, 3, 4, 5};
                ans[1] = new int[]{5, 1, 2, 3, 4};
                ans[2] = new int[]{4, 5, 1, 2, 3};
                ans[3] = new int[]{3, 4, 5, 1, 2};
                ans[4] = new int[]{2, 3, 4, 5, 1};
                break;
            case 10:
                result = "POSSIBLE";
                ans[0] = new int[]{2, 1, 3, 4, 5};
                ans[1] = new int[]{5, 2, 1, 3, 4};
                ans[2] = new int[]{4, 5, 2, 1, 3};
                ans[3] = new int[]{3, 4, 5, 2, 1};
                ans[4] = new int[]{1, 3, 4, 5, 2};
                break;
            case 15:
                result = "POSSIBLE";
                ans[0] = new int[]{3, 1, 2, 4, 5};
                ans[1] = new int[]{5, 3, 1, 2, 4};
                ans[2] = new int[]{4, 5, 3, 1, 2};
                ans[3] = new int[]{2, 4, 5, 3, 1};
                ans[4] = new int[]{1, 2, 4, 5, 3};
                break;
            case 20:
                result = "POSSIBLE";
                ans[0] = new int[]{4, 1, 2, 3, 5};
                ans[1] = new int[]{5, 4, 1, 2, 3};
                ans[2] = new int[]{3, 5, 4, 1, 2};
                ans[3] = new int[]{2, 3, 5, 4, 1};
                ans[4] = new int[]{1, 2, 3, 5, 4};
                break;
            case 25:
                result = "POSSIBLE";
                ans[0] = new int[]{5, 1, 2, 3, 4};
                ans[1] = new int[]{4, 5, 1, 2, 3};
                ans[2] = new int[]{3, 4, 5, 1, 2};
                ans[3] = new int[]{2, 3, 4, 5, 1};
                ans[4] = new int[]{1, 2, 3, 4, 5};
                break;
        }
        return result;
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}