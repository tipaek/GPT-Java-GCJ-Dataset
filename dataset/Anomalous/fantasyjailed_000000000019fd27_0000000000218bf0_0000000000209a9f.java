import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    private static String generateBraces(int count, char braceType) {
        char[] braceArray = new char[count];
        for (int i = 0; i < count; i++) {
            braceArray[i] = braceType;
        }
        return new String(braceArray);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int testCase = 1; testCase <= testCases; testCase++) {
            char[] inputChars = scanner.nextLine().toCharArray();
            StringBuilder result = new StringBuilder();
            int openBraces = 0;

            for (char ch : inputChars) {
                int digit = ch - '0';

                if (digit > openBraces) {
                    result.append(generateBraces(digit - openBraces, '('));
                    openBraces = digit;
                } else if (digit < openBraces) {
                    result.append(generateBraces(openBraces - digit, ')'));
                    openBraces = digit;
                }

                result.append(ch);
            }

            if (openBraces > 0) {
                result.append(generateBraces(openBraces, ')'));
            }

            System.out.printf("Case #%d: %s%n", testCase, result.toString());
        }
    }
}