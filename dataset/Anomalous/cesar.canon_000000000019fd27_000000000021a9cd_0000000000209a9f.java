import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        int testCases = Integer.parseInt(reader.readLine());
        
        for (int i = 0; i < testCases; i++) {
            String[] digits = reader.readLine().split("");
            Stack<String> stack = new Stack<>();
            StringBuilder result = new StringBuilder();
            int openParentheses = 0;
            
            stack.push(digits[0]);
            int firstDigit = Integer.parseInt(digits[0]);
            for (int k = 0; k < firstDigit; k++) result.append("(");
            result.append(digits[0]);
            openParentheses = firstDigit;
            
            for (int j = 1; j < digits.length; j++) {
                stack.push(digits[j]);
                int currentDigit = Integer.parseInt(digits[j]);
                int previousDigit = Integer.parseInt(digits[j - 1]);
                
                if (currentDigit > previousDigit) {
                    int diff = currentDigit - previousDigit;
                    for (int k = 0; k < diff; k++) {
                        result.append("(");
                        openParentheses++;
                    }
                    result.append(digits[j]);
                } else if (currentDigit < previousDigit) {
                    stack.pop();
                    int diff = previousDigit - currentDigit;
                    for (int k = 0; k < diff; k++) {
                        result.append(")");
                        openParentheses--;
                    }
                    result.append(digits[j]);
                } else {
                    result.append(digits[j]);
                }
            }
            
            for (int j = 0; j < openParentheses; j++) result.append(")");
            
            System.out.println(result);
        }
    }
}