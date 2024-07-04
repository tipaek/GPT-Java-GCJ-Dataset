import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int d = in.nextInt();
            TreeMap<Long, Integer> ts = new TreeMap<>((a, b) -> a - b < 0 ? -1 : a == b ? 0 : 1);
            for (int j = 0; j < n; j++) {
                long a = in.nextLong();
                ts.put(a, ts.getOrDefault(a, 0) + 1);
            }
            if (d == 2) {
                int res = 1;
                for (Integer it : ts.values()) {
                    if (it > 1) {
                        res = 0;
                    }
                }
                System.out.println("Case #" + i + ": " + res);
            } else if (d == 3) {
                int res = 2;
                for (Long it : ts.keySet()) {
                    if (ts.get(it) > 2) {
                        res = 0;
                        break;
                    }
                    if (ts.containsKey(it * 2)) {
                        res = 1;
                    }
                    if (ts.get(it) > 1 && ts.ceilingEntry(it + 1) != null) {
                        res = 1;
                    }
                }
                System.out.println("Case #" + i + ": " + res);
            }
        }
        in.close();
    }
}