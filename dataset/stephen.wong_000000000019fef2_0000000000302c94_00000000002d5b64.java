import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {
    private final int id;
    private final int r;
    private final int s;
    private final List<Step> solution;

    public Solution(int id, int r, int s) {
        this.id = id;
        this.r = r;
        this.s = s;
        this.solution = new ArrayList<>();
    }

    public void solve() {
        solve(r, s);
    }

    private void solve(int r, int s) {
        if (r == 1) {
            return;
        }
        for (int i = 1; i < s; i ++) {
            solution.add(new Step(r, r * s - r - i));
        }
        solve(r - 1, s);
    }

    private static class Step {
        private final int a;
        private final int b;

        private Step(final int a, final int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public String toString() {
            return a + " " + b;
        }
    }

    @Override
    public String toString() {
        return "Case #" + id + ": " + solution.size() + "\n"
            + solution.stream()
            .map(Step::toString)
            .collect(Collectors.joining("\n"));
    }

    static void processInput(InputStream inputStream) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(inputStream)));

        int tests = Integer.parseInt(in.nextLine());  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int testNumber = 1; testNumber <= tests; ++testNumber) {
            String[] input = in.nextLine().split(" ");
            Solution solution = new Solution(testNumber, Integer.parseInt(input[0]), Integer.parseInt(input[1]));
            solution.solve();
            System.out.println(solution);
        }
    }

    public static void main(String[] args) {
        processInput(System.in);
    }
}
