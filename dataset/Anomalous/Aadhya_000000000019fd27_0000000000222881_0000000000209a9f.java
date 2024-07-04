import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numTests = scanner.nextInt();
        String[] results = new String[numTests];

        for (int i = 0; i < numTests; i++) {
            String input = scanner.next();
            results[i] = formatString(input);
        }

        for (int i = 0; i < numTests; i++) {
            System.out.println("Case #" + (i + 1) + ": " + results[i]);
        }
    }

    private static String formatString(String input) {
        if (!input.contains("1")) {
            return input;
        }

        StringBuilder formatted = new StringBuilder();
        int length = input.length();
        int index = 0;

        while (index < length) {
            while (index < length && input.charAt(index) == '0') {
                formatted.append('0');
                index++;
            }
            if (index < length && input.charAt(index) == '1') {
                formatted.append('(');
                while (index < length && input.charAt(index) == '1') {
                    formatted.append('1');
                    index++;
                }
                formatted.append(')');
            }
        }

        return formatted.toString();
    }
}