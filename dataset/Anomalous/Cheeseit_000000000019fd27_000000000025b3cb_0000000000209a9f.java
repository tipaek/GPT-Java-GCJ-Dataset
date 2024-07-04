import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int testcases = scanner.nextInt();
            scanner.nextLine();
            for (int i = 0; i < testcases; i++) {
                String s = scanner.nextLine();
                printSolution(i + 1, s);
            }
        }
    }

    public static void printSolution(int testcase, String s) {
        int[] array = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            array[i] = Character.getNumericValue(s.charAt(i));
        }
        String result = createString(array);
        System.out.printf("Case #%d: %s%n", testcase, result);
    }

    public static String createString(int[] array) {
        StringBuilder stringBuilder = new StringBuilder();
        Queue<String> parentheses = new ArrayDeque<>();
        final String OPEN = "(";
        final String CLOSE = ")";

        for (int i = 0; i < array.length; i++) {
            if (array[0] == 0) {
                clearQueue(stringBuilder, parentheses);
                stringBuilder.append(0);
            } else {
                if (parentheses.isEmpty()) {
                    appendParentheses(stringBuilder, parentheses, OPEN, CLOSE, array[i]);
                    stringBuilder.append(array[i]);
                } else if (array[i] < array[i - 1]) {
                    appendClosingParentheses(stringBuilder, parentheses, array[i - 1] - array[i]);
                    stringBuilder.append(array[i]);
                } else if (array[i] > array[i - 1]) {
                    appendParentheses(stringBuilder, parentheses, OPEN, CLOSE, array[i] - array[i - 1]);
                    stringBuilder.append(array[i]);
                } else {
                    stringBuilder.append(array[i]);
                }
            }
        }

        clearQueue(stringBuilder, parentheses);
        return stringBuilder.toString();
    }

    private static void appendParentheses(StringBuilder stringBuilder, Queue<String> parentheses, String open, String close, int count) {
        for (int j = 0; j < count; j++) {
            stringBuilder.append(open);
            parentheses.add(close);
        }
    }

    private static void appendClosingParentheses(StringBuilder stringBuilder, Queue<String> parentheses, int count) {
        for (int j = 0; j < count; j++) {
            stringBuilder.append(parentheses.poll());
        }
    }

    private static void clearQueue(StringBuilder stringBuilder, Queue<String> parentheses) {
        while (!parentheses.isEmpty()) {
            stringBuilder.append(parentheses.poll());
        }
    }
}