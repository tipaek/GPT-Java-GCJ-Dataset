import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(reader.readLine());
        for (int i = 0; i < T; i++) solve(reader, i + 1);
    }

    static void solve(BufferedReader reader, int caseNum) throws Exception {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int R = Integer.parseInt(tokenizer.nextToken());
        int S = Integer.parseInt(tokenizer.nextToken());

        Card[] cards = new Card[R * S];
        int idx = 0;
        for (int i = 1; i <= S; i++) {
            for (int j = 1; j <= R; j++) {
                cards[idx++] = new Card(j, i);
            }
        }
        
        int done = 0;
        int cur = 1;
        int count = 0;
        List<Card> swaps = new ArrayList<>();
        while (++done < cards.length) {
            if (done % S == 0) cur++;
            if (cards[done].r == cur) {
                continue;
            }
            int swapA = done, swapB = -1;

            for (int i = done + 1; i < cards.length; i++) {
                if (cards[i].r == cur) {
                    swapB = i;
                }
            }
            Card[] temp = new Card[swapB - swapA];
            for (int i = swapA; i < swapB; i++) {
                temp[i - swapA] = cards[i];
            }
            for (int i = swapA; i < swapA + cards.length - swapB; i++) {
                cards[i] = cards[swapB + i - swapA];
            }
            for (int i = swapA + cards.length - swapB; i < cards.length; i++) {
                cards[i] = temp[i - (swapA + cards.length - swapB)];
            }
            count++;
            
            swaps.add(new Card(temp.length, cards.length - swapB));
        }
        System.out.printf("Case #%d: %d%n", caseNum, count);
        for (Card card : swaps) {
            System.out.printf("%d %d%n", card.s, card.r);
        }
    }

    static class Card {
        int r, s;

        Card(int r, int s) {
            this.r = r;
            this.s = s;
        }
    }

}

// 1 2 3 1 2 3 1 2 3

// 1 1 2 3 2 3 1 2 3