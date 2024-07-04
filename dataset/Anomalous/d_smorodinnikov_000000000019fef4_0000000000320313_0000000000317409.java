import java.util.Objects;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        solve();
    }

    static void solve() {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            String s = scanner.next();
            solveCase(i, x, y, s);
        }
    }

    static void solveCase(int caseNumber, int x, int y, String moves) {
        Coord initial = new Coord(0, 0);
        Coord[] catCoords = new Coord[moves.length() + 1];
        catCoords[0] = new Coord(x, y);

        for (int i = 1; i <= moves.length(); i++) {
            char move = moves.charAt(i - 1);
            catCoords[i] = getNextCoord(catCoords[i - 1], move);

            int steps = calculateManhattanDistance(catCoords[i], initial);
            if (steps <= i) {
                System.out.println("Case #" + (caseNumber + 1) + ": " + i);
                return;
            }
        }

        System.out.println("Case #" + (caseNumber + 1) + ": IMPOSSIBLE");
    }

    static Coord getNextCoord(Coord current, char move) {
        switch (move) {
            case 'S': return new Coord(current.x, current.y - 1);
            case 'N': return new Coord(current.x, current.y + 1);
            case 'W': return new Coord(current.x - 1, current.y);
            case 'E': return new Coord(current.x + 1, current.y);
            default: throw new IllegalArgumentException("Invalid move: " + move);
        }
    }

    static int calculateManhattanDistance(Coord c1, Coord c2) {
        return Math.abs(c1.x - c2.x) + Math.abs(c1.y - c2.y);
    }

    static class Coord {
        int x, y;

        Coord(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Coord coord = (Coord) obj;
            return x == coord.x && y == coord.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int x) {
            val = x;
        }
    }
}