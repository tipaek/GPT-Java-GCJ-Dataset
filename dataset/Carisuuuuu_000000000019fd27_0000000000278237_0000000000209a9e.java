import javax.swing.plaf.basic.BasicButtonUI;
import java.io.PrintStream;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Solution {
    private static enum State {
        NORMAL(false, false),
        SWAP(false, true),
        INVERSE(true, true),
        SWAP_INVERSE(true, false);
        private boolean sameChange;
        private boolean diffChange;
        State(boolean sameChange, boolean diffChange) {
            this.sameChange = sameChange;
            this.diffChange = diffChange;
        }
        static State findState(boolean diffChange, boolean sameChange) {
            return Stream.of(State.values())
                    .filter(s -> s.diffChange == diffChange && s.sameChange == sameChange)
                    .findAny()
                    .get();
        }
        State changeSame(boolean diffSame) {
            return findState(diffChange, sameChange);
        }
        State changeDiff(boolean diffChange) {
            return findState(diffChange, sameChange);
        }
    }
    private static final Scanner IN = new Scanner(System.in);
    private static final PrintStream OUT = System.out;

    public static void main(String[] args) {
        int t = IN.nextInt();
        int b = IN.nextInt();
        for (int g = 1; g <= t; ++g) {
            int[] bits = new int[b];
            int cnt = 0;
            int[] samePair = new int[2];
            int[] diffPair = new int[2];
            boolean haveSame = false;
            boolean havDiff = false;
            State state = State.NORMAL;
            for (int a = 0; a < b/2; ++a) {
                int[] next = checkBitPair(a, b);
                setBitPair(bits, next, a, b);
                if (cnt++ % 5 == 0) {
                }
            }

            IntStream.of(bits).forEachOrdered(OUT::print);
            OUT.println();
            OUT.flush();

            if (IN.next().equals("N")) {
                break;
            }
        }
    }

    private static int checkBit(int pos) {
        OUT.println(pos);
        OUT.flush();
        return IN.nextInt();
    }

    private static int[] checkBitPair(int pos, int total) {
        return new int[] { checkBit(pos), checkBit(total-pos-1) };
    }

    private static void setBitPair(int[] bits, int[] pair, int pos, int total) {
        bits[pos] = pair[0];
        bits[total-pos-1] = pair[1];
    }
}