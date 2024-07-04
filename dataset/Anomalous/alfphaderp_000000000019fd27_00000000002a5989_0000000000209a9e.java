import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {
    private static Scanner scanner;
    private static int testCases, bitLength;
    private static int[] bits;
    private static int bitPairsRead = 0;
    private static int queryCount = 0;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        testCases = scanner.nextInt();
        bitLength = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            initialize();

            readInitialPairs();

            while (bitPairsRead < bitLength / 2 || queryCount % 10 == 0) {
                if (queryCount % 10 == 0) {
                    applyChanges(detectChanges());
                } else {
                    fetchNextPair();
                }
            }

            for (int bit : bits) {
                System.out.print(bit);
            }
            System.out.println();

            if (scanner.next().equals("N")) {
                throw new Error();
            }
        }

        scanner.close();
    }

    private static void initialize() {
        bits = new int[bitLength];
        bitPairsRead = 0;
    }

    private static void readInitialPairs() {
        for (int i = 0; i < 5; i++) {
            fetchNextPair();
        }
    }

    private static void fetchNextPair() {
        System.out.println(bitPairsRead + 1);
        bits[bitPairsRead] = scanner.nextInt();

        System.out.println(bitLength - bitPairsRead);
        bits[bitLength - bitPairsRead - 1] = scanner.nextInt();

        bitPairsRead++;
        queryCount += 2;
    }

    private static String detectChanges() {
        List<Integer> currentBits = new ArrayList<>();
        for (int bit : bits) {
            currentBits.add(bit);
        }

        List<Integer> reversedBits = new ArrayList<>(currentBits);
        Collections.reverse(reversedBits);

        int sameBitIndex = findSameBitIndex(currentBits, reversedBits);
        int diffBitIndex = findDiffBitIndex(currentBits, reversedBits);

        boolean invert = false;
        if (sameBitIndex != -1) {
            System.out.println(sameBitIndex);
            int queriedSameBit = scanner.nextInt();
            if (queriedSameBit != currentBits.get(sameBitIndex - 1)) {
                invert = true;
            }
        }

        boolean reverse = false;
        if (diffBitIndex != -1) {
            System.out.println(diffBitIndex);
            int queriedDiffBit = scanner.nextInt();
            reverse = shouldReverse(invert, queriedDiffBit, currentBits.get(diffBitIndex - 1));
        }

        if (diffBitIndex == -1 || sameBitIndex == -1) {
            System.out.println(1);
            scanner.nextInt();
        }

        queryCount += 2;

        return determineChange(invert, reverse);
    }

    private static int findSameBitIndex(List<Integer> currentBits, List<Integer> reversedBits) {
        for (int i = 0; i < bitPairsRead; i++) {
            if (currentBits.get(i).equals(reversedBits.get(i))) {
                return i + 1;
            }
        }
        return -1;
    }

    private static int findDiffBitIndex(List<Integer> currentBits, List<Integer> reversedBits) {
        for (int i = 0; i < bitPairsRead; i++) {
            if (!currentBits.get(i).equals(reversedBits.get(i))) {
                return i + 1;
            }
        }
        return -1;
    }

    private static boolean shouldReverse(boolean invert, int queriedDiffBit, int originalDiffBit) {
        if (queriedDiffBit == originalDiffBit) {
            return invert;
        } else {
            return !invert;
        }
    }

    private static String determineChange(boolean invert, boolean reverse) {
        if (invert) {
            return reverse ? "IR" : "IN";
        } else {
            return reverse ? "NR" : "NN";
        }
    }

    private static void applyChanges(String change) {
        if (change.charAt(0) == 'I') {
            invertBits();
        }
        if (change.charAt(1) == 'R') {
            reverseBits();
        }
    }

    private static void invertBits() {
        for (int i = 0; i < bitLength; i++) {
            bits[i] = (bits[i] + 1) % 2;
        }
    }

    private static void reverseBits() {
        for (int i = 0; i < bitLength / 2; i++) {
            int temp = bits[i];
            bits[i] = bits[bitLength - i - 1];
            bits[bitLength - i - 1] = temp;
        }
    }
}