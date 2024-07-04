package codejam2020Pr;

import java.util.Scanner;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] input = scanner.nextLine().split(" ");
        int testCases = Integer.parseInt(input[0]);
        int bitLength = Integer.parseInt(input[1]);

        for (int testCase = 0; testCase < testCases; testCase++) {
            boolean[] bits = new boolean[bitLength + 1];

            for (int i = 1; i <= 5; i++) {
                bits[i] = queryBit(i);
                bits[bitLength - i + 1] = queryBit(bitLength - i + 1);
            }

            int nextQuery = 6;

            while (true) {
                int firstDiffIndex = findFirstIndex(bits, nextQuery, true);
                int firstSameIndex = findFirstIndex(bits, nextQuery, false);

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

                if (nextQuery > (bitLength + 1) / 2) {
                    break;
                }

                for (int a = 2; a < 10; a += 2) {
                    if (nextQuery > (bitLength + 1) / 2) {
                        break;
                    }

                    bits[nextQuery] = queryBit(nextQuery);
                    bits[bitLength - nextQuery + 1] = queryBit(bitLength - nextQuery + 1);
                    nextQuery++;
                }
            }

            System.out.println(formatBits(bits));
            if (scanner.nextLine().equals("N")) {
                System.exit(0);
            }
        }
    }

    private static String formatBits(boolean[] bits) {
        StringBuilder result = new StringBuilder();
        for (int i = 1; i < bits.length; i++) {
            result.append(bits[i] ? '1' : '0');
        }
        return result.toString();
    }

    private static void complementBits(boolean[] bits, int limit) {
        for (int i = 1; i < limit; i++) {
            bits[i] = !bits[i];
            bits[bits.length - i] = !bits[bits.length - i];
        }
    }

    private static void reverseBits(boolean[] bits, int limit) {
        for (int i = 1; i < limit; i++) {
            boolean temp = bits[i];
            bits[i] = bits[bits.length - i];
            bits[bits.length - i] = temp;
        }
    }

    private static int findFirstIndex(boolean[] bits, int max, boolean findDifference) {
        for (int i = 1; i < max; i++) {
            int mirroredIndex = bits.length - i;
            if ((bits[i] != bits[mirroredIndex]) == findDifference) {
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