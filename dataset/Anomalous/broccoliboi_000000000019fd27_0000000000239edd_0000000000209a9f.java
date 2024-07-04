import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int numCases = scanner.nextInt();
            scanner.nextLine();
            for (int caseNum = 1; caseNum <= numCases; caseNum++) {
                String input = scanner.nextLine();
                processCase(caseNum, input);
            }
        }
    }

    private static void processCase(int caseNum, String input) {
        StringBuilder result = new StringBuilder(input);
        int[] digitArray = input.chars().map(Character::getNumericValue).toArray();
        int offset = digitArray[0];

        insertParentheses(digitArray[0], 0, '(', result);

        for (int i = 1; i < input.length(); i++) {
            if (digitArray[i] < digitArray[i - 1]) {
                int diff = digitArray[i - 1] - digitArray[i];
                insertParentheses(diff, i + offset, ')', result);
                offset += diff;
            } else if (digitArray[i] > digitArray[i - 1]) {
                int diff = digitArray[i] - digitArray[i - 1];
                insertParentheses(diff, i + offset, '(', result);
                offset += diff;
            }
        }

        insertParentheses(digitArray[input.length() - 1], input.length() + offset, ')', result);
        System.out.printf("Case #%d: %s%n", caseNum, result.toString());
    }

    private static void insertParentheses(int count, int position, char parenthesis, StringBuilder sb) {
        for (int i = 0; i < count; i++) {
            sb.insert(position, parenthesis);
        }
    }
}