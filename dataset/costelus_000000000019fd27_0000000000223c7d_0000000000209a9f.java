import java.util.Scanner;

public class Solution {
    public void solve() {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        String[] result = new String[T];
        for (int i = 0; i < T; i++) {
            String s = sc.nextLine();
            result[i] = minPadding(s);
        }
        for (int i = 0; i < T; i++)
            System.out.println("Case #" + (i + 1) + ": " + result[i]);
    }

    public String minPadding(String s) {
        int nOpen = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int digit = s.charAt(i) - '0';
            if (digit < nOpen) {
                for (int j = 0; j < nOpen - digit; j++)
                    sb.append(")");
                nOpen = digit;
            }
            if (digit > nOpen) {
                for (int j = 0; j < digit - nOpen; j++)
                    sb.append("(");
                nOpen = digit;
            }
            sb.append(digit);
        }
        for (int j = 0; j < nOpen; j++)
            sb.append(")");
        return sb.toString();
    }

    public static void main(String[] args) {
        new Solution().solve();
    }
}