import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            String input = scanner.next();
            int[] depth = new int[input.length()];
            System.out.print("Case #" + t + ": ");

            for (int i = 0; i < input.length(); i++) {
                int currentDigit = Character.getNumericValue(input.charAt(i));

                if (i > 0) {
                    int previousDigit = Character.getNumericValue(input.charAt(i - 1));
                    if (currentDigit > previousDigit) {
                        printChars('(', currentDigit - previousDigit);
                    } else if (currentDigit < previousDigit) {
                        printChars(')', previousDigit - currentDigit);
                    }
                } else {
                    printChars('(', currentDigit);
                }

                System.out.print(currentDigit);
            }

            int lastDigit = Character.getNumericValue(input.charAt(input.length() - 1));
            printChars(')', lastDigit);
            System.out.println();
        }

        scanner.close();
    }

    private static void printChars(char ch, int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(ch);
        }
    }
}