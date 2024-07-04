import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int i = 0; i < testCases; i++) {
            String input = scanner.next();
            StringBuilder output = new StringBuilder();
            int previousDigit = 0;
            
            for (int j = 0; j < input.length(); j++) {
                int currentDigit = Character.getNumericValue(input.charAt(j));
                
                if (currentDigit > previousDigit) {
                    output.append("(".repeat(currentDigit - previousDigit));
                } else if (currentDigit < previousDigit) {
                    output.append(")".repeat(previousDigit - currentDigit));
                }
                
                output.append(currentDigit);
                previousDigit = currentDigit;
            }
            
            output.append(")".repeat(previousDigit));
            System.out.println("Case #" + (i + 1) + ": " + output);
        }
    }
}