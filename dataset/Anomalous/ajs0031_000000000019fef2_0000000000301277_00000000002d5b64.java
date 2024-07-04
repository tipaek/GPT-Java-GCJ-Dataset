import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    private static final List<Integer> amoves = new ArrayList<>();
    private static final List<Integer> bmoves = new ArrayList<>();

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int numCases = scanner.nextInt();
            for (int curCase = 1; curCase <= numCases; curCase++) {
                int R = scanner.nextInt();
                int S = scanner.nextInt();
                List<Card> deck = initializeDeck(R, S);
                sortDeck(deck);
                printResults(curCase);
            }
        }
    }

    private static List<Card> initializeDeck(int R, int S) {
        List<Card> deck = new ArrayList<>();
        for (int s = 1; s <= S; s++) {
            for (int r = 1; r <= R; r++) {
                deck.add(new Card(r, s));
            }
        }
        return deck;
    }

    private static void sortDeck(List<Card> deck) {
        while (!deck.isEmpty() && !allSame(deck)) {
            int A = 0, B = 0;
            Card lastCard = deck.remove(deck.size() - 1);
            int rank = lastCard.rank;
            int maxRank = rank;

            while (!deck.isEmpty() && deck.get(deck.size() - 1).rank == rank) {
                deck.remove(deck.size() - 1);
            }

            if (deck.isEmpty()) {
                return;
            }

            for (int i = deck.size() - 1; i >= 0; i--) {
                if (deck.get(i).rank != maxRank) {
                    B++;
                } else {
                    A = deck.size() - B;
                    break;
                }
            }

            if (A > 0) {
                amoves.add(A);
                bmoves.add(B);
                deck = cutDeck(deck, A, B);
            }
        }
    }

    private static List<Card> cutDeck(List<Card> deck, int A, int B) {
        List<Card> newDeck = new ArrayList<>();
        for (int i = A; i < A + B; i++) {
            newDeck.add(deck.get(i));
        }
        for (int i = 0; i < A; i++) {
            newDeck.add(deck.get(i));
        }
        return newDeck;
    }

    private static boolean allSame(List<Card> deck) {
        if (deck.size() <= 1) {
            return true;
        }
        int firstRank = deck.get(0).rank;
        for (Card card : deck) {
            if (card.rank != firstRank) {
                return false;
            }
        }
        return true;
    }

    private static void printResults(int curCase) {
        System.out.println("CASE #" + curCase + ": " + amoves.size());
        for (int i = 0; i < amoves.size(); i++) {
            System.out.println(amoves.get(i) + " " + bmoves.get(i));
        }
        amoves.clear();
        bmoves.clear();
    }
}

class Card {
    int rank;
    int suit;

    public Card(int rank, int suit) {
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public String toString() {
        return "(" + rank + "," + suit + ")";
    }
}