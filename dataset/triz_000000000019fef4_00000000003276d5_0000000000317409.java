import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tests = scanner.nextInt();
        for (int i = 0; i < tests; i++) {
            int xPos = scanner.nextInt();
            int yPos = scanner.nextInt();
            String moves = scanner.next();
            int count = solve(xPos, yPos, moves);
            if (count == -1) {
                System.out.println(String.format("Case #%d: %s", i+1, "IMPOSSIBLE" ));
            } else {
                System.out.println(String.format("Case #%d: %d", i+1, count ));
            }
        }
    }

    private static int solve(int xPos, int yPos, String path) {
        Pair theirCurrentPos = new Pair(xPos, yPos);

        Set<Pair> currentLevelMoves = new HashSet<>();
        Set<Pair> nextLevelMoves = new HashSet<>();

        currentLevelMoves.add(new Pair(0, 0));

        for (int move = 0; move <= path.length(); move ++) {
            for (Pair p : currentLevelMoves) {
                if (p.equals(theirCurrentPos)) {
                    return move;
                }

                nextLevelMoves.add(new Pair(p.getX(), p.getY() + 1));
                nextLevelMoves.add(new Pair(p.getX() + 1, p.getY()));
                nextLevelMoves.add(new Pair(p.getX(), p.getY() - 1));
                nextLevelMoves.add(new Pair(p.getX() - 1, p.getY()));
                nextLevelMoves.add(new Pair(p.getX(), p.getY()));  // can stay put
            }

            currentLevelMoves = nextLevelMoves;
            nextLevelMoves = new HashSet<>();

            if (move == path.length()) {
                return -1;
            }
            char theirNextMove = path.charAt(move);

            switch (theirNextMove) {
                case 'N':
                    theirCurrentPos = new Pair(theirCurrentPos.getX(), theirCurrentPos.getY() + 1);
                    break;
                case 'E':
                    theirCurrentPos = new Pair(theirCurrentPos.getX() + 1, theirCurrentPos.getY());
                    break;
                case 'S':
                    theirCurrentPos = new Pair(theirCurrentPos.getX(), theirCurrentPos.getY() - 1);
                    break;
                case 'W':
                    theirCurrentPos = new Pair(theirCurrentPos.getX() - 1, theirCurrentPos.getY());
                    break;
            }
        }
        return -1;
    }

    private static class Pair {
        private final int x;
        private final int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return x == pair.x &&
                    y == pair.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
