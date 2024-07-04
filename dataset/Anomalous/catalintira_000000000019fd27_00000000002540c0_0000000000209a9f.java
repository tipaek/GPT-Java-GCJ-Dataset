import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            String number = scanner.next();
            int parenthesisCount = 0;

            for (int i = 0; i < number.length(); i++) {
                int currentDigit = Character.getNumericValue(number.charAt(i));
                int difference = currentDigit - parenthesisCount;
                char parenthesisChar = difference > 0 ? '(' : ')';
                parenthesisCount += Math.abs(difference);

                for (int j = 0; j < Math.abs(difference); j++) {
                    System.out.print(parenthesisChar);
                }

                System.out.print(currentDigit);
            }

            for (int i = 0; i < parenthesisCount; i++) {
                System.out.print(')');
            }
            System.out.println();
        }
    }
}