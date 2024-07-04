import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        String[] settings = scanner.nextLine().split(" ");
        int testCases = Integer.parseInt(settings[0]);
        int bytes = Integer.parseInt(settings[1]);

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            handleTestCase(scanner, bytes);
        }
        scanner.close();
    }

    private static void handleTestCase(Scanner scanner, int bytes) {
        int[] byteState = new int[bytes + 1];
        boolean foundEqualPair = false, foundUnequalPair = false;
        int equalPairIndex = 0, unequalPairIndex = 0;
        int nextIndex = 1;
        int target = bytes / 2;
        int doublePeekCounter = 0;

        while (nextIndex <= target) {
            int lowValue = queryBit(nextIndex, scanner);
            int highIndex = bytes + 1 - nextIndex;
            int highValue = queryBit(highIndex, scanner);

            if (!foundEqualPair && lowValue == highValue) {
                foundEqualPair = true;
                equalPairIndex = nextIndex;
            } else if (!foundUnequalPair && lowValue != highValue) {
                foundUnequalPair = true;
                unequalPairIndex = nextIndex;
            }

            byteState[nextIndex] = lowValue;
            byteState[highIndex] = highValue;
            nextIndex++;
            doublePeekCounter++;

            if (doublePeekCounter == 5 && nextIndex <= target) {
                adjustByteState(scanner, byteState, bytes, foundEqualPair, foundUnequalPair, equalPairIndex, unequalPairIndex);
                doublePeekCounter = 1;
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= bytes; i++) {
            result.append(byteState[i]);
        }
        System.out.println(result.toString());
        scanner.nextLine();
    }

    private static void adjustByteState(Scanner scanner, int[] byteState, int bytes, boolean foundEqualPair, boolean foundUnequalPair, int equalPairIndex, int unequalPairIndex) {
        if (!foundEqualPair || !foundUnequalPair) {
            queryBit(1, scanner);
            int newValue = queryBit(1, scanner);
            if (newValue != byteState[1]) {
                complementBytes(byteState, bytes);
            }
        } else {
            boolean equalChanged = byteState[equalPairIndex] != queryBit(equalPairIndex, scanner);
            boolean unequalChanged = byteState[unequalPairIndex] != queryBit(unequalPairIndex, scanner);

            if (equalChanged && unequalChanged) {
                complementBytes(byteState, bytes);
            } else if (unequalChanged) {
                reverseBytes(byteState, bytes);
            } else if (equalChanged) {
                complementBytes(byteState, bytes);
                reverseBytes(byteState, bytes);
            }
        }
    }

    private static void complementBytes(int[] byteState, int bytes) {
        for (int i = 1; i <= bytes / 2; i++) {
            byteState[i] = 1 - byteState[i];
            byteState[bytes + 1 - i] = 1 - byteState[bytes + 1 - i];
        }
    }

    private static void reverseBytes(int[] byteState, int bytes) {
        for (int i = 1; i <= bytes / 2; i++) {
            int temp = byteState[i];
            byteState[i] = byteState[bytes + 1 - i];
            byteState[bytes + 1 - i] = temp;
        }
    }

    private static int queryBit(int position, Scanner scanner) {
        System.out.println(position);
        return Integer.parseInt(scanner.nextLine());
    }
}