
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
            for (int i = 2; i <= Math.min(max/e.getKey(), D); i++) {
                if (map.containsKey(i*e.getKey())) {
                    boolean flag = false;
                    for (int x = 0; x < map.get(i*e.getKey()); x++) {
                    if (slices + i < D) {
                        chop += i-1;
                        slices += i;
                    } else if (slices+i == D) {
                        chop += i-1;
                        slices += i;
                        flag = true;
                        break;
                    } else {
                        chop += D - slices;
                        flag = true;

                        slices = D;
                        break;
                    }
                    if (flag) break;
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
