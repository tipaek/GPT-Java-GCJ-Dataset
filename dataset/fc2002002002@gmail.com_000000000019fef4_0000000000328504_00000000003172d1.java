
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tc = scanner.nextInt();
        for (int i = 0; i < tc; i++) {
            int N = scanner.nextInt();
            int D = scanner.nextInt();
            long[] array = new long[N];
            for (int j = 0; j < N; j ++) {
                array[j] = scanner.nextLong();
            }
            int re = get(N, D, array);
            System.out.println("Case #" + (i+1) + ": " + re);
        }
    }
    private static int get(int N, int D, long[] array) {
        TreeMap<Long, Integer> map = new TreeMap<>();
        long max = 0;
        for (long a : array) {
            map.put(a, map.getOrDefault(a, 0) + 1);
            max = Math.max(max, a);
        }
        int minChop = D;
        for (Map.Entry<Long, Integer> e : map.entrySet()) {
            int chop = 0, slices = e.getValue();
            if (slices >= D) return 0;
        }
        for (Map.Entry<Long, Integer> e : map.entrySet()) {
            int chop = 0, slices = e.getValue();
            for (int i = 2; i <= Math.min(max/e.getKey(), D - e.getValue()); i++) {
                if (map.containsKey(i*e.getKey())) {
                    if (slices + i < D) {
                        chop += i-1;
                        slices += i;
                    } else if (slices+i == D) {
                        chop += i-1;
                        slices += i;
                        break;
                    } else {
                        chop += D - slices;

                        slices = D;
                        break;
                    }
                }

            }
            if (slices < D) {
                chop += D-slices;

            }
            minChop = Math.min(minChop, chop);

        }
        return minChop;
    }



}
