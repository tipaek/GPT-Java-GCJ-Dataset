import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        
        for (int testCase = 1; testCase <= t; testCase++) {
            String input = br.readLine();
            StringBuilder result = new StringBuilder();
            int balance = 0;

            for (char ch : input.toCharArray()) {
                int digit = Character.getNumericValue(ch);

                while (balance < digit) {
                    result.append("(");
                    balance++;
                }
                while (balance > digit) {
                    result.append(")");
                    balance--;
                }
                result.append(digit);
            }

            while (balance > 0) {
                result.append(")");
                balance--;
            }

            System.out.println("Case #" + testCase + ": " + result.toString());
        }
    }
}