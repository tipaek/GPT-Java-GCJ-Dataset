import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String inputString = scanner.next();
            StringBuilder outputString = new StringBuilder();
            boolean insideParentheses = false;
            
            for (char character : inputString.toCharArray()) {
                if (character == '1') {
                    if (!insideParentheses) {
                        insideParentheses = true;
                        outputString.append('(');
                    }
                } else {
                    if (insideParentheses) {
                        insideParentheses = false;
                        outputString.append(')');
                    }
                }
                outputString.append(character);
            }
            
            if (insideParentheses) {
                outputString.append(')');
            }
            
            System.out.println("Case #" + caseNumber + ": " + outputString.toString());
        }
        
        scanner.close();
    }
}