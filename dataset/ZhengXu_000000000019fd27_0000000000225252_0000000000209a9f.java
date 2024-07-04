import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(reader.readLine());
        for (int i = 1; i <= T; i++) {
            String S = reader.readLine();
            String result = solution(S);
            System.out.println("Case #" + i + ": " + result);

        }
        reader.close();
    }

    public static String solution(String S) {
        String[] parts = S.split("[0]");
        if (parts.length == 0) {
            return S;
        }
        StringBuilder builder = new StringBuilder();
        int left = 0;
        for (int i = 0; i < S.length(); i++) {
            int digit = S.charAt(i) - '0';
            if (digit == 0) {
                int length = i - left;
                if (length > 0) {
                    String A = F(S.substring(left, i));
                    builder.append(A);
                }
                builder.append("0");
                left = i + 1;
            }
        }
        if (S.charAt(S.length() - 1) != '0') {
            int length = S.length() - left;
            if (length > 0) {
                String A = F(S.substring(left));
                builder.append(A);
            }
        }

        return builder.toString();
    }

    private static String F(String S) {
        int left = 0;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            int n = S.charAt(i) - '0';
            int diff = n - left;
            builder.append(getChar(diff));
            builder.append(S.charAt(i));
            left = diff + left;
        }
        while(left>0) {
            left--;
            builder.append(")");
        }
        return builder.toString();
    }

    private static String getChar(int diff) {
        int abs = Math.abs(diff);
        char c;
        if (diff > 0) {
            c = '(';
        } else {
            c = ')';
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < abs; i++) {
            builder.append(c);
        }
        return builder.toString();
    }

}
