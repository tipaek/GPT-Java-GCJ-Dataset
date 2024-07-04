import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @author itsypkin
 * @since 04.04.20
 */
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.

//        System.out.println(t);
        in.nextLine();

        for (int k = 1; k <= t; ++k) {
            String input = in.nextLine();

//            System.out.println("input: " + input);

            System.out.println("Case #" + k + ": " + calculate(input));
        }

    }

    private static String calculate(String input) {

        StringBuilder sb = new StringBuilder();
        int depth = 0;

        for (int i = 0; i < input.length(); i++) {
            int x = input.charAt(i) - '0';

            if (depth > x)  {
                addClose(sb, depth - x);
            } else if (depth < x) {
                addOpen(sb, x - depth);
            }

            depth = x;

            sb.append(x);

        }

        addClose(sb, depth);

        return sb.toString();
    }

    private static void addOpen(StringBuilder sb, int n) {
        for (int i = 0; i < n; i++) {
            sb.append('(');
        }
    }

    private static void addClose(StringBuilder sb, int n) {
        for (int i = 0; i < n; i++) {
            sb.append(')');
        }
    }
}
