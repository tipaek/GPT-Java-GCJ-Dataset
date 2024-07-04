import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String input = reader.readLine();
            StringBuilder result = new StringBuilder();
            
            for (int i = 0; i < input.length(); i++) {
                char digitChar = input.charAt(i);
                int digit = Character.getNumericValue(digitChar);
                
                result.append("(".repeat(digit));
                result.append(digitChar);
                result.append(")".repeat(digit));
            }
            
            String finalResult = result.toString().replace(")(", "");
            System.out.println("Case #" + caseNumber + ": " + finalResult);
        }
    }
}