import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int i = 0; i < testCases; i++) {
            String input = scanner.next();
            StringBuilder output = new StringBuilder();
            int previousDigit = 0;
            
            for (int j = 0; j < input.length(); j++) {
                int currentDigit = Character.getNumericValue(input.charAt(j));
                
                if (previousDigit < currentDigit) {
                    appendCharacters(output, '(', currentDigit - previousDigit);
                } else if (previousDigit > currentDigit) {
                    appendCharacters(output, ')', previousDigit - currentDigit);
                }
                
                output.append(currentDigit);
                previousDigit = currentDigit;
            }
            
            appendCharacters(output, ')', previousDigit);
            System.out.println("Case #" + (i + 1) + ": " + output.toString());
        }
    }

    private static void appendCharacters(StringBuilder builder, char character, int count) {
        for (int i = 0; i < count; i++) {
            builder.append(character);
        }
    }
}