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
                boolean ans0 = false;
                boolean ans1 = false;
                boolean ans2 = true;
                for (Long k : map.keySet()) {
                    if (map.get(k) == 3) {
                        ans0 = true;
                    } else if (map.get(k) == 2) {
                        for (int i = 0; i < n; i++) {
                            if (arr[i] > k) {
                                ans1 = true;
                            }
                        }
                    } else if (map.get(k * 2) != null) {
                        ans1 = true;
                    }
                }
                if (ans0) {
                    ans = 0;
                } else if (ans1) {
                    ans = 1;
                } else {
                    ans = 2;
                }
            }
            System.out.printf("Case #%d: %s\n", t, ans);
        }
    }
}

