import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {

    private static final int[] BUFFER = new int[100000];

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int cases = readInt(in);
        for (int c = 1; c <= cases; ++c) {
            String[] split = in.readLine().split(" ");
            final int r = Integer.parseInt(split[0]);
            final int s = Integer.parseInt(split[1]);
            int[] cards = new int[r*s];
            int p = 0;
            for (int i = 1; i <= s; ++i) {
                for (int j = 1; j <= r; ++j) {
                    cards[p++] = j;
                }
            }

            List<Move> best = new ArrayList<>();
            solve(new State(new ArrayList<>(), cards), best, r, s);
            System.out.println(String.format("Case #%d: %d", c, best.size()));
            for (Move move : best) {
                System.out.println(String.format("%d %d", move.x, move.y));
            }
        }
    }

    private static void solve(State state, List<Move> best, int r, int s) {
        if (!best.isEmpty() && state.moves.size() >= best.size()) {
            return;
        }
        int lookFor = r;
        int count = 0;
        boolean inOrder = true;
        for (int i = state.cards.length-1; i >= 0; --i) {
            if (state.cards[i] != lookFor) {
                inOrder = false;
                State newState = new State(state);
                newState.moves.add(move(newState.cards, i, lookFor));
                solve(newState, best, r, s);
            }
            if (++count == s) {
                count = 0;
                --lookFor;
            }
        }
        if (inOrder && (best.isEmpty() || best.size() > state.moves.size())) {
            best.clear();
            best.addAll(state.moves);
        }
    }

    private static Move move(int[] cards, int index, int value) {
        int j = index-1;
        for (; j >= 0; --j) {
            if (cards[j] == value) {
                break;
            }
        }
        rearrange(cards, j, index);
        return new Move(j+1, index-j);
    }

    private static void rearrange(int[] cards, int j, int index) {
        System.arraycopy(cards, 0, BUFFER, 0, index + 1);
        for (int i = 0; i < index-j; ++i) {
            cards[i] = BUFFER[j+1+i];
        }
        for (int i = 0; i <= j; ++i) {
            cards[i+index-j] = BUFFER[i];
        }
    }

    private static int readInt(BufferedReader in) throws IOException {
        String line = in.readLine();
        return Integer.parseInt(line);
    }

    private static class State {
        private final List<Move> moves;
        private final int[] cards;

        private State(List<Move> moves, int[] cards) {
            this.moves = moves;
            this.cards = cards;
        }

        public State(State state) {
            moves = new ArrayList<>(state.moves);
            cards = new int[state.cards.length];
            System.arraycopy(state.cards, 0, cards, 0, cards.length);
        }
    }

    private static class Move {
        private final int x, y;

        private Move(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
