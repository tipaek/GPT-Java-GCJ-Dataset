import java.io.FileInputStream;
import java.util.*;

public class Solution {

    private static String process(Scanner in) {
        int N = in.nextInt();
        int D = in.nextInt();
        long[] A = new long[N];
        Map<Long, Integer> counts = new HashMap<>();
        boolean hasPair = false;
        boolean hasTriple = false;
        Set<Long> doubles = new HashSet<>();

        for (int i = 0; i < N; i++) {
            A[i] = in.nextLong();
            int currentCount = counts.getOrDefault(A[i], 0);
            counts.put(A[i], currentCount + 1);
            if (currentCount == 1) {
                hasPair = true;
                doubles.add(A[i]);
            }
            if (currentCount == 2) {
                hasTriple = true;
            }
        }

        if ((D == 3 && hasTriple) || (D == 2 && hasPair)) {
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
        return "X";
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