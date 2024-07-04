import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();

        int T = Integer.parseInt(reader.readLine().trim());

        for (int t = 1; t <= T; t++) {
            output.append("Case #").append(t).append(": ");
            output.append("\n");

            int N = Integer.parseInt(reader.readLine().trim());
            LinkedList<Pair> path = getPascalPath(N);

            for (Pair step : path) {
                output.append(step.r).append(" ").append(step.c).append("\n");
            }
        }

        System.out.print(output);
    }

    private static LinkedList<Pair> getPascalPath(int n) {
        LinkedList<Pair> path = new LinkedList<>();

        int r = 1, c = 1;
        path.add(new Pair(r, c));
        n--;

        int terms = (int) Math.floor((Math.sqrt(1 + 8 * n) - 1) / 2);
        while (terms-- > 0) {
            r++;
            c = 2;

            path.add(new Pair(r, c));
            n -= (r - 1);
        }

        while (n-- > 0) {
            c = 1;
            path.add(new Pair(r, c));
            r--;
        }

        return path;
    }

    static class Pair {
        int r, c;

        Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
