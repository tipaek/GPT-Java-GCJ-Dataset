import com.sun.security.jgss.GSSUtil;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        new Solution().solve();
    }

    class Card {
        int r, s;
        Card(int r, int s) {
            this.r = r;
            this.s = s;
        }

        @Override
        public String toString() {
            return "(" + r + "," + s + ")";
        }
    }

    List<Card> swap(List<Card> stack, int a, int b) {
        List<Card> newList = new ArrayList<>();
        for (int i = a, j = 0; j < b; i++, j++) {
            newList.add(stack.get(i));
        }
        for (int i = 0, j=0; j<a; i++, j++) {
            newList.add(stack.get(i));
        }
        for (int i = a+b; i < stack.size(); i++) {
            newList.add(stack.get(i));
        }
        return newList;
    }

    class Result {
        String res;
        int depth;
        Result(String r, int d) {
            res = r;
            depth = d;
        }
    }

    Result findBest(List<Card> cards, String curr, int depth) {
        if (depth > 6) {
            return null;
        }
        if (isSorted(cards)) {
            return new Result(curr, depth);
        }
        List<Result> results = new ArrayList<>();
        for (int i = 1; i < cards.size(); i++) {
            for (int j = 1; j < cards.size() - i; j++) {
                String s = i + " " + j + '\n';
                results.add(findBest(swap(new ArrayList<>(cards), i, j), curr + s, depth + 1));
            }
        }
        int minDepth = Integer.MAX_VALUE;
        Result min = null;
        for (Result r : results) {
            if (r != null && r.depth < minDepth) {
                min = r;
                minDepth = r.depth;
            }
        }
        return min;
    }


    void solve() {
        Scanner scan = new Scanner(System.in);
        int cases = scan.nextInt();
        for (int i = 0; i < cases; i++) {
            int ranks = scan.nextInt();
            int suits = scan.nextInt();
            List<Card> cards = new ArrayList<>();
            for (int s = 0; s < suits; s++) {
                for (int r = 0; r < ranks; r++) {
                    cards.add(new Card(r+1, s+1));
                }
            }
            Result best = findBest(new ArrayList<>(cards), "", 0);
            if (best == null) {
                best = new Result("", 0);
            }
            printCase(i+1,  '\n' + best.res);
        }
    }

    boolean isSorted(List<Card> cards) {
        for (int i = 1; i < cards.size() - 1; i++) {
            Card c = cards.get(i);
            Card before = cards.get(i-1);
            Card after = cards.get(i+1);
            if (c.r < before.r || c.r > after.r) {
                return false;
            }
        }
        return true;
    }



    void printCase(int num, String ans) {
        System.out.print("Case #" + num + ": " + ans);
    }

}
