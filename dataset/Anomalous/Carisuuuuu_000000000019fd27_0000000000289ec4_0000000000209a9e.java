import javax.swing.plaf.basic.BasicButtonUI;
import java.io.PrintStream;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Solution {
    private enum State {
        NORMAL(false, false, false, false),
        SWAP(false, true, true, false),
        INVERSE(true, true, false, true),
        SWAP_INVERSE(true, false, true, true);

        private final boolean sameChange;
        private final boolean diffChange;
        private final boolean swap;
        private final boolean invert;

        State(boolean sameChange, boolean diffChange, boolean swap, boolean invert) {
            this.sameChange = sameChange;
            this.diffChange = diffChange;
            this.swap = swap;
            this.invert = invert;
        }

        static State findState(boolean diffChange, boolean sameChange) {
            return Arrays.stream(State.values())
                    .filter(s -> s.diffChange == diffChange && s.sameChange == sameChange)
                    .findFirst()
                    .orElseThrow();
        }

        State changeSame() {
            return findState(diffChange, true);
        }

        State changeDiff() {
            return findState(true, sameChange);
        }

        void applyChange(int[] bits, int pos) {
            int opp = bits.length - pos - 1;
            if (swap) {
                int temp = bits[pos];
                bits[pos] = bits[opp];
                bits[opp] = temp;
            }
            if (invert) {
                bits[pos] ^= 1;
                bits[opp] ^= 1;
            }
        }
    }

    private static final Scanner IN = new Scanner(System.in);
    private static final PrintStream OUT = System.out;
    private static final PrintStream LOG = System.err;

    public static void main(String[] args) {
        int t = IN.nextInt();
        int b = IN.nextInt();
        for (int g = 1; g <= t; ++g) {
            int[] bits = new int[b];
            int cnt = 0;
            OptionalInt samePos = OptionalInt.empty();
            OptionalInt diffPos = OptionalInt.empty();
            int sameBit = 0;
            int diffBit = 0;

            for (int a = 0; a < b / 2; ++a) {
                int[] next = checkBitPair(a, b);
                setBitPair(bits, next, a, b);

                if (!samePos.isPresent() && next[0] == next[1]) {
                    samePos = OptionalInt.of(a);
                    sameBit = next[0];
                }
                if (!diffPos.isPresent() && next[0] != next[1]) {
                    diffPos = OptionalInt.of(a);
                    diffBit = next[0];
                }

                if (cnt++ % 5 == 0) {
                    State state = State.NORMAL;
                    if (samePos.isPresent() && sameBit != checkBit(samePos.getAsInt())) {
                        state = state.changeSame();
                        sameBit ^= 1;
                    }
                    if (diffPos.isPresent() && diffBit != checkBit(diffPos.getAsInt())) {
                        state = state.changeDiff();
                        diffBit ^= 1;
                    }
                    if (samePos.isPresent() != diffPos.isPresent()) {
                        checkBit(0);
                    }
                    ++cnt;
                    for (int c = 0; c < b / 2; ++c) {
                        state.applyChange(bits, c);
                    }
                }
            }

            IntStream.of(bits).forEachOrdered(OUT::print);
            OUT.println();

            if (IN.next().equals("N")) {
                break;
            }
        }
    }

    private static int checkBit(int pos) {
        OUT.println(pos + 1);
        log(pos, "Check bit: ");
        return Integer.parseInt(log(IN.next(), "Result: "));
    }

    private static int[] checkBitPair(int pos, int total) {
        return new int[]{checkBit(pos), checkBit(total - pos - 1)};
    }

    private static void setBitPair(int[] bits, int[] pair, int pos, int total) {
        bits[pos] = pair[0];
        bits[total - pos - 1] = pair[1];
    }

    private static <T> T log(T object) {
        return log(object, "");
    }

    private static <T> T log(T object, String message) {
        LOG.println(message + object);
        return object;
    }
}