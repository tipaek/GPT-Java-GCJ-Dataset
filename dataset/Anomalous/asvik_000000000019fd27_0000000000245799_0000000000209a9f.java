import java.io.*;
import java.util.*;

public class Solution {

    public static void nestingDepth(int caseNumber, String input) {
        StringBuilder result = new StringBuilder();
        int length = input.length();
        
        for (int i = 0; i < length - 1; i++) {
            char currentChar = input.charAt(i);
            char nextChar = input.charAt(i + 1);
            
            if (currentChar == '0') {
                result.append('0');
            } else if (currentChar == '1' && nextChar == '0') {
                if (i == 0) {
                    result.append("(1)");
                } else {
                    result.append("1)");
                }
            } else if (i > 0 && input.charAt(i - 1) == '1' && currentChar == '1' && nextChar == '1') {
                result.append('1');
            } else if (currentChar == '1' && nextChar == '1') {
                result.append("(1");
            }
        }
        
        if (input.charAt(length - 1) == '0') {
            result.append('0');
        } else {
            if (length == 1 || input.charAt(length - 2) == '0') {
                result.append("(1)");
            } else {
                result.append("1)");
            }
        }
        
        System.out.println("Case #" + caseNumber + ": " + result.toString());
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int testCases = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        for (int i = 0; i < testCases; i++) {
            String input = scanner.nextLine();
            nestingDepth(i + 1, input);
        }

        scanner.close();
    }
}