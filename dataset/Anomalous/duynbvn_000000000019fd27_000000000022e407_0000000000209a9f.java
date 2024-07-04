import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfTestCases = scanner.nextInt();

        for (int testCase = 1; testCase <= numberOfTestCases; testCase++) {
            String input = scanner.next();
            char[] characters = input.toCharArray();
            List<Character> resultList = new ArrayList<>();
            int maxNestingLevel = 0;

            for (char character : characters) {
                int digit = Character.getNumericValue(character);
                if (digit != 0) {
                    List<Character> wrappedCharacters = wrapWithParentheses(digit, character);
                    if (digit > maxNestingLevel) {
                        maxNestingLevel = digit;
                    }
                    resultList.addAll(wrappedCharacters);
                } else {
                    resultList.add(character);
                }
            }

            StringBuilder resultBuilder = new StringBuilder();
            for (char c : resultList) {
                resultBuilder.append(c);
            }

            String resultString = resultBuilder.toString();
            for (int i = 0; i < maxNestingLevel; i++) {
                resultString = resultString.replace(")(", "");
            }

            System.out.println("Case #" + testCase + ": " + resultString);
        }
    }

    private static List<Character> wrapWithParentheses(int count, char character) {
        List<Character> wrappedList = new ArrayList<>(count * 2 + 1);
        for (int i = 0; i < count; i++) {
            wrappedList.add('(');
        }
        wrappedList.add(character);
        for (int i = 0; i < count; i++) {
            wrappedList.add(')');
        }
        return wrappedList;
    }
}