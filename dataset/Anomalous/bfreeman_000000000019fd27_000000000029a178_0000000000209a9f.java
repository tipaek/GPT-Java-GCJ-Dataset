import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int numberOfCases = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < numberOfCases; i++) {
            processCase(i + 1);
        }
    }

    private static void processCase(int caseNumber) {
        String inputString = scanner.nextLine();
        ArrayList<Character> characters = new ArrayList<>(inputString.length() * 10);
        for (char character : inputString.toCharArray()) {
            characters.add(character);
        }
        insertAllParentheses(characters);
        while (removeAdjacentParentheses(characters)) {}
        displayCaseResult(caseNumber, convertToString(characters));
    }

    private static void insertAllParentheses(ArrayList<Character> characters) {
        int currentValue = -1;
        for (int i = 0; i < characters.size(); i += 1 + 2 * currentValue) {
            currentValue = Character.getNumericValue(characters.get(i));
            insertParentheses(characters, i);
        }
    }

    private static void insertParentheses(ArrayList<Character> characters, int index) {
        int value = Character.getNumericValue(characters.get(index));
        for (int i = 0; i < value; i++) {
            characters.add(index, '(');
        }
        for (int i = 0; i < value; i++) {
            characters.add(index + value + 1, ')');
        }
    }

    private static boolean removeAdjacentParentheses(ArrayList<Character> characters) {
        boolean modified = false;
        for (int i = characters.size() - 3; i >= 3; i--) {
            if (characters.get(i) == '(' && characters.get(i - 1) == ')') {
                modified = true;
                characters.remove(i);
                characters.remove(i - 1);
            }
        }
        return modified;
    }

    private static String convertToString(ArrayList<Character> characters) {
        StringBuilder result = new StringBuilder();
        for (Character character : characters) {
            result.append(character);
        }
        return result.toString();
    }

    public static String[] splitByZero(String input) {
        ArrayList<String> parts = new ArrayList<>();
        int lastZeroIndex = -1;
        int index = 0;
        while (index < input.length()) {
            if (input.charAt(index) == '0') {
                if (lastZeroIndex != index - 1) {
                    parts.add(input.substring(lastZeroIndex + 1, index));
                }
                parts.add("0");
                lastZeroIndex = index;
            }
            index++;
        }
        if (lastZeroIndex != input.length() - 1) {
            parts.add(input.substring(lastZeroIndex + 1));
        }
        return parts.toArray(new String[0]);
    }

    private static void displayCaseResult(int caseNumber, String result) {
        System.out.printf("Case #%d: %s%n", caseNumber, result);
    }
}