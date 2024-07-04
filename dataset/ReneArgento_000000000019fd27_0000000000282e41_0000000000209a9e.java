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
        int reverseIndex = bitsSize - 1 - startIndex;

        getValues(bits, startIndex, referenceSize);
        getReverseValues(bits, reverseIndex, referenceSize);

        for (int i = 7; i <= tries; i++) {
            int index = getNextBitIndex(bits);
            if (index == -1) {
                return getBitsString(bits);
            }

            if (i % 10 == 1 && i != 1) {
                int[] leftSide = getReferenceValues(bits, startIndex, referenceSize);
                int[] rightSide = getReferenceReverseValues(bits, reverseIndex, referenceSize);

                getValues(bits, startIndex, referenceSize);
                boolean isComplement = isComplement(bits, leftSide, startIndex);
                boolean isReverse = isReverse(bits, rightSide, startIndex);

                if (isComplement) {
                    complementArray(bits, startIndex, referenceSize);
                }
                if (isReverse) {
                    reverseArray(bits, startIndex, referenceSize);
                }
                i += 2;
            } else {
                System.out.println(index + 1);
                bits[index] = scanner.nextInt();
                scanner.nextLine();
            }
        }
        return getBitsString(bits);
    }

    private static void getValues(int[] bits, int startIndex, int referenceSize) {
        for (int i = startIndex; i < startIndex + referenceSize; i++) {
            System.out.println(i + 1);
            bits[i] = scanner.nextInt();
            scanner.nextLine();
        }
    }

    private static void getReverseValues(int[] bits, int startIndex, int referenceSize) {
        for (int i = startIndex; i > startIndex - referenceSize; i--) {
            System.out.println(i + 1);
            bits[i] = scanner.nextInt();
            scanner.nextLine();
        }
    }

    private static int[] getReferenceValues(int[] bits, int startIndex, int size) {
        int[] reference = new int[size];
        int referenceIndex = 0;

        for (int i = startIndex; i < startIndex + size; i++) {
            reference[referenceIndex++] = bits[i];
        }
        return reference;
    }

    private static int[] getReferenceReverseValues(int[] bits, int startIndex, int size) {
        int[] reference = new int[size];
        int referenceIndex = 0;

        for (int i = startIndex; i > startIndex - size; i--) {
            reference[referenceIndex++] = bits[i];
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

    private static void complementArray(int[] bits, int skipIndex, int skipSize) {
        for (int i = 0; i < bits.length; i++) {
            if (i >= skipIndex && i < skipIndex + skipSize) {
                continue;
            }

            if (bits[i] == 0) {
                bits[i] = 1;
            } else if (bits[i] == 1) {
                bits[i] = 0;
            }
        }
    }

    private static void reverseArray(int[] bits, int skipIndex, int skipSize) {
        for (int i = 0; i < bits.length / 2; i++) {
            if (i >= skipIndex && i < skipIndex + skipSize) {
                continue;
            }

            int temp = bits[i];
            bits[i] = bits[bits.length - 1 - i];
            bits[bits.length - 1 - i] = temp;
        }
    }

}
