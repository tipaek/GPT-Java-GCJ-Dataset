import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            String str = in.next();
            String result = solve(str);
            System.out.println("Case #" + i + ": " + result);
        }
    }

    private static String solve(String str) {
        int[] arr = new int[str.length()];
        for (int i = 0; i < str.length(); ++i) {
            arr[i] = str.charAt(i) - '0';
        }
        Deque<Integer> stack = new LinkedList<>();
        int cur = 0;
        String resStr = "";
        for (int i = 0; i < arr.length; ++i) {
            cur = arr[i];
            int last = 0;
            if (!stack.isEmpty()) {
                last = stack.peek();
            }
            int diff = cur - last;
            if (diff < 0) {
                for (int j = 0; j < Math.abs(diff); ++j) {
                    resStr += ")";
                }
                stack.pop();
                stack.push(cur);
            } else if (diff > 0) {
                for (int j = 0; j < diff; ++j) {
                    resStr += "(";
                }
                stack.push(cur);
            }
            resStr += String.valueOf(cur);
        }
        if (!stack.isEmpty()) {
            int last = stack.pop();
            for (int i = 0; i < last; ++i) {
                resStr += ")";
            }
        }
        return resStr;
    }
}
