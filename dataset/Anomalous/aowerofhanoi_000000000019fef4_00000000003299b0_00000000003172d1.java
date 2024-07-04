import java.util.Scanner;

public class Solution {
    static int solve(Scanner sc) {
        int N = sc.nextInt();
        int D = sc.nextInt();
        long[] A = new long[N + 1];
        
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextLong() * D;
        }
        A[N] = 1;

        if (D == 1) {
            return 0;
        } else if (N == 1) {
            return D - 1;
        }

        int minCuts = D - 1;

        for (int i = 0; i < N; i++) {
            long size = A[i];
            int cuts = 0;
            int count = 0;

            // Count occurrences of the same size
            for (int j = 0; j < N; j++) {
                if (A[j] == size) {
                    count++;
                }
            }

            if (count >= D) {
                return 0;
            }

            for (int pieces = 2; pieces < 100; pieces++) {
                for (int j = 0; j < N; j++) {
                    if (A[j] % size == 0 && A[j] / size == pieces) {
                        for (int f = 0; f < pieces; f++) {
                            count++;
                            cuts++;
                            if (count >= D) {
                                minCuts = Math.min(minCuts, cuts);
                            }
                        }
                    }
                }
            }
        }

        return minCuts;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int result = solve(sc);
            System.out.println("Case #" + t + ": " + result);
        }
    }
}