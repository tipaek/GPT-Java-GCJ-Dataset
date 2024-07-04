import java.io.*;
import java.util.*;

public class Solution {
    static BufferedReader in;
    public static void main(String[] args) throws Exception {
        in = new BufferedReader(
                new InputStreamReader(System.in)
        );
        int T = Integer.parseInt(in.readLine());
        for (int x = 1; x <= T; x++) {
            String[] line = in.readLine().split(" ");
            int N = Integer.parseInt(line[0]);
            int D = Integer.parseInt(line[1]);
            long[] A = new long[N];
            line = in.readLine().split(" ");
            for (int i = 0; i < N; i++) {
                A[i] = Long.parseLong(line[i]);
            }
            int y = solve(N, D, A);
            System.out.printf("Case #%d: %d\n", x, y);
        }
    }

    static int solve(int N, int D, long[] A) {
        Map<Long, Integer> q = new HashMap<>();
        for (long p : A) {
            if (!q.containsKey(p)) {
                q.put(p, 1);
            } else {
                q.put(p, q.get(p) + 1);
            }
            if (q.get(p) == D) return 0;
        }
        if (D == 2) return 1;
        for (int i = 0; i < N; i++)
            for (int j = i+1; j < N; j++)
                if (A[i] == A[j])
                    for (int k = 0; k < N; k++)
                        if (A[k] > A[i])
                            return 1;
        for (int i = 0; i < N; i++)
            for (int j = i+1; j < N; j++)
                if (2*A[i] == A[j] || 2*A[j] == A[i])
                    return 1;
        return 2;
    }
}