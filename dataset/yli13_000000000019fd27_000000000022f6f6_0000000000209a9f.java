import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int testCase = Integer.parseInt(input.nextLine());
        for (int i = 1; i <= testCase; i++) {
            solve(input, i);
        }
    }

    private static void solve(Scanner scanner, int tc) {
        String s = scanner.nextLine();
        char[] c = s.toCharArray();
        int n = c.length;

        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = 0; i < n; i++) {
            int cur = c[i] - '0';
            if (i == 0) {
                sb.append("(".repeat(Math.max(0, cur)));
                count += cur;
            }
            sb.append(cur);
            if (i + 1 < n) {
                int next = c[i + 1] - '0';
                int diff = cur - next;
                if (diff > 0) {
                    sb.append(")".repeat(Math.max(0, diff)));
                    count -= diff;
                } else if (diff < 0) {
                    diff *= (-1);
                    sb.append("(".repeat(Math.max(0, diff)));
                    count += diff;
                }
            }
        }
        if (count > 0) {
            sb.append(")".repeat(Math.max(0, count)));
        }
        System.out.println("Case #" + tc +": " + sb.toString());
    }
}