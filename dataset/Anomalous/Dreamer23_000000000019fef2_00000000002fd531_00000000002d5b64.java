import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    private static void test() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader("data/testIn"))) {
            StringBuilder total = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                total.append(line).append("\n");
            }
            InputStream testInput = new ByteArrayInputStream(total.toString().getBytes(StandardCharsets.UTF_8));
            System.setIn(testInput);
        }
    }

    public static void main(String[] args) throws IOException {
        // Uncomment the following line to enable test mode
        // test();
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int t = Integer.parseInt(scanner.nextLine());
            for (int c = 1; c <= t; ++c) {
                System.out.println("Case #" + c + ": " + getResult(scanner));
            }
        }
    }

    private static String getResult(final Scanner scanner) {
        String[] input = scanner.nextLine().split(" ");
        int tR = Integer.parseInt(input[0]);
        int tS = Integer.parseInt(input[1]);
        int size = tR * tS;
        Card[] cards = new Card[size];
        for (int i = 0; i < size; i++) {
            cards[i] = new Card(i % tR, i / tR);
        }
        List<Swap> swaps = new ArrayList<>();
        int next;
        while ((next = findNextIncorrectCard(cards, tS, size)) != -1) {
            int expectedR = next / tS;
            int a = findFirstCardWithR(cards, expectedR, size);
            swaps.add(new Swap(a + 1, next - a));
            cards = swapCards(cards, a, next, size);
        }
        return swapsToOutput(swaps);
    }

    private static String swapsToOutput(List<Swap> swaps) {
        StringBuilder sb = new StringBuilder().append(swaps.size());
        for (Swap swap : swaps) {
            sb.append("\n").append(swap.a).append(" ").append(swap.b);
        }
        return sb.toString();
    }

    private static Card[] swapCards(Card[] cards, int a, int b, int size) {
        Card[] output = new Card[size];
        int offset = a + 1;
        for (int i = offset; i <= b; i++) {
            output[i - offset] = cards[i];
        }
        offset = b - a;
        for (int i = 0; i <= a; i++) {
            output[i + offset] = cards[i];
        }
        for (int i = b + 1; i < size; i++) {
            output[i] = cards[i];
        }
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

    private static int findFirstCardWithR(Card[] cards, int r, int size) {
        for (int i = 0; i < size; i++) {
            if (cards[i].r == r) {
                return i;
            }
        }
        return -1;
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