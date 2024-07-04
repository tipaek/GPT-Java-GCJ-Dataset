import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int t = 1; t <= T; t++) {
            int solution = new Solution(scanner).solve();
            System.out.println("Case #" + t + ": " + solution);
        }
    }

    final int N, D;
    final long[] A;

    public Solution(Scanner scanner) {
        N = scanner.nextInt();
        D = scanner.nextInt();
        A = new long[N];
        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextLong();
        }
    }

    private int solve() {
        int max = getMax();

        if (max >= D) {
            return 0;
        } else if (D == 2) {
            return 1;
        }

        for (long a : A) {
            for (long b : A) {
                if (a == 2 * b) {
                    return 1;
                }
            }
        }

        OptionalInt max2 = getMaxWithLargest();
        if (max2.isPresent() && max2.getAsInt() >= D - 1) {
            return 1;
        }

        return 2;
    }

    private OptionalInt getMaxWithLargest() {
        long m = Arrays.stream(A).max().getAsLong();
        Map<Long, List<Long>> aToCount = Arrays.stream(A)
                .filter(l -> l != m)
                .boxed()
                .collect(Collectors.groupingBy(x -> x));

        return aToCount.values().stream()
                .mapToInt(List::size)
                .max();
    }

    private int getMax() {
        Map<Long, List<Long>> aToCount = Arrays.stream(A)
                .boxed()
                .collect(Collectors.groupingBy(x -> x));

        return aToCount.values().stream()
                .mapToInt(List::size)
                .max()
                .getAsInt();
    }

}
