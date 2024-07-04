import java.util.Scanner;
import java.util.stream.IntStream;

public class Solution {
    public static void main(final String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int testCount = scanner.nextInt();
        scanner.nextLine();
        for (int i = 1; i <= testCount; i++) {
            String input = scanner.nextLine();
            StringBuffer output = new StringBuffer();
            char[] chars = input.toCharArray();
            for (int c = 0; c < chars.length; c++) {
                int number = digitFromChar(chars[c]);

                if (number > 0 && c == 0 ) {
                    IntStream.rangeClosed(1, number).forEach((k) -> output.append('('));
                }
                output.append(number);
                if (c + 1 < chars.length) {
                    int nextNumber = digitFromChar(chars[c + 1]);
                    int diff = number - nextNumber;
                    if (diff > 0) {
                        IntStream.rangeClosed(1, diff).forEach((k) -> output.append(')'));
                    } else if (diff < 0) {
                        IntStream.rangeClosed(1, Math.abs(diff)).forEach((k) -> output.append('('));
                    }
                } else {
                    IntStream.rangeClosed(1, number).forEach((k) -> output.append(')'));
                }
            }
            System.out.println(String.format("Case #%d: %s", i, output));
        }
        scanner.close();
    }

    static int digitFromChar(char c) {
        return c - 48;
    }
}