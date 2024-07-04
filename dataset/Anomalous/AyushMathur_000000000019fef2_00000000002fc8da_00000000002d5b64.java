import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder output = new StringBuilder();
            int T = Integer.parseInt(reader.readLine().trim());

            for (int t = 1; t <= T; t++) {
                output.append("Case #").append(t).append(": ");
                String[] tokens = reader.readLine().trim().split(" ");
                int r = Integer.parseInt(tokens[0]);
                int s = Integer.parseInt(tokens[1]);

                List<Pair> moves = calculateOptimalMoves(r, s);

                output.append(moves.size()).append("\n");
                for (Pair move : moves) {
                    output.append(move.a).append(" ").append(move.b).append("\n");
                }
            }
            System.out.print(output);
        }
    }

    private static List<Pair> calculateOptimalMoves(int r, int s) {
        List<Pair> moves = new ArrayList<>();

        if (r >= s) {
            for (int i = r; i > 1; i--) {
                moves.add(new Pair(i, i - 1));
            }
        } else {
            int num = r * r;
            for (int i = 1; i < r; i++) {
                for (int j = 0; j < r; j++) {
                    moves.add(new Pair(num--, r - i));
                }
            }
        }

        return moves;
    }

    static class Pair {
        int a;
        int b;

        Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
}