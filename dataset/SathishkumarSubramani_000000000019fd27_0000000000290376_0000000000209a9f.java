import java.util.Scanner;
import java.util.stream.IntStream;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCount = scanner.nextInt();
        scanner.nextLine();
        for (int i = 1; i <= testCount; i++) {
            String input = scanner.nextLine();
            StringBuffer output = new StringBuffer();
            char[] chars = input.toCharArray();
            for (int c = 0; c < chars.length; c++) {
                int number = chars[c] - 48;
                if (number == 0) {
                    output.append(number);
                } else {
                    IntStream.rangeClosed(1, number).forEach((k) -> output.append('('));
                    output.append(number);
                    while (c + 1 < chars.length && chars[c] == chars[c + 1]) {
                        output.append(chars[c + 1]);
                        c++;
                    }
                    IntStream.rangeClosed(1, number).forEach((k) -> output.append(')'));
                }
            }
            System.out.println(String.format("Case #%d: %s", i, output));
        }
        scanner.close();
    }
}