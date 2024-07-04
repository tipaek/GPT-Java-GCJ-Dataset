import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        int bitLength = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            if (!processTestCase(scanner, bitLength)) {
                System.exit(0);
            }
        }
    }

    private static boolean processTestCase(Scanner scanner, int bitLength) {
        int[] bits = new int[bitLength];
        int differingIndex = -1, sameIndex = -1;
        
        for (int i = 0, queryCount = 0; i <= (bitLength - 1) / 2; i++) {
            if (queryCount > 0 && queryCount % 10 == 0) {
                handleTransformation(scanner, bits, i, differingIndex, sameIndex);
                queryCount += 2;
            }
            
            bits[i] = queryBit(scanner, i);
            queryCount++;
            bits[bitLength - i - 1] = queryBit(scanner, bitLength - i - 1);
            queryCount++;
            
            if (differingIndex == -1 && bits[i] != bits[bitLength - i - 1]) {
                differingIndex = i;
            }
            if (sameIndex == -1 && bits[i] == bits[bitLength - i - 1]) {
                sameIndex = i;
            }
        }

        printBits(bits);
        return "Y".equals(scanner.next());
    }

    private static void handleTransformation(Scanner scanner, int[] bits, int limit, int differingIndex, int sameIndex) {
        if (differingIndex == -1 || sameIndex == -1) {
            int targetIndex = (differingIndex == -1) ? sameIndex : differingIndex;
            int newBit = queryBit(scanner, targetIndex);
            if (newBit != bits[targetIndex]) {
                complement(bits, limit);
            }
            queryBit(scanner, 0); // Burn a query
        } else {
            int newSameBit = queryBit(scanner, sameIndex);
            boolean sameChanged = newSameBit != bits[sameIndex];

            int newDifferingBit = queryBit(scanner, differingIndex);
            boolean differingChanged = newDifferingBit != bits[differingIndex];

            if (sameChanged && differingChanged) {
                complement(bits, limit);
            } else if (differingChanged) {
                reverse(bits, limit);
            } else if (sameChanged) {
                both(bits, limit);
            }
        }
    }

    private static int queryBit(Scanner scanner, int index) {
        System.out.println(index + 1);
        return scanner.nextInt();
    }

    private static void complement(int[] bits, int limit) {
        for (int i = 0; i <= limit; i++) {
            bits[i] = 1 - bits[i];
            bits[bits.length - i - 1] = 1 - bits[bits.length - i - 1];
        }
    }

    private static void reverse(int[] bits, int limit) {
        for (int i = 0; i <= limit; i++) {
            int temp = bits[i];
            bits[i] = bits[bits.length - i - 1];
            bits[bits.length - i - 1] = temp;
        }
    }

    private static void both(int[] bits, int limit) {
        for (int i = 0; i <= limit; i++) {
            int temp = 1 - bits[i];
            bits[i] = 1 - bits[bits.length - i - 1];
            bits[bits.length - i - 1] = temp;
        }
    }

    private static void printBits(int[] bits) {
        StringBuilder result = new StringBuilder();
        for (int bit : bits) {
            result.append(bit);
        }
        System.out.println(result.toString());
    }
}