import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            String input = scanner.next();
            StringBuilder result = new StringBuilder();
            int[] digits = new int[input.length()];
            
            for (int i = 0; i < input.length(); i++) {
                digits[i] = input.charAt(i) - '0';
            }
            
            System.out.print("Case #" + caseNum + ": ");
            
            for (int i = 0; i < digits.length; i++) {
                if (digits[i] == 0) {
                    result.append('0');
                } else {
                    if (i > 0) {
                        if (digits[i - 1] < digits[i]) {
                            result.append(generateBrackets('(', digits[i] - digits[i - 1])).append(digits[i]);
                        } else {
                            result.append(digits[i]);
                        }
                    } else {
                        result.append(generateBrackets('(', digits[i])).append(digits[i]);
                    }
                    
                    if (i < digits.length - 1) {
                        if (digits[i + 1] < digits[i]) {
                            result.append(generateBrackets(')', digits[i] - digits[i + 1]));
                        }
                    } else {
                        result.append(generateBrackets(')', digits[i]));
                    }
                }
            }
            
            System.out.println(result);
        }
        
        scanner.close();
    }
    
    private static String generateBrackets(char bracketType, int count) {
        StringBuilder brackets = new StringBuilder();
        for (int i = 0; i < count; i++) {
            brackets.append(bracketType);
        }
        return brackets.toString();
    }
}