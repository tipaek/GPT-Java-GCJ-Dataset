

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Card {
    public int r;
    public int c;

    public Card(int r, int c) {
        this.r = r;
        this.c = c;
    }
}
public class Solution {
    private Scanner sc = new Scanner(System.in);

    private void go(List<Card> cards) {

    }

    private void solve() {
        int R = sc.nextInt();
        int C = sc.nextInt();

        List<Card> cards = new ArrayList<>();
        for (int j = 1; j <= C; ++j) {
            for (int i = 1; i <= R; ++i) {
                cards.add(new Card(i, j));
            }
        }

        List<Integer> rr = new ArrayList<>();
        for (int i = 1; i <= R; ++i) {
            for (int j = 1; j <= C; ++j) {
                rr.add(i);
            }
        }

        List<int[]> ret = new ArrayList<>();
        while (true) {
            int k = cards.size() - 1;
            while (k >= 0 && rr.get(k) == cards.get(k).r) {
                --k;
            }

            if (k < 0) {
                break;
            }

            int start = 0;
            while (start <= k && cards.get(start).r != cards.get(k + 1).r) {
                ++start;
            }

            List<Card> tmp = new ArrayList<>();
            for (int i = start + 1; i <= k; ++i) {
                tmp.add(cards.get(i));
            }

            for (int i = 0; i <= start; ++i) {
                tmp.add(cards.get(i));
            }

            for (int i = k + 1; i < cards.size(); ++i) {
                tmp.add(cards.get(i));
            }

            cards = tmp;
            ret.add(new int[] {start + 1, k - start});
        }
        
        System.out.println(ret.size());
        for (int[] s : ret) {
            System.out.println(String.format("%d %d", s[0], s[1]));
        }
    }

    private void run() {
        int T = sc.nextInt();
        for (int i = 1; i <= T; ++i) {
            System.out.print(String.format("Case #%d: ", i));
            solve();
        }
    }
    public static void main(String[] args) {
        new Solution().run();
    }
}
