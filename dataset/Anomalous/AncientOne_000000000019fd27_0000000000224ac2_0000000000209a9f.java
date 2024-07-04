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
            
            for (int i = 0; i < input.length(); i++) {
                digits[i] = input.charAt(i) - '0';
            }
            
            StringBuilder result = new StringBuilder();
            int currentDepth = digits[0];
            
            result.append("(".repeat(currentDepth));
            result.append(digits[0]);
            
            for (int i = 1; i < input.length(); i++) {
                int depthChange = digits[i] - currentDepth;
                
                if (depthChange > 0) {
                    result.append("(".repeat(depthChange));
                } else if (depthChange < 0) {
                    result.append(")".repeat(-depthChange));
                }
                
                result.append(digits[i]);
                currentDepth += depthChange;
            }
            
            result.append(")".repeat(currentDepth));
            System.out.println("Case #" + caseNumber + ": " + result);
        }
    }
}