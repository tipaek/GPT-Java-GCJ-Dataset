import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    private static final char LEFT = '(';
    private static final char RIGHT = ')';
    private static final char ZERO = '0';
    private static final String EMPTY = "";

    public static void main(String...args) {
        final Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final StringBuilder out = new StringBuilder();
        final int testCases = scanner.nextInt();
        for (int t=1; t<=testCases; t++) {
            final String line = scanner.next();
            char[] chars = line.toCharArray();
            String sol = solve(chars);
           out.append("Case #").append(t).append(": ")
                .append(sol).append(' ')
                .append('\n');
        }
        System.out.print(out.toString());
    }

    private static String solve(char[] chars) {
        char[] copy = chars.clone();
        String raw = raw(copy);
        char[] rawChars = raw.toCharArray();
        StringBuilder sb = new StringBuilder();
        int cur = 0;
        for (int i=0; i<rawChars.length; i++)  {
            if (rawChars[i] != LEFT && rawChars[i] != RIGHT) {
                sb.append(chars[cur++]);
            } else {
                sb.append(rawChars[i]);
            }
        }
        return sb.toString();
    }

    private static String raw(char[] chars) {
        return raw(chars, 0, chars.length, chars.length);
    }

    private static String raw(char[] chars, int from, int to, int length) {
        if (from >= length || from >= to)
            return EMPTY;
        if (chars[from] == ZERO)
            return ZERO + raw(chars, from+1, to, length);
        for (int i=from; i<to; i++) {
            if (chars[i] == ZERO) {
                return LEFT + raw(chars, from, i, length) + RIGHT + raw(chars, i, to, length);
            } else {
                chars[i] = (char) (Integer.valueOf(chars[i]) - 1);
            }
        }
        return LEFT + raw(chars, from, to, length) + RIGHT;
    }

}