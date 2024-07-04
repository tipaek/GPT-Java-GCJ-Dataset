import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            System.out.print("Case #" + i + ": ");
            int n = in.nextInt();
            int d = in.nextInt();
            long[] a = new long[n];
            for(int j=0; j<n; j++) {
                a[j] = in.nextLong();
            }
            testCase(n, d, a);
        }
    }
    private static void testCase(int n, int d, long[] a) {
        SortedMap<Long, Integer> m = new TreeMap<>();
        boolean hasEven = false;
        for(int i=0; i<n; i++) {
            if(a[i]%2==0) {
                hasEven = true;
            }
            if(m.containsKey(a[i])) {
                m.put(a[i], m.get(a[i])+1);
            }
            else {
                m.put(a[i], 1);
            }
        }
        
        Set<Long> set = m.keySet();
        Iterator<Long> kit = set.iterator();
        int leastCut = Integer.MAX_VALUE;
        while(kit.hasNext()) {
            long key = kit.next();
            int cutCount = Math.max(0, d-m.get(key));
            if(d==3 && m.containsKey(key*2)) {
                cutCount = Math.max(0, cutCount-1);
            }
            leastCut = Math.min(leastCut, cutCount);
        }
        if(hasEven && d==2) {
            leastCut = Math.min(leastCut, 1);
        }
        System.out.println(leastCut);
    }
}