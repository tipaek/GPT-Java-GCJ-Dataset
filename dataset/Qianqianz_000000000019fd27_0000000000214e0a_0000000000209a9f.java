import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        String first = in.nextLine(); // Scanner has functions to read ints, longs, strings, chars, etc.
        int t = Integer.parseInt(first);
        for (int i = 1; i <= t; i++) {
            String line = in.nextLine();
            StringBuffer sb = new StringBuffer();
            char[] char_arry = line.toCharArray();
            int depth = 0;
            for (int j = 0; j < char_arry.length; j++) {
                int current = char_arry[j] - '0';
                if (current == depth) {
                    sb.append(current);
                } else if (current > depth) {
                    int diff = current - depth;
                    for (int k = 0; k < diff; k++) {
                        sb.append('(');
                    }
                    sb.append(current);
                    depth = current;
                } else {
                    for (int k = 0; k < depth - current; k++) {
                        sb.append(')');
                    }
                    sb.append(current);
                    depth = current;
                }
            }
            for (int j = 0; j < depth; j++) {
                sb.append(')');
            }
            System.out.println("Case #" + i + ": " + sb.toString());
        }
    }
}
