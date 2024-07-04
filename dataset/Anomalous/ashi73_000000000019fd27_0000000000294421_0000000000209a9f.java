import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int caseIndex = 1; caseIndex <= testCases; caseIndex++) {
            String input = scanner.next();
            StringBuilder output = new StringBuilder();
            int openBrackets = 0;
            
            for (int i = 0; i < input.length(); i++) {
                int currentDigit = Character.getNumericValue(input.charAt(i));
                
                while (openBrackets < currentDigit) {
                    output.append('(');
                    openBrackets++;
                }
                
                while (openBrackets > currentDigit) {
                    output.append(')');
                    openBrackets--;
                }
                
                output.append(currentDigit);
            }
            
            while (openBrackets > 0) {
                output.append(')');
                openBrackets--;
            }
            
            System.out.println("Case #" + caseIndex + ": " + output.toString());
        }
    }
}