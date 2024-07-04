import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int x = 1; x <= t; ++x) {
            int n = in.nextInt();
            int[][] arr = new int[n][2];
            for (int i = 0; i < n; i++) {
                int l = in.nextInt();
                int r = in.nextInt();
                arr[i][0] = l;
                arr[i][1] = r;

            }

            String ans = solve(arr);
            System.out.printf("Case #%d: %s%n", x, ans);
        }
    }

    static private String solve(int[][] arr) {
        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));
        StringBuilder ans = new StringBuilder();
        int[] c = null;
        int[] j = null;
        for (int i = 0; i < arr.length; i++) {
            if (c == null || c[1] <= arr[i][0]) {
                c = arr[i];
                ans.append('C');
            } else if (j == null || j[1] <= arr[i][0]) {
                j = arr[i];
                ans.append('J');
            } else {
                return "IMPOSSIBLE";
            }
        }
        return ans.toString();
    }
}