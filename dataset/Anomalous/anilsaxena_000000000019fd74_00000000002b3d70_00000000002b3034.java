import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Solution {
    private static boolean debug = false;
    private static int N;
    private static String[] A;

    private static void solveProblem(InputStream inputStream) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(inputStream)));
        int testCount = scanner.nextInt();
        for (int t = 1; t <= testCount; t++) {
            N = scanner.nextInt();
            A = new String[N];
            for (int i = 0; i < N; i++) {
                A[i] = scanner.next();
            }
            Object result = solveTestCase();
            System.out.println("Case #" + t + ": " + result);
        }
    }

    private static Object solveTestCase() {
        StringBuilder resultBuilder = new StringBuilder();
        String[] reversedStrings = new String[N];
        for (int i = 0; i < N; i++) {
            reversedStrings[i] = new StringBuilder(A[i]).reverse().toString();
        }
        for (int i = 0; i < 100; i++) {
            char commonChar = 0;
            for (String str : reversedStrings) {
                if (str.length() <= i) {
                    continue;
                }
                char currentChar = str.charAt(i);
                if (currentChar == '*') {
                    continue;
                }
                if (commonChar == 0) {
                    commonChar = currentChar;
                } else if (commonChar != currentChar) {
                    return "*";
                }
            }
            if (commonChar == 0) {
                break;
            }
            resultBuilder.append(commonChar);
        }
        return resultBuilder.reverse().toString();
    }

    private static String joinValues(List<?> list, String delimiter) {
        return list.stream().map(Object::toString).collect(Collectors.joining(delimiter));
    }

    private static String joinValues(int[] array, String delimiter) {
        return Arrays.stream(array).mapToObj(Integer::toString).collect(Collectors.joining(delimiter));
    }

    private static int[] readInts(Scanner scanner, int count) {
        int[] array = new int[count];
        for (int i = 0; i < count; i++) {
            array[i] = scanner.nextInt();
        }
        return array;
    }

    public static void printDebug(Object message) {
        if (debug) {
            System.out.println("DEBUG: " + message);
        }
    }

    public static void main(String[] args) throws Exception {
        long startTime = System.currentTimeMillis();
        if (debug) {
            solveProblem(new FileInputStream(new File("input.in")));
            System.out.println("Time: " + (System.currentTimeMillis() - startTime));
        } else {
            solveProblem(System.in);
        }
    }
}