import java.util.Scanner;

/**
 * Created by Rene Argento on 03/04/20.
 */
// https://codingcompetitions.withgoogle.com/codejam/round/000000000019fd27/0000000000209a9e
public class Solution {

    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        int tests = scanner.nextInt();
        int bitsSize = scanner.nextInt();
        scanner.nextLine();

        for (int t = 0; t < tests; t++) {
            String bits = getBits(bitsSize);
            System.out.println(bits);
            String result = scanner.nextLine();
            if (result.charAt(0) == 'N') {
                return;
            }
        }
    }

    public static String getBits(int bitsSize) {
        int[] bits = new int[bitsSize];
        int referenceSize = 3;
        int tries = 144;

        for (int i = 0; i < bitsSize; i++) {
            bits[i] = -1;
        }

        int startIndex = 0;
        if (bitsSize == 20) {
            startIndex = 5;
        } else if (bitsSize == 100) {
            startIndex = 17;
        }
        int complementIndex = startIndex + (bitsSize / 2);

        getInitialValues(bits, startIndex, referenceSize);
        getInitialValues(bits, complementIndex, referenceSize);

        for (int i = 1; i <= tries; i++) {
            int index = getNextBitIndex(bits);
            if (index == -1) {
                return getBitsString(bits);
            }

            if (i % 10 == 1 && i != 1) {
                int[] leftSide = getReferenceValues(bits, startIndex, referenceSize);
                int[] rightSide = getReferenceValues(bits, complementIndex, referenceSize);

                getInitialValues(bits, startIndex, referenceSize);
                boolean isComplement = isComplement(bits, leftSide, startIndex);
                boolean isReverse = isReverse(bits, rightSide, startIndex);

                if (isComplement) {
                    complementArray(bits);
                }
                if (isReverse) {
                    reverseArray(bits);
                }
                i += 3;
            } else {
                System.out.println(index + 1);
                String value = scanner.nextLine();
                bits[index] = Integer.parseInt(value);
            }
        }
        return getBitsString(bits);
    }

    private static void getInitialValues(int[] bits, int startIndex, int referenceSize ) {
        for (int i = startIndex; i < startIndex + 5; i++) {
            System.out.println(i);
            String value = scanner.nextLine();
            bits[i] = Integer.parseInt(value);
        }
    }

    private static int[] getReferenceValues(int[] bits, int startIndex, int size) {
        int[] reference = new int[10];
        for (int i = startIndex; i < startIndex + size; i++) {
            reference[i] = bits[i];
        }
        return reference;
    }

    private static int getNextBitIndex(int[] bits) {
        for (int i = 0; i < bits.length; i++) {
            if (bits[i] == -1) {
                return i;
            }
        }
        return -1;
    }

    private static String getBitsString(int[] bits) {
        StringBuilder bitString = new StringBuilder();
        for (int bit : bits) {
            bitString.append(bit);
        }
        return bitString.toString();
    }

    private static boolean isComplement(int[] bits, int[] oldValues, int index) {
        for (int i = 0; i < oldValues.length; i++) {
            if (bits[index + i] == oldValues[i]) {
                return false;
            }
        }
        return true;
    }

    private static boolean isReverse(int[] bits, int[] oldValues, int index) {
        for (int i = 0; i < oldValues.length; i++) {
            if (bits[index + i] != oldValues[i]) {
                return false;
            }
        }
        return true;
    }

    private static void complementArray(int[] bits) {
        for (int i = 0; i < bits.length; i++) {
            bits[i] = 1 - bits[i];
        }
    }

    private static void reverseArray(int[] bits) {
        for (int i = 0; i < bits.length / 2; i++) {
            bits[i] = bits[bits.length - 1 - i];
        }
    }

}
