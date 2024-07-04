import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());
        
        for (int i = 1; i <= testCases; i++) {
            String input = scanner.nextLine();
            StringBuilder result = new StringBuilder();
            
            for (char ch : input.toCharArray()) {
                if (ch == '0') {
                    result.append(")0(");
                } else {
                    result.append(ch);
                }
            }
            
            String processedResult = "(" + result.toString() + ")";
            StringBuilder finalResult = new StringBuilder();
            
            for (int j = 0; j < processedResult.length(); j++) {
                if (processedResult.charAt(j) == '(' && processedResult.charAt(j + 1) == ')') {
                    j++; // Skip the next character as well
                } else {
                    finalResult.append(processedResult.charAt(j));
                }
            }
            
            System.out.println("Case #" + i + ": " + finalResult.toString());
        }
    }
}