import java.util.Scanner;

public class Main {
    
    private static Scanner scanner;
    private static int testCaseNumber = 1;
    
    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();
        
        while (testCases-- > 0) {
            processTestCase();
        }
    }
    
    private static void processTestCase() {
        String input = scanner.nextLine();
        StringBuilder result = new StringBuilder();
        char[] characters = input.toCharArray();
        
        int currentNumber = Character.getNumericValue(characters[0]);
        int openBrackets = currentNumber;
        
        // Append initial open brackets and first digit
        result.append("(".repeat(currentNumber)).append(currentNumber);
        
        for (int i = 1; i < characters.length; i++) {
            int nextNumber = Character.getNumericValue(characters[i]);
            
            if (nextNumber == currentNumber) {
                result.append(nextNumber);
            } else if (nextNumber > currentNumber) {
                // Append additional open brackets
                result.append("(".repeat(nextNumber - currentNumber)).append(nextNumber);
                openBrackets += (nextNumber - currentNumber);
            } else {
                // Append closing brackets
                result.append(")".repeat(currentNumber - nextNumber)).append(nextNumber);
                openBrackets -= (currentNumber - nextNumber);
            }
            
            currentNumber = nextNumber;
        }
        
        // Append remaining closing brackets
        result.append(")".repeat(openBrackets));
        
        System.out.println("Case #" + (testCaseNumber++) + ": " + result.toString());
    }
}