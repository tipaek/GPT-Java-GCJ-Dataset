import java.util.*;
import java.io.*;

public class Solution {

    static class Move {
        int a;
        int b;
        Move parent;

        public Move(int a, int b, Move parent) {
            this.a = a;
            this.b = b;
            this.parent = parent;
        }

        @Override
        public String toString() {
            return "Move [a=" + a + ", b=" + b + "] -> " + parent;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int tc = 1; tc <= testCases; tc++) {
            int r = scanner.nextInt();
            int s = scanner.nextInt();
            solve(tc, r, s);
        }
        scanner.close();
    }

    private static void solve(int testCase, int r, int s) {
        int[] stack = new int[r * s];
        int value = 1;
        for (int i = 0; i < r * s; i++) {
            stack[i] = value++;
            if (value > r) {
                value = 1;
            }
        }

        List<Move> moves = findMoves(stack);

        System.out.println("Case #" + testCase + ": " + moves.size());
        for (int i = moves.size() - 1; i >= 0; i--) {
            Move move = moves.get(i);
            System.out.println(move.a + " " + move.b);
        }
    }

    private static List<Move> findMoves(int[] stack) {
        Queue<Move> queue = new LinkedList<>();
        queue.add(new Move(-1, -1, null));
        Set<String> seen = new HashSet<>();

        while (!queue.isEmpty()) {
            Move currentMove = queue.poll();
            int[] currentStack = Arrays.copyOf(stack, stack.length);

            List<Move> moveList = new ArrayList<>();
            Move temp = currentMove;
            while (temp != null) {
                if (temp.a > 0) {
                    moveList.add(temp);
                }
                temp = temp.parent;
            }

            for (int i = moveList.size() - 1; i >= 0; i--) {
                Move move = moveList.get(i);
                applySwap(currentStack, move.a, move.b);
            }

            if (isOrdered(currentStack)) {
                return moveList;
            }

            String key = Arrays.toString(currentStack);
            if (seen.contains(key)) continue;
            seen.add(key);

            for (int a = 1; a <= stack.length; a++) {
                for (int b = 1; b <= stack.length - a; b++) {
                    queue.add(new Move(a, b, currentMove));
                }
            }
        }

        return Collections.emptyList();
    }

    private static void applySwap(int[] stack, int a, int b) {
        int[] temp = new int[a];
        System.arraycopy(stack, 0, temp, 0, a);
        System.arraycopy(stack, a, stack, 0, b);
        System.arraycopy(temp, 0, stack, b, a);
    }

    private static boolean isOrdered(int[] stack) {
        for (int i = 1; i < stack.length; i++) {
            if (stack[i] < stack[i - 1]) {
                return false;
            }
        }
        return true;
    }
}