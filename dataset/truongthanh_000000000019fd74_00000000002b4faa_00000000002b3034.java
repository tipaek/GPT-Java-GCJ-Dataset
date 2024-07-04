import java.util.*;
import java.io.*;
public class Solution {
    static boolean debug = false;

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            in.nextLine();
            String[] arr = new String[n];
            for (int j = 0; j < n; j++) {
                arr[j] = in.nextLine().trim();
            }
            System.out.println("Case #" + i + ": " + compute(n, arr));
        }
    }

    public static String compute(int n, String[] arr) {
        String[] first = arr[0].split("\\*", -1);
        String left = first[0];
        String right = first[first.length - 1];
        printArr(first);
        for (int i = 1; i < n; i++) {
            String[] cur = arr[i].split("\\*", -1);
            String curLeft = cur[0];
            String curRight = cur[cur.length - 1];
            printArr(cur);
            left = getLeft(left, curLeft);
            right = getRight(right, curRight);
            if (left == null || right == null) {
                return "*";
            }
        }
        return left + right;
    }

    public static void printArr(String[] arr) {
        if (debug) {
            System.out.println(Arrays.toString(arr));
        }
    }

    public static String getRight(String prev, String cur) {
        if (cur == "") {
            return prev;
        }
        if (prev.length() <= cur.length()) {
            if (cur.substring(cur.length() - prev.length()).equals(prev)) {
                return cur;
            } else {
                return null;
            }
        } else {
            if (prev.substring(prev.length() - cur.length()).equals(cur)) {
                return prev;
            } else {
                return null;
            }
        }
    }

    public static String getLeft(String prev, String cur) {
        if (cur == "") {
            return prev;
        }
        if (prev.length() <= cur.length()) {
            if (cur.substring(0, prev.length()).equals(prev)) {
                return cur;
            } else {
                return null;
            }
        } else {
            if (prev.substring(0, cur.length()).equals(cur)) {
                return prev;
            } else {
                return null;
            }
        }
    }
}