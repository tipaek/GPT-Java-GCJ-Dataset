import java.util.*;

public class Solution {

    public static void main(String[] args) {
        solve();
    }

    static void solve() {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            String moves = scanner.next();
            solveCase(i, x, y, moves);
        }
    }

    static void solveCase(int caseNumber, int x, int y, String moves) {
        Coord[] catCoords = new Coord[moves.length() + 1];
        catCoords[0] = new Coord(-x, y);

        for (int i = 1; i <= moves.length(); i++) {
            char move = moves.charAt(i - 1);
            Coord previousCoord = catCoords[i - 1];
            switch (move) {
                case 'S':
                    catCoords[i] = new Coord(previousCoord.x, previousCoord.y - 1);
                    break;
                case 'N':
                    catCoords[i] = new Coord(previousCoord.x, previousCoord.y + 1);
                    break;
                default:
                    catCoords[i] = previousCoord; // No movement for invalid input
                    break;
            }
        }

        List<Set<Coord>> possibleCoords = new ArrayList<>();
        Set<Coord> initialSet = new HashSet<>();
        initialSet.add(new Coord(0, 0));
        possibleCoords.add(initialSet);

        for (int i = 1; i <= moves.length(); i++) {
            Set<Coord> currentSet = new HashSet<>();
            for (Coord coord : possibleCoords.get(i - 1)) {
                currentSet.add(new Coord(coord.x, coord.y));
                currentSet.add(new Coord(coord.x, coord.y - 1));
                currentSet.add(new Coord(coord.x, coord.y + 1));
                currentSet.add(new Coord(coord.x - 1, coord.y));
                currentSet.add(new Coord(coord.x + 1, coord.y));
            }
            possibleCoords.add(currentSet);
        }

        for (int i = 1; i <= moves.length(); i++) {
            if (possibleCoords.get(i).contains(catCoords[i])) {
                System.out.println("Case #" + (caseNumber + 1) + ": " + i);
                return;
            }
        }
        System.out.println("Case #" + (caseNumber + 1) + ": IMPOSSIBLE");
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

        TreeNode(int val) {
            this.val = val;
        }
    }
}