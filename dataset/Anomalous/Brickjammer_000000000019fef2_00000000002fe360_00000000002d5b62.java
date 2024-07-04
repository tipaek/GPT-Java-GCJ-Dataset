import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution {
    private Scanner scanner;
    private InputStream in;
    private PrintStream out;
    private List<Move> allMoves = new ArrayList<>();

    public Solution(InputStream in, PrintStream out) {
        this.in = in;
        this.out = out;
        this.scanner = new Scanner(in);

        new Move(0, 1, new Loc(0, 0), null, null);

        allMoves.sort(Comparator.comparingInt(m -> m.moveIndex));
    }

    public static void main(String[] args) {
        Solution expogo = new Solution(System.in, System.out);
        expogo.run();
    }

    public void run() {
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            processTestCase(i, x, y);
        }
    }

    private void processTestCase(int testCaseNumber, int x, int y) {
        String result = allMoves.stream()
                                .filter(m -> m.position.x == x && m.position.y == y)
                                .findFirst()
                                .map(this::generatePath)
                                .orElse("IMPOSSIBLE");

        out.println("Case #" + testCaseNumber + ": " + result);
    }

    private String generatePath(Move move) {
        StringBuilder path = new StringBuilder();
        while (move.parent != null) {
            path.insert(0, move.direction.str);
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
        public int x, y;

        public Loc(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    class Move {
        int moveIndex;
        int moveAmount;
        Loc position;
        List<Move> nextMoves = new ArrayList<>();
        Move parent;
        Direction direction;

        public Move(int moveIndex, int moveAmount, Loc position, Move parent, Direction direction) {
            this.moveIndex = moveIndex;
            this.moveAmount = moveAmount;
            this.position = position;
            this.parent = parent;
            this.direction = direction;
            if (moveIndex < 10) {
                for (Direction dir : Direction.values()) {
                    Loc nextPosition = calculateNextPosition(dir, position);
                    nextMoves.add(new Move(moveIndex + 1, moveAmount * 2, nextPosition, this, dir));
                }
                allMoves.addAll(nextMoves);
            }
        }

        private Loc calculateNextPosition(Direction direction, Loc current) {
            switch (direction) {
                case EAST:
                    return new Loc(current.x + moveAmount, current.y);
                case NORTH:
                    return new Loc(current.x, current.y + moveAmount);
                case SOUTH:
                    return new Loc(current.x, current.y - moveAmount);
                case WEST:
                    return new Loc(current.x - moveAmount, current.y);
                default:
                    throw new IllegalStateException("Unexpected value: " + direction);
            }
        }
    }
}