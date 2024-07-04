import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        processNestingDepth();
    }

    public static void processNestingDepth() {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        int testCases = scanner.nextInt();
        scanner.nextLine();
        List<String> results = new ArrayList<>();
        
        for (int i = 0; i < testCases; i++) {
            String inputLine = scanner.nextLine();
            StringBuilder output = new StringBuilder();
            
            int previousDigit = Character.getNumericValue(inputLine.charAt(0));
            output.append(generateBrackets(previousDigit, true)).append(previousDigit);
            
            for (int j = 1; j < inputLine.length(); j++) {
                int currentDigit = Character.getNumericValue(inputLine.charAt(j));
                int difference = previousDigit - currentDigit;
                
                if (difference < 0) {
                    output.append(generateBrackets(-difference, true)).append(currentDigit);
                } else if (difference > 0) {
                    output.append(generateBrackets(difference, false)).append(currentDigit);
                } else {
                    output.append(currentDigit);
                }
                
                previousDigit = currentDigit;
            }
            
            output.append(generateBrackets(previousDigit, false));
            results.add(output.toString());
        }
        
        for (int i = 0; i < testCases; i++) {
            System.out.println("Case #" + (i + 1) + ": " + results.get(i));
        }
    }

    private static String generateBrackets(int count, boolean open) {
        char bracket = open ? '(' : ')';
        StringBuilder brackets = new StringBuilder();
        for (int i = 0; i < count; i++) {
            brackets.append(bracket);
        }
        return brackets.toString();
    }
}