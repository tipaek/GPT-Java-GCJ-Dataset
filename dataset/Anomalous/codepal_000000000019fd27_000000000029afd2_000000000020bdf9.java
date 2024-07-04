import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    static String ans = "";
    static boolean flag = false;

    public static void main(String[] args) {
        Scanner scn = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scn.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scn.nextInt();
            int[][] arr = new int[n][3];
            for (int j = 0; j < n; j++) {
                arr[j][0] = scn.nextInt();
                arr[j][1] = scn.nextInt();
            }
            ans = "";
            flag = false;
            solve(arr, "C", 0, -1, 1);
            System.out.println("Case #" + (i + 1) + ": " + ans);
        }
    }

    public static void solve(int[][] arr, String str, int c, int j, int k) {
        if (k > arr.length) {
            return;
        }
        if (k == arr.length) {
            ans = str;
            flag = true;
            return;
        }

        if (!flag) {
            if (j > 0 && arr[k][0] < arr[c][1] && arr[k][1] > arr[c][0] && arr[k][0] < arr[j][1] && arr[k][1] > arr[j][0]) {
                ans = "IMPOSSIBLE";
                return;
            }
            if (j == -1) {
                if (arr[k][0] < arr[c][1] && arr[k][1] > arr[c][0]) {
                    solve(arr, str + "J", c, k, k + 1);
                } else {
                    solve(arr, str + "C", k, j, k + 1);
                    if (!flag) {
                        solve(arr, str + "J", c, k, k + 1);
                    }
                }
            } else {
                if (arr[k][0] < arr[c][1] && arr[k][1] > arr[c][0]) {
                    solve(arr, str + "J", c, k, k + 1);
                } else if (arr[k][0] < arr[j][1] && arr[k][1] > arr[j][0]) {
                    solve(arr, str + "C", k, j, k + 1);
                } else {
                    solve(arr, str + "C", k, j, k + 1);
                    if (!flag) {
                        solve(arr, str + "J", c, k, k + 1);
                    }
                }
            }
        }
    }
}