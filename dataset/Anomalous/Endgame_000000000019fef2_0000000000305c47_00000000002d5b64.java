import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int testCases = scanner.nextInt();
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            List<Move> moves = generateMoves();
            System.out.println("Case #" + caseNumber + ": " + moves.size());
            for (Move move : moves) {
                System.out.println(move.a + " " + move.b);
            }
        }
    }

    public static class Move {
        int a;
        int b;

        Move(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    private static List<Move> generateMoves() {
        int R = scanner.nextInt();
        int S = scanner.nextInt();
        List<Move> moves = new ArrayList<>();

        while (R > 1) {
            for (int i = 1; i < S; i++) {
                moves.add(new Move(R, R * S - R - i));
            }
            R--;
        }

        return moves;
    }
}