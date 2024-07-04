import java.util.*;
import java.io.*;
class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tests = Integer.parseInt(in.nextLine()), test = 1;
        while (test <= tests) {
            String line = in.nextLine();
            //System.out.println(test + "  " + line);
            solve(test, line);
            test++;
        }
        in.close();
    }
    public static void solve(int test, String line) {
        StringBuilder sb = new StringBuilder();
        int depth = 0;
        for (char c : line.toCharArray()) {
            int digit = c - '0';
            if (digit > depth) {//more depth
                for (int i = 0; i < digit - depth; i++)
                    sb.append('(');
                append(c);
                depth = digit;
            } else if (digit == depth) {//same depth
                sb.append(c);
            } else {//less depth
                for (int i = 0; i < depth - digit; i++)
                    sb.append(')');
                append(c);
                depth = digit;
            }
        }
        for (int i = 0; i < depth; i++)
            sb.append(')');
        System.out.printf("Case #%d: %s\n", test, sb.toString());
    }
}