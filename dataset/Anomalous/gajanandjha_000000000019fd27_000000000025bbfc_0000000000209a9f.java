import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine().trim());
        
        for (int t = 1; t <= testCases; t++) {
            StringBuilder result = new StringBuilder();
            char[] inputChars = br.readLine().trim().toCharArray();
            int[] digits = new int[inputChars.length];
            
            for (int i = 0; i < inputChars.length; i++) {
                digits[i] = inputChars[i] - '0';
            }

            for (int i = 0; i < digits[0]; i++) {
                result.append("(");
            }
            result.append(digits[0]);

            for (int i = 1; i < digits.length; i++) {
                int diff = digits[i - 1] - digits[i];
                
                if (diff > 0) {
                    for (int j = 0; j < diff; j++) {
                        result.append(")");
                    }
                } else if (diff < 0) {
                    for (int j = 0; j < -diff; j++) {
                        result.append("(");
                    }
                }
                result.append(digits[i]);
            }

            for (int i = 0; i < digits[digits.length - 1]; i++) {
                result.append(")");
            }

            System.out.println("Case #" + t + ": " + result.toString());
        }
    }
}