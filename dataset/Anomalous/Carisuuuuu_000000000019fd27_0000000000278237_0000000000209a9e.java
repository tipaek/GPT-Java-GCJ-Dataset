import javax.swing.plaf.basic.BasicButtonUI;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Solution {

    private enum State {
        NORMAL(false, false),
        SWAP(false, true),
        INVERSE(true, true),
        SWAP_INVERSE(true, false);

        private final boolean sameChange;
        private final boolean diffChange;

        State(boolean sameChange, boolean diffChange) {
            this.sameChange = sameChange;
            this.diffChange = diffChange;
        }

        static State findState(boolean diffChange, boolean sameChange) {
            return Stream.of(State.values())
                         .filter(s -> s.diffChange == diffChange && s.sameChange == sameChange)
                         .findAny()
                         .orElseThrow();
        }

        State changeSame(boolean sameChange) {
            return findState(this.diffChange, sameChange);
        }

        State changeDiff(boolean diffChange) {
            return findState(diffChange, this.sameChange);
        }
    }

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final PrintStream OUT = System.out;

    public static void main(String[] args) {
        int t = SCANNER.nextInt();
        int b = SCANNER.nextInt();

        for (int g = 1; g <= t; ++g) {
            int[] bits = new int[b];
            State state = State.NORMAL;
            int cnt = 0;

            for (int a = 0; a < b / 2; ++a) {
                int[] nextPair = queryBitPair(a, b);
                updateBitPair(bits, nextPair, a, b);

                if (++cnt % 5 == 0) {
                    // Perform any necessary operations every 5 queries
                }
            }

            IntStream.of(bits).forEachOrdered(OUT::print);
            OUT.println();
            OUT.flush();

            if ("N".equals(SCANNER.next())) {
                break;
            }
        }
    }

    private static int queryBit(int pos) {
        OUT.println(pos + 1); // Adjust for 1-based position
        OUT.flush();
        return SCANNER.nextInt();
    }

    private static int[] queryBitPair(int pos, int total) {
        return new int[]{queryBit(pos), queryBit(total - pos - 1)};
    }

    private static void updateBitPair(int[] bits, int[] pair, int pos, int total) {
        bits[pos] = pair[0];
        bits[total - pos - 1] = pair[1];
    }
}