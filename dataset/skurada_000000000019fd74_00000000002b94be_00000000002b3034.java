import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();

        StringBuilder sb = new StringBuilder();

        for (int loop=1; loop<=T; loop++) {
            int n = in.nextInt();

            String[] strings = new String[n];

            for (int i = 0; i < n; i++) {
                String s = in.next();
                strings[i] = s;
            }

            String result = solve(strings, n);

            sb.append("Case #");
            sb.append(loop);
            sb.append(": ");
            sb.append(result);
            sb.append('\n');
        }

        System.out.println(sb.toString());
    }

    private static String solve(String[] strings, int n) {
        String[] val = new String[2];
        val[0] = "";
        val[1] = "";

        for (int i = 0; i < n; i++) {
            String s = strings[i];

            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                if (c == '*') {
                    String part1 = s.substring(0, j);

                    String part2 = "";

                    if (j+1 < s.length()) part2 = s.substring(j+1);

                    // now need to figure out the integration into the val array
                    if (val[0].isEmpty()) {
                        val[0] = part1;
                    }

                    else {
                        int shorterLength = Math.min(val[0].length(), part1.length());
                        if (val[0].substring(0, shorterLength).equals(part1.substring(0, shorterLength))) {
                            // the two strings fit each other
                            // lets integrate
                            if (shorterLength == val[0].length()) val[0] = part1;
                        }
                        else {
                            return "*";
                        }
                    }

                    if (val[1].isEmpty()) {
                        val[1] = part2;
                    }

                    else {
                        int shorterLength = Math.min(val[1].length(), part2.length());
                        if (val[1].substring(val[1].length() - shorterLength).equals(part2.substring(part2.length() - shorterLength))) {
                            // the two strings fit each other
                            // lets integrate
                            if (shorterLength == val[1].length()) val[1] = part2;
                        }
                        else {
                            return "*";
                        }
                    }
                    break;
                }
            }
        }

        return val[0] + val[1];
    }
}


