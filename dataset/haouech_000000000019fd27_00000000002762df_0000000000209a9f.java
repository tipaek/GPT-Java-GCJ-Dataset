import java.util.*;

class Solution {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String argv[]) {
        int t = scanner.nextInt();
        scanner.nextLine();
        for (int tc=1; tc <= t; tc++) {
            String input = scanner.nextLine();
            String result = solve(input);

            System.out.println("Case #" + tc + ": " + result);
        }
    }

    private static String solve(String s) {
        StringBuilder sb = new StringBuilder();
        int last = 0;
        s = s + '0';
        for (char c: s.toCharArray()) {
            int v = (c - '0');
            if (v < last) {
                int d = last - v;
                while(d-- > 0) {
                    sb.append(')');
                }

            } else if (v > last) {
                int d = v - last;
                while(d-- > 0) {
                    sb.append('(');
                }
            }
            sb.append(c);
            last = v;
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
}