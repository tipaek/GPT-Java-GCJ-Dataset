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
                    .findFirst()
                    .orElseThrow();
        }

        State changeSame(boolean sameChange) {
            return findState(this.diffChange, sameChange);
        }

        State changeDiff(boolean diffChange) {
            return findState(diffChange, this.sameChange);
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
            State state = State.NORMAL;

            for (int a = 0; a < b / 2; ++a) {
                int[] next = checkBitPair(a, b);
                setBitPair(bits, next, a, b);
                if (cnt++ % 5 == 0) {
                    // Logic for every 5th iteration can be added here if needed
                }
            }

            IntStream.of(bits).forEach(OUT::print);
            OUT.println();
            OUT.flush();

            if (IN.next().equals("N")) {
                break;
            }
        }
    }

    private static int checkBit(int pos) {
        OUT.println(pos + 1);
        OUT.flush();
        return IN.nextInt();
    }

    private static int[] checkBitPair(int pos, int total) {
        return new int[]{checkBit(pos), checkBit(total - pos - 1)};
    }

    private static void setBitPair(int[] bits, int[] pair, int pos, int total) {
        bits[pos] = pair[0];
        bits[total - pos - 1] = pair[1];
    }
}