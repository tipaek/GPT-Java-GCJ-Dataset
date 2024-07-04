import java.io.*;
import java.util.*;

public class Solution {
    private static final boolean INTERACTIVE_PROBLEM = false;
    private static final String FILE_NAME = null;

    private static String solve(Scanner in) {
        int R = in.nextInt();
        int S = in.nextInt();

        int[] deck = new int[R * S];
        for (int i = 0; i < S; i++) {
            for (int j = 1; j <= R; j++) {
                deck[i * R + j - 1] = j;
            }
        }

        List<Integer> bestReordering = new ArrayList<>();
        int cardCount = S;
        int cardNum = R;

        for (int i = deck.length - 1; i >= 0; i--) {
            if (deck[i] != cardNum) {
                for (int j = i - 1; j >= 0; j--) {
                    if (deck[j] == cardNum) {
                        bestReordering.add(j + 1);
                        bestReordering.add(i - j);

                        int[] deckCopy = deck.clone();
                        for (int index = 0; index < i - j; index++) {
                            deck[index] = deckCopy[j + 1 + index];
                        }
                        for (int index = 0; index < j + 1; index++) {
                            deck[i - j + index] = deckCopy[index];
                        }
                    }
                }
            }

            cardCount--;
            if (cardCount == 0) {
                cardCount = S;
                cardNum--;
            }
        }

        StringBuilder answer = new StringBuilder();
        answer.append(bestReordering.size() / 2);

        for (int i = 0; i < bestReordering.size(); i += 2) {
            answer.append("\n" + bestReordering.get(i) + " " + bestReordering.get(i + 1));
        }

        return answer.toString();
    }

    private static void run() {
        try {
            Scanner in = new Scanner(new BufferedReader(FILE_NAME == null ? new InputStreamReader(System.in)
                    : new FileReader(new File(FILE_NAME + ".in"))));

            long tc = in.nextLong();
            for (long t = 1; t <= tc; t++) {
                final String solution = solve(in);
                if (!INTERACTIVE_PROBLEM) {
                    System.out.println("Case #" + t + ": " + solution);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        run();
    }
}
