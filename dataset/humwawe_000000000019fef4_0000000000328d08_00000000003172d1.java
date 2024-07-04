import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @author hum
 */
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int n = sc.nextInt();
        String result = "Case #%d: %d";
        f:
        for (int cas = 1; cas <= n; cas++) {
            int len = sc.nextInt();
            int d = sc.nextInt();
            TreeMap<Long, Integer> map = new TreeMap<>();
            long[] arr = new long[len];
            boolean f = false;
            for (int i = 0; i < len; i++) {
                arr[i] = sc.nextLong();
                map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
                if (map.get(arr[i]) >= d) {
                    f = true;
                }
            }
            if (f) {
                System.out.println(String.format(result, cas, 0));
            } else if (len == 1) {
                System.out.println(String.format(result, cas, d - 1));
            } else if (d == 2) {
                System.out.println(String.format(result, cas, 1));
            } else if (d == 3) {
                for (Long l : map.keySet()) {
                    if (map.containsKey(l * 2)) {
                        System.out.println(String.format(result, cas, 1));
                        continue f;
                    }
                }
                for (Long l : map.keySet()) {
                    if (map.get(l) == 2 && map.ceilingKey(l + 1) != null) {
                        System.out.println(String.format(result, cas, 1));
                        continue f;
                    }
                }
                System.out.println(String.format(result, cas, d - 1));
            }
        }
    }
}