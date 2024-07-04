package codejam2020Pr;

import java.util.Scanner;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] input = scanner.nextLine().split(" ");
        int t = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);

        for (int testCase = 0; testCase < t; testCase++) {
            boolean[] bits = new boolean[b + 1];

            // Initial queries
            for (int i = 1; i <= 5; i++) {
                bits[i] = queryBit(i);
                bits[b - i + 1] = queryBit(b - i + 1);
            }

            int nextQueryIndex = 6;

            while (nextQueryIndex <= (b / 2)) {
                int firstDiffIndex = findIndex(bits, nextQueryIndex, true);
                int firstSameIndex = findIndex(bits, nextQueryIndex, false);

                boolean diffBit = false, sameBit = false;
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
                        complementBits(bits, nextQueryIndex);
                    }
                }

                if (firstDiffIndex == -1 && firstSameIndex != -1) {
                    if (sameBit != bits[firstSameIndex]) {
                        complementBits(bits, nextQueryIndex);
                    }
                }

                if (firstDiffIndex != -1 && firstSameIndex != -1) {
                    if (sameBit == bits[firstSameIndex]) {
                        if (diffBit != bits[firstDiffIndex]) {
                            reverseBits(bits, nextQueryIndex);
                        }
                    } else {
                        if (diffBit == bits[firstDiffIndex]) {
                            reverseBits(bits, nextQueryIndex);
                            complementBits(bits, nextQueryIndex);
                        } else {
                            complementBits(bits, nextQueryIndex);
                        }
                    }
                }

                for (int i = 0; i < 4 && nextQueryIndex <= (b / 2); i++) {
                    bits[nextQueryIndex] = queryBit(nextQueryIndex);
                    bits[b - nextQueryIndex + 1] = queryBit(b - nextQueryIndex + 1);
                    nextQueryIndex++;
                }
            }

            System.out.println(getBitString(bits));
            System.out.flush();
            if (!scanner.nextLine().equals("Y")) {
                break;
            }
        }
    }

    private static String getBitString(boolean[] bits) {
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

    private static int findIndex(boolean[] bits, int limit, boolean findDiff) {
        for (int i = 1; i < limit; i++) {
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