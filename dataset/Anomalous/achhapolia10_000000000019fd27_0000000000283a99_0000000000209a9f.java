import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String inputString = scanner.next();
            StringBuilder resultBuilder = new StringBuilder();
            
            int index = 0;
            while (index < inputString.length()) {
                char currentChar = inputString.charAt(index);
                StringBuilder tempBuilder = new StringBuilder();
                
                // Collect all consecutive characters that are the same
                while (index < inputString.length() && inputString.charAt(index) == currentChar) {
                    tempBuilder.append(currentChar);
                    index++;
                }
                
                int repeatCount = Character.getNumericValue(currentChar);
                String tempString = tempBuilder.toString();
                
                // Wrap the collected characters in parentheses repeatCount times
                for (int repeat = 0; repeat < repeatCount; repeat++) {
                    tempString = "(" + tempString + ")";
                }
                
                resultBuilder.append(tempString);
            }
            
            System.out.printf("Case #%d: %s\n", caseNumber, resultBuilder);
        }
        
        scanner.close();
    }
}