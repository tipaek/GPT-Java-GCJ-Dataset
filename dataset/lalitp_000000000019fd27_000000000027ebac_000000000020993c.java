import java.util.*;

public class Solution {

    public static void main(String[] args) {
	// write your code here
        short T, N, v;
        short i, r, c;
        int trace;
        Map<Short, Set<Short>> rMap = new HashMap<>(101);
        Map<Short, Set<Short>> cMap = new HashMap<>(101);
        Set<Short> cr = new HashSet<>(101);
        Set<Short> cc = new HashSet<>(101);
        Scanner sc = new Scanner(System.in);
        T = sc.nextShort();
        for(i = 1; i <= T; i++) {
            N = sc.nextShort();
            trace = 0;
            cr.clear();
            cc.clear();
            for(r = 0; r <= N; r++) {
                if(rMap.containsKey(r)) {
                    rMap.get(r).clear();
                    cMap.get(r).clear();
                } else {
                    rMap.put(r, new HashSet<>(101));
                    cMap.put(r, new HashSet<>(101));
                }
            }
            for(r = 1; r <= N; r++) {
                for(c = 1; c <= N; c++) {
                    v = sc.nextShort();
                    if(r == c) trace += v;

                    if(rMap.get(v).contains(r)) {
                        if(!cr.contains(r)) cr.add(r);
                    } else {
                        rMap.get(v).add(r);
                    }
                    if(cMap.get(v).contains(c)) {
                        if(!cc.contains(c)) cc.add(c);
                    } else {
                        cMap.get(v).add(c);
                    }
                }
            }

            System.out.println("Case #" + i + ": " + trace + " " + cr.size() + " " + cc.size());
        }
    }
}