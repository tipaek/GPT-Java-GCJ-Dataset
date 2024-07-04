import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int bitLength = scanner.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            BitSolver bitSolver = new BitSolver(scanner, bitLength);
            System.out.println(bitSolver.solve());
            if (scanner.next().equals("N")) {
                break;
            }
        }
    }
}

class BitSolver {

    private final BitArray bitArray;
    private final Scanner scanner;
    private int queryCount = 0;
    private Integer samePairIndex = null;
    private Integer diffPairIndex = null;

    public BitSolver(Scanner scanner, int length) {
        this.scanner = scanner;
        this.bitArray = new BitArray(length);
    }

    public String solve() {
        performIdleQuery();
        performIdleQuery();

        int left = 0;
        int right = bitArray.size() - 1;
        
        while (left < right) {
            if (queryCount % 10 != 0) {
                byte leftBit = queryBit(left);
                byte rightBit = queryBit(right);
                bitArray.setBit(left, leftBit);
                bitArray.setBit(right, rightBit);

                if (leftBit == rightBit) {
                    samePairIndex = left;
                } else {
                    diffPairIndex = left;
                }

                left++;
                right--;
            } else {
                FluctuationType fluctuation = detectFluctuation();
                bitArray.applyFluctuation(fluctuation);
            }
        }
        return bitArray.toString();
    }

    private void performIdleQuery() {
        queryBit(1); // Idle query
    }

    private byte queryBit(int index) {
        queryCount++;
        System.out.println(index + 1);
        return scanner.nextByte();
    }

    private FluctuationType detectFluctuation() {
        Boolean samePairMatch = (samePairIndex != null)
                ? queryBit(samePairIndex) == bitArray.getBit(samePairIndex)
                : performIdleQueryForFluctuation();
        Boolean diffPairMatch = (diffPairIndex != null)
                ? queryBit(diffPairIndex) == bitArray.getBit(diffPairIndex)
                : performIdleQueryForFluctuation();

        if (samePairMatch != null && diffPairMatch != null) {
            if (!samePairMatch && !diffPairMatch) {
                return FluctuationType.COMPLEMENT;
            } else if (samePairMatch && !diffPairMatch) {
                return FluctuationType.REVERSE;
            } else if (!samePairMatch && diffPairMatch) {
                return FluctuationType.COMPLEMENT_REVERSE;
            } else {
                return FluctuationType.NOTHING;
            }
        } else if (samePairMatch != null) {
            return samePairMatch ? FluctuationType.NOTHING : FluctuationType.COMPLEMENT;
        } else {
            return diffPairMatch ? FluctuationType.NOTHING : FluctuationType.COMPLEMENT;
        }
    }

    private Boolean performIdleQueryForFluctuation() {
        performIdleQuery();
        return null;
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

    public int size() {
        return bits.length;
    }

    public void setBit(int index, byte bit) {
        bits[index] = bit;
    }

    public byte getBit(int index) {
        return bits[index];
    }

    public void applyFluctuation(FluctuationType fluctuationType) {
        switch (fluctuationType) {
            case COMPLEMENT:
                complementBits();
                break;
            case REVERSE:
                reverseBits();
                break;
            case COMPLEMENT_REVERSE:
                complementBits();
                reverseBits();
                break;
            default:
                break;
        }
    }

    private void reverseBits() {
        for (int i = 0, j = bits.length - 1; i < j; i++, j--) {
            byte temp = bits[i];
            bits[i] = bits[j];
            bits[j] = temp;
        }
    }

    private void complementBits() {
        for (int i = 0; i < bits.length; i++) {
            bits[i] = (byte) (bits[i] ^ 1);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (byte bit : bits) {
            sb.append(bit == UNKNOWN ? '?' : (bit == 0 ? '0' : '1'));
        }
        return sb.toString();
    }
}