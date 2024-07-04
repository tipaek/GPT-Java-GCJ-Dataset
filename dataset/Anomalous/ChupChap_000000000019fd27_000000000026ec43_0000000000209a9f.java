import java.util.*;
import java.io.*;

public class Solution {
    public static String formatString(String S) {
        StringBuilder result = new StringBuilder();
        S = S + "0"; // Append '0' to handle the end case
        int previousDigit = S.charAt(0) - '0';
        
        // Add initial opening brackets
        for (int k = 0; k < previousDigit; k++) {
            result.append('(');
        }
        result.append(S.charAt(0));
        
        // Process the rest of the string
        for (int i = 1; i < S.length(); i++) {
            int currentDigit = S.charAt(i) - '0';
            int difference = currentDigit - previousDigit;
            
            if (difference < 0) {
                // Add closing brackets
                for (int l = 0; l < -difference; l++) {
                    result.append(')');
                }
            } else {
                // Add opening brackets
                for (int l = 0; l < difference; l++) {
                    result.append('(');
                }
            }
            result.append(S.charAt(i));
            previousDigit = currentDigit;
        }
        
        // Remove the trailing '0' and its corresponding bracket
        result.setLength(result.length() - 2);

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt(); // Number of test cases
        for (int i = 1; i <= T; ++i) {
            String S = in.next();
            String formattedString = formatString(S);
            System.out.println("Case #" + i + ": " + formattedString);
        }
    }
}