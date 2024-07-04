import java.io.*;
import java.util.*;

class Solution {

    public static void appendBrackets(StringBuilder builder, int count) {
        char bracket = count > 0 ? '(' : ')';
        count = Math.abs(count);
        for (int i = 0; i < count; i++) {
            builder.append(bracket);
        }
    }

    public static void generateAnswer(String input, int caseNumber) {
        int length = input.length();
        StringBuilder result = new StringBuilder();
        
        int previousDigit = input.charAt(0) - '0';
        appendBrackets(result, previousDigit);
        result.append(input.charAt(0));
        
        int balance = previousDigit;
        
        for (int i = 1; i < length; i++) {
            int currentDigit = input.charAt(i) - '0';
            appendBrackets(result, currentDigit - previousDigit);
            result.append(input.charAt(i));
            balance += currentDigit - previousDigit;
            previousDigit = currentDigit;
        }
        
        appendBrackets(result, -balance);
        
        System.out.println("Case #" + caseNumber + ": " + result);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; i++) {
            String input = scanner.next();
            generateAnswer(input, i);
        }
    }
}