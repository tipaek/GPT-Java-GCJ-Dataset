import java.util.Collections;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String input = scanner.next();
            StringBuilder output = new StringBuilder();
            
            for (char ch : input.toCharArray()) {
                int repeatCount = Character.getNumericValue(ch);
                String openParentheses = String.join("", Collections.nCopies(repeatCount, "("));
                String closeParentheses = String.join("", Collections.nCopies(repeatCount, ")"));
                output.append(openParentheses).append(ch).append(closeParentheses);
            }
            
            String result = output.toString();
            while (result.contains(")(")) {
                result = result.replace(")(", "");
            }
            
            System.out.printf("Case #%d: %s%n", caseNumber, result);
        }
        
        scanner.close();
    }
}