import java.util.*;

public class Solution {
    public static void main(String[] args) {
        solve(new Scanner(System.in));
    }

    public static void solve(Scanner scanner) {
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int sliceCount = scanner.nextInt();
            int dinerCount = scanner.nextInt();
            long[] slices = new long[sliceCount];
            for (int j = 0; j < sliceCount; j++) {
                slices[j] = scanner.nextLong();
            }
            int result = solve(slices, dinerCount);
            System.out.print("Case #" + (i + 1) + ": ");
            System.out.print(String.valueOf(result));
            if (i != n - 1)
                System.out.println();
        }
    }

    private static int solve(long[] slices, int dinerCount) {
        Arrays.sort(slices);
        List<Integer> primeList = getPrimeFactors(dinerCount);
        if (primeList.size() == 1) {
            Map<Long, List<List<Long>>> map = new HashMap<>(); // <sum, slices>
            List<List<Long>> zeroList = new ArrayList<>();
            zeroList.add(new ArrayList());
            map.put(0L, zeroList);
            for (int i = 0; i < slices.length; i++) {
                List<AbstractMap.SimpleEntry<Long, List<Long>>> newList = new ArrayList<>();
                for (Map.Entry<Long, List<List<Long>>> entry : map.entrySet()) {
                    for (List<Long> list : entry.getValue()) {
                        if (list.size() >= dinerCount) {
                            continue;
                        }
                        List<Long> newSliceList = new ArrayList(list);
                        newSliceList.add(slices[i]);
                        long newSum = entry.getKey() + slices[i];
                        newList.add(new AbstractMap.SimpleEntry<>(newSum, newSliceList));
                    }
                }

                for (AbstractMap.SimpleEntry<Long, List<Long>> pair : newList) {
                    if (!map.containsKey(pair.getKey())) {
                        map.put(pair.getKey(), new ArrayList<>());
                    }
                    map.get(pair.getKey()).add(pair.getValue());
                }
            }

            int bestSliceCount = 0;
            for (int j = 0; j < slices.length; j++) {
                long totalSlices = slices[j] * dinerCount;
                if (map.containsKey(totalSlices)) {
                    List<List<Long>> listList = map.get(totalSlices);
                    for (List<Long> list : listList) {
                        boolean canUse = true;
                        for (Long value : list) {
                            if (value % slices[j] != 0) {
                                canUse = false;
                                break;
                            }
                        }
                        if (canUse && list.size() > bestSliceCount)
                        bestSliceCount = list.size();
                    }
                }
            }

            if (bestSliceCount == 0) {
                return dinerCount - 1;
            }

            return dinerCount - bestSliceCount;
        }
        return -1;
    }

    private static List<Integer> getPrimeFactors(int n) {
        List<Integer> primeList = new ArrayList<>();
        while (n % 2 == 0) {
            primeList.add(2);
            n /= 2;
        }

        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            while (n % i == 0) {
                primeList.add(i);
                n /= i;
            }
        }

        if (n > 2)
            primeList.add(n);

        return primeList;
    }
}
