import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = in.nextInt();
        in.nextLine();
        for (int cs = 0; cs < cases; ++cs) {
            String s = in.nextLine();
            String ans = bracks(s);
            System.out.println("Case #" + (cs + 1) + ": " + ans);
        }


    }

    private static String bracks(String s) {
        int depth = 0;
        StringBuilder ans = new StringBuilder();
        for (char ch: s.toCharArray()) {
            int digit = ch - '0';
            int slop = digit - depth;
            if (slop > 0) {
                depth = digit;
                ans.append(repeat('(', slop));
            } else if (slop < 0) {
                depth = digit;
                ans.append(repeat(')', -slop));
            }
            ans.append(digit);
        }
        if (depth > 0) {
            ans.append(repeat(')', depth));
        }

        return ans.toString();
    }

    private static String repeat(char ch, int times) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < times; ++i) {
            builder.append(ch);
        }
        return builder.toString();
    }

}
