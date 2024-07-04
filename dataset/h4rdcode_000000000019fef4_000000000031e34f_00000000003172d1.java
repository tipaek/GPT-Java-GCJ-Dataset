import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

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

            if (d == 2 && !map.values().stream().anyMatch(q -> q > 1)) {
                answ = 1;
            } else if (d == 3 && !map.values().stream().anyMatch(q -> q > 2)) {
                if (n == 1) {
                    answ = 2;
                } else if (Arrays.stream(angles).boxed().anyMatch(q -> map.containsKey(q / 2.0))) {
                    answ = 1;
                }
            }

            System.out.println(String.format("Case #%d: %s", i + 1, answ));
        }
    }
}
