import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int bitLength = scanner.nextInt();

        if (bitLength % 2 != 0 || bitLength < 10) {
            throw new IllegalArgumentException("Can do, but won't do.");
        }

        for (int t = 0; t < testCases; t++) {
            boolean[] bits = new boolean[bitLength];
            int knownBits = 0;
            int halfBitLength = bitLength / 2;

            for (int queryCount = 0; ; ) {
                if (knownBits == halfBitLength) {
                    for (boolean bit : bits) {
                        System.out.print(bit ? '1' : '0');
                    }
                    System.out.println();
                    System.out.flush();
                    scanner.next();
                    break;
                }

                boolean isCheckQuery = queryCount > 0 && queryCount % 10 == 0;
                if (isCheckQuery) {
                    int sameIndex = findSameIndex(bits, knownBits);
                    int diffIndex = findDiffIndex(bits, knownBits);

                    if (sameIndex >= 0) {
                        processQuery(sameIndex, bits, scanner);
                        if (bits[sameIndex] != readResponse(scanner)) {
                            toggleBits(bits);
                        }
                    } else {
                        processQuery(0, bits, scanner);
                        readResponse(scanner);
                    }
                    queryCount++;

                    if (diffIndex >= 0) {
                        processQuery(diffIndex, bits, scanner);
                        if (bits[sameIndex] != readResponse(scanner)) {
                            reverseBits(bits);
                        }
                    } else {
                        processQuery(0, bits, scanner);
                        readResponse(scanner);
                    }
                    queryCount++;
                } else {
                    processQuery(knownBits, bits, scanner);
                    bits[knownBits] = readResponse(scanner);
                    queryCount++;

                    processQuery(bitLength - 1 - knownBits, bits, scanner);
                    bits[bitLength - 1 - knownBits] = readResponse(scanner);
                    queryCount++;
                    knownBits++;
                }
            }
        }
    }

    private static int findSameIndex(boolean[] bits, int knownBits) {
        for (int i = 0; i < knownBits; i++) {
            if (bits[i] == bits[bits.length - 1 - i]) {
                return i;
            }
        }
        return -1;
    }

    private static int findDiffIndex(boolean[] bits, int knownBits) {
        for (int i = 0; i < knownBits; i++) {
            if (bits[i] != bits[bits.length - 1 - i]) {
                return i;
            }
        }
        return -1;
    }

    private static void processQuery(int index, boolean[] bits, Scanner scanner) {
        System.out.println(index + 1);
        System.out.flush();
    }

    private static boolean readResponse(Scanner scanner) {
        return "1".equals(scanner.next());
    }

    private static void reverseBits(boolean[] bits) {
        for (int left = 0, right = bits.length - 1; left < right; left++, right--) {
            boolean temp = bits[left];
            bits[left] = bits[right];
            bits[right] = temp;
        }
    }

    private static void toggleBits(boolean[] bits) {
        for (int i = 0; i < bits.length; i++) {
            bits[i] = !bits[i];
        }
    }
}