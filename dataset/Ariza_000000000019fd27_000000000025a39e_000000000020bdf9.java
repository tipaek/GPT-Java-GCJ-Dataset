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
        Collections.sort(list, (a, b) -> a.end - b.end);
        int[] memo = new int[list.size()];
        
        int iter = 1;
        while (true) {
            int last = -1;
            for (int i = 0; i < list.size(); ++i) {
                if (memo[list.get(i).idx] != 0) continue;
                
                if (last <= list.get(i).start) {
                    last = list.get(i).end;
                    memo[list.get(i).idx] = iter;
                }
            }
            if (last == -1) break;
            iter++;
        }
        iter--;
        
        if (iter > 2) {
            return "IMPOSSIBLE";
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