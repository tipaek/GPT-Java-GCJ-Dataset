
import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String args[]) throws Exception {
        InputStreamReader ab = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(ab);

        int t = Integer.parseInt(in.readLine().trim());

        for (int tc = 1; tc <= t; tc++) {
            String s[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int k = Integer.parseInt(s[1]);

            solve(n, k, tc);
        }
    }


    public static void solve(int n, int k, int tc) {
        int arr[][] = new int[n][n];

        boolean result = solveUtil(arr, n);

        if (!result) {
            System.out.println("Case #" + tc + ": " + "IMPOSSIBLE");
        } else {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += arr[i][i];
            }
            if (sum == k) {
                System.out.println("Case #" + tc + ": " + "POSSIBLE");
                String z = "";
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        z += arr[i][j] + " ";
                    }
                    z = z.trim();
                    z += "\n";
                }
                System.out.println(z.trim());
            } else {
                System.out.println("Case #" + tc + ": " + "IMPOSSIBLE");
            }
        }
    }

    public static boolean solveUtil(int arr[][], int n) {
        int row = -1;
        int col = -1;
        boolean isEmpty = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 0) {
                    row = i;
                    col = j;
                    isEmpty = false;
                    break;
                }
            }
            if (!isEmpty) {
                break;
            }
        }
        if (isEmpty) {
            return true;
        }

        for (int num = 1; num <= n; num++) {
            if (isSafe(arr, num, row, col, n)) {
                arr[row][col] = num;
                if (solveUtil(arr, n)) {
                    return true;
                } else {
                    arr[row][col] = 0;
                }
            }
        }
        return false;
    }

    public static boolean isSafe(int arr[][], int val, int x, int y, int n) {
        if (x < 0 || x >= n || y < 0 || y >= n) {
            return false;
        }
        for (int i = 0; i < n; i++) {
            if (arr[i][y] == val || arr[x][i] == val) {
                return false;
            }
        }
        return true;
    }

}
