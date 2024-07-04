import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String result = formatNestingDepth(scanner.next());
            System.out.printf("Case #%d: %s%n", caseNumber, result);
        }
    }

    public static String formatNestingDepth(String input) {
        StringBuilder formattedString = new StringBuilder();
        int currentDepth = 0;
        
        for (char digitChar : input.toCharArray()) {
            int digit = Character.getNumericValue(digitChar);
            
            while (currentDepth > digit) {
                formattedString.append(')');
                currentDepth--;
            }
            while (currentDepth < digit) {
                formattedString.append('(');
                currentDepth++;
            }
            
            formattedString.append(digit);
        }

        while (currentDepth > 0) {
            formattedString.append(')');
            currentDepth--;
        }

        return formattedString.toString();
    }
}