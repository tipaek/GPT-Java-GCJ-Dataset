import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            processTestCase(i + 1, scanner);
        }
    }

    private static void processTestCase(int caseId, Scanner scanner) {
        int rows = scanner.nextInt();
        int columns = scanner.nextInt();
        int totalCards = rows * columns;

        int[] cards = new int[totalCards];
        int index = 0;

        for (int col = 0; col < columns; col++) {
            for (int row = 0; row < rows; row++) {
                cards[index++] = row;
            }
        }

        Queue<CardState> queue = new LinkedList<>();
        queue.add(new CardState(cards));

        while (true) {
            Queue<CardState> nextQueue = new LinkedList<>();
            for (CardState state : queue) {
                if (state.isSorted()) {
                    System.out.println("Case #" + caseId + ": " + state.history.size());
                    for (String step : state.history) {
                        System.out.println(step);
                    }
                    return;
                }
                for (int i = 1; i < totalCards; i++) {
                    for (int j = 1; j <= totalCards - i; j++) {
                        nextQueue.add(state.permute(i, j));
                    }
                }
            }
            queue = nextQueue;
        }
    }

    private static class CardState {

        int[] cards;
        List<String> history;

        CardState(int[] cards) {
            this.cards = cards;
            this.history = new LinkedList<>();
        }

        boolean isSorted() {
            for (int i = 0; i < cards.length - 1; i++) {
                if (cards[i] > cards[i + 1]) {
                    return false;
                }
            }
            return true;
        }

        CardState permute(int start, int length) {
            int[] newCards = new int[cards.length];
            int index = 0;

            for (int i = start; i < start + length; i++) {
                newCards[index++] = cards[i];
            }
            for (int i = 0; i < start; i++) {
                newCards[index++] = cards[i];
            }
            for (int i = start + length; i < cards.length; i++) {
                newCards[index++] = cards[i];
            }

            CardState newState = new CardState(newCards);
            newState.history.addAll(this.history);
            newState.history.add(start + " " + length);
            return newState;
        }
    }
}