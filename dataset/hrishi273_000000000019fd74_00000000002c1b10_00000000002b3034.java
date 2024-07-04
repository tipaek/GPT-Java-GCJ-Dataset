import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static boolean matchFirst(String s, StringBuilder result) {
        boolean match = true;

        String sub = s.substring(1);
        //System.out.println("first: " + sub + " " + result);

        if (result.length() < sub.length()) {
            match = (sub.indexOf(result.toString()) != -1);
            if (!match) return match;
        } else if (!sub.equals(result.substring(result.length() - sub.length()))) {
            //System.out.println(result.substring(result.length() - sub.length()));
            match = false;
            return match;
        }

        if (result.indexOf(sub) != -1) {
            return match;
        } else if (sub.indexOf(result.toString()) != -1) {
            result.replace(0, result.length(), sub);
        } else {
            result.append(sub);
        }
        return match;
    }

    public static boolean matchLast(String s, StringBuilder result) {
        boolean match = true;

        String sub = s.substring(0, s.length() - 1);
        //System.out.println("last: " + sub + " " + result);
        if (result.length() < sub.length()) {
            match = (sub.indexOf(result.toString()) != -1);
            if (!match) return match;
        } else if (!sub.equals(result.substring(0, sub.length()))) {
            //System.out.println(result.substring(0, sub.length()));
            match = false;
            return match;
        }

        if (result.indexOf(sub) != -1) {
            return match;
        } else if (sub.indexOf(result.toString()) != -1) {
            result.replace(0, result.length(), sub);
        } else {
            result.append(sub);
        }

        return match;
    }

    public static void main(String[] args) {
        int t, n;
        Scanner sc = new Scanner(System.in);

        t = sc.nextInt();
        for (int tc = 1; tc <= t; tc++) {
            n = sc.nextInt();

            String[] patterns = new String[n];
            for (int i = 0; i < n; i++)
                patterns[i] = sc.next();

            Arrays.sort(patterns, (String a, String b) -> b.compareTo(a));

            boolean match = true;
            StringBuilder resultFirst = new StringBuilder();
            StringBuilder resultLast = new StringBuilder();
            for (String s : patterns) {
                //System.out.println("Pattern: " + s + " Result: " + result + " " + result.length());

                if (s.equals("*"))
                    continue;

                if (s.charAt(0) == '*') {
                    match = matchFirst(s, resultFirst);
                    if (!match) break;
                } else if (s.charAt(s.length() - 1) == '*') {
                    match = matchLast(s, resultLast);
                    if (!match) break;
                } else {
                    int index = s.indexOf('*');
                    String left = s.substring(0, index + 1);
                    String right = s.substring(index);

                    boolean matchleft = matchLast(left, resultLast);
                    boolean matchright = matchFirst(right, resultFirst);
                    //System.out.println("index: " + index + " " + left + " " + right + " " + matchleft + " " + matchright);

                    match = matchleft && matchright;
                    if (!match) break;
                }
            }

            System.out.print("Case #" + tc + ": ");
            if (!match) {
                System.out.println("*");
            } else {
                String r1 = resultLast.toString();
                String r2 = resultFirst.toString();
                if (r1.equals(r2))
                    System.out.println(r1);
                else
                    System.out.println(r1 + r2);
            }
        }
    }
}
