import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            System.out.print("Case #" + testCase + ": ");

            String input = scanner.nextLine();
            int openParens = 0;
            int previousDigit = Character.getNumericValue(input.charAt(0));

            // Open initial parentheses
            for (int i = 0; i < previousDigit; i++) {
                System.out.print('(');
                openParens++;
            }
            System.out.print(previousDigit);

            for (int i = 1; i < input.length(); i++) {
                int currentDigit = Character.getNumericValue(input.charAt(i));

                if (currentDigit > previousDigit) {
                    for (int j = previousDigit; j < currentDigit; j++) {
                        System.out.print('(');
                        openParens++;
                    }
                } else if (currentDigit < previousDigit) {
                    for (int j = currentDigit; j < previousDigit; j++) {
                        System.out.print(')');
                        openParens--;
                    }
                }
                System.out.print(currentDigit);
                previousDigit = currentDigit;
            }

            // Close remaining open parentheses
            for (int i = 0; i < openParens; i++) {
                System.out.print(')');
            }
            System.out.println();
        }
        scanner.close();
    }
}