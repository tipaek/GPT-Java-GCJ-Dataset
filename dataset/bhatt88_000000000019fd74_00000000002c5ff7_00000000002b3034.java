import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            in.nextLine();
            String[] arr = new String[n];
            for (int j = 0; j < n; j++) {
                arr[j] = in.nextLine();
            }
            System.out.println("Case #" + i + ": " + getString(arr,n));
        }
    }

    private static String getString(String[] arr, int n) {
        String start = getStart(arr);
        if (start == null) return "*";
        String end = getEnd(arr);
        if (end == null) return  "*";
        String getword = getWord(arr, start, end);
        return getword;
    }

    private static String getWord(String[] arr, String start, String end) {
        String str = "";
        for (int i=0; i<arr.length; i++) {
            if (!arr[i].contains("*")) {
                return start.equals(end) ? start : "*";
            }
            int st = arr[i].indexOf("*") + 1;
            int ed = arr[i].lastIndexOf("*");
            if (st >= ed) continue;
            String s = arr[i].substring(st, ed);
            String[] split = s.split("\\*");
            for (String m : split) {
                str += m;
            }
        }
        return start + str + end;
    }

    private static String getStart(String[] arr) {
        String s = "";
        for (int i=0; i<arr.length; i++) {
            if (arr[i].startsWith("*")) continue;
            String start = arr[i].substring(0, arr[i].indexOf("*"));
            if (start.startsWith(s) || s.startsWith(start)) {
                s = s.length() > start.length() ? s : start;
            } else {
                return null;
            }
        }
        return s;
    }

    private static String getEnd(String[] arr) {
        String e = "";
        for (int i=0; i<arr.length; i++) {
            if (arr[i].endsWith("*")) continue;
            String end = arr[i].substring(arr[i].lastIndexOf("*")+1);
            if (end.endsWith(e) || e.startsWith(end)) {
                e = e.length() > end.length() ? e : end;
            } else {
                return null;
            }
        }
        return e;
    }

}