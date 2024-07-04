import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    private static String solve(Scanner sc) {
        final String s = sc.next();
        final StringBuilder sb = new StringBuilder();
        final int n = s.length();
        int i = 0;
        while (i < n) {
            while ((i < n) && (s.charAt(i) == '0')) {
                sb.append('0');
                ++i;
            }
            if (i < n) {
                sb.append('(');
                while ((i < n) && (s.charAt(i) == '1')) {
                    sb.append('1');
                    ++i;
                }
                sb.append(')');
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= t; ++i) {
            String output = solve(sc);
            sb.append("Case #").append(i).append(": ").append(output).append("\n");
        }

        System.out.print(sb);
    }
}