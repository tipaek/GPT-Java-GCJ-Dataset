import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Solution {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCaseCount = Integer.parseInt(br.readLine());
        String openingBrackets = "((((((((((((((((((";
        String closingBrackets = ")))))))))))))))))))))";

        for (int t = 0; t < testCaseCount; t++) {
            String[] inputDigits = br.readLine().split("");
            StringBuilder result = new StringBuilder();
            int[] digits = new int[inputDigits.length];

            for (int i = 0; i < inputDigits.length; i++) {
                digits[i] = Integer.parseInt(inputDigits[i]);
            }

            int currentBrackets = 0;
            for (int i = 0; i < digits.length; i++) {
                if (digits[i] > currentBrackets) {
                    result.append(openingBrackets.substring(0, digits[i] - currentBrackets));
                } else if (digits[i] < currentBrackets) {
                    result.append(closingBrackets.substring(0, currentBrackets - digits[i]));
                }
                result.append(digits[i]);
                currentBrackets = digits[i];
            }

            if (currentBrackets != 0) {
                result.append(closingBrackets.substring(0, currentBrackets));
            }

            bw.write("Case #" + (t + 1) + ": " + result.toString() + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}