import java.util.*;
import java.io.*;

public class Solution {   
    static final String[] BRACES = {
        ")))))))))",
        "))))))))",
        ")))))))",
        "))))))",
        ")))))",
        "))))",
        ")))",
        "))",
        ")",
        "",
        "(",
        "((",
        "(((",
        "((((",
        "(((((",
        "((((((",
        "(((((((",
        "((((((((",
        "((((((((("
    };
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            String result = processTestCase(scanner);
            System.out.println("Case #" + i + ": " + result);
        }
    }
    
    public static String processTestCase(Scanner scanner) {
        String inputString = scanner.next();
        int length = inputString.length();
        
        int[] digits = new int[length + 1];
        for (int i = 0; i < length; i++) {
            digits[i] = inputString.charAt(i) - '0';
        }
        
        StringBuilder result = new StringBuilder(BRACES[digits[0] + 9]);
        
        for (int i = 0; i < length; i++) {
            int braceIndex = (digits[i + 1] - digits[i]) + 9;
            result.append(digits[i]).append(BRACES[braceIndex]);
        }
        
        return result.toString();
    }
}