import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int T = Integer.parseInt(reader.readLine());
            for (int i = 0; i < T; i++) {
                processCase(reader, i + 1);
            }
        }
    }

    private static void processCase(BufferedReader reader, int caseNum) throws Exception {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int R = Integer.parseInt(tokenizer.nextToken());
        int S = Integer.parseInt(tokenizer.nextToken());

        List<Card> cards = new ArrayList<>();
        for (int s = 1; s <= S; s++) {
            for (int r = 1; r <= R; r++) {
                cards.add(new Card(r, s));
            }
        }

        List<Swap> swaps = new ArrayList<>();
        int currentRound = 1;
        int swapCount = 0;

        for (int i = 1; i < cards.size(); i++) {
            if (i % S == 0) currentRound++;

            if (cards.get(i).r == currentRound) continue;

            int swapA = i, swapB = -1;
            for (int j = i + 1; j < cards.size(); j++) {
                if (cards.get(j).r == currentRound) {
                    swapB = j;
                    break;
                }
            }

            List<Card> temp = new ArrayList<>(cards.subList(swapA, swapB));
            cards.subList(swapA, swapB).clear();
            cards.addAll(swapA, temp);
            swapCount++;

            swaps.add(new Swap(temp.size(), cards.size() - swapB));
        }

        System.out.printf("Case #%d: %d%n", caseNum, swapCount);
        for (Swap swap : swaps) {
            System.out.printf("%d %d%n", swap.length, swap.position);
        }
    }

    private static class Card {
        int r, s;
        Card(int r, int s) {
            this.r = r;
            this.s = s;
        }
    }

    private static class Swap {
        int length, position;
        Swap(int length, int position) {
            this.length = length;
            this.position = position;
        }
    }
}