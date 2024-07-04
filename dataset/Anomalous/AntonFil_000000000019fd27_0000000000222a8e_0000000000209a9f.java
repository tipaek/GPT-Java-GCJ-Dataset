import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfTests = scanner.nextInt();
        scanner.nextLine();

        for (int testIndex = 1; testIndex <= numberOfTests; testIndex++) {
            String inputString = scanner.nextLine();
            System.out.println("Case #" + testIndex + ": " + transformString(inputString));
        }

        scanner.close();
    }

    private static String transformString(String input) {
        StringBuilder resultBuilder = new StringBuilder();
        int currentDepth = input.charAt(0) - '0';
        
        appendCharacters(resultBuilder, '(', currentDepth);
        resultBuilder.append(input.charAt(0));
        
        for (int index = 1; index < input.length(); index++) {
            int nextDepth = input.charAt(index) - '0';
            
            if (nextDepth > currentDepth) {
                appendCharacters(resultBuilder, '(', nextDepth - currentDepth);
            } else if (nextDepth < currentDepth) {
                appendCharacters(resultBuilder, ')', currentDepth - nextDepth);
            }
            
            currentDepth = nextDepth;
            resultBuilder.append(input.charAt(index));
        }
        
        appendCharacters(resultBuilder, ')', currentDepth);
        
        return resultBuilder.toString();
    }

    private static void appendCharacters(StringBuilder builder, char character, int count) {
        for (int i = 0; i < count; i++) {
            builder.append(character);
        }
    }
}