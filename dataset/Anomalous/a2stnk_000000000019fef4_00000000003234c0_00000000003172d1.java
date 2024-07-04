import java.util.Arrays;
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

    static void solve(Scanner sc) {
        int N = sc.nextInt();
        int D = sc.nextInt();
        long[] A = new long[N];
        
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextLong();
        }
        
        Arrays.sort(A);
        int minCuts = D - 1;
        
        for (int i = 0; i < N; i++) {
            for (int j = 1; j <= D; j++) {
                long gcdValue = gcd(A[i], j);
                long numerator = A[i] / gcdValue;
                long denominator = j / gcdValue;
                boolean[] used = new boolean[N];
                int served = 0;
                int cuts = 0;
                
                for (int k = 0; k < N; k++) {
                    if (A[k] % numerator == 0) {
                        long capacity = A[k] * denominator / numerator;
                        if (served + capacity <= D) {
                            served += capacity;
                            cuts += capacity - 1;
                        } else {
                            int demand = D - served;
                            served += demand;
                            cuts += demand;
                        }
                        used[k] = true;
                    }
                }
                
                for (int k = 0; k < N; k++) {
                    if (!used[k]) {
                        long capacity = A[k] * denominator / numerator;
                        int demand = D - served;
                        served += Math.min(capacity, demand);
                        cuts += Math.min(capacity, demand);
                    }
                }
                
                if (served == D) {
                    minCuts = Math.min(minCuts, cuts);
                }
            }
        }
        
        System.out.println(minCuts);
    }

    static long gcd(long a, long b) {
        return (b == 0) ? a : gcd(b, a % b);
    }
}