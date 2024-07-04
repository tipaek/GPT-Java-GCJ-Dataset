import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tests = scanner.nextInt();
        int length = scanner.nextInt();
        for (int t = 1; t <= tests; t++) {
            Solver solver = new Solver(scanner, length);
            System.out.println(solver.solve());
            String answer = scanner.next();
            if (answer.equals("N")) {
                break;
            }
        }
    }
}

class Solver {

    private final BitArray bitArray;
    private final Scanner scanner;
    private int queryNum = 0;

    private Integer samePairIndex = null;
    private Integer diffPairIndex = null;

    public Solver(Scanner scanner, int length) {
        this.scanner = scanner;
        this.bitArray = new BitArray(length);
    }

    public String solve() {
        idleAskBit();
        idleAskBit();

        int left = 0;
        int right = bitArray.length() - 1;
        while (left < right) {
            if (queryNum % 10 != 0) {
                byte leftBit = askBit(left);
                byte rightBit = askBit(right);
                bitArray.set(left, leftBit);
                bitArray.set(right, rightBit);

                if (leftBit == rightBit) {
                    samePairIndex = left;
                } else {
                    diffPairIndex = left;
                }

                left++;
                right--;
            } else {
                FluctuationType fluctuationType = determineFluctuationType();
                bitArray.applyFluctuation(fluctuationType);
            }
        }
        return bitArray.toString();
    }

    private <T> T idleAskBit() {
        askBit(1); // idle
        return null;
    }

    private Byte askBit(int i) {
        queryNum++;
        System.out.println(i + 1);
        return scanner.nextByte();
    }

    private FluctuationType determineFluctuationType() {
        Boolean samePairEq = (samePairIndex != null)
                ? askBit(samePairIndex) == bitArray.get(samePairIndex)
                : idleAskBit();
        Boolean diffPairEq = (diffPairIndex != null)
                ? askBit(diffPairIndex) == bitArray.get(diffPairIndex)
                : idleAskBit();

        if (samePairEq != null && diffPairEq != null) {
            if (!samePairEq && !diffPairEq) {
                return FluctuationType.COMPLEMENT;
            } else if (samePairEq && !diffPairEq) {
                return FluctuationType.REVERSE;
            } else if (!samePairEq && diffPairEq) {
                return FluctuationType.COMPLEMENT_REVERSE;
            } else { // samePairEq && diffPairEq
                return FluctuationType.NOTHING;
            }
        } else if (samePairEq != null) {
            return samePairEq ? FluctuationType.NOTHING : FluctuationType.COMPLEMENT;
        } else { // diffPairEq != null
            return diffPairEq ? FluctuationType.NOTHING : FluctuationType.COMPLEMENT;
        }
    }
}

enum FluctuationType {
    COMPLEMENT,
    REVERSE,
    COMPLEMENT_REVERSE,
    NOTHING
}

class BitArray {

    private static final byte UNKNOWN = -1;

    private final byte[] bits;

    public BitArray(int length) {
        this.bits = new byte[length];
        Arrays.fill(bits, UNKNOWN);
    }

    public int length() {
        return bits.length;
    }

    public void set(int i, byte bit) {
        bits[i] = bit;
    }

    public byte get(int i) {
        return bits[i];
    }

    public void applyFluctuation(FluctuationType fluctuationType) {
        switch (fluctuationType) {
            case COMPLEMENT:
                complement();
                break;
            case REVERSE:
                reverse();
                break;
            case COMPLEMENT_REVERSE:
                complementReverse();
                break;
        }
    }

    private void reverse() {
        for (int i = 0, j = bits.length - 1; i < j && bits[i] != UNKNOWN; i++, j--) {
            byte temp = bits[i];
            bits[i] = bits[j];
            bits[j] = temp;
        }
    }

    private void complement() {
        for (int i = 0, j = bits.length - 1; i < j && bits[i] != UNKNOWN; i++, j--) {
            bits[i] = complement(bits[i]);
            bits[j] = complement(bits[j]);
        }
    }

    private byte complement(byte x) {
        return (byte) (x ^ 1);
    }

    private void complementReverse() {
        complement();
        reverse();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (byte bit : bits) {
            char c = (bit == UNKNOWN) ? '?' : (bit == 0) ? '0' : '1';
            sb.append(c);
        }
        return sb.toString();
    }
}
