import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int i = 1; i <= testCases; ++i) {
            String input = scanner.next();
            StringBuilder result = new StringBuilder();
            int previousDigit = 0;
            int balance = 0;

            for (char currentChar : input.toCharArray()) {
                int currentDigit = currentChar - '0';
                if (previousDigit != currentDigit) {
                    char bracket = currentDigit > previousDigit ? '(' : ')';
                    int diff = Math.abs(currentDigit - previousDigit);
                    balance += currentDigit - previousDigit;
                    result.append(repeatChar(bracket, diff));
                    previousDigit = currentDigit;
                }
                result.append(currentChar);
            }

            if (balance > 0) {
                result.append(repeatChar(')', balance));
            }

            System.out.println("Case #" + i + ": " + result.toString());
        }
    }

    private static String repeatChar(char character, int count) {
        char[] array = new char[count];
        for (int i = 0; i < count; i++) {
            array[i] = character;
        }
        return new String(array);
    }
}