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

    Stack<Card> swap(Stack<Card> stack, int a, int b) {
        Stack<Card> c1 = new Stack<>();
        for (int i = 0; i < a; i++) {
            c1.push(stack.pop());
        }
        Stack<Card> c2 = new Stack<>();
        for (int i = 0; i < b; i++) {
            c2.push(stack.pop());
        }
        while (!c1.isEmpty()) {
            stack.push(c1.pop());
        }
        while (!c2.isEmpty()) {
            stack.push(c2.pop());
        }
        return stack;
    }

    class Result {
        String res;
        int depth;
        Result(String r, int d) {
            res = r;
            depth = d;
        }
    }

    Result findBest(Stack<Card> stack, String curr, int depth) {
        if (depth > 5) {
            return null;
        }
        if (isSorted(stack)) {
            return new Result(curr, depth);
        }
        List<Result> results = new ArrayList<>();
        for (int i = 1; i < stack.size(); i++) {
            //System.out.println(i + " " + (stack.size() - i));
            for (int j = 1; j < stack.size() - i; j++) {
                String s = i + " " + j + '\n';
                results.add(findBest(swap((Stack<Card>) stack.clone(), i, j), curr + s, depth + 1));
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
            Collections.reverse(cards);
            Stack<Card> stack = new Stack<>();
            stack.addAll(cards);
//            System.out.println(stack);
//            stack = swap(stack, 2, 1);
//            System.out.println(stack);
//            System.out.println(isSorted(stack));
            Result best = findBest((Stack<Card>)stack.clone(), "", 0);
            if (best == null) {
                best = new Result("", 0);
            }
            printCase(i+1, '\n' + best.res);
        }
    }

    boolean isSorted(Stack<Card> c2) {
        List<Card> cards = new ArrayList<>(c2);
        Collections.reverse(cards);
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
        System.out.println("Case #" + num + ": " + ans);
    }

}
