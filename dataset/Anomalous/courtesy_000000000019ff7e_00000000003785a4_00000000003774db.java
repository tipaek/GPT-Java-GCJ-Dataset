import java.io.*;
import java.util.*;

public class Solution {

    public static Scanner scanner = new Scanner(System.in);
    public static OutputWriter outputWriter = new OutputWriter();

    public static String s1, s2;
    public static int l1, l2;
    public static Map<String, Result> memoization;
    public static int minOperations, difference;
    public static String resultString;

    public static void main(String[] args) throws Exception {
        int testCases = scanner.nextInt();
        memoization = new HashMap<>();
        for (int cs = 1; cs <= testCases; cs++) {
            s1 = scanner.next();
            s2 = scanner.next();
            l1 = s1.length();
            l2 = s2.length();
            memoization.clear();
            difference = minOperations = Integer.MAX_VALUE;

            System.out.print("Case #" + cs + ": ");

            calculateOperations(0, 0, 0, "");

            if (resultString.isEmpty()) {
                throw new Exception("Result string is empty");
            }

            System.out.println(resultString);
        }
    }

    public static Result calculateOperations(int p1, int p2, int currentOperations, String currentString) {
        Result result;
        String key = p1 + ":" + p2 + ":" + currentOperations;
        int remainingOperations = -1;

        if (memoization.containsKey(key)) {
            result = memoization.get(key);
            remainingOperations = result.remainingOperations;
        } else {
            result = new Result();
            if (p1 == l1) {
                result.remainingOperations = l2 - p2;
                result.resultSubstring = "";
                remainingOperations = result.remainingOperations;
                if (result.remainingOperations > currentOperations + 1) {
                    int k = (result.remainingOperations - currentOperations) / 2;
                    currentOperations += k;
                    remainingOperations -= k;
                    result.resultSubstring = s2.substring(p2, p2 + k);
                }
            } else if (p2 == l2) {
                result.remainingOperations = l1 - p1;
                result.resultSubstring = s1.substring(p1);
                remainingOperations = result.remainingOperations;
                if (result.remainingOperations > currentOperations + 1) {
                    int k = (result.remainingOperations - currentOperations) / 2;
                    currentOperations += k;
                    remainingOperations -= k;
                    result.resultSubstring = s1.substring(p1 + k);
                }
            } else {
                Result nextResult;
                if (s1.charAt(p1) == s2.charAt(p2)) {
                    nextResult = calculateOperations(p1 + 1, p2 + 1, currentOperations, currentString + s1.charAt(p1));
                    result.remainingOperations = nextResult.remainingOperations;
                    result.resultSubstring = s1.substring(p1);
                } else {
                    nextResult = calculateOperations(p1 + 1, p2, currentOperations + 1, currentString);
                    result.remainingOperations = nextResult.remainingOperations;
                    result.resultSubstring = s1.substring(p1);

                    nextResult = calculateOperations(p1, p2 + 1, currentOperations + 1, currentString + s2.charAt(p2));
                    if (nextResult.remainingOperations < result.remainingOperations) {
                        result.remainingOperations = nextResult.remainingOperations;
                        result.resultSubstring = s1.substring(p1);
                    }

                    nextResult = calculateOperations(p1 + 1, p2 + 1, currentOperations + 1, currentString + s2.charAt(p2));
                    if (nextResult.remainingOperations < result.remainingOperations) {
                        result.remainingOperations = nextResult.remainingOperations;
                        result.resultSubstring = s1.substring(p1);
                    }

                    result.remainingOperations++;
                }
                remainingOperations = result.remainingOperations;
            }
            memoization.put(key, result);
        }

        if (currentOperations + remainingOperations < minOperations) {
            minOperations = currentOperations + remainingOperations;
            difference = Math.abs(currentOperations - remainingOperations);
            resultString = currentString + result.resultSubstring;
        } else if (currentOperations + remainingOperations == minOperations && Math.abs(currentOperations - remainingOperations) < difference) {
            minOperations = currentOperations + remainingOperations;
            difference = Math.abs(currentOperations - remainingOperations);
            resultString = currentString + result.resultSubstring;
        }

        return result;
    }

    static class Result {
        int remainingOperations;
        String resultSubstring;
    }

    static class OutputWriter {
        private final PrintWriter writer;

        public OutputWriter() {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        }

        public void print(Object... objects) {
            for (int i = 0; i < objects.length; i++) {
                if (i != 0) writer.print(' ');
                writer.print(objects[i]);
            }
        }

        public void printLine(Object... objects) {
            print(objects);
            writer.println();
        }

        public void close() {
            writer.close();
        }

        public void flush() {
            writer.flush();
        }
    }
}