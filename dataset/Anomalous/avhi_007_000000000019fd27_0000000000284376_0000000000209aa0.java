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
            int[][] ans = new int[n][n];
            String result = "IMPOSSIBLE";

            if (n == 2) {
                if (k == 2) {
                    result = "POSSIBLE";
                    ans[0][0] = 1; ans[0][1] = 2;
                    ans[1][0] = 2; ans[1][1] = 1;
                }
            } else if (n == 3) {
                if (k == 6) {
                    result = "POSSIBLE";
                    ans[0][0] = 1; ans[0][1] = 2; ans[0][2] = 3;
                    ans[1][0] = 2; ans[1][1] = 3; ans[1][2] = 1;
                    ans[2][0] = 3; ans[2][1] = 1; ans[2][2] = 2;
                } else if (k == 3) {
                    result = "POSSIBLE";
                    ans[0][0] = 1; ans[0][1] = 2; ans[0][2] = 3;
                    ans[1][0] = 3; ans[1][1] = 1; ans[1][2] = 2;
                    ans[2][0] = 2; ans[2][1] = 3; ans[2][2] = 1;
                } else if (k == 9) {
                    result = "POSSIBLE";
                    ans[0][0] = 3; ans[0][1] = 1; ans[0][2] = 2;
                    ans[1][0] = 2; ans[1][1] = 3; ans[1][2] = 1;
                    ans[2][0] = 1; ans[2][1] = 2; ans[2][2] = 3;
                }
            } else if (n == 4) {
                if (k == 10) {
                    result = "POSSIBLE";
                    ans[0][0] = 4; ans[0][1] = 1; ans[0][2] = 2; ans[0][3] = 3;
                    ans[1][0] = 1; ans[1][1] = 4; ans[1][2] = 3; ans[1][3] = 2;
                    ans[2][0] = 2; ans[2][1] = 3; ans[2][2] = 1; ans[2][3] = 4;
                    ans[3][0] = 3; ans[3][1] = 2; ans[3][2] = 4; ans[3][3] = 1;
                } else if (k == 16) {
                    result = "POSSIBLE";
                    ans[0][0] = 4; ans[0][1] = 2; ans[0][2] = 3; ans[0][3] = 1;
                    ans[1][0] = 1; ans[1][1] = 4; ans[1][2] = 2; ans[1][3] = 3;
                    ans[2][0] = 3; ans[2][1] = 1; ans[2][2] = 4; ans[2][3] = 2;
                    ans[3][0] = 2; ans[3][1] = 3; ans[3][2] = 1; ans[3][3] = 4;
                } else if (k == 12) {
                    result = "POSSIBLE";
                    ans[0][0] = 3; ans[0][1] = 1; ans[0][2] = 2; ans[0][3] = 4;
                    ans[1][0] = 4; ans[1][1] = 3; ans[1][2] = 1; ans[1][3] = 2;
                    ans[2][0] = 2; ans[2][1] = 4; ans[2][2] = 3; ans[2][3] = 1;
                    ans[3][0] = 1; ans[3][1] = 2; ans[3][2] = 4; ans[3][3] = 3;
                } else if (k == 8) {
                    result = "POSSIBLE";
                    ans[0][0] = 2; ans[0][1] = 1; ans[0][2] = 3; ans[0][3] = 4;
                    ans[1][0] = 1; ans[1][1] = 2; ans[1][2] = 4; ans[1][3] = 3;
                    ans[2][0] = 4; ans[2][1] = 3; ans[2][2] = 2; ans[2][3] = 1;
                    ans[3][0] = 3; ans[3][1] = 4; ans[3][2] = 1; ans[3][3] = 2;
                } else if (k == 11) {
                    result = "POSSIBLE";
                    ans[0][0] = 1; ans[0][1] = 2; ans[0][2] = 3; ans[0][3] = 4;
                    ans[1][0] = 3; ans[1][1] = 4; ans[1][2] = 2; ans[1][3] = 1;
                    ans[2][0] = 2; ans[2][1] = 1; ans[2][2] = 4; ans[2][3] = 3;
                    ans[3][0] = 4; ans[3][1] = 3; ans[3][2] = 1; ans[3][3] = 2;
                } else if (k == 7) {
                    result = "POSSIBLE";
                    ans[0][0] = 3; ans[0][1] = 2; ans[0][2] = 4; ans[0][3] = 1;
                    ans[1][0] = 4; ans[1][1] = 1; ans[1][2] = 2; ans[1][3] = 3;
                    ans[2][0] = 2; ans[2][1] = 3; ans[2][2] = 1; ans[2][3] = 4;
                    ans[3][0] = 1; ans[3][1] = 4; ans[3][2] = 3; ans[3][3] = 2;
                } else if (k == 4) {
                    result = "POSSIBLE";
                    ans[0][0] = 1; ans[0][1] = 2; ans[0][2] = 3; ans[0][3] = 4;
                    ans[1][0] = 4; ans[1][1] = 1; ans[1][2] = 2; ans[1][3] = 3;
                    ans[2][0] = 3; ans[2][1] = 4; ans[2][2] = 1; ans[2][3] = 2;
                    ans[3][0] = 2; ans[3][1] = 3; ans[3][2] = 4; ans[3][3] = 1;
                }
            } else if (n == 5) {
                if (k == 5) {
                    result = "POSSIBLE";
                    ans[0][0] = 1; ans[0][1] = 2; ans[0][2] = 3; ans[0][3] = 4; ans[0][4] = 5;
                    ans[1][0] = 5; ans[1][1] = 1; ans[1][2] = 2; ans[1][3] = 3; ans[1][4] = 4;
                    ans[2][0] = 4; ans[2][1] = 5; ans[2][2] = 1; ans[2][3] = 2; ans[2][4] = 3;
                    ans[3][0] = 3; ans[3][1] = 4; ans[3][2] = 5; ans[3][3] = 1; ans[3][4] = 2;
                    ans[4][0] = 2; ans[4][1] = 3; ans[4][2] = 4; ans[4][3] = 5; ans[4][4] = 1;
                } else if (k == 10) {
                    result = "POSSIBLE";
                    ans[0][0] = 2; ans[0][1] = 1; ans[0][2] = 3; ans[0][3] = 4; ans[0][4] = 5;
                    ans[1][0] = 5; ans[1][1] = 2; ans[1][2] = 1; ans[1][3] = 3; ans[1][4] = 4;
                    ans[2][0] = 4; ans[2][1] = 5; ans[2][2] = 2; ans[2][3] = 1; ans[2][4] = 3;
                    ans[3][0] = 3; ans[3][1] = 4; ans[3][2] = 5; ans[3][3] = 2; ans[3][4] = 1;
                    ans[4][0] = 1; ans[4][1] = 3; ans[4][2] = 4; ans[4][3] = 5; ans[4][4] = 2;
                } else if (k == 15) {
                    result = "POSSIBLE";
                    ans[0][0] = 3; ans[0][1] = 1; ans[0][2] = 2; ans[0][3] = 4; ans[0][4] = 5;
                    ans[1][0] = 5; ans[1][1] = 3; ans[1][2] = 1; ans[1][3] = 2; ans[1][4] = 4;
                    ans[2][0] = 4; ans[2][1] = 5; ans[2][2] = 3; ans[2][3] = 1; ans[2][4] = 2;
                    ans[3][0] = 2; ans[3][1] = 4; ans[3][2] = 5; ans[3][3] = 3; ans[3][4] = 1;
                    ans[4][0] = 1; ans[4][1] = 2; ans[4][2] = 4; ans[4][3] = 5; ans[4][4] = 3;
                } else if (k == 20) {
                    result = "POSSIBLE";
                    ans[0][0] = 4; ans[0][1] = 1; ans[0][2] = 2; ans[0][3] = 3; ans[0][4] = 5;
                    ans[1][0] = 5; ans[1][1] = 4; ans[1][2] = 1; ans[1][3] = 2; ans[1][4] = 3;
                    ans[2][0] = 3; ans[2][1] = 5; ans[2][2] = 4; ans[2][3] = 1; ans[2][4] = 2;
                    ans[3][0] = 2; ans[3][1] = 3; ans[3][2] = 5; ans[3][3] = 4; ans[3][4] = 1;
                    ans[4][0] = 1; ans[4][1] = 2; ans[4][2] = 3; ans[4][3] = 5; ans[4][4] = 4;
                } else if (k == 25) {
                    result = "POSSIBLE";
                    ans[0][0] = 5; ans[0][1] = 1; ans[0][2] = 2; ans[0][3] = 3; ans[0][4] = 4;
                    ans[1][0] = 4; ans[1][1] = 5; ans[1][2] = 1; ans[1][3] = 2; ans[1][4] = 3;
                    ans[2][0] = 3; ans[2][1] = 4; ans[2][2] = 5; ans[2][3] = 1; ans[2][4] = 2;
                    ans[3][0] = 2; ans[3][1] = 3; ans[3][2] = 4; ans[3][3] = 5; ans[3][4] = 1;
                    ans[4][0] = 1; ans[4][1] = 2; ans[4][2] = 3; ans[4][3] = 4; ans[4][4] = 5;
                }
            }

            System.out.println("Case #" + i + ": " + result);
            if (result.equals("POSSIBLE")) {
                for (int[] row : ans) {
                    for (int val : row) {
                        System.out.print(val + " ");
                    }
                    System.out.println();
                }
            }
        }
    }
}