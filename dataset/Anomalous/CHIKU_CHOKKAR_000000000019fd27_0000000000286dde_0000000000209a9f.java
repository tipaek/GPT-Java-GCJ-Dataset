import java.util.Scanner;

public class Main {
    
    private static Scanner scanner;
    private static int caseNumber = 1;
    
    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();
        
        while (testCases-- > 0) {
            processTestCase();
        }
    }
    
    private static void processTestCase() {
        String inputString = scanner.nextLine();
        StringBuilder result = new StringBuilder();
        char[] characters = inputString.toCharArray();
        
        int currentNumber = Character.getNumericValue(characters[0]);
        int openBrackets = currentNumber;
        
        // Append initial open brackets and the first number
        result.append("(".repeat(currentNumber)).append(currentNumber);
        
        for (int i = 1; i < characters.length; i++) {
            int nextNumber = Character.getNumericValue(characters[i]);
            
            if (nextNumber > currentNumber) {
                result.append("(".repeat(nextNumber - currentNumber));
                openBrackets += nextNumber - currentNumber;
            } else if (nextNumber < currentNumber) {
                result.append(")".repeat(currentNumber - nextNumber));
                openBrackets -= currentNumber - nextNumber;
            }
            
            result.append(nextNumber);
            currentNumber = nextNumber;
        }
        
        // Close any remaining open brackets
        result.append(")".repeat(openBrackets));
        
        System.out.println("Case #" + (caseNumber++) + ": " + result);
    }
}