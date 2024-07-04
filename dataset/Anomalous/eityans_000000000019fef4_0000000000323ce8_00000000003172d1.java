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
            long tmp = A[0];
            int cnt = 0;
            int maxCnt = 0;
            
            for (int i = 0; i < N; i++) {
                if (tmp == A[i]) {
                    cnt++;
                } else {
                    maxCnt = Math.max(maxCnt, cnt);
                    cnt = 1;
                    tmp = A[i];
                }
            }
            maxCnt = Math.max(maxCnt, cnt);
            
            if (maxCnt >= D) {
                ans = 0;
            } else if (maxCnt >= D - 1) {
                ans = 1;
            } else {
                boolean hasHalf = false;
                outerLoop:
                for (int i = 0; i < N; i++) {
                    for (int j = i + 1; j < N; j++) {
                        if (A[i] * 2 == A[j]) {
                            hasHalf = true;
                            break outerLoop;
                        }
                    }
                }
                ans = hasHalf ? 1 : 2;
            }

            System.out.println("Case #" + (t + 1) + ": " + ans);
        }

        sc.close();
    }
}