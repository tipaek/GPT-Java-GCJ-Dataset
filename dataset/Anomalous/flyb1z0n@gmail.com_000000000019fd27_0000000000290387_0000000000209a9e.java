import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class Solution {
    private static final int FLAG_SAME = 1;
    private static final int FLAG_DIFFERENT = 0;
    private static final int UNDEFINED = -1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCaseCount = scanner.nextInt();
        int bitsCount = scanner.nextInt();
        PrintWriter writer = new PrintWriter(System.out, true);

        for (int t = 1; t <= testCaseCount; t++) {
            if (!processTestCase(scanner, writer, bitsCount)) {
                System.exit(0);
            }
        }
    }

    private static boolean processTestCase(Scanner scanner, PrintWriter writer, int bitsCount) {
        int[] flag = new int[bitsCount / 2 + 1];
        int[] values = new int[bitsCount / 2 + 1];
        initializeArrays(flag, values);

        int requestCount = 0;
        int pointer = 1;

        while (pointer <= bitsCount / 2) {
            if (requestCount != 0 && requestCount % 10 == 0) {
                requestCount += handleRecalculation(scanner, writer, flag, values);
                continue;
            }

            int leftValue = makeRequest(scanner, writer, pointer);
            int rightValue = makeRequest(scanner, writer, bitsCount - pointer + 1);
            values[pointer] = leftValue;
            flag[pointer] = (leftValue == rightValue) ? FLAG_SAME : FLAG_DIFFERENT;
            requestCount += 2;
            pointer++;
        }

        writer.println(constructResultString(values, flag));
        writer.flush();
        return "Y".equals(scanner.next());
    }

    private static void initializeArrays(int[] flag, int[] values) {
        for (int i = 0; i < values.length; i++) {
            values[i] = UNDEFINED;
            flag[i] = UNDEFINED;
        }
    }

    private static int handleRecalculation(Scanner scanner, PrintWriter writer, int[] flag, int[] values) {
        int requestCount = 0;
        int sameIndex = findFirst(flag, FLAG_SAME);
        if (sameIndex > 0) {
            int sameValue = makeRequest(scanner, writer, sameIndex);
            if (values[sameIndex] != sameValue) {
                invertValues(flag, values, FLAG_SAME);
            }
            requestCount++;
        } else {
            makeRequest(scanner, writer, 1);
            requestCount++;
        }

        int differentIndex = findFirst(flag, FLAG_DIFFERENT);
        if (differentIndex > 0) {
            int differentValue = makeRequest(scanner, writer, differentIndex);
            if (values[differentIndex] != differentValue) {
                invertValues(flag, values, FLAG_DIFFERENT);
            }
            requestCount++;
        } else {
            makeRequest(scanner, writer, 1);
            requestCount++;
        }
        return requestCount;
    }

    private static void invertValues(int[] flag, int[] values, int targetValue) {
        for (int i = 0; i < flag.length; i++) {
            if (flag[i] == targetValue) {
                values[i] = invert(values[i]);
            }
        }
    }

    private static int invert(int value) {
        return value == 1 ? 0 : 1;
    }

    private static int findFirst(int[] flag, int targetValue) {
        for (int i = 0; i < flag.length; i++) {
            if (flag[i] == targetValue) {
                return i;
            }
        }
        return UNDEFINED;
    }

    private static int makeRequest(Scanner scanner, PrintWriter writer, int index) {
        writer.println(index);
        writer.flush();
        return scanner.nextInt();
    }

    private static String constructResultString(int[] values, int[] flag) {
        StringBuilder result = new StringBuilder();
        for (int i = 1; i < values.length; i++) {
            result.append(values[i]);
        }
        for (int i = values.length - 1; i >= 1; i--) {
            int value = (flag[i] == FLAG_SAME) ? values[i] : invert(values[i]);
            result.append(value);
        }
        return result.toString();
    }
}