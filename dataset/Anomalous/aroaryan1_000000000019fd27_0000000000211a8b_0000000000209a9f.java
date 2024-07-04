import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCases = scanner.nextInt();
        
        for (int caseIndex = 1; caseIndex <= numberOfCases; caseIndex++) {
            String inputString = scanner.next().trim();
            inputString = "0" + inputString + "0";
            StringBuilder result = new StringBuilder();
            
            for (int i = 1; i < inputString.length() - 1; i++) {
                char currentChar = inputString.charAt(i);
                
                if (currentChar != '0') {
                    if (inputString.charAt(i - 1) == '0') {
                        result.append('(').append(currentChar);
                    }
                    if (inputString.charAt(i + 1) == '0') {
                        result.append(currentChar).append(')');
                    }
                    if (inputString.charAt(i - 1) != '0' && inputString.charAt(i + 1) != '0') {
                        result.append(currentChar);
                    }
                } else {
                    result.append(currentChar);
                }
            }
            
            System.out.println("Case #" + caseIndex + ": " + result.toString());
        }
        
        scanner.close();
    }
}