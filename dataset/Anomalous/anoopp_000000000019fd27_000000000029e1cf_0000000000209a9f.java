import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class NestingDepthBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int i = 1; i <= testCases; i++) {
            String input = scanner.next();
            processString(input, i);
        }
        
        scanner.close();
    }

    private static void processString(String input, int caseNumber) {
        StringBuilder result = new StringBuilder();
        int currentDepth = 0;

        for (int i = 0; i < input.length(); i++) {
            int digit = Character.getNumericValue(input.charAt(i));
            
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
}