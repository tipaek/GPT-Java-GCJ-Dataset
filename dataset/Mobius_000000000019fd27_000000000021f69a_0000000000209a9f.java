import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();

        for (int i = 1; i <= t; ++i) {

            String s = in.next();

            System.out.println("Case #" + i + ": " + process(s));
        }
    }

    public static String process(String in) {
        StringBuilder out = new StringBuilder();

        int[] chars = new int[in.length()];

        for (int i = 0; i < in.length(); i++) {
            chars[i] = Character.getNumericValue(in.charAt(i));
        }

        int depth = 0;

        for (int b : chars) {
            while (b > depth) {
                out.append("(");
                depth++;
            }
            while (b < depth) {
                out.append(")");
                depth--;
            }

            out.append(b);
        }

        while (depth > 0) {
            out.append(")");
            depth--;
        }

        return out.toString();
    }
}
