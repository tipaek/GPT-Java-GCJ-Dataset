

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        int t = 0;
        Scanner s = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        t = s.nextInt();
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i <= t; i++) {
            HashMap<Long, Integer> map = new HashMap<>();
            int n = s.nextInt();
            int d = s.nextInt();
            long[] a = new long[n];
            for (int j = 0; j < n; j++) {
                a[j] = s.nextLong();
                if (map.containsKey(a[j]))
                    map.put(a[j], map.get(a[j]) + 1);
                else
                    map.put(a[j], 1);
            }
            boolean val = get(map, d);
            int ans = Integer.MAX_VALUE;
            if (val) {
                ans = 0;
            }
            if (!val) {
                if(d==2)
                    ans=1;
                else if(d==3)
                    ans=2;
            }


            builder.append("Case #" + i + ": " + ans).append("\n");
        }
        System.out.println(builder);
    }

    private static boolean get(HashMap<Long, Integer> map, int d) {
        Set<Map.Entry<Long, Integer>> entrySet = map.entrySet();
        for (Map.Entry<Long, Integer> entries :
                entrySet) {
            if (entries.getValue() == d)
                return true;

        }
        return false;
    }
}
