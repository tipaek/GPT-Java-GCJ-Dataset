import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            String input = scanner.next();
            int[] digits = new int[input.length()];
            
            for (int i = 0; i < input.length(); i++) {
                digits[i] = Character.getNumericValue(input.charAt(i));
            }
            
            printResult(testCase, digits);
        }
    }

    private static void printResult(int testCase, int[] digits) {
        StringBuilder result = new StringBuilder("Case #" + testCase + ": ");
        int openParentheses = 0;
        
        for (int digit : digits) {
            while (openParentheses < digit) {
                result.append('(');
                openParentheses++;
            }
            while (openParentheses > digit) {
                result.append(')');
                openParentheses--;
            }
            result.append(digit);
        }
        
        while (openParentheses > 0) {
            result.append(')');
            openParentheses--;
        }
        
        System.out.println(result.toString());
    }
}