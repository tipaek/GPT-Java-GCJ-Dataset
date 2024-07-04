import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution {
    private final Scanner scanner;
    private final PrintStream out;
    private final List<Move> allMoves = new ArrayList<>();

    public Solution(InputStream in, PrintStream out) {
        this.scanner = new Scanner(in);
        this.out = out;

        initializeMoves();
    }

    public static void main(String[] args) {
        Solution expogo = new Solution(System.in, System.out);
        expogo.run();
    }

    private void run() {
        int testCount = scanner.nextInt();
        for (int i = 1; i <= testCount; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            evaluateTestCase(i, x, y);
        }
    }

    private void initializeMoves() {
        new Move(0, 1, new Loc(0, 0), null, null);
        allMoves.sort(Comparator.comparingInt(move -> move.moveIndex));
    }

    private void evaluateTestCase(int testNumber, int x, int y) {
        String result = allMoves.stream()
                .filter(move -> move.position.x == x && move.position.y == y)
                .findFirst()
                .map(this::buildPath)
                .orElse("IMPOSSIBLE");

        out.println("Case #" + testNumber + ": " + result);
    }

    private String buildPath(Move move) {
        StringBuilder path = new StringBuilder();
        while (move.parent != null) {
            path.insert(0, move.directionToGetHere.str);
            move = move.parent;
        }
        return path.toString();
    }

    enum Direction {
        NORTH("N"), EAST("E"), SOUTH("S"), WEST("W");

        public final String str;

        Direction(String str) {
            this.str = str;
        }
    }

    static class Loc {
        public final int x, y;

        public Loc(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    class Move {
        final int moveIndex;
        final int moveAmount;
        final Loc position;
        final List<Move> nextMoves = new ArrayList<>();
        final Move parent;
        final Direction directionToGetHere;

        Move(int moveIndex, int moveAmount, Loc position, Move parent, Direction directionToGetHere) {
            this.moveIndex = moveIndex;
            this.moveAmount = moveAmount;
            this.position = position;
            this.parent = parent;
            this.directionToGetHere = directionToGetHere;
            if (moveIndex < 5) {
                for (Direction direction : Direction.values()) {
                    Loc nextPosition = calculateNextPosition(direction, position);
                    nextMoves.add(new Move(moveIndex + 1, moveAmount * 2, nextPosition, this, direction));
                }
                allMoves.addAll(nextMoves);
            }
        }

        private Loc calculateNextPosition(Direction direction, Loc current) {
            switch (direction) {
                case EAST: return new Loc(current.x + moveAmount, current.y);
                case NORTH: return new Loc(current.x, current.y + moveAmount);
                case SOUTH: return new Loc(current.x, current.y - moveAmount);
                case WEST: return new Loc(current.x - moveAmount, current.y);
                default: throw new IllegalStateException("Unexpected value: " + direction);
            }
        }
    }
}