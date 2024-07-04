import java.util.*;

public class Solution {

    private static int g(int d) {
        int solution = 0;
        while (d > 0) {
            d >>= 1;
            ++solution;
        }
        return solution;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nCases = scanner.nextInt();
        for (int caseNo = 1; caseNo <= nCases; ++caseNo) {
            int n = scanner.nextInt();
            int d = scanner.nextInt();
            List<Long> slices = new ArrayList<>();
            for (int i = 0; i < n; ++i) {
                long a = scanner.nextLong();
                slices.add(a);
            }
            if (n == 1) {
                int solution = g(d);
                System.out.println(String.format("Case #%d: %d", caseNo, solution));
            } else {
                SortedMap<Long, Integer> counts = new TreeMap<>();
                for (Long a : slices) {
                    if (!counts.containsKey(a)) {
                        counts.put(a, 1);
                    } else {
                        counts.put(a, counts.get(a) + 1);
                    }
                }
                if (d <= n) {
                    int maxCount = counts.values().stream().max(Comparator.naturalOrder()).get();
                    int solution = 0;
                    if (maxCount < d) {
                        solution = 1;
                    }
                    System.out.println(String.format("Case #%d: %d", caseNo, solution));
                } else {  // d > n
                    int ceiling = ((d - 1) - 1) / n + 1;
                    int solution = g(ceiling);
                    System.out.println(String.format("Case #%d: %d", caseNo, solution));
                }
            }
        }
    }

}
