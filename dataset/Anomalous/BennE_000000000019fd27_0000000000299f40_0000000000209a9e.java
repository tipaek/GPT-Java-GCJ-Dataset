import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    private static final String RESULT_PATTERN = "{0}";
    public static final String INCORRECT_ANSWER = "N";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int bits = scanner.nextInt();

        for (int i = 1; i <= testCases; i++) {
            String solution = findSolution(scanner, bits);
            System.out.println(MessageFormat.format(RESULT_PATTERN, solution));
            if (INCORRECT_ANSWER.equals(scanner.next())) {
                return;
            }
        }
    }

    private static String findSolution(Scanner scanner, int bits) {
        List<BitPair> pairs = new ArrayList<>();
        BitPair firstSame = null;
        BitPair firstDifferent = null;
        int bitLimit = bits / 2;

        for (int currentBit = 1; currentBit <= bitLimit; currentBit++) {
            if (currentBit > 1 && currentBit % 5 == 1) {
                handleFluctuation(pairs, firstSame, firstDifferent, scanner);
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

        StringBuilder output = new StringBuilder();
        for (BitPair pair : pairs) {
            output.append(pair.leftBit ? '1' : '0');
        }
        for (int i = pairs.size() - 1; i >= 0; i--) {
            output.append(pairs.get(i).rightBit ? '1' : '0');
        }
        return output.toString();
    }

    private static void handleFluctuation(List<BitPair> pairs, BitPair firstSame, BitPair firstDifferent, Scanner scanner) {
        if (firstSame == null) {
            if (askBit(firstDifferent.position, scanner) != firstDifferent.leftBit) {
                pairs.forEach(BitPair::complement);
            }
            return;
        }

        if (firstDifferent == null) {
            if (askBit(firstSame.position, scanner) != firstSame.leftBit) {
                pairs.forEach(BitPair::complement);
            }
            return;
        }

        boolean sameChanged = askBit(firstSame.position, scanner) != firstSame.leftBit;
        boolean differentChanged = askBit(firstDifferent.position, scanner) != firstDifferent.leftBit;

        if (sameChanged && differentChanged) {
            pairs.forEach(BitPair::complement);
        } else if (!sameChanged && differentChanged) {
            pairs.forEach(BitPair::reverse);
        } else if (sameChanged && !differentChanged) {
            pairs.forEach(BitPair::complementReverse);
        }
    }

    private static BitPair readBitPair(int length, int index, Scanner scanner) {
        boolean leftBit = askBit(index, scanner);
        boolean rightBit = askBit(length - index + 1, scanner);
        return new BitPair(leftBit, rightBit, index);
    }

    private static boolean askBit(int position, Scanner scanner) {
        System.out.println(position);
        return scanner.nextInt() == 1;
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
        SAME, DIFFERENT
    }
}