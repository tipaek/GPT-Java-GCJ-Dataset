import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    static Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) {
        int cases = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < cases; i++) {
            char[] line = sc.nextLine().toCharArray();
            processCase(line, i + 1);
        }
    }

    private static void processCase(char[] inputArray, int caseNumber) {
        if (inputArray.length == 1 && inputArray[0] == '0') {
            printResult(caseNumber, String.valueOf(inputArray[0]));
        } else if (inputArray.length == 1) {
            printResult(caseNumber, wrapWithParentheses(Integer.parseInt(String.valueOf(inputArray[0]))));
        } else {
            printResult(caseNumber, matchParentheses(inputArray));
        }
    }

    private static String wrapWithParentheses(int number) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < number; i++) {
            result.append("(");
        }
        result.append(number);
        for (int i = 0; i < number; i++) {
            result.append(")");
        }
        return result.toString();
    }

    private static void printResult(int caseNumber, String result) {
        System.out.println("Case #" + caseNumber + ": " + result);
    }

    private static String matchParentheses(char[] inputArray) {
        StringBuilder result = new StringBuilder(wrapWithParentheses(Character.getNumericValue(inputArray[0])));
        for (int i = 1; i < inputArray.length; i++) {
            int current = Character.getNumericValue(inputArray[i]);
            int previous = Character.getNumericValue(inputArray[i - 1]);
            result = adjustParentheses(result, current, previous);
        }
        return result.toString();
    }

    private static StringBuilder adjustParentheses(StringBuilder result, int current, int previous) {
        if (current == 0) {
            result.append(current);
        } else if (current <= previous) {
            result.append(")".repeat(previous - current));
            result.append(current);
        } else {
            result.append("(".repeat(current - previous));
            result.append(current);
        }
        return result;
    }
}