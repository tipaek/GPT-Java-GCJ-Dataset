import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = sc.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int t = 1; t <= T; ++t) {
            System.out.printf("Case #%d: ", t);
            char[] s = sc.next().toCharArray();
            int depth = 0;
            for (char c : s) {
                int n = (int) c - (int) '0';
                while (depth < n) {
                    System.out.print('(');
                    depth++;
                }
                while (depth > n) {
                    System.out.print(')');
                    depth--;
                }
                System.out.print(n);
            }
            while (depth-- > 0) {
                System.out.print(')');
            }
            System.out.println();
        }
    }
}
