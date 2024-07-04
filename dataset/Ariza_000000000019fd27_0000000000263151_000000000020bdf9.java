import java.util.*;

public class Solution {
    static class Inter {
        public int start;
        public int end;
        public int idx;
        public Inter(int a, int b, int c) {
            start = a;
            end = b;
            idx = c;
        }
    }
    
    static boolean noOverlap(final List<Inter> sorted) {
        int last = -1;
        for (Inter it : sorted) {
            if (it.start < last) return false;
            last = it.end;
        }
        return true;
    }
    
    static String solve(final List<Inter> list) {
        int n = list.size();
        Collections.sort(list, (a, b) -> a.end - b.end);
        
        for (int i = 0; i < (1<<n); ++i) {
            final List<Inter> lc = new ArrayList<>();
            final List<Inter> lj = new ArrayList<>();
            for (int j = 0; j < n; ++j) {
                if (((1<<j) & i) > 0) {
                    lc.add(list.get(j));
                } else {
                    lj.add(list.get(j));
                }
            }
            
            if (noOverlap(lc) && noOverlap(lj)) {
                char[] temp = new char[n];
                for (Inter it : lc) {
                    temp[it.idx] = 'C';
                }
                for (Inter it : lj) {
                    temp[it.idx] = 'J';
                }
                final StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; ++j) {
                    sb.append(temp[j]);
                }
                return sb.toString();
            }
        }
        return "IMPOSSIBLE";
    }
    
    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        int ntest = sc.nextInt();
        
        for (int test = 1; test <= ntest; ++test) {
            int n = sc.nextInt();
            final List<Inter> list = new ArrayList<>();
            for (int i = 0; i < n; ++i) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                list.add(new Inter(a, b, i));
            }
            final String ans = solve(list);
            System.out.println("Case #" + test + ": " + ans);
        }
    }
}