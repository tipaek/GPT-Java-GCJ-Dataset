import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    private static final String RESULT_PATTERN = "Case #{0}: {1}";
    private static final String INCORRECT_ANSWER = "N";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int bits = scanner.nextInt();

        for (int i = 1; i <= testCases; i++) {
            String solution = solve(scanner, bits);
            System.out.println(MessageFormat.format(RESULT_PATTERN, i, solution));
            if (scanner.next().equals(INCORRECT_ANSWER)) {
                return;
            }
        }
    }

    private static String solve(Scanner scanner, int bits) {
        List<BitPair> pairs = new ArrayList<>();
        BitPair firstSame = null;
        BitPair firstDifferent = null;
        int halfBits = bits / 2;

        for (int currentBit = 1; currentBit <= halfBits; currentBit++) {
            if (currentBit > 1 && currentBit % 10 == 1) {
                handleFluctuations(pairs, firstSame, firstDifferent, scanner);
            }
            BitPair bitPair = readBitPair(bits, currentBit, scanner);
            pairs.add(bitPair);
            if (bitPair.type == BitPairType.SAME && firstSame == null) {
                firstSame = bitPair;
            }
            if (bitPair.type == BitPairType.DIFFERENT && firstDifferent == null) {
                firstDifferent = bitPair;
            }
        }

        return buildOutput(pairs);
    }

    private static void handleFluctuations(List<BitPair> pairs, BitPair firstSame, BitPair firstDifferent, Scanner scanner) {
        boolean firstSameChanged = firstSame != null && ask(firstSame.position, scanner) != firstSame.leftBit;
        boolean firstDifferentChanged = firstDifferent != null && ask(firstDifferent.position, scanner) != firstDifferent.leftBit;

        if (firstSameChanged && firstDifferentChanged) {
            pairs.forEach(BitPair::complement);
        } else if (!firstSameChanged && firstDifferentChanged) {
            pairs.forEach(BitPair::reverse);
        } else if (firstSameChanged && !firstDifferentChanged) {
            pairs.forEach(BitPair::complementReverse);
        }
    }

    private static BitPair readBitPair(int length, int position, Scanner scanner) {
        boolean leftBit = ask(position, scanner);
        boolean rightBit = ask(length - position + 1, scanner);
        return new BitPair(leftBit, rightBit, position);
    }

    private static boolean ask(int position, Scanner scanner) {
        System.out.println(position);
        return scanner.nextInt() == 1;
    }

    private static String buildOutput(List<BitPair> pairs) {
        StringBuilder output = new StringBuilder();
        for (BitPair pair : pairs) {
            output.append(pair.leftBit ? '1' : '0');
        }
        for (int i = pairs.size() - 1; i >= 0; i--) {
            output.append(pairs.get(i).rightBit ? '1' : '0');
        }
        return output.toString();
    }

    private static class BitPair {
        final int position;
        boolean leftBit;
        boolean rightBit;
        final BitPairType type;

        BitPair(boolean leftBit, boolean rightBit, int position) {
            this.leftBit = leftBit;
            this.rightBit = rightBit;
            this.position = position;
            this.type = (leftBit == rightBit) ? BitPairType.SAME : BitPairType.DIFFERENT;
        }

        void reverse() {
            boolean temp = leftBit;
            leftBit = rightBit;
            rightBit = temp;
        }

        void complement() {
            leftBit = !leftBit;
            rightBit = !rightBit;
        }

        void complementReverse() {
            complement();
            reverse();
        }
    }

    private enum BitPairType {
        SAME,
        DIFFERENT
    }
}