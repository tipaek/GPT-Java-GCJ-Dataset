import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseId = 1; caseId <= testCases; caseId++) {
            String input = scanner.next();
            StringBuilder result = new StringBuilder();
            int currentDepth = 0;

            for (int i = 0; i < input.length(); i++) {
                int digit = input.charAt(i) - '0';

                if (digit > currentDepth) {
                    appendCharacters(result, '(', digit - currentDepth);
                } else if (digit < currentDepth) {
                    appendCharacters(result, ')', currentDepth - digit);
                }

                result.append(digit);
                currentDepth = digit;
            }

            appendCharacters(result, ')', currentDepth);
            System.out.println("Case #" + caseId + ": " + result);
        }
    }

    private static void appendCharacters(StringBuilder sb, char character, int count) {
        for (int i = 0; i < count; i++) {
            sb.append(character);
        }
    }
}