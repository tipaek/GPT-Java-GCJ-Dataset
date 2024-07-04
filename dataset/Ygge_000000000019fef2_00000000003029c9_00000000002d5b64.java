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
            List<Move> moves = new ArrayList<>();
            while (true) {
                int lookFor = r;
                int count = 0;
                boolean inOrder = true;
                for (int i = cards.length-1; i >= 0; --i) {
                    if (cards[i] != lookFor) {
                        inOrder = false;
                        moves.add(move(cards, i, lookFor));
                        break;
                    }
                    if (++count == s) {
                        count = 0;
                        --lookFor;
                    }
                }
                if (inOrder) {
                    break;
                }
            }
            System.out.println(String.format("Case #%d: %d", c, moves.size()));
            for (Move move : moves) {
                System.out.println(String.format("%d %d", move.x, move.y));
            }
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

    private static class Move {
        private final int x, y;

        private Move(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
