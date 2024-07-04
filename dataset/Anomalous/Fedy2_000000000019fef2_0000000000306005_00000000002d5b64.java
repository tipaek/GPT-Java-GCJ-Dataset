import java.util.*;

public class Solution {

    static class Move {
        int[] stack;
        int a;
        int b;
        Move parent;
        String key;

        public Move(int[] stack, int a, int b, Move parent) {
            this.stack = stack.clone();
            this.a = a;
            this.b = b;
            this.parent = parent;
            this.key = Arrays.toString(stack);
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(stack);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Move other = (Move) obj;
            return Arrays.equals(stack, other.stack);
        }

        @Override
        public String toString() {
            return "Move [stack=" + Arrays.toString(stack) + ", a=" + a + ", b=" + b + "] -> " + parent;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        for (int tc = 1; tc <= t; tc++) {
            int r = in.nextInt();
            int s = in.nextInt();
            solve(tc, r, s);
        }
        in.close();
    }

    private static void solve(int tc, int r, int s) {
        int[] stack = new int[r * s];
        for (int i = 0; i < r * s; i++) {
            stack[i] = (i % r) + 1;
        }

        List<Move> moves = find(stack);

        System.out.println("Case #" + tc + ": " + moves.size());
        for (int i = moves.size() - 1; i >= 0; i--) {
            Move move = moves.get(i);
            System.out.println(move.a + " " + move.b);
        }
    }

    private static List<Move> find(int[] stack) {
        Queue<Move> queue = new LinkedList<>();
        queue.add(new Move(stack, -1, -1, null));

        Set<String> seen = new HashSet<>();

        while (!queue.isEmpty()) {
            Move current = queue.poll();

            int[] currentStack = Arrays.copyOf(stack, stack.length);
            List<Move> moves = new ArrayList<>();
            Move temp = current;
            while (temp != null) {
                if (temp.a > 0) {
                    moves.add(temp);
                }
                temp = temp.parent;
            }

            for (int i = moves.size() - 1; i >= 0; i--) {
                Move move = moves.get(i);
                swapInPlace(currentStack, move.a, move.b);
            }

            if (isOrdered(currentStack)) {
                return moves;
            }

            String key = Arrays.toString(currentStack);
            if (seen.contains(key)) continue;
            seen.add(key);

            for (int a = 1; a <= current.stack.length; a++) {
                for (int b = 1; b <= current.stack.length - a; b++) {
                    queue.add(new Move(stack, a, b, current));
                }
            }
        }

        return Collections.emptyList();
    }

    private static void swapInPlace(int[] stack, int a, int b) {
        int[] tmp = Arrays.copyOfRange(stack, 0, a);
        System.arraycopy(stack, a, stack, 0, b);
        System.arraycopy(tmp, 0, stack, b, a);
    }

    private static boolean isOrdered(int[] stack) {
        for (int i = 1; i < stack.length; i++) {
            if (stack[i] < stack[i - 1]) return false;
        }
        return true;
    }
}