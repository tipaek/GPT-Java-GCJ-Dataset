import java.util.Scanner;

public class Solution {

    static class Input {
        int n;
        int k;

        public Input(int n, int k) {
            this.n = n;
            this.k = k;
        }

        @Override
        public String toString() {
            return "Input [n=" + n + ", k=" + k + "]";
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int T = Integer.parseInt(scan.nextLine());
        for (int ks = 1; ks <= T; ks++) {
            Input input = readInput(scan);
            String solution = solve(input);
            System.out.println("Case #" + ks + ": " + solution);
        }
    }

    private static String solve(Input input) {
        if (input.k % input.n != 0) {
            return "IMPOSSIBLE";
        }

        StringBuilder solution = new StringBuilder("POSSIBLE");
        int l = input.k / input.n;

        for (int a = 0; a < input.n; a++) {
            solution.append("\n");
            int c = (l - a) % input.n;

            for (int b = 0; b < input.n; b++) {
                int d = (c + b) % input.n == 0 ? input.n : (c + b) % input.n;
                solution.append(d).append(" ");
            }
        }

        return solution.toString();
    }

    private static Input readInput(Scanner scan) {
        int n = scan.nextInt();
        int k = scan.nextInt();
        scan.nextLine(); // Consume the newline character
        return new Input(n, k);
    }
}