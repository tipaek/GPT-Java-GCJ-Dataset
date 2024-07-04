import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character left by nextInt()

        for (int i = 1; i <= testCases; ++i) {
            String input = scanner.nextLine();
            StringBuilder result = new StringBuilder();
            char previousChar = '0';

            for (int j = 0; j < input.length(); j++) {
                char currentChar = input.charAt(j);

                if (previousChar == currentChar) {
                    result.append(previousChar);
                } else {
                    char bracket = (currentChar > previousChar) ? '(' : ')';
                    for (int k = 0; k < Math.abs(previousChar - currentChar); k++) {
                        result.append(bracket);
                    }
                    result.append(currentChar);
                    previousChar = currentChar;
                }
            }

            for (int k = 0; k < Math.abs(previousChar - '0'); k++) {
                result.append(')');
            }

            System.out.println("Case #" + i + ": " + result.toString());
        }
    }
}