import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCaseCount = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < testCaseCount; i++) {
            String input = scanner.nextLine();
            StringBuilder output = new StringBuilder();
            int currentBracketCount = 0;

            for (char ch : input.toCharArray()) {
                int digit = Character.getNumericValue(ch);
                
                while (currentBracketCount < digit) {
                    output.append('(');
                    currentBracketCount++;
                }
                while (currentBracketCount > digit) {
                    output.append(')');
                    currentBracketCount--;
                }
                output.append(ch);
            }

            while (currentBracketCount > 0) {
                output.append(')');
                currentBracketCount--;
            }

            System.out.println("Case #" + (i + 1) + ": " + output.toString());
        }

        scanner.close();
    }
}