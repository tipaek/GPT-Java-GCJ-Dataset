import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();

        for (int x = 1; x <= t; x++) {
            int n = input.nextInt();
            int k = 0, r = 0, c = 0;
            boolean[][] rowCheck = new boolean[n][n];
            boolean[][] colCheck = new boolean[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int value = input.nextInt();
                    if (i == j) {
                        k += value;
                    }
                    rowCheck[i][value - 1] = true;
                    colCheck[j][value - 1] = true;
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!rowCheck[i][j]) {
                        r++;
                        break;
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!colCheck[i][j]) {
                        c++;
                        break;
                    }
                }
            }

            System.out.println("Case #" + x + ": " + k + " " + r + " " + c);
        }

        input.close();
    }
}