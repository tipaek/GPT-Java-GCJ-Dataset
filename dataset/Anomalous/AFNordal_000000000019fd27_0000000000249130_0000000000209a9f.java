import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int i = 1; i <= testCases; i++) {
            StringBuilder result = new StringBuilder();
            int currentDepth = 0;
            char[] digits = scanner.next().toCharArray();
            
            for (char digit : digits) {
                int number = digit - '0';
                
                if (number > currentDepth) {
                    result.append("(".repeat(number - currentDepth));
                } else if (number < currentDepth) {
                    result.append(")".repeat(currentDepth - number));
                }
                
                currentDepth = number;
                result.append(digit);
            }
            
            result.append(")".repeat(currentDepth));
            System.out.println("Case #" + i + ": " + result);
        }
        
        scanner.close();
    }
}