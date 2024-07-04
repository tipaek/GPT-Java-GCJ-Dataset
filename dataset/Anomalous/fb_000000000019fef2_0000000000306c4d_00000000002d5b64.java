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

        Queue<CardState> stateQueue = new LinkedList<>();
        stateQueue.add(new CardState(cards));

        while (!stateQueue.isEmpty()) {
            Queue<CardState> nextQueue = new LinkedList<>();
            for (CardState currentState : stateQueue) {
                if (currentState.isSorted()) {
                    System.out.println("Case #" + caseId + ": " + currentState.history.size());
                    for (String step : currentState.history) {
                        System.out.println(step);
                    }
                    return;
                }
                for (int i = totalCards - 1; i > 0; i--) {
                    for (int j = totalCards - i; j > 0; j--) {
                        nextQueue.add(currentState.permute(i, j));
                    }
                }
            }
            stateQueue = nextQueue;
        }
    }

    private static class CardState {
        int[] cards;
        List<String> history;

        CardState(int[] cards) {
            this.cards = Arrays.copyOf(cards, cards.length);
            this.history = new ArrayList<>();
        }

        boolean isSorted() {
            for (int i = 0; i < cards.length - 1; i++) {
                if (cards[i] > cards[i + 1]) {
                    return false;
                }
            }
            return true;
        }

        CardState permute(int a, int b) {
            int[] newCards = new int[cards.length];
            int index = 0;
            for (int i = a; i < a + b; i++) {
                newCards[index++] = cards[i];
            }
            for (int i = 0; i < a; i++) {
                newCards[index++] = cards[i];
            }
            for (int i = a + b; i < cards.length; i++) {
                newCards[index++] = cards[i];
            }
            CardState newState = new CardState(newCards);
            newState.history.addAll(this.history);
            newState.history.add(a + " " + b);
            return newState;
        }
    }
}