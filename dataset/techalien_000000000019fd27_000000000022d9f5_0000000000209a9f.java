import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();
        for (int t = 1; t <= T; ++t) {
            String s = in.next();

            System.out.println(String.format("Case #%d: %s", t, processSegment(s, 0)));
        }
    }

    private static String processSegment(String s, int depth) {
        StringBuilder builder = new StringBuilder();
        int l = 0, r = 0;
        char[] array =  s.toCharArray();

        while (r < array.length) {
            if (array[r] - '0' <= depth) {
                String sub = s.substring(l, r);
                if (l!=r) builder.append(padString(processSegment(sub, depth + 1)));
                l = r;
                while(r<array.length && array[r] - '0' <= depth) {
                    r++;
                }
                builder.append(s, l, r);
                l=r;
            } else {
                r++;
            }
        }
        if (l < r) {
            String sub = s.substring(l, r);
            builder.append(padString(processSegment(sub, depth + 1)));
        }
        return builder.toString();
    }

    private static String padString(String s) {
        return '('+s+')';
    }
}
