import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.AbstractMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class Database {

    private static Map.Entry<Integer, Integer> sameBit;
    private static Map.Entry<Integer, Integer> differentBit;
    private static Integer[] bits;

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int numTestCases = sc.nextInt();
            for (int count = 0; count < numTestCases; count++) {
                int numBits = sc.nextInt();
                bits = new Integer[numBits];
                int numQueries = 0;
                int currentIndex = 0;
                while (currentIndex < numBits / 2) {
                    if (numQueries > 0 && numQueries % 10 == 0) {
                        updateState();
                        int changedSameBit = fetchBit(sc, sameBit.getKey());
                        int changedDifferentBit = fetchBit(sc, differentBit.getKey());
                        handleStateChange(changedSameBit, changedDifferentBit);
                    } else {
                        fetchBits(sc, currentIndex++);
                    }
                    numQueries += 2;
                }
                printResult();
                if (sc.next().equals("N")) {
                    break;
                }
                System.exit(0);
            }
        }
    }

    private static void handleStateChange(int changedSameBit, int changedDifferentBit) {
        if (sameBit.getValue().equals(changedSameBit) && !differentBit.getValue().equals(changedDifferentBit)) {
            applyAction(Action.REVERSE);
        } else if (differentBit.getValue().equals(changedDifferentBit)) {
            applyAction(Action.REVERSE_COMPLEMENT);
        } else {
            applyAction(Action.COMPLEMENT);
        }
    }

    private static void fetchBits(Scanner sc, int index) {
        bits[index] = fetchBit(sc, index);
        bits[bits.length - 1 - index] = fetchBit(sc, bits.length - 1 - index);
    }

    private static int fetchBit(Scanner sc, int index) {
        System.out.println(index + 1);
        sc.hasNext();
        return sc.nextInt();
    }

    private static void applyAction(Action action) {
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
            if (Objects.nonNull(bits[i])) {
                int temp = bits[i];
                bits[i] = bits[bits.length - 1 - i];
                bits[bits.length - 1 - i] = temp;
            } else {
                break;
            }
        }
    }

    private static void complementBits() {
        for (int i = 0; i < bits.length; i++) {
            if (Objects.nonNull(bits[i])) {
                bits[i] = bits[i] == 1 ? 0 : 1;
            }
        }
    }

    private static void updateState() {
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

    private static void printResult() {
        StringBuilder result = new StringBuilder();
        for (Integer bit : bits) {
            result.append(bit);
        }
        System.out.println(result);
    }

    enum Action {
        REVERSE, COMPLEMENT, REVERSE_COMPLEMENT
    }
}