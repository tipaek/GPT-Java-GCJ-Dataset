import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());
        
        for (int i = 1; i <= testCases; i++) {
            String inputStr = reader.readLine();
            String result = processString(inputStr);
            System.out.println("Case #" + i + ": " + result);
        }
    }

    private static String processString(String input) {
        StringBuilder output = new StringBuilder();
        int prevDigit = 0;
        
        for (char ch : input.toCharArray()) {
            int currentDigit = Character.getNumericValue(ch);
            if (currentDigit > prevDigit) {
                output.append("(".repeat(currentDigit - prevDigit));
            } else if (currentDigit < prevDigit) {
                output.append(")".repeat(prevDigit - currentDigit));
            }
            output.append(currentDigit);
            prevDigit = currentDigit;
        }
        
        output.append(")".repeat(prevDigit));
        return output.toString();
    }
}