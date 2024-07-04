import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int caseNumber = 1; caseNumber <= t; caseNumber++) {
            String input = br.readLine();
            int currentDepth = 0;
            StringBuilder result = new StringBuilder();

            for (char ch : input.toCharArray()) {
                int digit = Character.getNumericValue(ch);

                while (currentDepth < digit) {
                    result.append('(');
                    currentDepth++;
                }
                while (currentDepth > digit) {
                    result.append(')');
                    currentDepth--;
                }

                result.append(ch);
            }

            while (currentDepth > 0) {
                result.append(')');
                currentDepth--;
            }

            System.out.println("Case #" + caseNumber + ": " + result.toString());
        }
    }

    private static String generateBraces(int count, char braceType) {
        return String.join("", Collections.nCopies(count, String.valueOf(braceType)));
    }
}