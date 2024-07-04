import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int index = 1; index <= t; ++index) {
            int all = in.nextInt();
            int[][] act = new int[all][2];
            for (int i = 0; i < all; i++) {
                act[i][0] = in.nextInt();
                act[i][1] = in.nextInt();
            }
            System.out.println("Case #" + index + ": " + getRes(index, act, all));
        }
    }

    private static String getRes(int index, int[][] act, int num) {
        Arrays.sort(act, (a, b) -> (a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]));
        StringBuilder res = new StringBuilder();
        String[] pick = new String[]{"C", "J"};
        int start = 0;
        for (int i = 0; i < act.length; i++) {
            int curEnd = act[i][1];
            res.append(pick[(start++) % 2]);
            int preEnd = -1;
            int j = i + 1;
            for (; j < act.length && act[j][0] < curEnd; j++) {
                if (act[j][0] < preEnd) {
                    return "IMPOSSIBLE";
                } else {
                    res.append(pick[(start) % 2]);
                    preEnd = act[j][1];
                }
            }
            if (i + 1 == j) {
                continue;
            }
            i = j - 2;
            res.deleteCharAt(res.length() - 1);
        }
        return res.toString();
    }
}