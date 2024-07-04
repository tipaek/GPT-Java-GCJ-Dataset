import java.util.*;

public class Solution {

    static class Move {
        int[] stack;
        int a;
        int b;
        Move parent;
        String key;

        public Move(int[] stack, int a, int b, Move parent) {
            this.stack = stack.clone(); // Ensure we clone the stack to avoid mutation issues
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
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
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
        int ri = 1;
        for (int i = 0; i < r * s; i++) {
            stack[i] = ri++;
            if (ri > r) {
                ri = 1;
            }
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
            Move currentMove = queue.poll();

            if (ordered(currentMove.stack)) {
                List<Move> moves = new ArrayList<>();
                while (currentMove != null) {
                    if (currentMove.a > 0) {
                        moves.add(currentMove);
                    }
                    currentMove = currentMove.parent;
                }
                return moves;
            }

            if (seen.contains(currentMove.key)) continue;
            seen.add(currentMove.key);

            for (int a = 1; a <= currentMove.stack.length; a++) {
                for (int b = 1; b <= currentMove.stack.length - a; b++) {
                    int[] newStack = swap(currentMove.stack, a, b);
                    queue.add(new Move(newStack, a, b, currentMove));
                }
            }
        }

        return Collections.emptyList();
    }

    private static int[] swap(int[] stack, int a, int b) {
        int[] newStack = new int[stack.length];

        System.arraycopy(stack, a, newStack, 0, b);
        System.arraycopy(stack, 0, newStack, b, a);
        System.arraycopy(stack, a + b, newStack, a + b, stack.length - a - b);

        return newStack;
    }

    private static boolean ordered(int[] stack) {
        for (int i = 1; i < stack.length; i++) {
            if (stack[i] < stack[i - 1]) return false;
        }
        return true;
    }
}