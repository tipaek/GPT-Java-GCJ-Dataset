import java.util.Scanner;

class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().trim().split(" ");
        int testCases = Integer.parseInt(input[0]);
        int bitLength = Integer.parseInt(input[1]);

        while (testCases-- > 0) {
            int[] bits = new int[bitLength];
            int requests = 0;
            int knownBits = 0;
            int queryPosition = 1;
            int leftIndex = -1;
            int rightIndex = bitLength;

            while (knownBits < bitLength && requests < 150) {
                if (requests == 0 || requests % 10 != 0) {
                    bits[queryPosition - 1] = query(scanner, queryPosition);
                    requests++;
                    knownBits++;

                    if (queryPosition <= bitLength / 2) {
                        leftIndex = queryPosition;
                        queryPosition = bitLength - queryPosition + 1;
                    } else {
                        rightIndex = queryPosition;
                        queryPosition = bitLength - queryPosition + 2;
                    }
                } else {
                    if (isMirror(bits, leftIndex) || isComplement(bits, leftIndex)) {
                        int bit = query(scanner, 1);
                        if (bit != bits[0]) {
                            complement(bits);
                        }
                        query(scanner, 1);
                    } else {
                        int mirrorPos = getMirrorBitPosition(bits, leftIndex);
                        int complementPos = getComplementBitPosition(bits, leftIndex);
                        int bit0 = query(scanner, mirrorPos + 1);
                        int bit1 = query(scanner, complementPos + 1);

                        if (bit0 == bits[mirrorPos]) {
                            if (bit1 != bits[complementPos]) {
                                reverse(bits);
                            }
                        } else {
                            if (bit1 == bits[complementPos]) {
                                reverse(bits);
                            }
                            complement(bits);
                        }
                    }
                    requests += 2;
                }
            }

            StringBuilder result = new StringBuilder();
            for (int bit : bits) {
                result.append(bit);
            }
            System.out.println(result);
            if (scanner.nextLine().trim().equals("N")) {
                break;
            }
        }
    }

    private static int getMirrorBitPosition(int[] bits, int leftIndex) {
        for (int i = 0; i < leftIndex; i++) {
            if (bits[i] == bits[bits.length - i - 1]) {
                return i;
            }
        }
        return -1;
    }

    private static int getComplementBitPosition(int[] bits, int leftIndex) {
        for (int i = 0; i < leftIndex; i++) {
            if (bits[i] == 1 - bits[bits.length - i - 1]) {
                return i;
            }
        }
        return -1;
    }

    private static int query(Scanner scanner, int position) {
        System.out.println(position);
        return Integer.parseInt(scanner.nextLine().trim());
    }

    private static boolean isMirror(int[] bits, int leftIndex) {
        for (int i = 0; i < leftIndex; i++) {
            if (bits[i] != bits[bits.length - i - 1]) {
                return false;
            }
        }
        return true;
    }

    private static boolean isComplement(int[] bits, int leftIndex) {
        for (int i = 0; i < leftIndex; i++) {
            if (bits[i] != 1 - bits[bits.length - i - 1]) {
                return false;
            }
        }
        return true;
    }

    private static void complement(int[] bits) {
        for (int i = 0; i < bits.length; i++) {
            bits[i] = 1 - bits[i];
        }
    }

    private static void reverse(int[] bits) {
        for (int i = 0; i < bits.length / 2; i++) {
            int temp = bits[i];
            bits[i] = bits[bits.length - i - 1];
            bits[bits.length - i - 1] = temp;
        }
    }
}