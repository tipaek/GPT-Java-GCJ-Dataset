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
                strings[j] = line.split("\\*");
                if (line.endsWith("*")) {
                    String[] arr = new String[strings[j].length + 1];
                    System.arraycopy(strings[j], 0, arr, 0, strings[j].length);
                    arr[arr.length - 1] = "";
                    strings[j] = arr;
                }
                if (strings[j].length > maxLen) maxLen = strings[j].length;
                if (strings[j].length < minLen) minLen = strings[j].length;
            }
            String maxLeft = "", maxRight = "";
            boolean fail = false;
            if (minLen == 1) {
                String single = null;
                for (int i = 0; i < strings.length; i++) {
                    if (strings[i].length == 1) {
                        if (single == null) single = strings[i][0];
                        else fail = true;
                    }
                }
                maxLeft = maxRight = single;
            }
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
            if (fail) {
                System.out.println("Case #" + case_num + ": *");
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
                if (maxLeft.equals(maxRight)) System.out.println();
                else System.out.println(maxRight);
            }
        }
    }
}
