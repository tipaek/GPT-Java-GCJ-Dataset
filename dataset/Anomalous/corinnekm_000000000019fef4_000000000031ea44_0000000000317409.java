import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public class Position {
        private int x;
        private int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

    static boolean canReachPosition(Position myPos, Position catPos, int nbMoves) {
        return Math.abs(myPos.getX() - catPos.getX()) + Math.abs(myPos.getY() - catPos.getY()) <= nbMoves;
    }

    static Position move(Solution sol, Position start, char direction) {
        int x = start.getX();
        int y = start.getY();
        switch (direction) {
            case 'S':
                return sol.new Position(x, y - 1);
            case 'N':
                return sol.new Position(x, y + 1);
            case 'E':
                return sol.new Position(x + 1, y);
            case 'W':
                return sol.new Position(x - 1, y);
            default:
                return sol.new Position(x, y);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int T = Integer.parseInt(sc.nextLine());

        for (int t = 0; t < T; t++) {
            String[] input = sc.nextLine().split(" ");
            int X = Integer.parseInt(input[0]);
            int Y = Integer.parseInt(input[1]);
            char[] moves = input[2].toCharArray();
            int nbMoves = moves.length;

            Position[] catPositions = new Position[nbMoves + 1];
            catPositions[0] = sol.new Position(X, Y);

            Position positionZero = sol.new Position(0, 0);
            boolean found = false;

            for (int i = 1; i <= nbMoves && !found; i++) {
                catPositions[i] = move(sol, catPositions[i - 1], moves[i - 1]);
                if (canReachPosition(positionZero, catPositions[i], i)) {
                    found = true;
                    System.out.println("Case #" + (t + 1) + ": " + i);
                }
            }

            if (!found) {
                System.out.println("Case #" + (t + 1) + ": IMPOSSIBLE");
            }
        }
    }
}