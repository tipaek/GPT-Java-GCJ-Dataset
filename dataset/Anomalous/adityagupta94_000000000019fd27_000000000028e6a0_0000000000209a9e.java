import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.AbstractMap;
import java.util.Scanner;

public class Solution {

    private static AbstractMap.SimpleEntry<Integer, Integer> sameBit;
    private static AbstractMap.SimpleEntry<Integer, Integer> differentBit;
    private static Integer[] bits;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int t = 0; t < testCases; t++) {
            int bitCount = scanner.nextInt();
            bits = new Integer[bitCount];
            int queriesMade = 0;
            int index = 0;

            while (index < bitCount / 2) {
                if (queriesMade > 0 && queriesMade % 10 == 0) {
                    updatePreviousState();
                    int sameBitChanged = fetchBit(scanner, sameBit.getKey());
                    int differentBitChanged = fetchBit(scanner, differentBit.getKey());
                    applyActionBasedOnChange(sameBitChanged, differentBitChanged);
                } else {
                    fetchBits(scanner, index++);
                }
                queriesMade += 2;
            }

            StringBuilder result = new StringBuilder();
            for (Integer bit : bits) {
                result.append(bit);
            }
            System.out.println(result.toString());

            String outcome = scanner.next();
            if (outcome.equals("N")) {
                break;
            }
        }
        scanner.close();
    }

    private static void applyActionBasedOnChange(int sameBitChanged, int differentBitChanged) {
        if (sameBit.getValue().equals(sameBitChanged)) {
            if (!differentBit.getValue().equals(differentBitChanged)) {
                executeAction(Action.REVERSE);
            }
        } else {
            if (differentBit.getValue().equals(differentBitChanged)) {
                executeAction(Action.REVERSE_COMPLEMENT);
            } else {
                executeAction(Action.COMPLEMENT);
            }
        }
    }

    private static void fetchBits(Scanner scanner, int index) {
        bits[index] = fetchBit(scanner, index);
        bits[bits.length - 1 - index] = fetchBit(scanner, bits.length - 1 - index);
    }

    private static int fetchBit(Scanner scanner, int index) {
        System.out.println(index + 1);
        return scanner.nextInt();
    }

    private static void executeAction(Action action) {
        switch (action) {
            case REVERSE:
                reverseBits();
                break;
            case COMPLEMENT:
                complementBits();
                break;
            case REVERSE_COMPLEMENT:
                reverseBits();
                complementBits();
                break;
        }
    }

    private static void reverseBits() {
        for (int i = 0; i < bits.length / 2; i++) {
            if (bits[i] != null) {
                int temp = bits[i];
                bits[i] = bits[bits.length - 1 - i];
                bits[bits.length - 1 - i] = temp;
            }
        }
    }

    private static void complementBits() {
        for (int i = 0; i < bits.length; i++) {
            if (bits[i] != null) {
                bits[i] = bits[i] == 1 ? 0 : 1;
            }
        }
    }

    private static void updatePreviousState() {
        if (sameBit != null && differentBit != null) {
            return;
        }
        for (int i = 0; i < bits.length / 2 && bits[i] != null; i++) {
            if (bits[i].equals(bits[bits.length - 1 - i])) {
                sameBit = new AbstractMap.SimpleEntry<>(i, bits[i]);
            } else {
                differentBit = new AbstractMap.SimpleEntry<>(i, bits[i]);
            }
            if (sameBit != null && differentBit != null) {
                break;
            }
        }
    }

    private enum Action {
        REVERSE, COMPLEMENT, REVERSE_COMPLEMENT;
    }
}