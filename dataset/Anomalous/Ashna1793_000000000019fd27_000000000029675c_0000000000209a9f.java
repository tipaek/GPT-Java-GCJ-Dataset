import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    public static String getNestedString(String S) {
        StringBuilder result = new StringBuilder();
        S = S + "0";
        int previousDigit = 0;
        
        for (int i = 0; i < S.length(); i++) {
            int currentDigit = Character.getNumericValue(S.charAt(i));
            int bracketDifference = Math.abs(currentDigit - previousDigit);
            char bracketType = currentDigit > previousDigit ? '(' : ')';
            
            for (int j = 0; j < bracketDifference; j++) {
                result.append(bracketType);
            }
            
            result.append(currentDigit);
            previousDigit = currentDigit;
        }
        
        // Remove the trailing '0' added at the end
        result.deleteCharAt(result.length() - 1);
        return result.toString();
    }

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int testCases = Integer.parseInt(reader.readLine());
            
            for (int i = 1; i <= testCases; i++) {
                String inputString = reader.readLine();
                String nestedString = getNestedString(inputString);
                System.out.println("Case #" + i + ": " + nestedString);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}