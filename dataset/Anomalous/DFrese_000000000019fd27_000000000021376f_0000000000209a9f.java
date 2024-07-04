import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCaseCount = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= testCaseCount; i++) {
            processTestCase(i, scanner.nextLine());
        }
    }

    private static void processTestCase(int caseNumber, String input) {
        StringBuilder wrappedInput = new StringBuilder();

        for (char c : input.toCharArray()) {
            wrappedInput.append(wrapCharacter(c));
        }

        String finalOutput = optimizeParentheses(wrappedInput.toString());
        System.out.println(String.format("Case #%d: %s", caseNumber, finalOutput));
    }

    private static String wrapCharacter(char c) {
        int count = Character.getNumericValue(c);
        StringBuilder wrapped = new StringBuilder();

        for (int i = 0; i < count; i++) {
            wrapped.append('(');
        }
        wrapped.append(c);
        for (int i = 0; i < count; i++) {
            wrapped.append(')');
        }

        return wrapped.toString();
    }

    private static String optimizeParentheses(String input) {
        String previous;
        String current = input;

        do {
            previous = current;
            current = previous.replace(")(", "");
        } while (!previous.equals(current));

        return current;
    }
}