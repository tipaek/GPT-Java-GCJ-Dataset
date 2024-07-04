package csibe;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    private static int bitCount;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        String[] input = scanner.nextLine().split(" ");
        int testCases = Integer.parseInt(input[0]);
        bitCount = Integer.parseInt(input[1]);

        for (int t = 0; t < testCases; t++) {
            List<Integer> sameIndices = new ArrayList<>();
            List<Integer> differentIndices = new ArrayList<>();
            int[] bits = new int[bitCount];
            int unknownBits = bitCount;
            int index = 0;
            int queryCount = 0;

            while (unknownBits > 0) {
                if (queryCount > 1 && queryCount % 10 == 0) {
                    if (adjustSameBits(bits, sameIndices, scanner)) {
                        queryCount++;
                    }
                    if (adjustDifferentBits(bits, differentIndices, scanner)) {
                        queryCount++;
                    }
                }
                System.out.println(index + 1);
                queryCount++;
                int firstBit = Integer.parseInt(scanner.nextLine());
                bits[index] = firstBit;
                unknownBits--;

                if (unknownBits == 0) {
                    break;
                }

                boolean adjusted = false;
                if (queryCount > 1 && queryCount % 10 == 0) {
                    adjusted = true;
                    if (adjustSameBits(bits, sameIndices, scanner)) {
                        queryCount++;
                    }
                    if (adjustDifferentBits(bits, differentIndices, scanner)) {
                        queryCount++;
                    }
                }

                if (adjusted) {
                    System.out.println(index + 1);
                    queryCount++;
                    firstBit = Integer.parseInt(scanner.nextLine());
                    bits[index] = firstBit;
                }

                int lastIndex = bitCount - 1 - index;
                System.out.println(lastIndex + 1);
                queryCount++;
                int lastBit = Integer.parseInt(scanner.nextLine());
                bits[lastIndex] = lastBit;
                unknownBits--;

                if (firstBit == lastBit) {
                    sameIndices.add(index);
                } else {
                    differentIndices.add(index);
                }
                index++;
            }

            StringBuilder result = new StringBuilder();
            for (int bit : bits) {
                result.append(bit);
            }
            System.out.println(result.toString());

            if ("N".equals(scanner.nextLine())) {
                return;
            }
        }
    }

    private static boolean adjustSameBits(int[] bits, List<Integer> indices, Scanner scanner) {
        if (indices.isEmpty()) {
            return false;
        }

        int index = indices.get(0);
        System.out.println(index + 1);
        int currentBit = Integer.parseInt(scanner.nextLine());
        if (bits[index] != currentBit) {
            for (int idx : indices) {
                bits[idx] = 1 - bits[idx];
                bits[bitCount - 1 - idx] = 1 - bits[bitCount - 1 - idx];
            }
        }
        return true;
    }

    private static boolean adjustDifferentBits(int[] bits, List<Integer> indices, Scanner scanner) {
        if (indices.isEmpty()) {
            return false;
        }

        int index = indices.get(0);
        System.out.println(index + 1);
        int currentBit = Integer.parseInt(scanner.nextLine());
        if (bits[index] != currentBit) {
            for (int idx : indices) {
                int temp = bits[idx];
                bits[idx] = bits[bitCount - 1 - idx];
                bits[bitCount - 1 - idx] = temp;
            }
        }
        return true;
    }
}