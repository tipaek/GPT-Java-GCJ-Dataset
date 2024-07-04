import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution main = new Solution();
        main.solve();
    }
    public void solve() {
        Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = scan.nextInt();
        for (int caseNo = 1; caseNo <= T; caseNo++) {
            int U = scan.nextInt();
            Map<Long, Set<Character>> map = new HashMap<>();
            Set<Character> all_items = new HashSet<>();
            for (int i = 0; i < 10000; i++) {
                long m = scan.nextLong();
                String S = scan.next();
                char[] data = S.toCharArray();
                if (1 <= m && m <= 9) {
                    if (!map.containsKey(m)) {
                        map.put(m, new HashSet<>());
                    }
                    map.get(m).add(data[0]);
                }
                if (10 <= all_items.size()) {
                    continue;
                }
                for (char x : data) {
                    all_items.add(x);
                }
            }
            char[] ans = new char[10];
            HashSet<Character> used = new HashSet<>();
            for (int i = 1; i <= 9; i++) {
                for (char x : map.get(Long.valueOf(i))) {
                    if (used.contains(x)) {
                        continue;
                    }
                    ans[i] = x;
                    all_items.remove(x);
                    used.add(x);
                    break;
                }
            }
            for (char x : all_items) {
                ans[0] = x;
                break;
            }
            System.out.printf("Case #%d: %s\n", caseNo, String.valueOf(ans));
        }
    }
}
