import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= numberOfCases; caseNumber++) {
            String input = scanner.next();
            StringBuilder result = new StringBuilder();
            
            for (int i = 0; i < input.length(); i++) {
                char currentChar = input.charAt(i);
                if (currentChar == '1') {
                    result.append('(').append(currentChar).append(')');
                } else {
                    result.append(currentChar);
                }
            }

            String resultString = result.toString();
            result = new StringBuilder();

            for (int j = 0; j < resultString.length() - 1; j++) {
                if (!(resultString.charAt(j) == '(' && resultString.charAt(j + 1) == ')')) {
                    result.append(resultString.charAt(j));
                }
            }
            result.append(resultString.charAt(resultString.length() - 1)); // Append the last character

            System.out.println("Case #" + caseNumber + ": " + result.toString());
        }
        
        scanner.close();
    }
}