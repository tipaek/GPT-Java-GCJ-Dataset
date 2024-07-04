import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;

public class Solution {
    private static final int FREQ = 10;
    private static final StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) throws IOException {
        int t = nextInt();
        int b = nextInt();
        for (int cn = 1; cn <= t; cn++) {
            solve(b);
        }
    }

    private static void solve(int b) throws IOException {
        int same = -1;
        int opposite = -1;
        int tries = 0;
        int[] known = new int[b];
        Arrays.fill(known, -1);
        int current = 0;

        while (current < b / 2) {
            known[current] = read(current + 1);
            known[b - 1 - current] = read(b - current);
            tries += 2;

            if (opposite == -1 && known[current] != known[b - 1 - current]) opposite = current;
            if (same == -1 && known[current] == known[b - 1 - current]) same = current;
            current++;

            if (tries == FREQ && current < b / 2) {
                boolean reverse = false;
                boolean complement = false;

                if (same != -1) {
                    int r = read(same + 1);
                    if (r != known[same]) {
                        complement = true;
                    }
                } else {
                    read(1);
                }

                if (opposite != -1) {
                    int r = read(opposite + 1);
                    boolean changed = r != known[opposite];
                    if (changed ^ complement) reverse = true;
                } else {
                    read(1);
                }

                if (reverse) reverseArray(known);
                if (complement) complementArray(known);
                tries += 2;
            }
        }
        respond(known);
    }

    private static void respond(int[] known) throws IOException {
        StringBuilder res = new StringBuilder();
        for (int value : known) {
            res.append(value);
        }
        System.out.println(res);
        System.out.flush();
        if ("N".equals(next())) System.exit(0);
    }

    private static void complementArray(int[] known) {
        for (int i = 0; i < known.length; i++) {
            known[i] = known[i] == 0 ? 1 : 0;
        }
    }

    private static void reverseArray(int[] known) {
        for (int i = 0; i < known.length / 2; i++) {
            int j = known.length - 1 - i;
            int temp = known[i];
            known[i] = known[j];
            known[j] = temp;
        }
    }

    private static int read(int x) throws IOException {
        System.out.println(x);
        System.out.flush();
        return nextInt();
    }

    private static int nextInt() throws IOException {
        in.nextToken();
        return (int) in.nval;
    }

    private static String next() throws IOException {
        in.nextToken();
        return in.sval;
    }
}