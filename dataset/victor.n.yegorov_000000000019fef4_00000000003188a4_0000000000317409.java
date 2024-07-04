import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
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

    private static String solve(Scanner sc) {
        int x = sc.nextInt(), y = sc.nextInt();
        String s = sc.next();
        if (test(x, y, 0)) {
            return "0";
        }

        for (int i = 0, n = s.length(); i < n; ) {
            switch (s.charAt(i)) {
                case 'N':
                    ++y;
                    break;
                case 'S':
                    --y;
                    break;
                case 'E':
                    ++x;
                    break;
                case 'W':
                    --x;
                    break;
            }
            if (test(x, y, ++i)) {
                return String.valueOf(i);
            }
        }
        return "IMPOSSIBLE";
    }

    private static boolean test(int x, int y, int t) {
        return Math.abs(x) + Math.abs(y) <= t;
    }
}