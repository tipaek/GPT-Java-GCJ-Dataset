import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static Map<Long, Integer> freq;

    public static int getSmallestCount(long[] arr, int d, int n) {
        Arrays.sort(arr);
        for (long value : arr) {
            if (freq.get(value) == d) {
                return 0;
            }
        }
        if (d == 2) {
            return 1;
        } else if (d == 3) {
            if (n == 1) {
                return 2;
            } else if (n == 2) {
                return (arr[0] * 2 == arr[1]) ? 1 : 2;
            } else {
                for (long value : arr) {
                    if (Arrays.asList(arr).contains(value * 2)) {
                        return 1;
                    }
                }
                return 2;
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int tt = 1; tt <= t; tt++) {
            int n = sc.nextInt();
            int d = sc.nextInt();
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextLong();
            }
            freq = new HashMap<>();
            for (long s : arr) {
                freq.put(s, freq.getOrDefault(s, 0) + 1);
            }
            System.out.println("Case #" + tt + ": " + getSmallestCount(arr, d, n));
        }
        sc.close();
    }
}