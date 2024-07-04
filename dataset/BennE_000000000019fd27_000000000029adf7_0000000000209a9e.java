import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    private static final String RESULT_PATTERN = "{0}";
    public static final String INCORRECT_ANSWER = "N";

    private static String getSolution(final Scanner scanner, final int bits) {
        final List<BitPair> pairs = new ArrayList<>();
        BitPair firstSame = null;
        BitPair firstDifferent = null;
        int bitLimit = bits/2;

        for (int currentBit = 1; currentBit <= bitLimit; currentBit++) {
            if(currentBit > 1 && currentBit % 5 == 1) {
                handleFluctuation(pairs, firstSame, firstDifferent, scanner);
            }
            final BitPair bitPair = getBitPair(bits, currentBit, scanner);
            pairs.add(bitPair);
            if(bitPair.type == BitPairType.SAME && firstSame == null) {
                firstSame = bitPair;
            }
            if(bitPair.type == BitPairType.DIFFERENT && firstDifferent == null) {
                firstDifferent = bitPair;
            }
        }

        final StringBuilder output = new StringBuilder();
        for (final BitPair pair : pairs) {
            output.append(pair.leftBit ? '1' : '0');
        }
        for(int i = pairs.size() - 1; i >= 0; i--) {
            output.append(pairs.get(i).rightBit ? '1' : '0');
        }
        return output.toString();
    }

    private static int handleFluctuation(final List<BitPair> pairs, final BitPair firstSame, final BitPair firstDifferent, final Scanner scanner) {
        if(firstSame == null) {
            final boolean answer = ask(firstDifferent.position, scanner);
            ask(firstDifferent.position, scanner);
            if(answer != firstDifferent.leftBit) {
                pairs.forEach(BitPair::complement);
            }
            return 1;
        }

        if(firstDifferent == null) {
            final boolean answer = ask(firstSame.position, scanner);
            ask(firstSame.position, scanner);
            if(answer != firstSame.leftBit) {
                pairs.forEach(BitPair::complement);
            }
            return 1;
        }

        final boolean sameAnswer = ask(firstSame.position, scanner);
        boolean firstSameChanged = sameAnswer != firstSame.leftBit;

        final boolean differentAnswer = ask(firstDifferent.position, scanner);
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

    private static BitPair getBitPair(final int length, final int i, final Scanner scanner) {
        final boolean leftBit = ask(i, scanner);
        final boolean rightBit = ask(length - (i - 1), scanner);
        return new BitPair(leftBit, rightBit, i);
    }

    private static boolean ask(int i, final Scanner scanner) {
        System.out.println(i);
        final int answer = scanner.nextInt();
        return answer == 1;
    }

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final int testCases = scanner.nextInt();
        final int bits = scanner.nextInt();
        for(int i = 1; i <= testCases; i++) {
            final String solution = getSolution(scanner, bits);
            System.out.println(MessageFormat.format(RESULT_PATTERN, solution));
            final String answer = scanner.next();
            if(answer.equals(INCORRECT_ANSWER)) {
                return;
            }
        }
    }

    private static class BitPair {
        final int position;
        boolean leftBit;
        boolean rightBit;
        final BitPairType type;

        public BitPair(final boolean leftBit, final boolean rightBit, final int position) {
            this.leftBit = leftBit;
            this.rightBit = rightBit;
            type = leftBit == rightBit ? BitPairType.SAME : BitPairType.DIFFERENT;
            this.position = position;
        }

        public void reverse() {
            boolean temp = leftBit;
            leftBit = rightBit;
            rightBit = temp;
        }

        public void complement() {
            leftBit = !leftBit;
            rightBit = !rightBit;
        }

        public void complementReverse() {
            complement();
            reverse();
        }
    }

    private enum BitPairType {
        SAME,
        DIFFERENT
    }
}
