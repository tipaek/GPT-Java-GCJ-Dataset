import java.util.Scanner;

public class Solution {

    public static String generateBrackets(int count, boolean isOpening) {
        StringBuilder result = new StringBuilder();
        char bracket = isOpening ? '(' : ')';
        for (int i = 0; i < count; i++) {
            result.append(bracket);
        }
        return result.toString();
    }

    public static String nestedBrackets(String input) {
        int length = input.length();
        int[] numbers = new int[length];
        for (int i = 0; i < length; i++) {
            numbers[i] = Character.getNumericValue(input.charAt(i));
        }

        StringBuilder output = new StringBuilder();
        int current = numbers[0];
        output.append(generateBrackets(current, true)).append(current);

        int remainingBrackets = current;
        for (int i = 1; i < length; i++) {
            int next = numbers[i];
            if (next < current) {
                output.append(generateBrackets(current - next, false)).append(next);
                remainingBrackets -= (current - next);
            } else if (current < next) {
                output.append(generateBrackets(next - current, true)).append(next);
                remainingBrackets -= (current - next);
            } else {
                output.append(next);
            }
            current = next;
        }
        output.append(generateBrackets(remainingBrackets, false));
        return output.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        StringBuilder result = new StringBuilder();
        for (int t = 0; t < testCases; t++) {
            String input = scanner.nextLine();
            String formattedOutput = nestedBrackets(input);
            result.append("Case #").append(t + 1).append(": ").append(formattedOutput);
            if (t < testCases - 1) {
                result.append("\n");
            }
        }
        System.out.println(result.toString());
    }
}