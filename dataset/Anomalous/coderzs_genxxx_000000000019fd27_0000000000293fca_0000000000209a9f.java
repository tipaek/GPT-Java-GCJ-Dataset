import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int tt = 0; tt < t; tt++) {
            String s = br.readLine();
            int balance = 0;
            StringBuilder result = new StringBuilder();
            for (char ch : s.toCharArray()) {
                int digit = ch - '0';
                if (digit > balance) {
                    result.append(repeatChar('(', digit - balance));
                } else if (digit < balance) {
                    result.append(repeatChar(')', balance - digit));
                }
                result.append(ch);
                balance = digit;
            }
            if (balance > 0) {
                result.append(repeatChar(')', balance));
            }
            System.out.println(result.toString());
        }
    }

    private static String repeatChar(char ch, int count) {
        return String.join("", Collections.nCopies(count, String.valueOf(ch)));
    }
}