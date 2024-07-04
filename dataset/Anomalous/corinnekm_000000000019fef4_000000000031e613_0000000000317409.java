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
    }

    static boolean canReachPosition(Position myPos, Position catPos, int nbMoves) {
        return Math.abs(myPos.x - catPos.x) + Math.abs(myPos.y - catPos.y) <= nbMoves;
    }

    static Position move(Position start, char direction) {
        switch (direction) {
            case 'S':
                return new Position(start.x, start.y - 1);
            case 'N':
                return new Position(start.x, start.y + 1);
            case 'E':
                return new Position(start.x + 1, start.y);
            case 'W': // Changed 'O' to 'W' for West direction
                return new Position(start.x - 1, start.y);
            default:
                return new Position(start.x, start.y);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = Integer.parseInt(sc.nextLine());

        for (int t = 0; t < T; t++) {
            String[] input = sc.nextLine().split(" ");
            int X = Integer.parseInt(input[0]);
            int Y = Integer.parseInt(input[1]);
            String strMoves = input[2];
            char[] moves = strMoves.toCharArray();
            int nbMoved = moves.length;
            Position[] catPositions = new Position[nbMoved + 1];
            catPositions[0] = new Position(X, Y);
            Position positionZero = new Position(0, 0);
            boolean found = false;

            for (int i = 1; i <= nbMoved && !found; i++) {
                Position actualCatPosition = move(catPositions[i - 1], moves[i - 1]);
                catPositions[i] = actualCatPosition;
                if (canReachPosition(positionZero, actualCatPosition, i)) {
                    found = true;
                    System.out.println("Case #" + t + ": " + i);
                }
            }

            if (!found) {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            }
        }
    }
}