import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        int bitLength = scanner.nextInt();
        for (int i = 1; i <= testCases; ++i) {
            processTestCase(scanner, bitLength);
        }
    }

    public static boolean processTestCase(Scanner scanner, int bitLength) {
        int differingIndex = -1, sameIndex = -1;
        int[] bitsArray = new int[bitLength];
        int queryCount = 0;

        for (int i = 0; i <= (bitLength - 1) / 2; i++) {
            if (queryCount > 0 && queryCount % 10 == 0) {
                handleTransformation(scanner, bitsArray, differingIndex, sameIndex, i);
                queryCount += 2;
            }

            bitsArray[i] = queryBit(scanner, i + 1);
            bitsArray[bitLength - i - 1] = queryBit(scanner, bitLength - i);
            queryCount += 2;

            if (differingIndex == -1 && bitsArray[i] != bitsArray[bitLength - i - 1]) {
                differingIndex = i;
            }
            if (sameIndex == -1 && bitsArray[i] == bitsArray[bitLength - i - 1]) {
                sameIndex = i;
            }
        }

        return submitBits(scanner, bitsArray);
    }

    private static void handleTransformation(Scanner scanner, int[] bitsArray, int differingIndex, int sameIndex, int currentIndex) {
        if (differingIndex == -1 || sameIndex == -1) {
            int targetIndex = (differingIndex == -1) ? sameIndex : differingIndex;
            int targetBit = queryBit(scanner, targetIndex + 1);
            if (targetBit != bitsArray[targetIndex]) {
                complementArray(bitsArray, currentIndex);
            }
            queryBit(scanner, 1); // Burn a query
        } else {
            boolean sameChanged = queryBit(scanner, sameIndex + 1) != bitsArray[sameIndex];
            boolean diffChanged = queryBit(scanner, differingIndex + 1) != bitsArray[differingIndex];

            if (sameChanged && diffChanged) {
                complementArray(bitsArray, currentIndex);
            } else if (diffChanged) {
                reverseArray(bitsArray, currentIndex);
            } else if (sameChanged) {
                complementAndReverseArray(bitsArray, currentIndex);
            }
        }
    }

    private static int queryBit(Scanner scanner, int position) {
        System.out.println(position);
        return scanner.nextInt();
    }

    private static boolean submitBits(Scanner scanner, int[] bitsArray) {
        StringBuilder result = new StringBuilder();
        for (int bit : bitsArray) {
            result.append(bit);
        }
        System.out.println(result.toString());
        return "Y".equals(scanner.next());
    }

    private static void complementArray(int[] array, int length) {
        for (int i = 0; i <= length; i++) {
            array[i] = 1 - array[i];
            array[array.length - i - 1] = 1 - array[array.length - i - 1];
        }
    }

    private static void reverseArray(int[] array, int length) {
        for (int i = 0; i <= length; i++) {
            int temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }
    }

    private static void complementAndReverseArray(int[] array, int length) {
        for (int i = 0; i <= length; i++) {
            int temp = 1 - array[i];
            array[i] = 1 - array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }
    }
}