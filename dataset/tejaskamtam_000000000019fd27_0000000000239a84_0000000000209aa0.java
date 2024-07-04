import java.util.Arrays;
import java.util.Scanner;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for (int i = 1; i <= t; i++) {
            String y = "";
            int n = scan.nextInt();
            int k = scan.nextInt();
            int[][] m = new int[n][n];
            int total = 0;
            for (int j = n; j > 0; j--) {
                total += j;
            }
            if (k % n == 0 && k / n <= n) {
                y += "POSSIBLE\n";
                m[0][0] = k / n;
                for (int j = 1; j < n; j++) {
                    boolean b = true;
                    int val = 1;
                    while (b) {
                        int count = 0;
                        for (int x : m[0]) {
                            if (val == x) {
                                count++;
                            }
                        }
                        if (count == 0) {
                            b = false;
                        } else {
                            val++;
                        }
                    }
                    m[0][j] = val;

                }
                for (int row = 0; row < n - 1; row++) {
                    m[row + 1][0] = m[row][n - 1];
                    for (int col = 1; col < n; col++) {
                        m[row + 1][col] = m[row][col - 1];
                    }
                }
                for (int j = 0; j < n; j++) {
                    for (int x = 0; x < n; x++) {
                        if (x == n - 1) {
                            y += m[j][x];
                        } else {
                            y += m[j][x] + " ";
                        }
                    }
                    if (j != n - 1) {
                        y += "\n";
                    }
                }
            } else if (total == k) {
                y += "POSSIBLE\n";
                m[0][0] = n;
                for (int j = 1; j < n; j++) {
                    boolean b = true;
                    int val = 1;
                    while (b) {
                        int count = 0;
                        for (int x : m[0]) {
                            if (val == x) {
                                count++;
                            }
                        }
                        if (count == 0) {
                            b = false;
                        } else {
                            val++;
                        }
                    }
                    m[0][j] = val;

                }
                for (int row = 0; row < n - 1; row++) {
                    m[row + 1][n - 1] = m[row][0];
                    for (int col = n - 2; col >= 0; col--) {
                        m[row + 1][col] = m[row][col + 1];
                    }
                }
                for (int j = 0; j < n; j++) {
                    for (int x = 0; x < n; x++) {
                        if (x == n - 1) {
                            y += m[j][x];
                        } else {
                            y += m[j][x] + " ";
                        }
                    }
                    if (j != n - 1) {
                        y += "\n";
                    }
                }

            } else {
                y += "IMPOSSIBLE";
            }

            System.out.println("Case #" + i + ": " + y);
        }
    }

}