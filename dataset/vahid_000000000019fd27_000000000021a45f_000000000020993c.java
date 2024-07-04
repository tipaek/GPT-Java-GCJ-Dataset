import static java.lang.String.format;
import static java.util.Arrays.stream;
import static java.util.stream.IntStream.range;

import java.io.BufferedInputStream;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution {

    private static Scanner scanner = new Scanner(new BufferedInputStream(System.in, 64 * 1024));

    public static void main(String[] args) {
        new Solution().solveProblem();
    }

    private void solveProblem() {
        int t = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < t; i++) {
            solveCase(i + 1);
        }
    }

    private void solveCase(int item) {
        Input input = getInput();
        System.out.println(format("Case #%d: %s", item, solve(input)));
    }

    private String solve(Input input) {
        int trace = range(0, input.n).map(i -> input.m[i][i]).sum();
        int rows = range(0, input.n).map(i -> stream(input.m[i]).boxed().collect(Collectors.toSet()).size() < input.n ? 1 : 0).sum();
        int cols = 0;
        for (int i = 0; i < input.n; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < input.n; j++) {
                set.add(input.m[j][i]);
            }
            if (set.size() < input.n) cols++;
        }
        return format("%s %s %s", trace, rows, cols);
    }

    private Input getInput() {
        int n = scanner.nextInt();
        int[][] m = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                m[i][j] = scanner.nextInt();
            }
        }
        return new Input(n, m);
    }

    class Input {
        int n;
        int[][] m;

        public Input(int n, int[][] m) {
            this.n = n;
            this.m = m;
        }
    }

}
