import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static class Position {
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

    public static boolean canReachPosition(Position myPos, Position catPos, int nbMoves) {
        return Math.abs(myPos.getX() - catPos.getX()) + Math.abs(myPos.getY() - catPos.getY()) <= nbMoves;
    }

    public static Position move(Position start, char direction) {
        switch (direction) {
            case 'S':
                return new Position(start.getX(), start.getY() - 1);
            case 'N':
                return new Position(start.getX(), start.getY() + 1);
            case 'E':
                return new Position(start.getX() + 1, start.getY());
            case 'W':
                return new Position(start.getX() - 1, start.getY());
            default:
                return new Position(start.getX(), start.getY());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = Integer.parseInt(sc.nextLine());

        for (int t = 0; t < T; t++) {
            String input = sc.nextLine();
            String[] inputParts = input.split(" ");
            int X = Integer.parseInt(inputParts[0]);
            int Y = Integer.parseInt(inputParts[1]);
            char[] moves = inputParts[2].toCharArray();

            int nbMoves = moves.length;
            Position[] catPositions = new Position[nbMoves + 1];
            catPositions[0] = new Position(X, Y);
            Position positionZero = new Position(0, 0);

            boolean found = false;
            for (int i = 1; i <= nbMoves && !found; i++) {
                catPositions[i] = move(catPositions[i - 1], moves[i - 1]);
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