import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int t = 0; t < T; t++) {
            int N = sc.nextInt();
            int D = sc.nextInt();
            int ans = D - 1;
            long[] A = new long[N];

            for (int i = 0; i < N; i++) {
                A[i] = sc.nextLong();
            }

            Arrays.sort(A);

            long current = A[0];
            int count = 0;
            int maxCount = 0;

            for (int i = 0; i < N; i++) {
                if (current == A[i]) {
                    count++;
                } else {
                    maxCount = Math.max(maxCount, count);
                    count = 1;
                    current = A[i];
                }
            }
            maxCount = Math.max(maxCount, count);

            if (maxCount >= D) {
                ans = 0;
            } else if (maxCount >= D - 1) {
                ans = 1;
            } else {
                boolean hasHalf = false;
                for (int i = 0; i < N && !hasHalf; i++) {
                    for (int j = i + 1; j < N && !hasHalf; j++) {
                        if (A[i] * 2 == A[j]) {
                            hasHalf = true;
                        }
                    }
                }
                ans = hasHalf ? 1 : 2;
                if (D == 2) {
                    ans = 1;
                }
            }

            System.out.println("Case #" + (t + 1) + ": " + ans);
        }

        sc.close();
    }
}