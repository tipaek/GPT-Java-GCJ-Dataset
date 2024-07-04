import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    public void processRawInput(InputStream is) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        int caseNumber = Integer.parseInt(reader.readLine());
        for (int i = 1; i <= caseNumber; i++) {
            System.out.println("Case #" + i + ": " + process(reader.readLine()));
        }

    }

    public String process(String input) {
        StringBuilder out = new StringBuilder();
        int opened = 0;
        int prev = 0;
        for (int i = 0; i < input.length(); i++) {
            int digit = Integer.parseInt("" + input.charAt(i));
            int diff = digit - prev;
            opened += diff;
            if (diff > 0) {
                for (int r = 0; r < diff; r++) {
                    out.append('(');
                }
            } else if (diff < 0) {
                for (int r = 0; r > diff; r--) {
                    out.append(')');
                }
            }
            out.append(digit);
            prev = digit;
        }
        for (int i = 0; i < opened; i++) {
            out.append(')');
        }
        return out.toString();
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        new Solution().processRawInput(System.in);
    }
}
