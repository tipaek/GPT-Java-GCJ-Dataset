import java.io.*;
import java.util.*;

public class Solution {

    private static void test() throws IOException {
        StringBuilder total = new StringBuilder();
        try (BufferedReader read = new BufferedReader(new FileReader("data/testIn"))) {
            String s;
            while ((s = read.readLine()) != null) {
                total.append(s).append("\n");
            }
        }
        InputStream testInput = new ByteArrayInputStream(total.toString().getBytes("UTF-8"));
        System.setIn(testInput);
    }

    public static void main(String[] args) throws IOException {
        // test();
        try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int t = Integer.parseInt(in.nextLine());
            for (int c = 1; c <= t; ++c) {
                System.out.println("Case #" + c + ": " + getResult(in));
            }
        }
    }

    private static String getResult(final Scanner in) {
        String[] input = in.nextLine().split(" ");
        int tR = Integer.parseInt(input[0]);
        int tS = Integer.parseInt(input[1]);
        final int size = tR * tS;
        Card[] cards = new Card[size];
        for (int i = 0; i < size; i++) {
            cards[i] = new Card(i % tR, i / tR);
        }
        State initialState = new State(new ArrayList<>(), cards);
        Queue<State> queue = new ArrayDeque<>();
        queue.add(initialState);

        while (true) {
            State currentState = queue.poll();
            if (findNextIncorrectCard(currentState.cards, tS, size) == -1) {
                return swapsToOutput(currentState.swaps);
            }
            for (int i = 0; i < size - 1; i++) {
                for (int j = i + 1; j < size; j++) {
                    State newState = new State(new ArrayList<>(currentState.swaps), swapCards(currentState.cards, i, j, size));
                    newState.swaps.add(new Swap(i + 1, j - i));
                    queue.add(newState);
                }
            }
        }
    }

    private static String swapsToOutput(List<Swap> swaps) {
        StringBuilder sb = new StringBuilder().append(swaps.size());
        for (Swap swap : swaps) {
            sb.append("\n").append(swap.a).append(" ").append(swap.b);
        }
        return sb.toString();
    }

    private static Card[] swapCards(Card[] input, int a, int b, int size) {
        Card[] output = new Card[size];
        int offset = a + 1;
        System.arraycopy(input, offset, output, 0, b - a);
        System.arraycopy(input, 0, output, b - a, a + 1);
        System.arraycopy(input, b + 1, output, b + 1, size - b - 1);
        return output;
    }

    private static int findNextIncorrectCard(Card[] cards, int s, int size) {
        for (int i = size - 1; i > 0; i--) {
            if (cards[i].r != i / s) {
                return i;
            }
        }
        return -1;
    }

    private static class State {
        private final List<Swap> swaps;
        private final Card[] cards;

        private State(List<Swap> swaps, Card[] cards) {
            this.swaps = swaps;
            this.cards = cards;
        }
    }

    private static class Swap {
        final int a, b;

        private Swap(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    private static class Card {
        final int r, s;

        private Card(int r, int s) {
            this.r = r;
            this.s = s;
        }
    }
}