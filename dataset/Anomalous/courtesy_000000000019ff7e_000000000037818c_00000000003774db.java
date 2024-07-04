import java.io.*;
import java.util.*;

public class Solution {

    public static Scanner scanner = new Scanner(System.in);
    public static OutputWriter outputWriter = new OutputWriter();

    public static String s1, s2;
    public static int l1, l2;
    public static Map<String, Operation> dp;
    public static int minOperations, difference;
    public static String result;

    public static void main(String[] args) {
        int testCases = scanner.nextInt();
        dp = new HashMap<>();
        for (int cs = 1; cs <= testCases; cs++) {
            s1 = scanner.next();
            s2 = scanner.next();
            l1 = s1.length();
            l2 = s2.length();
            dp.clear();
            difference = minOperations = Integer.MAX_VALUE;

            System.out.print("Case #" + cs + ": ");
            findMinOperations(0, 0, 0, "");

            System.out.println(result);
        }
    }

    public static Operation findMinOperations(int p1, int p2, int current, String currentStr) {
        String key = p1 + ":" + p2 + ":" + current;
        Operation operation = dp.getOrDefault(key, new Operation());

        if (operation.isInitialized()) {
            return operation;
        }

        if (p1 == l1) {
            operation.remaining = l2 - p2;
            operation.str = "";
        } else if (p2 == l2) {
            operation.remaining = l1 - p1;
            operation.str = s1.substring(p1);
        } else {
            if (s1.charAt(p1) == s2.charAt(p2)) {
                Operation nextOperation = findMinOperations(p1 + 1, p2 + 1, current, currentStr + s1.charAt(p1));
                operation.remaining = nextOperation.remaining;
                operation.str = s1.substring(p1);
            } else {
                Operation nextOperation = findMinOperations(p1 + 1, p2, current + 1, currentStr);
                operation.remaining = nextOperation.remaining;
                operation.str = s1.substring(p1);

                nextOperation = findMinOperations(p1, p2 + 1, current + 1, currentStr + s2.charAt(p2));
                if (nextOperation.remaining < operation.remaining) {
                    operation.remaining = nextOperation.remaining;
                    operation.str = s1.substring(p1);
                }

                nextOperation = findMinOperations(p1 + 1, p2 + 1, current + 1, currentStr + s2.charAt(p2));
                if (nextOperation.remaining < operation.remaining) {
                    operation.remaining = nextOperation.remaining;
                    operation.str = s1.substring(p1);
                }
                operation.remaining++;
            }
        }

        dp.put(key, operation);

        if (current + operation.remaining < minOperations) {
            minOperations = current + operation.remaining;
            difference = Math.abs(current - operation.remaining);
            result = currentStr + s1.substring(p1);
        } else if (current + operation.remaining == minOperations && Math.abs(current - operation.remaining) < difference) {
            minOperations = current + operation.remaining;
            difference = Math.abs(current - operation.remaining);
            result = currentStr + s1.substring(p1);
        }

        return operation;
    }

    static class Operation {
        int remaining;
        String str;

        boolean isInitialized() {
            return str != null;
        }
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