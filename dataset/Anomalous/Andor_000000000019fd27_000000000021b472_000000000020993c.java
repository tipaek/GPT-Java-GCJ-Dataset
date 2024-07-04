import java.util.Scanner;

public class Solution {
    static int t, n, k, r, c;
    static boolean[] rowCheck;
    static boolean[][] colCheck;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        t = input.nextInt();

        for (int testCase = 1; testCase <= t; testCase++) {
            k = 0;
            r = 0;
            c = 0;
            n = input.nextInt();
            colCheck = new boolean[n + 1][n + 1];

            for (int row = 1; row <= n; row++) {
                rowCheck = new boolean[n + 1];

                for (int col = 1; col <= n; col++) {
                    int value = input.nextInt();

                    if (!rowCheck[0]) {
                        if (rowCheck[value]) {
                            rowCheck[0] = true;
                            r++;
                        } else {
                            rowCheck[value] = true;
                        }
                    }

                    if (!colCheck[col][0]) {
                        if (colCheck[col][value]) {
                            colCheck[col][0] = true;
                            c++;
                        } else {
                            colCheck[col][value] = true;
                        }
                    }

                    if (row == col) {
                        k += value;
                    }
                }
            }

            System.out.println("Case #" + testCase + ": " + k + " " + r + " " + c);
        }
    }
}