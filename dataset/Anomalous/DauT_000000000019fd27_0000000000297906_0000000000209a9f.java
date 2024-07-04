import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String input = scanner.next();
            String result = generateOutput(input, caseNumber);
            System.out.println(result);
        }
    }

    static String generateOutput(String input, int caseNumber) {
        StringBuilder result = new StringBuilder();
        int openBrackets = 0;
        
        for (char ch : input.toCharArray()) {
            int digit = ch - '0';
            
            while (openBrackets < digit) {
                result.append('(');
                openBrackets++;
            }
            
            while (openBrackets > digit) {
                result.append(')');
                openBrackets--;
            }
            
            result.append(ch);
        }
        
        while (openBrackets > 0) {
            result.append(')');
            openBrackets--;
        }
        
        return "Case #" + caseNumber + ": " + result.toString();
    }
}