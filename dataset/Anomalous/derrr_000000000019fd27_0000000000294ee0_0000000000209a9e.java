import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        int bitLength = scanner.nextInt();

        for (int i = 1; i <= testCases; i++) {
            processTestCase(scanner, bitLength);
        }
    }

    private static boolean processTestCase(Scanner scanner, int bitLength) {
        int diffIndex = -1, sameIndex = -1;
        int[] bits = new int[bitLength];
        int queryCount = 0;

        for (int i = 0; i <= (bitLength - 1) / 2; i++) {
            if (queryCount > 0 && queryCount % 10 == 0) {
                handleSpecialQueries(scanner, bits, diffIndex, sameIndex, i);
                queryCount += 2;
            }

            bits[i] = queryBit(scanner, i + 1);
            bits[bitLength - i - 1] = queryBit(scanner, bitLength - i);
            queryCount += 2;

            if (diffIndex == -1 && bits[i] != bits[bitLength - i - 1]) {
                diffIndex = i;
            }
            if (sameIndex == -1 && bits[i] == bits[bitLength - i - 1]) {
                sameIndex = i;
            }
        }

        System.out.println(arrayToString(bits));
        return "Y".equals(scanner.next());
    }

    private static int queryBit(Scanner scanner, int position) {
        System.out.println(position);
        return scanner.nextInt();
    }

    private static void handleSpecialQueries(Scanner scanner, int[] bits, int diffIndex, int sameIndex, int len) {
        if (diffIndex == -1 || sameIndex == -1) {
            int targetIndex = (diffIndex == -1) ? sameIndex : diffIndex;
            if (targetIndex != -1) {
                queryBit(scanner, targetIndex + 1);
                if (scanner.nextInt() != bits[targetIndex]) {
                    complementArray(bits, len);
                }
            }
            queryBit(scanner, 1);
            scanner.nextLine();
        } else {
            boolean sameChanged = queryBit(scanner, sameIndex + 1) != bits[sameIndex];
            boolean diffChanged = queryBit(scanner, diffIndex + 1) != bits[diffIndex];

            if (sameChanged && diffChanged) {
                complementArray(bits, len);
            } else if (diffChanged) {
                reverseArray(bits, len);
            } else if (sameChanged) {
                reverseAndComplementArray(bits, len);
            }
        }
    }

    private static void complementArray(int[] array, int len) {
        for (int i = 0; i <= len; i++) {
            array[i] = 1 - array[i];
            array[array.length - i - 1] = 1 - array[array.length - i - 1];
        }
    }

    private static void reverseArray(int[] array, int len) {
        for (int i = 0; i <= len; i++) {
            int temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }
    }

    private static void reverseAndComplementArray(int[] array, int len) {
        for (int i = 0; i <= len; i++) {
            int temp = 1 - array[i];
            array[i] = 1 - array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }
    }

    private static String arrayToString(int[] array) {
        StringBuilder sb = new StringBuilder();
        for (int bit : array) {
            sb.append(bit);
        }
        return sb.toString();
    }
}