import java.io.*;
import java.util.*;

public class Solution {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int testCases = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        for (int cs = 1; cs <= testCases; cs++) {
            String input = scanner.nextLine();
            StringBuilder result = new StringBuilder();
            int currentDepth = 0;

            for (int i = 0; i < input.length(); i++) {
                int digit = input.charAt(i) - '0';
                if (digit > currentDepth) {
                    appendCharacters(result, '(', digit - currentDepth);
                    currentDepth = digit;
                } else if (digit < currentDepth) {
                    appendCharacters(result, ')', currentDepth - digit);
                    currentDepth = digit;
                }
                result.append(input.charAt(i));
            }
            appendCharacters(result, ')', currentDepth);

            System.out.println("Case #" + cs + ": " + result.toString());
        }
    }

    private static void appendCharacters(StringBuilder sb, char c, int count) {
        for (int i = 0; i < count; i++) {
            sb.append(c);
        }
    }
}