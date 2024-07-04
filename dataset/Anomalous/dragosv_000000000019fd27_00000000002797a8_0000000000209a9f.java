import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfTests = scanner.nextInt();
        
        for (int testCase = 1; testCase <= numberOfTests; testCase++) {
            String input = scanner.next();
            StringBuilder result = new StringBuilder();
            char[] chars = input.toCharArray();
            int currentDepth = 0;
            
            for (char ch : chars) {
                int targetDepth = ch - '0';
                
                while (currentDepth < targetDepth) {
                    result.append('(');
                    currentDepth++;
                }
                
                while (currentDepth > targetDepth) {
                    result.append(')');
                    currentDepth--;
                }
                
                result.append(ch);
            }
            
            while (currentDepth > 0) {
                result.append(')');
                currentDepth--;
            }
            
            System.out.printf("Case #%d: %s%n", testCase, result.toString());
        }
    }
}