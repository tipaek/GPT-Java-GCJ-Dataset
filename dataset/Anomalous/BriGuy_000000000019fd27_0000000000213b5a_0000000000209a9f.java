import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        int testCases = Integer.parseInt(reader.readLine());
        
        for (int t = 1; t <= testCases; t++) {
            String input = reader.readLine();
            StringBuilder result = new StringBuilder();
            int previousDigit = 0;
            
            for (int i = 0; i < input.length(); i++) {
                int currentDigit = Character.getNumericValue(input.charAt(i));
                
                if (previousDigit < currentDigit) {
                    result.append("(".repeat(currentDigit - previousDigit));
                } else if (previousDigit > currentDigit) {
                    result.append(")".repeat(previousDigit - currentDigit));
                }
                
                result.append(currentDigit);
                previousDigit = currentDigit;
            }
            
            result.append(")".repeat(previousDigit));
            
            System.out.println("Case #" + t + ": " + result);
        }
    }
}