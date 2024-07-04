import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfTestCases = scanner.nextInt();
        scanner.nextLine();

        for (int testCaseNumber = 1; testCaseNumber <= numberOfTestCases; testCaseNumber++) {
            String input = scanner.nextLine();
            String answer = solve(input);
            System.out.printf("Case #%d: %s\n", testCaseNumber, answer);
        }
    }

    public static String solve(String input) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            int currentNumber = Integer.parseInt(String.valueOf(input.charAt(i)));
            append(builder, getFrontInterval(input, i, currentNumber), "(");
            builder.append(currentNumber);
            append(builder, getRearInterval(input, i, currentNumber), ")");

        }

        return builder.toString();
    }

    private static int getFrontInterval(String input, int i, int currentNumber) {
        if (i == 0) {
            return currentNumber;
        } else {
            int previousNumber = Integer.parseInt(String.valueOf(input.charAt(i - 1)));
            return currentNumber - previousNumber;
        }
    }

    private static int getRearInterval(String input, int i, int currentNumber) {
        if (i == input.length() - 1) {
            return currentNumber;
        } else {
            int nextNumber = Integer.parseInt(String.valueOf(input.charAt(i + 1)));
            return currentNumber - nextNumber;
        }
    }

    private static void append(StringBuilder builder, int interval, String s) {
        for (int j = 0; j < interval; j++) {
            builder.append(s);
        }
    }
}