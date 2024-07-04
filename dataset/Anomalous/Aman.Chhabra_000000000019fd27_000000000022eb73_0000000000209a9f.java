import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        List<String> results = new ArrayList<>();
        
        for (int i = 0; i < testCases; i++) {
            String input = scanner.next();
            results.add(formatOutput(input));
        }
        
        for (int i = 0; i < results.size(); i++) {
            System.out.println("Case #" + (i + 1) + ": " + results.get(i));
        }
    }

    private static String formatOutput(String input) {
        StringBuilder result = new StringBuilder();
        int previousDigit = Character.getNumericValue(input.charAt(0));
        
        result.append("(".repeat(previousDigit)).append(previousDigit);
        
        for (int i = 1; i < input.length(); i++) {
            int currentDigit = Character.getNumericValue(input.charAt(i));
            if (currentDigit > previousDigit) {
                result.append("(".repeat(currentDigit - previousDigit));
            } else if (currentDigit < previousDigit) {
                result.append(")".repeat(previousDigit - currentDigit));
            }
            result.append(currentDigit);
            previousDigit = currentDigit;
        }
        
        result.append(")".repeat(previousDigit));
        
        return result.toString();
    }
}