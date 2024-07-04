import java.io.*;
import java.util.*;

public class Solution {
    private static final boolean DEBUG = false;
    private static int B;

    public static void main(String[] args) {
        solveProblem(System.in);
    }

    private static void solveProblem(InputStream input) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(input)));
        int testCases = scanner.nextInt();
        B = scanner.nextInt();
        for (int i = 1; i <= testCases; ++i) {
            if (B == 10) {
                solveTestCaseB10(scanner);
            } else if (B == 20) {
                solveTestCaseB20(scanner);
            } else {
                // solveTestCase(scanner);
            }
        }
    }

    private static void solveTestCaseB10(Scanner scanner) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            printOut(String.valueOf(i + 1));
            result.append(scanner.nextInt());
        }

        printOut(result.toString());
        String resultResponse = scanner.next();
        if (!resultResponse.equals("Y")) {
            throw new AssertionError("Failed " + resultResponse);
        }
    }

    private static void solveTestCaseB20(Scanner scanner) {
        boolean[] same = new boolean[B / 2];
        findSameness(scanner, 0, same);
        findSameness(scanner, 5, same);
        int[] answer = new int[B];
        findAnswers(scanner, 0, answer);

        for (int i = 0; i < B / 2; i++) {
            if (same[i]) {
                answer[B - i - 1] = answer[i];
            } else {
                answer[B - i - 1] = 1 - answer[i];
            }
        }

        StringBuilder result = new StringBuilder();
        for (int value : answer) {
            result.append(value);
        }

        printOut(result.toString());
        String resultResponse = scanner.next();
        if (!resultResponse.equals("Y")) {
            throw new AssertionError("Failed " + resultResponse + "\n" + printArr(same));
        }
    }

    private static void findAnswers(Scanner scanner, int startIndex, int[] answers) {
        for (int i = startIndex; i < startIndex + 10; i++) {
            printOut(String.valueOf(i + 1));
            answers[i] = scanner.nextInt();
        }
    }

    private static void findSameness(Scanner scanner, int startIndex, boolean[] same) {
        for (int i = startIndex; i < startIndex + 5; i++) {
            printOut(String.valueOf(i + 1));
            int left = scanner.nextInt();
            printOut(String.valueOf(B - i));
            int right = scanner.nextInt();
            same[i] = (left == right);
        }
    }

    private static void printOut(String output) {
        System.out.println(output);
    }

    private static String printArr(boolean[] array) {
        StringBuilder builder = new StringBuilder();
        for (boolean element : array) {
            builder.append(element).append(" ");
        }
        return builder.toString();
    }

    private static void printDebug(Object message) {
        if (DEBUG) {
            System.out.println(message);
        }
    }

    private static String getTokenSeparatedString(Collection<?> values, String delimiter) {
        StringBuilder result = new StringBuilder();
        if (values != null) {
            Iterator<?> iterator = values.iterator();
            if (iterator.hasNext()) {
                result.append(iterator.next());
            }
            while (iterator.hasNext()) {
                result.append(delimiter).append(iterator.next());
            }
        }
        return result.toString();
    }
}