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
            String result = solve(inputString);
            System.out.println("Case #" + (i + 1) + ": " + result);
        }
    }

    private static String solve(String s) {
        int length = s.length();
        int currentDepth = 0;
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < length; i++) {
            int digit = Character.getNumericValue(s.charAt(i));

            if (digit > currentDepth) {
                result.append("(".repeat(digit - currentDepth));
                currentDepth = digit;
            } else if (digit < currentDepth) {
                result.append(")".repeat(currentDepth - digit));
                currentDepth = digit;
            }

            result.append(s.charAt(i));
        }

        if (currentDepth > 0) {
            result.append(")".repeat(currentDepth));
        }

        return result.toString();
    }
}