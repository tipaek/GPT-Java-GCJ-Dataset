import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String opens = "((((((((((";
        String closes = "))))))))))";
        StringBuilder result;
        int T = Integer.parseInt(in.nextLine());
        for (int t = 1; t <= T; t++) {
            char[] digits = in.nextLine().toCharArray();
            int L = digits.length;
            result = new StringBuilder();
            int prev = 0;
            for (int i = 0; i < L; i++) {
                int d = digits[i] - '0';
                result.append(closes.substring(0, Math.max(0, prev - d)));
                result.append(opens.substring(0, Math.max(0, d - prev)));
                result.append(d);
                if (i == L - 1)
                    result.append(closes.substring(0, d));
                prev = d;
            }
            System.out.println("Case #" + t + ": " + result);
        }
    }
}