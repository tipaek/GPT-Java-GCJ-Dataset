import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int index = 1; index <= t; ++index) {
            int num = in.nextInt();
            String[] all = new String[num];
            for (int i = 0; i < num; i++) {
                all[i] = in.next();
            }
            System.out.println("Case #" + index + ": " + getRes(all));
        }
    }


    private static String getRes(String[] arr) {
        String res = "";
        for (String a : arr) {
            if (a.length() > res.length()) {
                res = a;
            }
        }
        res = res.substring(1);
        for (String a : arr) {
            if (!res.endsWith(a.substring(1))) {
                return "*";
            }
        }
        return res;
    }

}