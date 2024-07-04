import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int numberOfCases = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= numberOfCases; i++) {
            String input = scanner.nextLine();
            List<Character> output = new ArrayList<>();
            char[] digits = input.toCharArray();
            int offset = 0;

            for (char digit : digits) {
                output.add(digit);
            }

            for (int j = 0; j < digits.length; j++) {
                int currentDigitValue = Character.getNumericValue(digits[j]);

                while (currentDigitValue > netDepth(output, j + offset)) {
                    output.add(j + offset, '(');
                    offset++;
                }

                while (currentDigitValue < netDepth(output, j + offset)) {
                    output.add(j + offset, ')');
                    offset++;
                }
            }

            while (netDepth(output, output.size()) > 0) {
                output.add(')');
            }

            StringBuilder result = new StringBuilder();
            for (char c : output) {
                result.append(c);
            }

            System.out.println("Case #" + i + ": " + result);
        }
    }

    public static int netDepth(List<Character> characters, int index) {
        int depth = 0;
        for (int i = 0; i < index; i++) {
            if (characters.get(i) == '(') {
                depth++;
            } else if (characters.get(i) == ')') {
                depth--;
            }
        }
        return depth;
    }
}