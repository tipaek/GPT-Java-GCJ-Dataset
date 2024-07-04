import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        int[][] arr = new int[t][2];
        for (int i = 0; i < t; i++) {
            arr[i][0] = in.nextInt();
            arr[i][1] = in.nextInt();
        }

        for (int i = 0; i < t; i++) {
            String result = isPossible(arr[i][1], arr[i][0]) ? "POSSIBLE" : "IMPOSSIBLE";
            System.out.println("Case #" + i + ": " + result);
        }
    }

    static Boolean isPossible(int k, int n) {
        if (k % n == 0 && k / n <= n) {
            return true;
        }

        if (n % 2 == 1) {
            return k == n * (n + 1) / 2;
        }

        int[] set = new int[n];
        for (int i = 0; i < n; i++) {
            set[i] = i + 1;
        }
        return n % 2 == 0 && k % 2 == 0 && isSubsetSum(set, n, k / 2, 0, n / 2);
    }

    static boolean isSubsetSum(int set[], int n, int sum, int size, int target) {
        if (sum == 0 && size == target)
            return true;
        if (n == 0 && sum != 0)
            return false;

        if (set[n - 1] > sum)
            return isSubsetSum(set, n - 1, sum, size, target);

        return isSubsetSum(set, n - 1, sum, size, target) ||
                isSubsetSum(set, n - 1, sum - set[n - 1], size + 1, target);
    }
}