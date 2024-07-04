import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfTests = Integer.parseInt(scanner.nextLine());
        
        for (int testNumber = 1; testNumber <= numberOfTests; testNumber++) {
            String inputLine = scanner.nextLine();
            processTestCase(testNumber, inputLine);
        }
        
        scanner.close();
    }

    public static void processTestCase(int testNumber, String inputLine) {
        StringBuilder result = new StringBuilder();
        int currentDepth = 0;

        for (char character : inputLine.toCharArray()) {
            int digit = character - '0';

            if (digit > currentDepth) {
                for (int i = 0; i < digit - currentDepth; i++) {
                    result.append('(');
                }
                result.append(character);
                currentDepth = digit;
            } else if (digit == currentDepth) {
                result.append(character);
            } else {
                for (int i = 0; i < currentDepth - digit; i++) {
                    result.append(')');
                }
                result.append(character);
                currentDepth = digit;
            }
        }

        for (int i = 0; i < currentDepth; i++) {
            result.append(')');
        }

        System.out.printf("Case #%d: %s%n", testNumber, result.toString());
    }
}