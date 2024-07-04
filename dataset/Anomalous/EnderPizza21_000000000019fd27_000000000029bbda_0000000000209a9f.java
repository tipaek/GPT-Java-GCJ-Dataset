import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCaseCount = Integer.parseInt(br.readLine());
        
        for (int caseNumber = 1; caseNumber <= testCaseCount; caseNumber++) {
            String nestedString = createNestedString(br.readLine());
            System.out.println("Case #" + caseNumber + ": " + nestedString);
        }
    }

    public static String createNestedString(String input) {
        int openParentheses = 0;
        StringBuilder result = new StringBuilder();
        
        for (char ch : input.toCharArray()) {
            int currentValue = Character.getNumericValue(ch);
            
            while (currentValue > openParentheses) {
                result.append("(");
                openParentheses++;
            }
            
            while (currentValue < openParentheses) {
                result.append(")");
                openParentheses--;
            }
            
            result.append(currentValue);
        }
        
        while (openParentheses > 0) {
            result.append(")");
            openParentheses--;
        }
        
        return result.toString();
    }
}