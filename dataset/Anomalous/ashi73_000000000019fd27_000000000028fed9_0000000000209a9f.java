import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            String input = scanner.next();
            StringBuilder output = new StringBuilder();
            
            for (int i = 0; i < input.length(); i++) {
                char currentChar = input.charAt(i);
                int digit = Character.getNumericValue(currentChar);
                
                if (digit == 0) {
                    output.append(digit);
                } else {
                    StringBuilder repeatedDigits = new StringBuilder();
                    
                    while (i + 1 < input.length() && input.charAt(i) == input.charAt(i + 1)) {
                        repeatedDigits.append(digit);
                        i++;
                    }
                    
                    for (int j = 0; j < digit; j++) {
                        output.append('(');
                    }
                    
                    output.append(digit).append(repeatedDigits);
                    
                    for (int j = 0; j < digit; j++) {
                        output.append(')');
                    }
                }
            }
            
            System.out.println("Case #" + caseNum + ": " + output.toString());
        }
        
        scanner.close();
    }
}