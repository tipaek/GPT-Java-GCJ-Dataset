import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ", 2);
        int amount = Integer.parseInt(input[0]);
        int bits = Integer.parseInt(input[1]);

        for (int i = 0; i < amount; i++) {
            process(bits, scanner);
        }
    }

    private static void process(int bits, Scanner scanner) {
        int[] requestCounter = {0};
        int[][] pairs = identifyPairs(scanner, bits, requestCounter);

        int[] staticPair = pairs[0];
        int[] dynamicPair = pairs[1];

        List<Integer> bitSequence = new ArrayList<>();
        for (int i = 0; i < bits; i++) bitSequence.add(-1);

        int position = 0;
        while (position < bits / 2) {
            if (requestCounter[0] % 10 == 0) {
                adjustSequence(bitSequence, staticPair, dynamicPair, scanner, requestCounter);
            } else {
                bitSequence.set(position, queryBit(position, scanner));
                if (staticPair != null && dynamicPair != null) {
                    bitSequence.set(bits - position - 1, queryBit(bits - position - 1, scanner));
                    requestCounter[0]++;
                }
                requestCounter[0]++;
                position++;
            }
        }

        if (staticPair == null) {
            for (int i = 0; i < bits / 2; i++) {
                bitSequence.set(bits - i - 1, 1 - bitSequence.get(i));
            }
        } else if (dynamicPair == null) {
            for (int i = 0; i < bits / 2; i++) {
                bitSequence.set(bits - i - 1, bitSequence.get(i));
            }
        }

        StringBuilder result = new StringBuilder();
        for (int bit : bitSequence) result.append(bit);
        System.out.println(result);
        scanner.nextLine();
    }

    private static void adjustSequence(List<Integer> bitSequence, int[] staticPair, int[] dynamicPair, Scanner scanner, int[] requestCounter) {
        int newStaticValue = -1;
        if (staticPair != null) {
            newStaticValue = queryBit(staticPair[0], scanner);
            requestCounter[0]++;
        }

        int newDynamicValue = -1;
        if (dynamicPair != null) {
            newDynamicValue = queryBit(dynamicPair[0], scanner);
            requestCounter[0]++;
        }

        if ((newStaticValue == -1 && newDynamicValue != dynamicPair[1]) || (newDynamicValue == -1 && newStaticValue != staticPair[1])) {
            invertSequence(bitSequence);
            if (newStaticValue == -1) {
                dynamicPair[1] = newDynamicValue;
            } else {
                staticPair[1] = newStaticValue;
            }
        }
        if (newStaticValue != staticPair[1]) {
            invertSequence(bitSequence);
            if (newDynamicValue == dynamicPair[1]) {
                reverseSequence(bitSequence);
            }
        } else {
            if (newDynamicValue != dynamicPair[1]) {
                reverseSequence(bitSequence);
            }
        }

        staticPair[1] = newStaticValue;
        dynamicPair[1] = newDynamicValue;
    }

    private static int[][] identifyPairs(Scanner scanner, int bits, int[] requestCounter) {
        int[] staticPair = null;
        int[] dynamicPair = null;

        int position = 0;
        while ((staticPair == null || dynamicPair == null) && position < bits / 2) {
            for (int i = 0; i < 10 && (staticPair == null || dynamicPair == null) && position < bits / 2; i++) {
                int firstValue = queryBit(position, scanner);
                int secondValue = queryBit(bits - position - 1, scanner);

                if (firstValue == secondValue) {
                    if (staticPair == null) staticPair = new int[]{position, -1};
                } else {
                    if (dynamicPair == null) dynamicPair = new int[]{position, -1};
                }

                position++;
                requestCounter[0] += 2;
            }
        }

        if (staticPair != null) {
            staticPair[1] = queryBit(staticPair[0], scanner);
            requestCounter[0]++;
        }
        if (dynamicPair != null) {
            dynamicPair[1] = queryBit(dynamicPair[0], scanner);
            requestCounter[0]++;
        }

        return new int[][]{
                staticPair,
                dynamicPair
        };
    }

    private static void reverseSequence(List<Integer> sequence) {
        for (int i = 0, j = sequence.size() - 1; i < j; i++) {
            sequence.add(i, sequence.remove(j));
        }
    }

    private static void invertSequence(List<Integer> sequence) {
        for (int i = 0; i < sequence.size(); i++) {
            sequence.set(i, 1 - sequence.get(i));
        }
    }

    private static int queryBit(int position, Scanner scanner) {
        System.out.println(position + 1);
        return Integer.parseInt(scanner.nextLine());
    }
}