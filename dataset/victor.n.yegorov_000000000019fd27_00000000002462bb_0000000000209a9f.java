import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    private static String solve(Scanner sc) {
        String s = sc.next();
        StringBuilder sb = new StringBuilder();
        char prev = '0';
        for (int i = 0, n = s.length(); i <= n; ++i) {
            char cur = (i < n) ? s.charAt(i) : '0';
            if (cur != prev) {
                char par = cur > prev ? '(' : ')';
                for (int j = 0, k = Math.abs(cur - prev); j < k; ++j) {
                    sb.append(par);
                }
            }
            if (i < n) {
                sb.append(cur);
            }
            prev = cur;
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