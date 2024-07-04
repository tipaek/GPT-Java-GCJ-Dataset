import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            String input = scanner.next();
            StringBuilder result = new StringBuilder();
            
            for (int i = 0; i < input.length(); i++) {
                int currentDigit = Character.getNumericValue(input.charAt(i));
                
                if (currentDigit == 0) {
                    result.append(currentDigit);
                    continue;
                }
                
                if (i == 0) {
                    String[] brackets = generateBrackets(currentDigit);
                    result.append(brackets[0]).append(currentDigit).append(brackets[1]);
                    continue;
                }
                
                int previousDigit = Character.getNumericValue(input.charAt(i - 1));
                if (previousDigit == 0) {
                    String[] brackets = generateBrackets(currentDigit);
                    result.append(brackets[0]).append(currentDigit).append(brackets[1]);
                } else if (currentDigit == previousDigit) {
                    int lastIndex = result.lastIndexOf(String.valueOf(previousDigit));
                    result.insert(lastIndex + 1, currentDigit);
                } else if (currentDigit > previousDigit) {
                    String[] brackets = generateBrackets(currentDigit - previousDigit);
                    int lastIndex = result.lastIndexOf(String.valueOf(previousDigit));
                    result.insert(lastIndex + 1, brackets[0] + currentDigit + brackets[1]);
                } else {
                    result.insert(result.length() - previousDigit, currentDigit);
                }
            }
            
            System.out.println("Case #" + testCase + ": " + result.toString());
        }
    }

    private static String[] generateBrackets(int count) {
        StringBuilder openBrackets = new StringBuilder();
        StringBuilder closeBrackets = new StringBuilder();
        
        for (int i = 0; i < count; i++) {
            openBrackets.append("(");
            closeBrackets.append(")");
        }
        
        return new String[]{openBrackets.toString(), closeBrackets.toString()};
    }
}