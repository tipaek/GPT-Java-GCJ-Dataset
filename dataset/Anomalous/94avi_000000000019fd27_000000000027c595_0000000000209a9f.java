import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCaseCount = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= testCaseCount; testCase++) {
            String input = br.readLine();
            int[] digits = input.chars().map(Character::getNumericValue).toArray();
            StringBuilder result = new StringBuilder();
            int currentDepth = 0;

            for (int digit : digits) {
                while (currentDepth < digit) {
                    result.append("(");
                    currentDepth++;
                }
                while (currentDepth > digit) {
                    result.append(")");
                    currentDepth--;
                }
                result.append(digit);
            }

            while (currentDepth > 0) {
                result.append(")");
                currentDepth--;
            }

            System.out.println("Case #" + testCase + ": " + result.toString());
        }
    }
}