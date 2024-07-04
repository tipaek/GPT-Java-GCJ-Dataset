import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int rows = scanner.nextInt();
            int columns = scanner.nextInt();
            int[][] deck = new int[rows * columns][2];
            int deckIndex = 0;

            for (int column = 1; column <= columns; column++) {
                for (int row = 1; row <= rows; row++) {
                    deck[deckIndex][0] = row;
                    deck[deckIndex][1] = column;
                    deckIndex++;
                }
            }

            printResult(testCase, deck, rows, columns);
        }
    }

    private static void printResult(int testCase, int[][] deck, int rows, int columns) {
        ArrayList<int[]> moves = new ArrayList<>();
        String result = "Case #" + testCase + ": ";
        boolean sorted = true;
        int[] correctOrder = new int[rows * columns];
        int currentRow = 1;
        int currentColumn = 1;
        int moveCount = 0;

        for (int i = 0; i < correctOrder.length; i++) {
            correctOrder[i] = currentRow;
            currentColumn++;
            if (currentColumn > columns) {
                currentRow++;
                currentColumn = 1;
            }
        }

        while (true) {
            int a = -1;
            int b = -1;
            int correctRow = -1;
            moveCount++;
            sorted = true;

            for (int i = deck.length - 1; i > 0; i--) {
                if (deck[i][0] < correctOrder[i] && b == -1) {
                    b = i + 1;
                    correctRow = correctOrder[i];
                } else if (deck[i][0] == correctRow && b != -1) {
                    a = i + 1;
                    b = b - a;
                    sorted = false;
                    deck = rebuildDeck(deck, a, b);
                    break;
                }
            }

            if (sorted) break;
            moves.add(new int[]{a, b});
        }

        System.out.println(result + moveCount);
        for (int[] move : moves) {
            System.out.println(move[0] + " " + move[1]);
        }
    }

    private static int[][] rebuildDeck(int[][] deck, int a, int b) {
        int[][] deckA = new int[a][2];
        int[][] deckB = new int[b][2];
        int[][] newDeck = new int[deck.length][2];

        System.arraycopy(deck, 0, deckA, 0, a);
        System.arraycopy(deck, a, deckB, 0, b);
        System.arraycopy(deckB, 0, newDeck, 0, b);
        System.arraycopy(deckA, 0, newDeck, b, a);
        System.arraycopy(deck, a + b, newDeck, a + b, deck.length - a - b);

        return newDeck;
    }
}