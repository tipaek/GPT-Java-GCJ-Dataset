import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();

        int T = Integer.parseInt(reader.readLine().trim());

        for (int t = 1; t <= T; t++) {
            output.append("Case #").append(t).append(": ");

            String[] tokens = reader.readLine().trim().split(" ");
            int r = Integer.parseInt(tokens[0]);
            int s = Integer.parseInt(tokens[1]);

            LinkedList<Pair> moves = getOptimalMoves(r, s);

            output.append(moves.size()).append("\n");
            for (Pair p : moves) {
                output.append(p.a).append(" ").append(p.b).append("\n");
            }
        }

        System.out.print(output);
    }

    private static LinkedList<Pair> getOptimalMoves(int r, int s) {
        LinkedList<Pair> moves = new LinkedList<>();

        if (r >= s) {
            for (int i = r; i > 1; i--) {
                moves.add(new Pair(i, i - 1));
            }

            return moves;
        }

        int num = (int) Math.pow(r, 2);
        for (int i = 1; i < r; i++) {
            for (int j = 0; j < r; j++) {
                moves.add(new Pair(num--, r - i));
            }
        }

        return moves;
    }

    static class Pair {
        int a;
        int b;

        Pair(int x, int y) {
            a = x;
            b = y;
        }
    }
}