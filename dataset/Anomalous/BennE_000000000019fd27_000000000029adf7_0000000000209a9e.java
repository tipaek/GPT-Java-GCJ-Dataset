import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    private static final String RESULT_PATTERN = "{0}";
    public static final String INCORRECT_ANSWER = "N";

    private static String getSolution(Scanner scanner, int bits) {
        List<BitPair> pairs = new ArrayList<>();
        BitPair firstSame = null;
        BitPair firstDifferent = null;
        int bitLimit = bits / 2;

        for (int currentBit = 1; currentBit <= bitLimit; currentBit++) {
            if (currentBit > 1 && currentBit % 5 == 1) {
                handleFluctuation(pairs, firstSame, firstDifferent, scanner);
            }
            BitPair bitPair = getBitPair(bits, currentBit, scanner);
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

    private static int handleFluctuation(List<BitPair> pairs, BitPair firstSame, BitPair firstDifferent, Scanner scanner) {
        if (firstSame == null) {
            boolean answer = ask(firstDifferent.position, scanner);
            ask(firstDifferent.position, scanner);
            if (answer != firstDifferent.leftBit) {
                pairs.forEach(BitPair::complement);
            }
            return 1;
        }

        if (firstDifferent == null) {
            boolean answer = ask(firstSame.position, scanner);
            ask(firstSame.position, scanner);
            if (answer != firstSame.leftBit) {
                pairs.forEach(BitPair::complement);
            }
            return 1;
        }

        boolean sameAnswer = ask(firstSame.position, scanner);
        boolean firstSameChanged = sameAnswer != firstSame.leftBit;

        boolean differentAnswer = ask(firstDifferent.position, scanner);
        boolean firstDifferentChanged = differentAnswer != firstDifferent.leftBit;

        if (firstSameChanged && firstDifferentChanged) {
            pairs.forEach(BitPair::complement);
        } else if (!firstSameChanged && firstDifferentChanged) {
            pairs.forEach(BitPair::reverse);
        } else if (firstSameChanged && !firstDifferentChanged) {
            pairs.forEach(BitPair::complementReverse);
        }
        return 2;
    }

    private static BitPair getBitPair(int length, int i, Scanner scanner) {
        boolean leftBit = ask(i, scanner);
        boolean rightBit = ask(length - (i - 1), scanner);
        return new BitPair(leftBit, rightBit, i);
    }

    private static boolean ask(int i, Scanner scanner) {
        System.out.println(i);
        int answer = scanner.nextInt();
        return answer == 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCases = scanner.nextInt();
        int bits = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            String solution = getSolution(scanner, bits);
            System.out.println(MessageFormat.format(RESULT_PATTERN, solution));
            String answer = scanner.next();
            if (answer.equals(INCORRECT_ANSWER)) {
                return;
            }
        }
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