import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.AbstractMap;
import java.util.Objects;
import java.util.Scanner;

public class Solution {

    private static AbstractMap.SimpleEntry<Integer, Integer> sameBitPair;
    private static AbstractMap.SimpleEntry<Integer, Integer> differentBitPair;
    private static Integer[] bitArray;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int bitCount = scanner.nextInt();
            bitArray = new Integer[bitCount];
            int queryCount = 0;
            int index = 0;

            while (index < bitCount / 2) {
                if (queryCount > 0 && queryCount % 10 == 0) {
                    updatePreviousState();
                    int newSameBit = fetchBit(scanner, sameBitPair.getKey());
                    int newDifferentBit = fetchBit(scanner, differentBitPair.getKey());
                    applyTransformation(newSameBit, newDifferentBit);
                } else {
                    fetchBitPair(scanner, index++);
                }
                queryCount += 2;
            }

            StringBuilder result = new StringBuilder();
            for (Integer bit : bitArray) {
                result.append(bit);
            }
            System.out.println(result.toString());

            if ("N".equals(scanner.next())) {
                break;
            }
        }
    }

    private static void applyTransformation(int newSameBit, int newDifferentBit) {
        if (sameBitPair.getValue().equals(newSameBit) && !differentBitPair.getValue().equals(newDifferentBit)) {
            executeAction(Action.REVERSE);
        } else if (differentBitPair.getValue().equals(newDifferentBit)) {
            executeAction(Action.REVERSE_COMPLEMENT);
        } else {
            executeAction(Action.COMPLEMENT);
        }
    }

    private static void fetchBitPair(Scanner scanner, int index) {
        bitArray[index] = fetchBit(scanner, index);
        bitArray[bitArray.length - 1 - index] = fetchBit(scanner, bitArray.length - 1 - index);
    }

    private static int fetchBit(Scanner scanner, int index) {
        System.out.println(index + 1);
        scanner.hasNext();
        return scanner.nextInt();
    }

    private static void executeAction(Action action) {
        switch (action) {
            case REVERSE:
                reverseArray();
                break;
            case COMPLEMENT:
                complementArray();
                break;
            case REVERSE_COMPLEMENT:
                reverseArray();
                complementArray();
                break;
        }
    }

    private static void reverseArray() {
        for (int i = 0; i < bitArray.length / 2; i++) {
            if (Objects.nonNull(bitArray[i])) {
                int temp = bitArray[i];
                bitArray[i] = bitArray[bitArray.length - 1 - i];
                bitArray[bitArray.length - 1 - i] = temp;
            } else {
                break;
            }
        }
    }

    private static void complementArray() {
        for (int i = 0; i < bitArray.length; i++) {
            if (Objects.nonNull(bitArray[i])) {
                bitArray[i] = bitArray[i] == 1 ? 0 : 1;
            }
        }
    }

    private static void updatePreviousState() {
        if (Objects.nonNull(sameBitPair) && Objects.nonNull(differentBitPair)) {
            return;
        }
        for (int i = 0; i < bitArray.length / 2 && Objects.nonNull(bitArray[i]); i++) {
            if (bitArray[i].equals(bitArray[bitArray.length - 1 - i])) {
                sameBitPair = new AbstractMap.SimpleEntry<>(i, bitArray[i]);
            } else {
                differentBitPair = new AbstractMap.SimpleEntry<>(i, bitArray[i]);
            }
            if (Objects.nonNull(sameBitPair) && Objects.nonNull(differentBitPair)) {
                break;
            }
        }
    }

    enum Action {
        REVERSE, COMPLEMENT, REVERSE_COMPLEMENT;
    }
}