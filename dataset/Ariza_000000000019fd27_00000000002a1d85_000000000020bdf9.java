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
    
    static String solve(final List<Inter> list) {
        Collections.sort(list, (a, b) -> a.start - b.start);
        int[] memo = new int[list.size()];
        for (int i = 0; i < memo.length; ++i) memo[i] = 0;
        
        int last = -1;
        for (Inter it : list) {
            if (last <= it.start) {
                last = it.end;
                memo[it.idx] = 1;
            }
        }
        
        last = -1;
        for (Inter it : list) {
            if (memo[it.idx] == 0) {
                if (last > it.start) return "IMPOSSIBLE";
                last = it.end;
            }
        }
        
        char[] arrTmp = new char[list.size()];
        for (int i = 0; i < list.size(); ++i) {
            int tmp = list.get(i).idx;
            if (memo[tmp] == 1) arrTmp[tmp] = 'C';
            else arrTmp[tmp] = 'J';
        }
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arrTmp.length; ++i) {
            sb.append(arrTmp[i]);
        }
        return sb.toString();
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