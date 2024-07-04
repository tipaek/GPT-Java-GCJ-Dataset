import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int T = Integer.parseInt(reader.readLine());
            for (int t = 1; t <= T; t++) {
                String s = reader.readLine();
                StringBuilder result = new StringBuilder();
                int openBraces = 0;
                
                for (char ch : s.toCharArray()) {
                    int digit = ch - '0';
                    int difference = digit - openBraces;
                    openBraces = digit;
                    appendBraces(result, difference);
                    result.append(ch);
                }
                
                if (openBraces > 0) {
                    appendBraces(result, -openBraces);
                }

                System.out.printf("Case #%d: %s%n", t, result);
            }
        }
    }

    private static void appendBraces(StringBuilder result, int count) {
        char brace = count > 0 ? '(' : ')';
        for (int i = 0; i < Math.abs(count); i++) {
            result.append(brace);
        }
    }
}