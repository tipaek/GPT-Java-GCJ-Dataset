import java.io.*;
import java.util.*;

class Solution {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        for (int t = 1; t <= count; t++) {
            int n = in.nextInt();
            int d = in.nextInt();
            long[] arr = new long[n];
            Map<Long, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextLong();
                map.merge(arr[i], 1, Integer::sum);
            }
            int ans = 0;
            if (d == 2) {
                if (map.size() == n) {
                    ans = 1;
                } else {
                    ans = 0;
                }
            } else if (d == 3) {
                ans = 2;
                for (Long k : map.keySet()) {
                    if (map.get(k) == 3) {
                        ans = 0;
                        break;
                    } else if (map.get(k) == 2) {
                        boolean flag = false;
                        for (int i = 0; i < n; i++) {
                            if (arr[i] > map.get(k)) {
                                ans = 1;
                                flag = true;
                                break;
                            }
                        }
                        if (flag) {
                            break;
                        }
                    } else if (map.get(k * 2) != null) {
                        ans = 1;
                        break;
                    }
                }
            }
            System.out.printf("Case #%d: %s\n", t, ans);
        }
    }
}

