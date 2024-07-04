import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String input = scanner.next();
            StringBuilder result = new StringBuilder();
            int currentBrackets = 0;

            for (char digitChar : input.toCharArray()) {
                int digit = Character.getNumericValue(digitChar);

                while (currentBrackets < digit) {
                    result.append('(');
                    currentBrackets++;
                }
                while (currentBrackets > digit) {
                    result.append(')');
                    currentBrackets--;
                }
                
                result.append(digitChar);
            }
            
            while (currentBrackets > 0) {
                result.append(')');
                currentBrackets--;
            }
            
            System.out.println("Case #" + caseNumber + ": " + result);
        }

        scanner.close();
    }
}