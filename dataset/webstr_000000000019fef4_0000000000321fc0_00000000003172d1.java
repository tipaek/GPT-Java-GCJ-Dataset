import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t1 = in.nextInt();
        for (int t = 1; t <= t1; t++) {
            int n = in.nextInt();
            int d = in.nextInt();
            Map<Long, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                long s = in.nextLong();
                if (!map.containsKey(s)) {
                    map.put(s, 1);
                } else {
                    map.put(s, map.get(s) + 1);
                }
            }

            int res = d - 1;
            long max = 0;
            int maxv = -1;

            for (Map.Entry<Long, Integer> entry : map.entrySet()) {
                if (maxv <= entry.getValue() ) {
                    max = entry.getKey();
                    maxv = entry.getValue();
                }
            }
            boolean isEnd = false;
            if (maxv >= d) {
                res = 0;
            } else {
                if (d < 3) {
                    res = 1;
                } else {
                    Set<Long> set = map.keySet();

                    if (maxv == 2) {
                        for (Long i : set) {
                            if (!isEnd && map.get(i) == 2) {
                                for (Long j : set) {
                                    if (j > i) {
                                        res = 1;
                                        isEnd = true;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    for (Long i : set) {
                        if (!isEnd) {
                            for (Long j : set) {
                                if (j % i == 0 && j / i == 2) {
                                    res = 1;
                                    isEnd = true;
                                    break;
                                }
                            }
                        }
                    }

                    if (!isEnd) {
                        res = 2;
                    }
                }
            }

            System.out.println("Case #" + t + ": "  + res);
        }
    }
}
