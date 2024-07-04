import java.io.*;
import java.util.*;

public class Solution {

    public static Scanner scanner = new Scanner(System.in);
    public static OutputWriter outputWriter = new OutputWriter();

    public static String s1, s2;
    public static int l1, l2;
    public static Map<String, Operation> memoization;
    public static int minOperations, diffOperations;
    public static String result;

    public static void main(String[] args) throws IOException {
        int testCases = scanner.nextInt();
        memoization = new HashMap<>();
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            s1 = scanner.next();
            s2 = scanner.next();
            l1 = s1.length();
            l2 = s2.length();
            memoization.clear();
            diffOperations = minOperations = Integer.MAX_VALUE;

            System.out.print("Case #" + caseNumber + ": ");
            findMinimumOperations(0, 0, 0, "");

            System.out.println(result);
        }
    }

    public static Operation findMinimumOperations(int index1, int index2, int currentOperations, String currentString) {
        String key = index1 + ":" + index2 + ":" + currentOperations;
        if (memoization.containsKey(key)) {
            return memoization.get(key);
        }

        Operation operation = new Operation();
        if (index1 == l1) {
            operation.remainingOperations = l2 - index2;
            operation.resultString = "";
        } else if (index2 == l2) {
            operation.remainingOperations = l1 - index1;
            operation.resultString = "";
        } else {
            if (s1.charAt(index1) == s2.charAt(index2)) {
                operation = findMinimumOperations(index1 + 1, index2 + 1, currentOperations, currentString + s1.charAt(index1));
                operation.resultString = s1.charAt(index1) + operation.resultString;
            } else {
                operation = findMinimumOperations(index1 + 1, index2, currentOperations + 1, currentString);
                Operation alternativeOperation = findMinimumOperations(index1, index2 + 1, currentOperations + 1, currentString + s2.charAt(index2));
                if (alternativeOperation.remainingOperations < operation.remainingOperations) {
                    operation = alternativeOperation;
                    operation.resultString = s2.charAt(index2) + operation.resultString;
                }
                alternativeOperation = findMinimumOperations(index1 + 1, index2 + 1, currentOperations + 1, currentString + s2.charAt(index2));
                if (alternativeOperation.remainingOperations < operation.remainingOperations) {
                    operation = alternativeOperation;
                    operation.resultString = s2.charAt(index2) + operation.resultString;
                }
                operation.remainingOperations++;
            }
        }

        memoization.put(key, operation);

        if (currentOperations + operation.remainingOperations < minOperations) {
            minOperations = currentOperations + operation.remainingOperations;
            diffOperations = Math.abs(currentOperations - operation.remainingOperations);
            result = currentString + s1.substring(index1);
        } else if (currentOperations + operation.remainingOperations == minOperations && Math.abs(currentOperations - operation.remainingOperations) < diffOperations) {
            minOperations = currentOperations + operation.remainingOperations;
            diffOperations = Math.abs(currentOperations - operation.remainingOperations);
            result = currentString + s1.substring(index1);
        }

        return operation;
    }

    static class Operation {
        int remainingOperations;
        String resultString;
    }

    static class OutputWriter {
        private final PrintWriter writer;

        public OutputWriter() {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        }

        public void print(Object... objects) {
            for (int i = 0; i < objects.length; i++) {
                if (i != 0) {
                    writer.print(' ');
                }
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