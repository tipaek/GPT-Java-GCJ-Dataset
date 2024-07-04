import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Oversized Pancake Choppers (10pts, 16pts, 16pts)
 */
public class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int t = 1; t <= T; t++) {
            int N = in.nextInt();
            int D = in.nextInt();
            long[] A = new long[N];
            for(int i = 0; i < N; i++) {
                A[i] = in.nextLong();
            }

            Map<Long, AtomicInteger> map = new HashMap<>();
            for(int i = 0; i < N; i++) {
                AtomicInteger count = map.computeIfAbsent(A[i], e -> new AtomicInteger(0));
                count.incrementAndGet();
            }
            Integer result = null;
            if(D == 2) {
                result = map.size() < A.length ? 0 : 1;
            } else if(D == 3) {
                if(map.size() < A.length - 1)  {
                    result = 0;
                } else if(map.size() < A.length) {
                    result = 1;
                } else {
                    for(int i = 0; i < N; i++) {
                        if(map.containsKey(A[i] * 2)) {
                            result = 1;
                            break;
                        }
                    }
                    if(null == result) {
                        result = 2;
                    }
                }
            } else {
                throw new RuntimeException();
            }
            System.out.format("Case #%d: %s\n", t, result);
        }
    }

}
