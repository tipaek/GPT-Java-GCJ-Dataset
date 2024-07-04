import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        int testCases = Integer.parseInt(reader.readLine());
        
        for (int i = 0; i < testCases; i++) {
            String input = reader.readLine();
            StringBuilder result = new StringBuilder();
            int openParentheses = 0;
            
            for (int j = 0; j < input.length(); j++) {
                int currentDigit = Character.getNumericValue(input.charAt(j));
                int previousDigit = j > 0 ? Character.getNumericValue(input.charAt(j - 1)) : 0;
                
                if (currentDigit > previousDigit) {
                    for (int k = 0; k < currentDigit - previousDigit; k++) {
                        result.append("(");
                        openParentheses++;
                    }
                } else if (currentDigit < previousDigit) {
                    for (int k = 0; k < previousDigit - currentDigit; k++) {
                        result.append(")");
                        openParentheses--;
                    }
                }
                
                result.append(currentDigit);
            }
            
            for (int j = 0; j < openParentheses; j++) {
                result.append(")");
            }
            
            System.out.println("Case #" + (i + 1) + ": " + result);
        }
    }
}