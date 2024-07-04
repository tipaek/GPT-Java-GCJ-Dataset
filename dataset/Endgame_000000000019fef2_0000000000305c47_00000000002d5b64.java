import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    static Scanner in = new Scanner(System.in);

    public static void main(String args[]) {
        int T = in.nextInt();
        for (int i = 1; i <= T; i++) {
            List<Move> moves = secret();
            System.out.println("Case #" + i + ": " + moves.size());

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

    private static List<Move> secret() {
        int R = in.nextInt();
        int S = in.nextInt();
        List<Move> moves = new LinkedList<>();

        while (R > 1) {
            for (int i = 1; i < S; i++) {
                moves.add(new Move(R, R * S - R - i));
            }
            R--;
        }


        return moves;
    }
}
