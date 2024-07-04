

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *
 * @author alexk
 */
public class Solution {

    public static void main(String[] args) throws IOException {
        try (BufferedReader r = new BufferedReader(new InputStreamReader(System.in))) {
            process(r);
        }
    }

    private static class Input {

        int n;
        int[] s, e;

        public Input(BufferedReader r) throws IOException {
            n = Integer.parseInt(r.readLine());
            s = new int[n];
            e = new int[n];
            for (int i = 0; i < n; i++) {
                String[] ss = r.readLine().split(" ");
                s[i] = Integer.parseInt(ss[0]);
                e[i] = Integer.parseInt(ss[1]);
            }
        }
    }

    private static class Output {

        String s;

        public Output(String s) {
            this.s = s;
        }

        @Override
        public String toString() {
            return s;
        }
    }

    public static void process(BufferedReader r) throws IOException {
        int c = Integer.parseInt(r.readLine());
        for (int i = 0; i < c; i++) {
            System.out.println("Case #" + (i + 1) + ": " + solve(new Input(r)));
        }
    }

    static Output solve(Input in) {
        PriorityQueue<int[]> events = new PriorityQueue<>(Comparator.<int[]>comparingInt(v -> v[0])
                .thenComparing(Comparator.comparingInt(v -> v[1])));
        char[] assignments = new char[in.n];
        String owners = "CJ";
        boolean[] busy = new boolean[owners.length()];
        for (int i = 0; i < in.n; i++) {
            events.add(new int[]{in.e[i], 0, i});
            events.add(new int[]{in.s[i], 1, i});
        }
        int concurrent = 0;
        while (!events.isEmpty()) {
            int[] e = events.poll();
            if (e[1] == 0) {
                concurrent--;
                busy[owners.indexOf(assignments[e[2]])] = false;
            } else {
                concurrent++;
                if (concurrent == 3) {
                    return new Output("IMPOSSIBLE");
                }
                for (int i = 0; i < busy.length; i++) {
                    if (busy[i]) {
                        continue;
                    }
                    assignments[e[2]] = owners.charAt(i);
                    busy[i] = true;
                    break;
                }
            }
        }
        return new Output(new String(assignments));
    }
}
