import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i11 = 0; i11 < t; i11++) {
            String s = in.next();
            StringBuilder ans = new StringBuilder();
            Stack<Character> stack = new Stack<>();
            int depth = 0;
            for (int i = 0; i < s.length(); i++) {
                int num = s.charAt(i)-'0';
                ans.append(numOfBrackets(num-depth));
                ans.append(num);
                depth = num;
            }
            ans.append(numOfBrackets(-depth));
            System.out.printf("Case %d: %s\n", i11+1, ans.toString());
        }
    }
    private static String numOfBrackets(int i) {
        StringBuilder builder = new StringBuilder(Math.abs(i));
        for (int j = 0; j < Math.abs(i); j++) {
            builder.append(i<0?')':'(');
        }
        return builder.toString();
    }
}
