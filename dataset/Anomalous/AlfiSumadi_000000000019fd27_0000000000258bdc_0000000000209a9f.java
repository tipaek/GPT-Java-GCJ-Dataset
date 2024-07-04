import java.util.Scanner;

public class Solution {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        long testCases = scanner.nextLong();
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            processCase(caseNumber);
        }
    }

    private static void processCase(long caseNumber) {
        String input = scanner.next();
        String result = input;

        for (char digit = '0'; digit <= '9'; digit++) {
            int offset = 0;
            boolean isInGroup = false;

            for (int index = 0; index < input.length(); index++) {
                char currentChar = input.charAt(index);

                if (currentChar == '(' || currentChar == ')') {
                    continue;
                }

                if (currentChar > digit) {
                    if (!isInGroup) {
                        result = result.substring(0, index + offset) + '(' + result.substring(index + offset);
                        offset++;
                        isInGroup = true;
                    }
                } else {
                    if (isInGroup) {
                        result = result.substring(0, index + offset) + ')' + result.substring(index + offset);
                        offset++;
                        isInGroup = false;
                    }
                }
            }

            if (isInGroup) {
                result += ')';
            }

            input = result;
        }

        System.out.println("Case #" + caseNumber + ": " + result);
    }
}