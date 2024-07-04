import java.io.*;
import java.util.Scanner;

class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfTestCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= numberOfTestCases; testCase++) {
            int openParentheses = 0;
            String inputNumber = Integer.toString(scanner.nextInt());
            StringBuilder result = new StringBuilder();
            
            for (int i = 0; i < inputNumber.length(); i++) {
                int currentDigit = Character.getNumericValue(inputNumber.charAt(i));
                
                while (openParentheses < currentDigit) {
                    result.append('(');
                    openParentheses++;
                }
                
                while (openParentheses > currentDigit) {
                    result.append(')');
                    openParentheses--;
                }
                
                result.append(currentDigit);
            }
            
            while (openParentheses > 0) {
                result.append(')');
                openParentheses--;
            }
            
            System.out.println("Case #" + testCase + ": " + result.toString());
        }
    }
}