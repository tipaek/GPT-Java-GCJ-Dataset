import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        scanner.nextLine();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String input = scanner.nextLine();
            int[] digits = new int[input.length()];
            
            for (int i = 0; i < input.length(); i++) {
                digits[i] = Character.getNumericValue(input.charAt(i));
            }
            
            StringBuilder result = new StringBuilder();
            appendCharacters(result, '(', digits[0]);
            result.append(digits[0]);
            
            for (int i = 1; i < digits.length; i++) {
                if (digits[i] > digits[i - 1]) {
                    appendCharacters(result, '(', digits[i] - digits[i - 1]);
                } else if (digits[i] < digits[i - 1]) {
                    appendCharacters(result, ')', digits[i - 1] - digits[i]);
                }
                result.append(digits[i]);
            }
            
            appendCharacters(result, ')', digits[digits.length - 1]);
            System.out.println("Case #" + caseNumber + ": " + result.toString());
        }
    }
    
    private static void appendCharacters(StringBuilder builder, char character, int count) {
        for (int i = 0; i < count; i++) {
            builder.append(character);
        }
    }
}