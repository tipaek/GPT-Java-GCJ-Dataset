import java.util.Scanner;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] input = scanner.nextLine().split(" ");
        int testCases = Integer.parseInt(input[0]);
        int bitLength = Integer.parseInt(input[1]);

        for (int testCase = 0; testCase < testCases; testCase++) {
            boolean[] bits = new boolean[bitLength + 1];
            int nextQuery = 6;

            for (int i = 1; i <= 5; i++) {
                bits[i] = queryBit(i);
                bits[bitLength - i + 1] = queryBit(bitLength - i + 1);
            }

            while (nextQuery <= (bitLength + 1) / 2) {
                int firstDiffIndex = findIndex(bits, nextQuery, true);
                int firstSameIndex = findIndex(bits, nextQuery, false);

                boolean diffBit = false;
                boolean sameBit = false;

                if (firstDiffIndex != -1) {
                    diffBit = queryBit(firstDiffIndex);
                } else {
                    queryBit(firstSameIndex);
                }

                if (firstSameIndex != -1) {
                    sameBit = queryBit(firstSameIndex);
                } else {
                    queryBit(firstDiffIndex);
                }

                if (firstDiffIndex != -1 && firstSameIndex == -1) {
                    if (diffBit != bits[firstDiffIndex]) {
                        complementBits(bits, nextQuery);
                    }
                }

                if (firstDiffIndex == -1 && firstSameIndex != -1) {
                    if (sameBit != bits[firstSameIndex]) {
                        complementBits(bits, nextQuery);
                    }
                }

                if (firstDiffIndex != -1 && firstSameIndex != -1) {
                    if (sameBit == bits[firstSameIndex]) {
                        if (diffBit != bits[firstDiffIndex]) {
                            reverseBits(bits, nextQuery);
                        }
                    } else {
                        if (diffBit == bits[firstDiffIndex]) {
                            reverseBits(bits, nextQuery);
                            complementBits(bits, nextQuery);
                        } else {
                            complementBits(bits, nextQuery);
                        }
                    }
                }

                for (int a = 0; a < 4; a++) {
                    if (nextQuery > (bitLength + 1) / 2) {
                        break;
                    }

                    bits[nextQuery] = queryBit(nextQuery);
                    bits[bitLength - nextQuery + 1] = queryBit(bitLength - nextQuery + 1);
                    nextQuery++;
                }
            }

            System.out.println(bitsToString(bits));
            if (scanner.nextLine().equals("N")) {
                System.exit(0);
            }
        }
    }

    private static String bitsToString(boolean[] bits) {
        StringBuilder result = new StringBuilder();
        for (int i = 1; i < bits.length; i++) {
            result.append(bits[i] ? '1' : '0');
        }
        return result.toString();
    }

    private static void complementBits(boolean[] bits, int nextQuery) {
        for (int i = 1; i < nextQuery; i++) {
            bits[i] = !bits[i];
            bits[bits.length - i] = !bits[bits.length - i];
        }
    }

    private static void reverseBits(boolean[] bits, int nextQuery) {
        for (int i = 1; i < nextQuery; i++) {
            boolean temp = bits[i];
            bits[i] = bits[bits.length - i];
            bits[bits.length - i] = temp;
        }
    }

    private static int findIndex(boolean[] bits, int max, boolean findDiff) {
        for (int i = 1; i < max; i++) {
            int mirrorIndex = bits.length - i;
            if ((bits[i] != bits[mirrorIndex]) == findDiff) {
                return i;
            }
        }
        return -1;
    }

    private static boolean queryBit(int index) {
        System.out.println(index);
        System.out.flush();
        return scanner.nextLine().charAt(0) == '1';
    }
}