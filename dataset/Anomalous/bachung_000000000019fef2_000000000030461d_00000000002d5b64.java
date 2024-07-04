import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());

        for (int i = 0; i < T; i++) {
            solve(reader, i + 1);
        }
    }

    static void solve(BufferedReader reader, int caseNum) throws Exception {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int R = Integer.parseInt(tokenizer.nextToken());
        int S = Integer.parseInt(tokenizer.nextToken());

        List<Card> cards = new ArrayList<>();
        for (int i = 1; i <= S; i++) {
            for (int j = 1; j <= R; j++) {
                cards.add(new Card(j, i));
            }
        }

        Queue<Card> queue = new LinkedList<>(cards);
        int currentRank = 1;
        int count = 0;
        int removed = 0;
        int numSwaps = 0;
        List<Card> swaps = new ArrayList<>();

        while (!queue.isEmpty()) {
            if (count == S) {
                currentRank++;
                count = 0;
            }
            Card card = queue.poll();
            if (card.rank != currentRank) {
                queue.add(card);
                removed++;
            } else {
                if (removed > 0) {
                    numSwaps++;
                    swaps.add(new Card(queue.size(), removed));
                    removed = 0;
                }
                count++;
            }
        }

        System.out.printf("Case #%d: %d%n", caseNum, swaps.size());
        for (Card swap : swaps) {
            System.out.printf("%d %d%n", swap.suit, swap.rank);
        }
    }

    static class Card {
        int rank, suit;

        Card(int rank, int suit) {
            this.rank = rank;
            this.suit = suit;
        }
    }
}