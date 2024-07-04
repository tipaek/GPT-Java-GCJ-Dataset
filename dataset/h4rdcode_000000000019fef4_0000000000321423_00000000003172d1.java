import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int d = in.nextInt();
            long[] angles = new long[n];
            for (int j = 0; j < n; j++) {
                angles[j] = in.nextLong();
            }

            HashMap<Double, Integer> map = new HashMap<>();
            for (long l : angles) {
                map.put((double) l, map.getOrDefault((double)l, 0) + 1);
            }

            int answ = 0;

            if (d == 2) {
                if (map.values().stream().anyMatch(q -> q > 1)) {
                    answ = 0;
                } else {
                    answ = 1;
                }
            } else if (d == 3) {
                if (map.values().stream().anyMatch(q -> q > 2)) {
                    answ = 0;
                } else if (map.values().stream().anyMatch(q -> q == 2)) {
                    double key = map.keySet().stream().filter(q -> map.get(q) == 2).min(Double::compareTo).get();
                    if (map.keySet().stream().anyMatch(q -> q > key)) {
                        answ = 1;
                    } else {
                        answ = 2;
                    }
                } else {
                    boolean f = false;
                    HashSet<Long> set = new HashSet<>();
                    set.addAll(Arrays.stream(angles).boxed().collect(Collectors.toList()));
                    for(long l : angles) {
                        f = f || set.contains(l * 2);
                    }
                    answ = f ? 1 : 2;
                }
            }

            System.out.println(String.format("Case #%d: %s", i + 1, answ));
        }
    }
}
