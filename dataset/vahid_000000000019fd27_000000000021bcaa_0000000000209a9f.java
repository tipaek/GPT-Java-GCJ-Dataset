import static java.lang.String.format;
import static java.util.stream.IntStream.range;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class Solution {

    private static Scanner scanner = new Scanner(new BufferedInputStream(System.in, 64 * 1024));

    public static void main(String[] args) {
        new Solution().solveProblem();
    }

    private void solveProblem() {
        int t = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < t; i++) {
            solveCase(i + 1);
        }
    }

    private void solveCase(int item) {
        Input input = getInput();
        System.out.println(format("Case #%d: %s", item, solve(input)));
    }

    private String solve(Input input) {
        StringBuffer buffer = new StringBuffer();
        int lastDigit = 0;
        for (char ch : input.number.toCharArray()) {
            int digit = (int) ch - (int) '0';
            if (digit > lastDigit) {
                addParentheses(buffer, '(', digit - lastDigit);
            } else {
                addParentheses(buffer, ')', lastDigit - digit);
            }
            buffer.append(digit);
            lastDigit = digit;
        }
        addParentheses(buffer, ')', lastDigit);
        return buffer.toString();
    }

    private void addParentheses(StringBuffer buffer, char p, int count) {
        range(0, count).forEach(i -> buffer.append(p));
    }

    private Input getInput() {
        return new Input(scanner.nextLine());
    }

    class Input {
        String number;

        public Input(String number) {
            this.number = number;
        }
    }

}
