import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] s = br.readLine().toCharArray();
        StringBuilder res = new StringBuilder();
        
        int openBrackets = charToInt(s[0]);
        appendChars(res, '(', openBrackets);

        for (int i = 0; i < s.length - 1; ++i) {
            int current = charToInt(s[i]);
            int next = charToInt(s[i + 1]);
            
            res.append(current);
            int difference = Math.abs(current - next);

            if (next > current) {
                appendChars(res, '(', difference);
            } else if (next < current) {
                appendChars(res, ')', difference);
            }
        }

        res.append(charToInt(s[s.length - 1]));

        int closeBrackets = charToInt(s[s.length - 1]);
        appendChars(res, ')', closeBrackets);

        System.out.println(res);
    }

    private static int charToInt(char c) {
        return c - '0';
    }

    private static void appendChars(StringBuilder sb, char ch, int count) {
        for (int i = 0; i < count; i++) {
            sb.append(ch);
        }
    }
}