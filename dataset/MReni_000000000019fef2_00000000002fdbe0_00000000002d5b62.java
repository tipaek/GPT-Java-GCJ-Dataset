import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
      Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
      int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
      in.nextLine();
      for (int i = 1; i <= t; ++i) {
        int X = in.nextInt(), Y = in.nextInt();

        String output = getOutput(X, Y);
        System.out.println("Case #" + i + ": " + output);
      }
    }

    private static String getOutput(int X, int Y) {
        int target = Math.abs(X) + Math.abs(Y);
        int i = 0;
        int sum = (int)Math.pow(2, i-1);
        while (sum < target) {
            i++;
            sum += (int)Math.pow(2, i-1);
        }
        boolean[] neg = new boolean[i + 1];
        for (int m = i; m > 0; m--) {
            int val = (int)Math.pow(2, m-1)*2;
            if (sum - val >= target) {
                sum -= val;
                neg[m] = true;
            }
        }
        if (sum != target) return "IMPOSSIBLE";
        boolean[] used = new boolean[i + 1];
        used = findRoute(Math.abs(X), neg, 1, 0, used);
        if (used == null) return "IMPOSSIBLE";
        String output = "";
        for (int m = 1; m <= i; m++) {
            String[] directions = used[m]? xs : ys;
            int targetInt = used[m] ? X : Y;
            boolean targetDir = targetInt > 0 ? neg[m] : !neg[m];
            String dir = targetDir? directions[0] : directions[1];
            output += dir;
        }
        return output;
    }

    private static String[] ys = new String[]{"S", "N"};
    private static String[] xs = new String[]{"W", "E"};

    private static boolean[] findRoute(int X, boolean[] neg, int idx, int partialSum, boolean[] used) {
        if (idx >= neg.length) return null;
        if (partialSum == X) {return used;}
        for (int m = idx; m < neg.length; m++) {
            used[m] = true;
            int sign = neg[m]? -1: 1;
            int currSum = partialSum + sign * (int)Math.pow(2, m-1);
            if (currSum == X || findRoute(X, neg, m+1, currSum, used) != null) {
                return used;
            }
            used[m] = false;
        }
        return null;
    }
}