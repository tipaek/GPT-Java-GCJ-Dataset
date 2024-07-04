import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

class Solution {
    private static ArrayList<String> patterns;
    private static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int ti = 1; ti <= t; ti++) {
            n = sc.nextInt();
            patterns = new ArrayList<String>();
            for (int i = 0; i < n; i++) {
                patterns.add(sc.next());
            }
            patterns.sort(new Comparator<String>() {
                @Override
                public int compare(String arg0, String arg1) {
                    int cnt0 = 0, cnt1 = 0;
                    for (int i = 0; i < arg0.length(); i++) {
                        if (arg0.charAt(i) == '*')
                            cnt0++;
                    }
                    for (int i = 0; i < arg1.length(); i++) {
                        if (arg1.charAt(i) == '*')
                            cnt1++;
                    }
                    return cnt0 - cnt1;
                }
            });
            System.out.println("Case #" + ti + ": " + solve());
        }
        sc.close();
    }

    private static String solve() {
        String str = "";
        do {
            str = findLongestSub();
            for (int i = 0; i < patterns.size(); i++) {
                String matchStr = match(str, patterns.get(i));
                if (matchStr.equals("*"))
                    return "*";
                patterns.set(i, matchStr);
            }
        } while (!found(str));
        return str;
    }

    private static String findLongestSub() {
        String longSub = "", sub;
        int pos;
        for (String pattern : patterns) {
            pos = pattern.indexOf('*');
            if (pos == -1)
                pos = 0;
            sub = pattern.substring(pos + 1);
            if (sub.length() > longSub.length())
                longSub = sub;
        }
        return longSub;
    }

    private static boolean found(String str) {
        for (String pattern : patterns) {
            if (!pattern.replaceAll("\\*", "").equals(str))
                return false;
        }
        return true;
    }

    private static String match(String str, String pattern) {
        for (int i = 1; i <= str.length(); i++) {
            if (i > pattern.length())
                return "*";
            if (str.charAt(str.length() - i) == pattern.charAt(pattern.length() - i)) {
                continue;
            }
            if (pattern.charAt(pattern.length() - i) == '*') {
                return pattern.substring(0, pattern.length() - i) + str;
            }
            return "*";
        }
        return pattern;
    }
}