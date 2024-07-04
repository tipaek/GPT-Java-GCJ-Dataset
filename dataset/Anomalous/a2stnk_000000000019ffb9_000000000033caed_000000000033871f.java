import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int T = sc.nextInt();
            
            for (int i = 0; i < T; i++) {
                System.out.printf("Case #%d: ", i + 1);
                solve(sc);
            }
        }
    }

    private static void solve(Scanner sc) {
        int C = sc.nextInt();
        int D = sc.nextInt();

        int[] order = new int[C];
        for (int i = 1; i < C; i++) {
            int X = sc.nextInt();
            if (X < 0) {
                order[i] = -X;
            }
        }

        int[] latency = new int[D];
        for (int i = 0; i < D; i++) {
            int U = sc.nextInt() - 1;
            int V = sc.nextInt() - 1;
            latency[i] = Math.abs(order[U] - order[V]);
            if (latency[i] == 0) {
                latency[i] = 1000000;
            }
        }

        for (int i = 0; i < D; i++) {
            System.out.print(latency[i]);
            if (i < D - 1) {
                System.out.print(" ");
            } else {
                System.out.println();
            }
        }
    }
}