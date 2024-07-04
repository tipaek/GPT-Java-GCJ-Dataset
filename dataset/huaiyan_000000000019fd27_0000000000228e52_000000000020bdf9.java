import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int index = 1; index <= t; ++index) {
            int num = in.nextInt();
            int[][] act = new int[num][3];
            for (int i = 0; i < num; i++) {
                act[i][0] = in.nextInt();
                act[i][1] = in.nextInt();
                act[i][2] = i;
            }
            System.out.println("Case #" + index + ": " + getRes(index, act, num));
        }
    }

    private static String getRes(int index, int[][] act, int num) {
        Arrays.sort(act, (a, b) -> (a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]));
        String[] res = new String[num];
        String[] pick = new String[]{"C", "J"};
        int start = 0;
        for (int i = 0; i < act.length; i++) {
            int curEnd = act[i][1];
            res[act[i][2]] = pick[start++ % 2];
            int preEnd = -1;
            int j = i + 1;
            for (; j < act.length && act[j][0] < curEnd; j++) {
                if (act[j][0] < preEnd) {
                    return "IMPOSSIBLE";
                } else {
                    res[act[j][2]] = pick[(start) % 2];
                    preEnd = act[j][1];
                }
            }
            if (i + 1 == j) {
                continue;
            }
            i = j - 2;
        }
        StringBuilder rst = new StringBuilder();
        for (String aa :res) {
            rst.append(aa);
        }
        return rst.toString();
    }
}