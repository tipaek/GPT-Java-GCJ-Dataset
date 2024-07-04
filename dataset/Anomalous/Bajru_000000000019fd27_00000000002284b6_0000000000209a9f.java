import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < testCases; i++) {
            String inputString = scanner.nextLine();
            String result = generateBalancedString(inputString);
            System.out.println(result);
        }
    }

    private static String generateBalancedString(String s) {
        int maxDepth = 0;
        StringBuilder result = new StringBuilder();
        
        for (char c : s.toCharArray()) {
            int currentDigit = Character.getNumericValue(c);
            
            if (currentDigit > maxDepth) {
                result.append("(".repeat(currentDigit - maxDepth));
                maxDepth = currentDigit;
            } else if (currentDigit < maxDepth) {
                result.append(")".repeat(maxDepth - currentDigit));
                maxDepth = currentDigit;
            }
            result.append(c);
        }
        
        if (maxDepth > 0) {
            result.append(")".repeat(maxDepth));
        }
        
        return result.toString();
    }
}