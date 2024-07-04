import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        new Solution().solve();
    }

    public void solve() {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNo = 1; caseNo <= testCases; caseNo++) {
            int N = scanner.nextInt();
            long D = scanner.nextLong();
            long[] A = new long[N];
            
            for (int i = 0; i < N; i++) {
                A[i] = scanner.nextLong();
            }
            
            Arrays.sort(A);
            long minimumCuts = Long.MAX_VALUE;
            
            for (int i = 0; i < N; i++) {
                long cuts = 0;
                long total = 1;
                long remaining = D - 1;
                
                for (int j = i + 1; j < N && remaining > 0; j++) {
                    if (A[i] == A[j]) {
                        remaining--;
                        total++;
                        continue;
                    }
                    
                    long factor = A[j] / A[i];
                    if (A[j] % A[i] == 0) {
                        if (remaining + 1 < factor) {
                            cuts += remaining;
                            total += remaining;
                            remaining = 0;
                        } else {
                            cuts += factor - 1;
                            total += Math.min(remaining, factor);
                            remaining -= Math.min(remaining, factor);
                        }
                    } else {
                        if (remaining < factor) {
                            cuts += remaining;
                            total += remaining;
                            remaining = 0;
                        } else {
                            cuts += factor;
                            total += factor;
                            remaining -= factor;
                        }
                    }
                }
                
                if (remaining == 0) {
                    minimumCuts = Math.min(minimumCuts, cuts);
                } else if (total == 1) {
                    minimumCuts = Math.min(minimumCuts, D - 1);
                } else if (D % total == 0) {
                    cuts += (D / total - 1) * total;
                    minimumCuts = Math.min(minimumCuts, cuts);
                } else {
                    minimumCuts = Math.min(minimumCuts, cuts + D);
                }
            }
            
            System.out.printf("Case #%d: %d\n", caseNo, minimumCuts);
        }
    }
}