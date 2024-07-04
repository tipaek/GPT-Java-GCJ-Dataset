import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tests = in.nextInt();
        for (int i = 0; i < tests; i++) {
            helper(i + 1, in);
        }
    }

    public static void helper(int id, Scanner in) {
        int N = in.nextInt();
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            set.add(in.next());
        }

        String ans = "*";

        for (String s : set) {
            ans = cmp(ans, s);
            if ("*".equals(ans)) break;
        }

        if (ans.length() > 10001) ans = "*";

        if ("*".equals(ans)) {
            System.out.println("Case #" + id + ": " + ans);
        } else {
            StringBuilder sb = new StringBuilder();
            for (char c : ans.toCharArray()) {
                if (c == '*') continue;
                ;
                sb.append(c);
            }

            System.out.println("Case #" + id + ": " + sb.toString());
        }
    }

    public static String cmp(String s1, String s2) {
        if ("*".equals(s1)) return s2;
        if ("*".equals(s2)) return s1;

        String[] a1 = getArr(s1);
        String[] a2 = getArr(s2);
        
        String prefix;

        if ("*".equals(a1[0])) {
            prefix = a2[0];
        } else if ("*".equals(a2[0])) {
            prefix = a1[0];
        } else {
            if (a1[0].length() > a2[0].length()) {
                if (a1[0].startsWith(a2[0])) {
                    prefix = a1[0];
                } else {
                    return "*";
                }
            } else {
                if (a2[0].startsWith(a1[0])) {
                    prefix = a2[0];
                } else {
                    return "*";
                }
            }
        }

        String suffix;

        if ("*".equals(a1[1])) {
            suffix = a2[1];
        } else if ("*".equals(a2[1])) {
            suffix = a1[1];
        } else {
            if (a1[1].length() > a2[1].length()) {
                if (a1[1].endsWith(a2[1])) {
                    suffix = a1[1];
                } else {
                    return "*";
                }
            } else {
                if (a2[1].endsWith(a1[1])) {
                    suffix = a2[1];
                } else {
                    return "*";
                }
            }
        }

        if (suffix.equals("*") || prefix.equals("*")) return prefix + suffix;
        return prefix + "*" + suffix;
    }

    public static String[] getArr(String s) {
        if (s.charAt(0) == '*') {
            return new String[]{"*", s.substring(1)};
        } else if (s.charAt(s.length() - 1) == '*') {
            return new String[]{s.substring(0, s.length() - 1), "*"};
        } else {
            return s.split("\\*");
        }
    }
}