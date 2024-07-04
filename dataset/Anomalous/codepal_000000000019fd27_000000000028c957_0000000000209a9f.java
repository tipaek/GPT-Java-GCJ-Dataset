import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            String inputString = scanner.next();
            int openParenthesesCount = 0;

            System.out.print("Case #" + (i + 1) + ": ");
            for (int j = 0; j < inputString.length(); j++) {
                int currentDigit = inputString.charAt(j) - '0';

                while (openParenthesesCount < currentDigit) {
                    System.out.print("(");
                    openParenthesesCount++;
                }

                while (openParenthesesCount > currentDigit) {
                    System.out.print(")");
                    openParenthesesCount--;
                }

                System.out.print(inputString.charAt(j));
            }

            while (openParenthesesCount > 0) {
                System.out.print(")");
                openParenthesesCount--;
            }

            System.out.println();
        }

        scanner.close();
    }
}