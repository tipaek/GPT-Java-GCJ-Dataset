import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    private static final String[] OPENING_PARENTHESIS = {
        "", "(", "((", "(((", "((((", "(((((",
        "((((((", "(((((((", "((((((((", "((((((((("
    };

    private static final String[] CLOSING_PARENTHESIS = {
        "", ")", "))", ")))", "))))", ")))))",
        "))))))", ")))))))", "))))))))", ")))))))))"
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; ++i) {
            String input = scanner.next() + "0";

            StringBuilder result = new StringBuilder();
            int currentNumber = 0;

            for (int j = 0; j < input.length(); ++j) {
                int nextNumber = input.charAt(j) - '0';
                if (nextNumber > currentNumber) {
                    result.append(OPENING_PARENTHESIS[nextNumber - currentNumber]);
                } else if (nextNumber < currentNumber) {
                    result.append(CLOSING_PARENTHESIS[currentNumber - nextNumber]);
                }
                result.append(input.charAt(j));
                currentNumber = nextNumber;
            }

            result.deleteCharAt(result.length() - 1);

            System.out.println("Case #" + i + ": " + result);
        }
    }
}