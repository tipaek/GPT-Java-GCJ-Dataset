import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.String.format;

public class Solution {

    public static void main(String[] args) {
        Scanner in = newScanner();
        PrintStream out = System.out;

        int testCases = in.nextInt();
        in.nextLine();

        for (int t = 1; t <= testCases; t++) {
            Input input = readTestCase(in, t);
            Output output = solve(input);
            printOutput(out, output);
        }
    }

    private static Output solve(Input input) {
        int[] digits = toDigitsWithEncompassingZeroes(input.getDigitsString());
        Character[] resultWithEncompassingZeroes = doSolve(digits);
        String result = toStringRemovingEncompassingZeroes(resultWithEncompassingZeroes);
        return new Output(input.getTestCase(), result);
    }

    private static Character[] doSolve(int[] digits) {
        List<Character> result = new ArrayList<>();
        int openedParentheses = 0;
        for (int digit : digits) {
            if (openedParentheses < digit) {
                int parenthesesToOpen = digit - openedParentheses;
                openParentheses(result, parenthesesToOpen);
                openedParentheses += parenthesesToOpen;
            } else if (openedParentheses > digit) {
                int parenthesesToClose = openedParentheses - digit;
                closeParentheses(result, parenthesesToClose);
                openedParentheses -= parenthesesToClose;
            }
            result.add(toChar(digit));
        }
        return result.toArray(new Character[0]);
    }

    private static void openParentheses(List<Character> result, int parenthesesToOpen) {
        addCharacterCopies(result, parenthesesToOpen, '(');
    }

    private static void closeParentheses(List<Character> result, int parenthesesToClose) {
        addCharacterCopies(result, parenthesesToClose, ')');
    }

    private static void addCharacterCopies(List<Character> result, int copiesCount, char c) {
        for (int i = 0; i < copiesCount; i++) {
            result.add(c);
        }
    }

    private static char toChar(int i) {
        return Character.forDigit(i, 10);
    }

    private static String toStringRemovingEncompassingZeroes(Character[] resultWithEncompassingZeroes) {
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i < resultWithEncompassingZeroes.length - 1; i++) {
            builder.append(resultWithEncompassingZeroes[i]);
        }
        return builder.toString();
    }

    private static int[] toDigitsWithEncompassingZeroes(String digitsString) {
        char[] chars = digitsString.toCharArray();
        int[] result = new int[chars.length + 2];
        result[0] = 0;
        result[result.length - 1] = 0;
        for (int i = 0; i < chars.length; i++) {
            result[i + 1] = Character.getNumericValue(chars[i]);
        }
        return result;
    }

    private static Scanner newScanner() {
        return new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    }

    private static Input readTestCase(Scanner in, int testCase) {
        String digitsString = in.nextLine();
        return new Input(testCase, digitsString);
    }

    private static void printOutput(PrintStream out, Output output) {
        String outputString = format("Case #%s: %s",
                output.getTestCase(),
                output.getDigitsWithParentheses());

        out.println(outputString);
    }

    private static class Input {

        private final int testCase;
        private final String digitsString;

        private Input(int testCase, String digitsString) {
            this.testCase = testCase;
            this.digitsString = digitsString;
        }

        public int getTestCase() {
            return testCase;
        }

        public String getDigitsString() {
            return digitsString;
        }
    }

    private static class Output {

        private final int testCase;
        private final String digitsWithParentheses;

        public Output(int testCase, String digitsWithParentheses) {
            this.testCase = testCase;
            this.digitsWithParentheses = digitsWithParentheses;
        }

        public int getTestCase() {
            return testCase;
        }

        public String getDigitsWithParentheses() {
            return digitsWithParentheses;
        }
    }
}
