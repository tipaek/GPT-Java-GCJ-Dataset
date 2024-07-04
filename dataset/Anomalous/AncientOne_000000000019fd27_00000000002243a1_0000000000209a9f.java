import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class NestingDepths {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String input = scanner.next();
            int[] digits = new int[input.length()];
            
            for (int index = 0; index < input.length(); index++) {
                digits[index] = input.charAt(index) - '0';
            }
            
            StringBuilder result = new StringBuilder();
            int currentDepth = 0;
            
            for (int digit : digits) {
                while (currentDepth < digit) {
                    result.append("(");
                    currentDepth++;
                }
                while (currentDepth > digit) {
                    result.append(")");
                    currentDepth--;
                }
                result.append(digit);
            }
            
            while (currentDepth > 0) {
                result.append(")");
                currentDepth--;
            }
            
            System.out.println("Case #" + caseNumber + ": " + result.toString());
        }
        
        scanner.close();
    }
}