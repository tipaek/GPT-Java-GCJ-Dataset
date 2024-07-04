import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.AbstractMap;
import java.util.Objects;
import java.util.Scanner;

public class Database {

    private static AbstractMap.SimpleEntry<Integer, Integer> sameBit;
    private static AbstractMap.SimpleEntry<Integer, Integer> differentBit;
    private static Integer[] bits;

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numTestCases = sc.nextInt();
        for (int count = 0; count < numTestCases; count++) {
            int numBits = sc.nextInt();
            bits = new Integer[numBits];
            int numQueries = 0;
            int currentIndex = 0;
            while (currentIndex < numBits / 2) {
                if (numQueries > 0 && numQueries % 10 == 0) {
                    getPreviousState();
                    int changedSameBit = getBit(sc, sameBit.getKey());
                    int changedDifferentBit = getBit(sc, differentBit.getKey());
                    performAppropriateAction(changedSameBit, changedDifferentBit);
                } else {
                    getBits(sc, currentIndex++);
                }
                numQueries += 2;
            }
            String result = "";
            for (Integer bit : bits) {
                result = result.concat(String.valueOf(bit));
            }
            System.out.println(result);
            String outcome = sc.next();
            if (outcome.equals("N")) {
                break;
            }
            System.exit(0);
        }
    }

    private static void performAppropriateAction(int changedSameBit, int changedDifferentBit) {
        if (sameBit.getValue().equals(changedSameBit) && !differentBit.getValue().equals(changedDifferentBit)) {
            performAction(ACTION.REVERSE);
        } else {
            if (differentBit.getValue().equals(changedDifferentBit)) {
                performAction(ACTION.REVERSE_COMPLEMENT);
            } else {
                performAction(ACTION.COMPLEMENT);
            }
        }
    }

    private static void getBits(Scanner sc, int index) {
        bits[index] = getBit(sc, index);
        bits[bits.length - 1 - index] = getBit(sc, bits.length - 1 - index);
    }

    private static int getBit(Scanner sc, int index) {
        System.out.println(index + 1);
        sc.hasNext();
        return sc.nextInt();
    }

    private static void performAction(ACTION action) {
        switch (action) {
            case REVERSE:
                performReverseAction();
                break;
            case COMPLEMENT:
                performComplementAction();
                break;
            case REVERSE_COMPLEMENT:
                performReverseAction();
                performComplementAction();
                break;
        }
    }

    private static void performReverseAction() {
        int temp;
        for (int i = 0; i < bits.length / 2; i++) {
            if (Objects.nonNull(bits[i])) {
                temp = bits[i];
                bits[i] = bits[bits.length - 1 - i];
                bits[bits.length - 1 - i] = temp;
            } else {
                break;
            }
        }
    }

    private static void performComplementAction() {
        for (int i = 0; i < bits.length; i++) {
            if (Objects.nonNull(bits[i])) {
                if (bits[i] == 1) {
                    bits[i] = 0;
                } else {
                    bits[i] = 1;
                }
            }
        }
    }

    private static void getPreviousState() {
        if (Objects.nonNull(sameBit) && Objects.nonNull(differentBit)) {
            return;
        }
        for (int i = 0; i < bits.length / 2 && Objects.nonNull(bits[i]); i++) {
            if (bits[i].equals(bits[bits.length - 1 - i])) {
                sameBit = new AbstractMap.SimpleEntry<>(i, bits[i]);
            } else {
                differentBit = new AbstractMap.SimpleEntry<>(i, bits[i]);
            }
            if (Objects.nonNull(sameBit) && Objects.nonNull(differentBit)) {
                break;
            }
        }
    }

    enum ACTION {
        REVERSE, COMPLEMENT, REVERSE_COMPLEMENT;
    }

}
