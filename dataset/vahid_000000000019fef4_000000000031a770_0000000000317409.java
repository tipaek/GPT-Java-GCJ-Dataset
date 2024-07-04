import static java.lang.Math.abs;
import static java.lang.String.format;

import java.io.BufferedInputStream;
import java.util.Scanner;

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
        for (int i = 0; i < input.m.length(); i++) {
            switch (input.m.charAt(i)) {
                case 'N':
                    input.y++;
                case 'S':
                    input.y--;
                case 'E':
                    input.x++;
                case 'W':
                    input.x--;
            }
            if (abs(input.x) + abs(input.y) - (i + 1) <= 0) {
                return String.valueOf(i+1);
            }
        }
        return "IMPOSSIBLE";
    }

    private Input getInput() {
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        String m = scanner.nextLine().trim();
        return new Input(x, y, m);
    }

    class Input {
        int x, y;
        String m;

        public Input(int x, int y, String m) {
            this.x = x;
            this.y = y;
            this.m = m;
        }
    }

}
