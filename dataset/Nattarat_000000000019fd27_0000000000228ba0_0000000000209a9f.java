import java.util.Scanner;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        String[] str = new String[T];
        for(int t=0; t<T; t++) {
            str[t] = in.next();
        }

        for(int i=0; i<T; i++) {
            output(str[i], i);
        }
    }

    private static void output(String s, int testCaseNo) {
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        int open = 0;
        for(int c=0; c<chars.length; c++) {
            int value = chars[c] - '0';
            int top = c == 0 ? 0 : chars[c-1] - '0';
            if(value > top) {
                int diff = value - open;
                for(int i=0; i<diff; i++) {
                    sb.append("(");
                }
                open += diff;
                sb.append(value);
            } else if(value < top) {
                int diff = open - value;
                for(int i=0; i<diff; i++) {
                    sb.append(")");
                    open--;
                }
                sb.append(value);
            } else {
                sb.append(value);
            }
        }

        while (open > 0) {
            sb.append(")");
            open--;
        }
        System.out.println("Case #" + (testCaseNo+1) + ": " + sb.toString());
    }
}
