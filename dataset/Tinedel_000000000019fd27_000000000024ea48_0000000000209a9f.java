import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        in.nextLine();
        for (int i = 1; i <= t; ++i) {
            String n = in.nextLine();
            String res = solve(n);
            System.out.printf("Case #%d: %s%n", i, res);
        }
    }

    static String solve(String n) {
        char currentOpen = '0';
        StringBuilder res = new StringBuilder();
        int length = n.length();
        for (int i = 0; i < length; i++) {
            char c = n.charAt(i);
            if ('0' <= c && c <= '9') {
                // if there's less need to open more
                while (currentOpen < c) {
                    res.append('(');
                    currentOpen++;
                }
                // if there's more close some
                while (currentOpen > c) {
                    res.append(')');
                    currentOpen--;
                }
                res.append(c);
            } else {
                res.append(c);
            }
        }
        while (currentOpen > '0') {
            res.append(')');
            currentOpen--;
        }
        return res.toString();
    }
}