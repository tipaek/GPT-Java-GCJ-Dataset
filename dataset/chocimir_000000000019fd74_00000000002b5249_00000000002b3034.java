import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    String solve(Scanner in) {
        int n = in.nextInt();
        List<String> strings = new ArrayList<>();
        List<String> revStrings = new ArrayList<>();
        for(int i = 0; i < n; ++i) {
            String s = in.next();
            strings.add(s);
            revStrings.add(rev(s));
        }
        String pref = findPrefix(strings);
        if (pref.equals("*")) {
            return pref;
        }

        String suff = rev(findPrefix(revStrings));
        if (suff.equals("*")) {
            return suff;
        }
        StringBuilder res = new StringBuilder(pref);
        for(String s : strings) {
            res.append(mid(s));
        }
        res.append(suff);
        return res.toString();
    }

    private String mid(String s) {
        int i = s.indexOf('*');
        int j = s.lastIndexOf('*');
        StringBuilder res = new StringBuilder();
        for(int a = i; a <=j; ++a) {
            if (s.charAt(a) != '*') {
                res.append(s.charAt(a));
            }
        }
        return res.toString();
    }

    private String rev(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    private String findPrefix(List<String> strings) {
        String pref = "";
        for(String s : strings) {
            int i = 0;
            while (s.charAt(i) != '*') {
                if (pref.length() > i && pref.charAt(i) != s.charAt(i)) {
                    return "*";
                }
                if (pref.length() <= i) {
                    pref += s.charAt(i);
                }
                i++;
            }
        }
        return pref;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        Solution sol = new Solution();
        for (int i = 1; i <= t; ++i) {
            System.out.println("Case #" + i + ": " + sol.solve(in));
        }
    }
}
