import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        outer:
        for (int case_num = 1; case_num <= T; case_num++) {
            int N = in.nextInt();
            in.nextLine();
            int maxLen = 0, minLen = Integer.MAX_VALUE;
            String[][] strings = new String[N][];
            for (int j = 0; j < strings.length; j++) {
                String line = in.nextLine();
                strings[j] = line.split("\\*", -1);
                if (strings[j].length > maxLen) maxLen = strings[j].length;
                if (strings[j].length < minLen) minLen = strings[j].length;
            }
            boolean fail = false;
            String maxLeft = "", maxRight = "";
            String single = null;
            if (minLen == 1) {
                for (int i = 0; !fail && i < strings.length; i++) {
                    if (strings[i].length == 1) {
                        if (single == null) single = strings[i][0];
                        else if (!single.equals(strings[i][0])) {
                            fail = true;
                        }
                    }
                }
                maxLeft = maxRight = single;
            } else {
                for (int i = 0; !fail && i < strings.length; i++) {
                    if (maxLeft.length() < strings[i][0].length()) {
                        if (!strings[i][0].startsWith(maxLeft)) {
                            fail = true;
                        }
                        maxLeft = strings[i][0];
                    } else if (!maxLeft.startsWith(strings[i][0])) {
                        fail = true;
                    }
                }
                for (int i = 0; !fail && i < strings.length; i++) {
                    String curr = strings[i][strings[i].length - 1];
                    if (maxRight.length() < curr.length()) {
                        if (!curr.endsWith(maxRight)) {
                            fail = true;
                        }
                        maxRight = curr;
                    } else if (!maxRight.endsWith(curr)) {
                        fail = true;
                    }
                }
            }
            if (maxLeft.equals(maxRight)) {
                single = maxLeft;
            }
            if (fail) {
                System.out.println("Case #" + case_num + ": *");
            } else if (single != null && !fail_walking_single(strings, single)) {
                System.out.println("Case #" + case_num + ": " + single);
            } else {
                System.out.print("Case #" + case_num + ": ");
                System.out.print(maxLeft);
                for (int i = 1; i < maxLen - 1; i++) {
                    for (int j = 0; j < strings.length; j++) {
                        if (i < strings[j].length - 1) {
                            System.out.print(strings[j][i]);
                        }
                    }
                }
                System.out.println(maxRight);
            }
        }
    }

    public static boolean fail_walking_single(String[][] strings, String single) {
        boolean fail = false;
        for (int i = 0; !fail && i < strings.length; i++) {
            int j = 0, k = 0, l = 0;
            while (j < strings[i].length && k == strings[i][j].length()) {
                k = 0;
                j++;
            }
            while (j < strings[i].length && k < strings[i][j].length() && l < single.length()) {
                if (single.charAt(l++) == strings[i][j].charAt(k)) k++;
                while (j < strings[i].length && k == strings[i][j].length()) {
                    k = 0;
                    j++;
                }
            }
            if (k != 0 || j < strings[i].length) {
                fail = true;
            }
        }
        return fail;
    }
}
