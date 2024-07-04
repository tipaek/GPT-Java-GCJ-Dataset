import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numTestCases = scanner.nextInt();
        String[] results = new String[numTestCases];
        
        for (int i = 0; i < numTestCases; i++) {
            String input = scanner.next();
            results[i] = processInput(input);
        }
        
        for (int i = 0; i < numTestCases; i++) {
            System.out.println("Case #" + (i + 1) + ": " + results[i]);
        }
    }
    
    private static String processInput(String input) {
        if (!input.contains("1")) {
            return input;
        }
        
        StringBuilder result = new StringBuilder();
        int index = 0;
        
        while (index < input.length()) {
            while (index < input.length() && input.charAt(index) == '0') {
                result.append('0');
                index++;
            }
            
            if (index < input.length() && input.charAt(index) == '1') {
                result.append('(');
                while (index < input.length() && input.charAt(index) == '1') {
                    result.append('1');
                    index++;
                }
                result.append(')');
            }
        }
        
        return result.toString();
    }
}