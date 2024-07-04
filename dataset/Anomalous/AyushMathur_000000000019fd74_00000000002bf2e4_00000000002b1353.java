import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();

        int T = Integer.parseInt(reader.readLine().trim());

        for (int t = 1; t <= T; t++) {
            output.append("Case #").append(t).append(":\n");

            int N = Integer.parseInt(reader.readLine().trim());
            List<Pair> path = generatePascalPath(N);

            for (Pair step : path) {
                output.append(step.row).append(" ").append(step.col).append("\n");
            }
        }

        System.out.print(output);
    }

    private static List<Pair> generatePascalPath(int n) {
        List<Pair> path = new ArrayList<>();

        int row = 1, col = 1;
        path.add(new Pair(row, col));
        n--;

        int terms = (int) Math.floor((Math.sqrt(1 + 8 * n) - 1) / 2);
        while (terms-- > 0) {
            row++;
            col = 2;

            path.add(new Pair(row, col));
            n -= (row - 1);
        }

        while (n-- > 0) {
            col = 1;
            path.add(new Pair(row, col));
            row--;
        }

        return path;
    }

    static class Pair {
        int row, col;

        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}