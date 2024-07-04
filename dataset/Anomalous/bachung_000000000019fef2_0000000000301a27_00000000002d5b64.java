import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
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
        for (int s = 1; s <= S; s++) {
            for (int r = 1; r <= R; r++) {
                cards.add(new Card(r, s));
            }
        }

        int swapsCount = 0;
        List<Swap> swaps = new ArrayList<>();
        int curRow = 1;

        for (int i = 1; i < cards.size(); i++) {
            if (i % S == 0) curRow++;
            if (cards.get(i).r == curRow) continue;

            int swapA = i;
            int swapB = -1;
            for (int j = i + 1; j < cards.size(); j++) {
                if (cards.get(j).r == curRow) {
                    swapB = j;
                    break;
                }
            }

            List<Card> temp = new ArrayList<>(cards.subList(swapA, swapB));
            cards.subList(swapA, swapB).clear();
            cards.addAll(swapA, cards.subList(swapB, cards.size()));
            cards.subList(swapA + cards.size() - swapB, cards.size()).clear();
            cards.addAll(temp);

            swapsCount++;
            swaps.add(new Swap(temp.size(), cards.size() - swapB));
        }

        System.out.printf("Case #%d: %d%n", caseNum, swapsCount);
        for (Swap swap : swaps) {
            System.out.printf("%d %d%n", swap.length, swap.distance);
        }
    }

    static class Card {
        int r, s;

        Card(int r, int s) {
            this.r = r;
            this.s = s;
        }
    }

    static class Swap {
        int length, distance;

        Swap(int length, int distance) {
            this.length = length;
            this.distance = distance;
        }
    }
}