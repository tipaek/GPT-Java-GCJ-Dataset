import java.io.FileInputStream;
import java.util.*;

public class Solution {

    private static String process(Scanner in) {
        int N = in.nextInt();
        int D = in.nextInt();
        long[] A = new long[N];
        Map<Long, Integer> counts = new HashMap<>();
        boolean has2plus = false;
        boolean has3plus = false;
        Set<Long> doubles = new HashSet<>();

        for (int i = 0; i < N; i++) {
            A[i] = in.nextLong();
            int curr = counts.getOrDefault(A[i], 0);
            counts.put(A[i], curr + 1);
            if (curr == 1) {
                has2plus = true;
                doubles.add(A[i]);
            }
            if (curr == 2) {
                has3plus = true;
            }
        }

        if ((D == 3 && has3plus) || (D == 2 && has2plus)) {
            return "0";
        } else if (D == 2) {
            return "1";
        } else if (D == 3) {
            for (Long key : counts.keySet()) {
                if (counts.containsKey(key * 2)) {
                    return "1";
                }
            }
            Arrays.sort(A);
            for (int i = 0; i < A.length - 1; i++) {
                if (doubles.contains(A[i])) {
                    return "1";
                }
            }
            return "2";
        }
        throw new RuntimeException("not supported");
    }

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in.available() > 0 ? System.in :
                new FileInputStream(Thread.currentThread().getStackTrace()[1].getClassName() + ".practice.in"));
        int T = in.nextInt();
        for (int i = 1; i <= T; i++) {
            System.out.format("Case #%d: %s\n", i, process(in));
        }
    }
}