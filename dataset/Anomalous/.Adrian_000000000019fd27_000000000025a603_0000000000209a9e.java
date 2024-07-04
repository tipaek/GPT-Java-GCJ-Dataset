import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ", 2);
        int numCases = Integer.parseInt(input[0]);
        int bitLength = Integer.parseInt(input[1]);
        
        for (int i = 0; i < numCases; i++) {
            processCase(bitLength, scanner);
        }
    }

    private static void processCase(int bitLength, Scanner scanner) {
        int[] queryCount = {0};
        int[][] pairs = findPairs(scanner, bitLength, queryCount);
        int[] staticPair = pairs[0];
        int[] dynamicPair = pairs[1];

        List<Integer> bits = new ArrayList<>();
        for (int i = 0; i < bitLength; i++) bits.add(-1);

        int position = 0;
        while (position < bitLength / 2) {
            if (queryCount[0] % 10 == 0) {
                adjustBits(bits, staticPair, dynamicPair, scanner, queryCount);
            } else {
                bits.set(position, fetchBit(position, scanner));
                if (staticPair != null && dynamicPair != null) {
                    bits.set(bitLength - position - 1, fetchBit(bitLength - position - 1, scanner));
                    queryCount[0]++;
                }
                queryCount[0]++;
                position++;
            }
        }

        if (staticPair == null) {
            for (int i = 0; i < bitLength / 2; i++) {
                bits.set(bitLength - i - 1, 1 - bits.get(i));
            }
        } else if (dynamicPair == null) {
            for (int i = 0; i < bitLength / 2; i++) {
                bits.set(bitLength - i - 1, bits.get(i));
            }
        }

        StringBuilder result = new StringBuilder();
        for (int bit : bits) result.append(bit);
        System.out.println(result);
        if (scanner.nextLine().equals("N")) System.exit(0);
    }

    private static void adjustBits(List<Integer> bits, int[] staticPair, int[] dynamicPair, Scanner scanner, int[] queryCount) {
        int newStaticBit = -1;
        if (staticPair != null) {
            newStaticBit = fetchBit(staticPair[0], scanner);
            queryCount[0]++;
        }

        int newDynamicBit = -1;
        if (dynamicPair != null) {
            newDynamicBit = fetchBit(dynamicPair[0], scanner);
            queryCount[0]++;
        }

        if ((newStaticBit == -1 && newDynamicBit != dynamicPair[1]) || (newDynamicBit == -1 && newStaticBit != staticPair[1])) {
            invertBits(bits);
            if (newStaticBit == -1) {
                dynamicPair[1] = newDynamicBit;
            } else {
                staticPair[1] = newStaticBit;
            }
            return;
        }
        if (newStaticBit == -1 || newDynamicBit == -1) return;
        if (newStaticBit != staticPair[1]) {
            invertBits(bits);
            if (newDynamicBit == dynamicPair[1]) {
                reverseBits(bits);
            }
        } else {
            if (newDynamicBit != dynamicPair[1]) {
                reverseBits(bits);
            }
        }

        staticPair[1] = newStaticBit;
        dynamicPair[1] = newDynamicBit;
    }

    private static int[][] findPairs(Scanner scanner, int bitLength, int[] queryCount) {
        int[] staticPair = null;
        int[] dynamicPair = null;

        int position = 0;
        while ((staticPair == null || dynamicPair == null) && position < bitLength / 2) {
            for (int i = 0; i < 10 && (staticPair == null || dynamicPair == null) && position < bitLength / 2; i++) {
                int bit1 = fetchBit(position, scanner);
                int bit2 = fetchBit(bitLength - position - 1, scanner);

                if (bit1 == bit2) {
                    if (staticPair == null) staticPair = new int[]{position, -1};
                } else {
                    if (dynamicPair == null) dynamicPair = new int[]{position, -1};
                }

                position++;
                queryCount[0] += 2;
            }
        }

        if (staticPair != null) {
            staticPair[1] = fetchBit(staticPair[0], scanner);
            queryCount[0]++;
        }
        if (dynamicPair != null) {
            dynamicPair[1] = fetchBit(dynamicPair[0], scanner);
            queryCount[0]++;
        }

        return new int[][]{staticPair, dynamicPair};
    }

    private static void reverseBits(List<Integer> bits) {
        for (int i = 0, j = bits.size() - 1; i < j; i++) {
            bits.add(i, bits.remove(j));
        }
    }

    private static void invertBits(List<Integer> bits) {
        for (int i = 0; i < bits.size(); i++) {
            bits.set(i, 1 - bits.get(i));
        }
    }

    private static int fetchBit(int position, Scanner scanner) {
        System.out.println(position + 1);
        String response = scanner.nextLine();
        if (response.equals("N")) System.exit(0);
        return Integer.parseInt(response);
    }
}