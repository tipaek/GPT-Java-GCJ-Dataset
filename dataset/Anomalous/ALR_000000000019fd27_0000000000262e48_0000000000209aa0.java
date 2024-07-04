import java.io.File;
import java.io.FileNotFoundException;
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

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(System.in);
        // Scanner scan = new Scanner(new File("./data/data1.in"));

        int T = Integer.parseInt(scan.nextLine());
        for (int ks = 1; ks <= T; ks++) {
            Input in = readInput(scan);
            String solution = solve(in);
            System.out.println("Case #" + ks + ": " + solution);
        }
    }

    private static String solve(Input in) {
        if (in.k % in.n != 0) {
            return "IMPOSSIBLE";
        }
        StringBuilder solution = new StringBuilder("POSSIBLE");
        int l = in.k / in.n;
        for (int a = 0; a < in.n; a++) {
            solution.append("\n");
            int c = (l - a + in.n) % in.n;
            for (int b = 0; b < in.n; b++) {
                int d = (c + b) % in.n == 0 ? in.n : (c + b) % in.n;
                solution.append(d).append(" ");
            }
        }

        return solution.toString();
    }

    private static Input readInput(Scanner scan) {
        int n = scan.nextInt();
        int k = scan.nextInt();
        return new Input(n, k);
    }
}