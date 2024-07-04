import java.util.*;

class Solution {

    static Scanner scr = new Scanner(System.in);

    public static void main(String[] args) {
        int T = scr.nextInt();
        for (int t = 1; t <= T; t++) {
            int X = scr.nextInt();
            int Y = scr.nextInt();
            String MOVES = scr.nextLine().trim();
            List<String> results = new ArrayList<>();
            findPath(X, Y, MOVES, 0, results);
            OptionalInt ans = results.stream().filter(x -> !x.equals("IMPOSSIBLE")).mapToInt(Integer::parseInt).min();
            String result;
            if (ans.isPresent()) {
                result = Integer.toString(ans.getAsInt());
            } else {
                result = "IMPOSSIBLE";
            }
            System.out.format("Case #%d: %s\n", t, result);
        }
    }

    public static void findPath(int X, int Y, String MOVES, int mins, List<String> results) {
        if (X == 0 && Y == 0) {
            results.add(Integer.toString(mins));
            return;
        } else if (MOVES.isEmpty()) {
            results.add("IMPOSSIBLE");
            return;
        }

        Tuple<Integer, Integer> nextMove = getNextPosition(X, Y, MOVES);
        int newX = nextMove.x;
        int newY = nextMove.y;
        String remMoves = MOVES.substring(1);
        findPath(newX - 1, newY, remMoves, mins + 1, results);
        findPath(newX, newY + 1, remMoves, mins + 1, results);
        findPath(newX, newY - 1, remMoves, mins + 1, results);
        findPath(newX + 1, newY, remMoves, mins + 1, results);
        findPath(newX, newY, remMoves, mins + 1, results);
        return;
    }

    public static Tuple<Integer, Integer> getNextPosition(int X, int Y, String moves) {
        char c = moves.charAt(0);
        if (c == 'S') {
            return new Tuple<>(X, Y - 1);
        } else if (c == 'N') {
            return new Tuple<>(X, Y + 1);
        } else if (c == 'E') {
            return new Tuple<>(X + 1, Y);
        } else {
            return new Tuple<>(X - 1, Y);
        }
    }


}

class Tuple<X, Y> {
    X x;
    Y y;

    Tuple(X x, Y y) {
        this.x = x;
        this.y = y;
    }
}
