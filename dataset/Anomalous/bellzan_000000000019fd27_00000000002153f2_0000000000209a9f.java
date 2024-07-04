import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine().trim());
        
        for (int i = 0; i < T; i++) {
            String S = reader.readLine().trim();
            int maxVal = 0;

            // Find the maximum digit in the string
            for (char c : S.toCharArray()) {
                int currentNum = Character.getNumericValue(c);
                if (currentNum > maxVal) {
                    maxVal = currentNum;
                }
            }

            StringBuilder result = new StringBuilder();
            int openBrackets = 0;

            // Build the new string with parentheses
            for (char c : S.toCharArray()) {
                int currentNum = Character.getNumericValue(c);

                // Add opening brackets if needed
                while (openBrackets < currentNum) {
                    result.append('(');
                    openBrackets++;
                }

                // Add closing brackets if needed
                while (openBrackets > currentNum) {
                    result.append(')');
                    openBrackets--;
                }

                result.append(c);
            }

            // Close any remaining open brackets
            while (openBrackets > 0) {
                result.append(')');
                openBrackets--;
            }

            System.out.println("Case #" + (i + 1) + ": " + result.toString());
        }
        
        reader.close();
    }
}