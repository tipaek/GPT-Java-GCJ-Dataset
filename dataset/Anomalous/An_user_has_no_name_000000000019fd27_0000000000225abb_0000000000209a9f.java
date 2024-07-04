import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        int caseNumber = 1;

        while (t-- > 0) {
            char[] inputChars = in.readLine().toCharArray();
            StringBuilder result = new StringBuilder();
            int currentDepth = 0;

            for (int i = 0; i < inputChars.length; i++) {
                int digit = inputChars[i] - '0';

                while (currentDepth < digit) {
                    result.append('(');
                    currentDepth++;
                }
                while (currentDepth > digit) {
                    result.append(')');
                    currentDepth--;
                }

                result.append(digit);
            }

            while (currentDepth > 0) {
                result.append(')');
                currentDepth--;
            }

            System.out.println("Case #" + caseNumber++ + ": " + result.toString());
        }
    }
}