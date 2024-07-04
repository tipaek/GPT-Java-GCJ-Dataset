import java.util.*;
import java.util.stream.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            String s = scanner.next();
            printCase(t, solve(s));
        }
    }
    
    private static String solve(String s) {
        StringBuilder sb = new StringBuilder();
        int depth = 0;
        for (char c : (s+'0').toCharArray()) {
            int newDepth = c - '0';
            int toOpen = Math.max(0, newDepth - depth);
            int toClose = Math.max(0, depth - newDepth);
            IntStream.range(0, toOpen).forEach(ignored -> sb.append('('));
            IntStream.range(0, toClose).forEach(ignored -> sb.append(')'));
            sb.append(c);
            depth = newDepth;
        }
        return sb.substring(0, sb.length() - 1);
    }
    
    private static void printCase(int t, String s) {
        System.out.println(String.format(
            "Case #%d: %s",
            t + 1,
            s
        ));
    }
}