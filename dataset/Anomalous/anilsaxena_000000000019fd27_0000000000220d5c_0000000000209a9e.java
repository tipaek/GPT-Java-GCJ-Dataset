import java.io.*;
import java.util.*;

public class Solution {
    private static boolean debug = false;
    private static int B;

    public static void main(String[] args) {
        solveProblem(System.in);
    }

    private static void solveProblem(InputStream input) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(input)));
        int testCases = scanner.nextInt();
        B = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            solveTestCase(scanner);
        }
    }

    private static void solveTestCase(Scanner scanner) {
        List<int[]> answers = new ArrayList<>();
        
        for (int loop = 0; loop < 4; loop++) {
            int[] answer = new int[B];
            answers.add(answer);
            for (int i = 0; i < 10; i++) {
                printOut(String.valueOf(i + 1));
                answer[i] = scanner.nextInt();
            }
        }

        StringBuilder result = new StringBuilder();
        for (int num : answers.get(3)) {
            result.append(num);
        }
        printOut(result.toString());

        String resultResponse = scanner.next();
        if (!resultResponse.equals("Y")) {
            throw new AssertionError("Failed " + resultResponse);
        }
    }

    private static void printOut(String message) {
        System.out.println(message);
    }

    private static void printDebug(Object message) {
        if (debug) {
            System.out.println(message);
        }
    }

    private static String getTokenSeparatedString(Collection<?> values, String delimiter) {
        StringBuilder result = new StringBuilder();
        if (values != null) {
            Iterator<?> iterator = values.iterator();
            if (iterator.hasNext()) {
                result.append(iterator.next());
                while (iterator.hasNext()) {
                    result.append(delimiter).append(iterator.next());
                }
            }
        }
        return result.toString();
    }
}