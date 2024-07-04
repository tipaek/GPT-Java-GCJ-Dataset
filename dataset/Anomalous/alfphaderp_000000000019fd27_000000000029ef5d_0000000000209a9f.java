import java.util.Scanner;

public class Solution {
    private static Scanner scanner;
    private static int testCases;
    private static String inputString;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        testCases = scanner.nextInt();
        scanner.nextLine(); // Consume the remaining newline

        for (int i = 1; i <= testCases; i++) {
            readInput();
            System.out.println("Case #" + i + ": " + solve());
        }

        scanner.close();
    }

    private static void readInput() {
        inputString = scanner.nextLine();
    }

    private static String repeat(String str, int count) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < count; i++) {
            builder.append(str);
        }
        return builder.toString();
    }

    private static String solve() {
        StringBuilder result = new StringBuilder();
        int currentParens = 0;

        for (int i = 0; i < inputString.length(); i++) {
            int number = Character.getNumericValue(inputString.charAt(i));

            if (number > currentParens) {
                result.append(repeat("(", number - currentParens));
                currentParens = number;
            } else if (number < currentParens) {
                result.append(repeat(")", currentParens - number));
                currentParens = number;
            }

            result.append(number);
        }

        result.append(repeat(")", currentParens));
        return result.toString();
    }
}