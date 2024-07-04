import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCaseCount = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCaseCount; testCase++) {
            String inputString = scanner.next();
            StringBuilder result = new StringBuilder();
            int balance = 0;

            for (int i = 0; i < inputString.length(); i++) {
                int currentDigit = Character.getNumericValue(inputString.charAt(i));
                int openBrackets = currentDigit - balance;

                while (openBrackets > 0) {
                    result.append("(");
                    openBrackets--;
                }

                int closeBrackets = balance - currentDigit;
                
                while (closeBrackets > 0) {
                    result.append(")");
                    closeBrackets--;
                }

                balance = currentDigit;
                result.append(currentDigit);
            }

            while (balance > 0) {
                result.append(")");
                balance--;
            }

            System.out.println("Case #" + testCase + ": " + result.toString());
        }
    }
}