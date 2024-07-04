
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    static List<Integer> stepA = new ArrayList<>();
    static List<Integer> stepB = new ArrayList<>();

    static int reSort(List<Integer> deck, int S) {
        int startB = -1, startA = -1;
        int prev = deck.get(0) / 100;
        int count = 1;
        for (int i = 1; i < deck.size(); i++) {
            int current = deck.get(i);
            if (current / 100 == prev) {
                count++;
            } else if (current / 100 > prev) {
                if (startA == -1) {
                    startA = i;
                }
            } else {
                if (count == S) {
                    count = 1;
                } else {
                    if (startB == -1) {
                        startB = i;
                    }
                }
            }
            prev = current / 100;
        }

        List<Integer> newDeck = new ArrayList<>(deck.subList(0, startB));
        List<Integer> pileA = new ArrayList<>(deck.subList(startA, deck.size()));
        List<Integer> pileB = new ArrayList<>(deck.subList(startB, startA));
        deck.clear();
        deck.addAll(newDeck);
        deck.addAll(pileA);
        deck.addAll(pileB);

        stepA.add(deck.size() - startA);
        stepB.add(startA - startB);

        if (!checkValidDeck(deck, S)) {
            return reSort(deck, S) + 1;
        }
        return 1;
    }

    static boolean checkValidDeck(List<Integer> deck, int S) {
        int last = deck.get(0) / 100;
        int count = 1;
        for (int i = 1; i < deck.size(); i++) {
            if (deck.get(i) / 100 == last) {
                count++;
            } else {
                if (count < S) {
                    return false;
                } else {
                    count = 1;
                }
            }
            last = deck.get(i) / 100;
        }
        return true;
    }

    public static void main(String[] args) {
//        checkValidDeck(Arrays.asList(201, 202, 101, 102), 2);
        int T = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int t = 1; t <= T; ++t) {
            int R = in.nextInt();
            int S = in.nextInt();

            stepA.clear();
            stepB.clear();

            List<Integer> deck = new ArrayList<>();
            for (int s = 1; s <= S; s++) {
                for (int r = 1; r <= R; r++) {
                    deck.add(r * 100 + s);
                }
            }

            Collections.reverse(deck);
//            System.out.println(deck);
            Integer run = reSort(deck, S);

            String res = "Case #" + t + ": " + run;

            for (int i = 0; i < run; i++) {
                res += "\n" + stepA.get(i) + " " + stepB.get(i);
            }

            System.out.println(res);
        }
    }
}
