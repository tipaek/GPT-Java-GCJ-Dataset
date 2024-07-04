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
        PrintWriter printWriter = new PrintWriter(System.out, true);

        for (int t = 1; t <= testCaseCount; t++) {
            if (!processTestCase(scanner, printWriter, bitsCount)) {
                System.exit(0);
            }
        }
    }

    private static boolean processTestCase(Scanner scanner, PrintWriter printWriter, int bitsCount) {
        int[] flags = new int[bitsCount / 2 + 1];
        int[] bitsArray = new int[bitsCount / 2 + 1];

        initializeArrays(flags, bitsArray);

        int requestCount = 0;
        int pointer = 1;

        while (pointer <= bitsCount / 2) {
            if (requestCount != 0 && requestCount % 10 == 0) {
                requestCount += handleRecalculation(scanner, printWriter, flags, bitsArray);
                continue;
            }

            int leftValue = sendRequest(scanner, printWriter, pointer);
            int rightValue = sendRequest(scanner, printWriter, bitsCount - pointer + 1);
            bitsArray[pointer] = leftValue;
            flags[pointer] = (leftValue == rightValue) ? FLAG_SAME : FLAG_DIFFERENT;
            requestCount += 2;
            pointer++;
        }

        String resultString = buildResultString(flags, bitsArray);
        printWriter.println(resultString);
        printWriter.flush();

        return "Y".equals(scanner.next());
    }

    private static void initializeArrays(int[] flags, int[] bitsArray) {
        for (int i = 0; i < bitsArray.length; i++) {
            bitsArray[i] = UNDEFINED;
            flags[i] = UNDEFINED;
        }
    }

    private static int handleRecalculation(Scanner scanner, PrintWriter printWriter, int[] flags, int[] bitsArray) {
        int requestCount = 0;

        int sameIndex = findIndex(flags, FLAG_SAME);
        if (sameIndex > 0) {
            int sameValue = sendRequest(scanner, printWriter, sameIndex);
            if (bitsArray[sameIndex] != sameValue) {
                invertArrayValues(flags, bitsArray, FLAG_SAME);
            }
            requestCount++;
        }

        int differentIndex = findIndex(flags, FLAG_DIFFERENT);
        if (differentIndex > 0) {
            int differentValue = sendRequest(scanner, printWriter, differentIndex);
            if (bitsArray[sameIndex] != differentValue) {
                invertArrayValues(flags, bitsArray, FLAG_DIFFERENT);
            }
            requestCount++;
        }

        return requestCount;
    }

    private static void invertArrayValues(int[] flags, int[] bitsArray, int value) {
        for (int i = 0; i < flags.length; i++) {
            if (flags[i] == value) {
                bitsArray[i] = invert(bitsArray[i]);
            }
        }
    }

    private static int invert(int value) {
        return (value == 1) ? 0 : 1;
    }

    private static int findIndex(int[] flags, int value) {
        for (int i = 0; i < flags.length; i++) {
            if (flags[i] == value) {
                return i;
            }
        }
        return UNDEFINED;
    }

    private static int sendRequest(Scanner scanner, PrintWriter printWriter, int index) {
        printWriter.println(index);
        printWriter.flush();
        return scanner.nextInt();
    }

    private static String buildResultString(int[] flags, int[] bitsArray) {
        StringBuilder resultBuilder = new StringBuilder();

        for (int i = 1; i < bitsArray.length; i++) {
            resultBuilder.append(bitsArray[i]);
        }

        for (int i = bitsArray.length - 1; i >= 1; i--) {
            int value = (flags[i] == FLAG_SAME) ? bitsArray[i] : invert(bitsArray[i]);
            resultBuilder.append(value);
        }

        return resultBuilder.toString();
    }
}