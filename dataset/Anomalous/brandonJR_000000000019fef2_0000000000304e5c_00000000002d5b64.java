import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int t = 1; t <= testCases; t++) {
            int ranks = scanner.nextInt();
            int suits = scanner.nextInt();
            List<String> swaps = performSwaps(ranks, suits);

            System.out.printf("Case #%d: %d%n", t, swaps.size());
            for (String swap : swaps) {
                System.out.printf("%s%n", swap);
            }
        }
    }

    private static List<String> performSwaps(int ranks, int suits) {
        List<Card> deck = initializeDeck(ranks, suits);
        List<String> swaps = new ArrayList<>();

        while (!isDeckInOrder(deck)) {
            deck = swapDeck(deck, ranks, suits, swaps);
        }

        return swaps;
    }

    private static List<Card> initializeDeck(int ranks, int suits) {
        List<Card> deck = new ArrayList<>();
        for (int suit = 1; suit <= suits; suit++) {
            for (int rank = 1; rank <= ranks; rank++) {
                deck.add(new Card(rank, suit));
            }
        }
        return deck;
    }

    private static List<Card> swapDeck(List<Card> deck, int ranks, int suits, List<String> swaps) {
        int topSuit = deck.get(0).getSuit();
        int firstCut = findFirstCut(deck, topSuit);
        int secondCut = findSecondCut(deck, ranks, suits, firstCut);

        swaps.add(firstCut + " " + (secondCut - firstCut));
        secondCut = Math.min(secondCut, deck.size());

        if (firstCut > 0 && secondCut > firstCut) {
            List<Card> a = new ArrayList<>(deck.subList(0, firstCut));
            List<Card> b = new ArrayList<>(deck.subList(firstCut, secondCut));
            List<Card> c = new ArrayList<>(deck.subList(secondCut, deck.size()));
            deck.clear();
            deck.addAll(b);
            deck.addAll(a);
            deck.addAll(c);
        }

        return deck;
    }

    private static int findFirstCut(List<Card> deck, int topSuit) {
        for (int i = 0; i < deck.size(); i++) {
            if (deck.get(i).getSuit() != topSuit) {
                return i;
            }
        }
        return deck.size();
    }

    private static int findSecondCut(List<Card> deck, int ranks, int suits, int firstCut) {
        if (ranks > suits) {
            int endFirstCutRank = deck.get(firstCut - 1).getRank();
            for (int i = firstCut; i < deck.size(); i++) {
                if (deck.get(i).getRank() == endFirstCutRank) {
                    return i;
                }
            }
        } else {
            int firstCutRank = deck.get(firstCut).getRank();
            for (int i = firstCut + 1; i < deck.size(); i++) {
                if (deck.get(i).getRank() == firstCutRank) {
                    return i + 1;
                }
            }
        }
        return deck.size();
    }

    private static boolean isDeckInOrder(List<Card> deck) {
        for (int i = 1; i < deck.size(); i++) {
            if (deck.get(i).getRank() < deck.get(i - 1).getRank()) {
                return false;
            }
        }
        return true;
    }

    static class Card {
        private final int rank;
        private final int suit;

        public Card(int rank, int suit) {
            this.rank = rank;
            this.suit = suit;
        }

        public int getRank() {
            return rank;
        }

        public int getSuit() {
            return suit;
        }

        @Override
        public String toString() {
            return "Card [rank=" + rank + ", suit=" + suit + "]";
        }
    }
}