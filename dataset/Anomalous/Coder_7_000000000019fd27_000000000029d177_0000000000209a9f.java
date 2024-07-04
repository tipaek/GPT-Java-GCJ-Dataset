import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCases = Integer.parseInt(scanner.nextLine());
        
        for (int caseIndex = 1; caseIndex <= numberOfCases; caseIndex++) {
            String input = scanner.nextLine();
            StringBuilder result = new StringBuilder();
            int previousDigit = Character.getNumericValue(input.charAt(0));
            result.append(generateBrackets(previousDigit, 0, 0));
            
            for (int i = 1; i < input.length(); i++) {
                int currentDigit = Character.getNumericValue(input.charAt(i));
                if (previousDigit < currentDigit) {
                    String brackets = generateBrackets(currentDigit, previousDigit, 0);
                    result = new StringBuilder(mergeStrings(result.toString(), brackets, 0, previousDigit));
                } else if (previousDigit > currentDigit) {
                    String brackets = generateBrackets(currentDigit, 0, 0);
                    result = new StringBuilder(mergeStrings(result.toString(), brackets, currentDigit, 0));
                } else {
                    String brackets = generateBrackets(currentDigit, currentDigit, 0);
                    result = new StringBuilder(mergeStrings(result.toString(), brackets, currentDigit, 0));
                }
                previousDigit = currentDigit;
            }
            
            System.out.println("Case #" + caseIndex + ": " + result);
        }
        
        scanner.close();
    }

    private static String mergeStrings(String result, String next, int first, int second) {
        return result.substring(0, result.length() - first) + next.substring(second);
    }

    private static String generateBrackets(int num, int left, int right) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < num - left; i++) {
            result.append("(");
        }
        result.append(num);
        for (int i = 0; i < num - right; i++) {
            result.append(")");
        }
        return result.toString();
    }
}