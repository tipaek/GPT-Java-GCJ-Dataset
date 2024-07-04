import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testcases = scanner.nextInt();
        for (int i = 0; i < testcases; i++) {
            String numbers = scanner.next();
            String ans = setNesting(numbers);
            System.out.println("Case #" + (i + 1) + ": " + ans );
        }

    }

    private static String setNesting(String value) {
        StringBuilder builder = new StringBuilder();
        char[] valueInChar = value.toCharArray();
        int numberOfOpenBrace = 0;
        for (int i = 0; i < valueInChar.length; i++) {
            int number = Integer.parseInt(String.valueOf(valueInChar[i]));

            if (numberOfOpenBrace > number) {
                int amount = numberOfOpenBrace - number;
                builder.append(getCloseBrace(amount));
                numberOfOpenBrace = number;
                builder.append(number);

            } else if (numberOfOpenBrace == number) {
                builder.append(number);
            } else {
                int amount = number - numberOfOpenBrace;
                builder.append(getOpenBrace(amount));
                numberOfOpenBrace += amount;
                builder.append(number);
            }
        }
        builder.append(getCloseBrace(numberOfOpenBrace));
        return builder.toString();
    }

    private static String getCloseBrace(int n) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            builder.append(')');
        }
        return builder.toString();
    }

    private static String getOpenBrace(int n) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            builder.append('(');
        }
        return builder.toString();
    }
}