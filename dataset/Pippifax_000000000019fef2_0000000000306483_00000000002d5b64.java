import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    private static BufferedReader in;
    static List<Deck> decks = new ArrayList<>();

    public static void main(String[] args) {
        readInput();

        int i = 1;

        for (Deck deck : decks) {
            reshuffleDeck(deck, i);
            i++;
        }
    }

    private static void reshuffleDeck(Deck deck, int testcaseId) {
        int cards[] = new int[deck.farben * deck.ranks];

        List<int[]> moves = new ArrayList<>();

        initializeDeck(cards, deck);

        int rankToSort = deck.ranks;

        while (rankToSort != 1) {
            int unsortedIndex = getUnsortedIndex(cards, deck);
            if (unsortedIndex == 0) {
                break;
            }

            rankToSort = getRankToSort(cards, deck);

            int firstCard = findFirstWithIndex(rankToSort, cards) + 1;
            int move[] = new int[2];
            move[0] = firstCard;
            move[1] = unsortedIndex - firstCard + 1;
            moves.add(move);

            performMove(cards, move);
        }

        System.out.println("Case #" + testcaseId + ": " + moves.size());

        for (int[] move : moves) {
            System.out.println(move[0] + " " + move[1]);
        }
    }

    private static void performMove(int[] cards, int[] move) {
        int pileA[] = new int[move[0]];
        int pileB[] = new int[move[1]];

        System.arraycopy(cards, 0, pileA, 0, move[0]);

        System.arraycopy(cards, move[0], pileB, 0, move[1]);

        System.arraycopy(pileB, 0, cards, 0, move[1]);

        System.arraycopy(pileA, 0, cards, move[1], move[0]);
    }

    private static int findFirstWithIndex(int rankToFind, int[] cards) {
        for (int i = 0; i < cards.length; i++) {
            if (cards[i] == rankToFind) {
                return i;
            }
        }

        return cards.length;
    }

    private static int getRankToSort(int[] cards, Deck deck) {
        int rankToSort = deck.ranks;
        int counter = 0;

        for (int i = cards.length - 1; i >= 0; i--) {
            if (cards[i] == rankToSort) {
                counter++;
                if (counter == deck.farben) {
                    rankToSort--;
                    counter = 0;
                }
            } else {
                return rankToSort;
            }
        }

        return rankToSort;
    }

    private static int getUnsortedIndex(int[] cards, Deck deck) {
        int rankToSort = deck.ranks;
        int counter = 0;

        for (int i = cards.length - 1; i >= 0; i--) {
            if (cards[i] == rankToSort) {
                counter++;
                if (counter == deck.farben) {
                    rankToSort--;
                    counter = 0;
                }
            } else {
                return i;
            }
        }

        return 0;
    }

    private static void initializeDeck(int[] cards, Deck deck) {
        for (int i = 0; i < cards.length; i++) {
            cards[i] = (i % deck.ranks) + 1;
        }
    }

    private static void readInput() {
        in = new BufferedReader(new InputStreamReader(System.in));

        try {
            String line = in.readLine();

            int numberOfTestCases = Integer.parseInt(line);

            for (int i = 0; i < numberOfTestCases; i++) {
                line = in.readLine();

                String[] fractals = line.split(" ");

                decks.add(new Deck(Integer.parseInt(fractals[0]), Integer.parseInt(fractals[1])));
            }
        } catch (IOException e) {
            System.out.println("something went wrong during reading input");
        }
    }

    private static class Deck {
        int ranks;
        int farben;

        public Deck(int ranks, int farben) {
            this.ranks = ranks;
            this.farben = farben;
        }
    }
}
