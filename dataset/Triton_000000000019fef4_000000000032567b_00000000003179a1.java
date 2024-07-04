import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static class Entity {
        public long m;
        public String r;

        public Entity(long m, String r) {
            this.m = m;
            this.r = r;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int u = in.nextInt();
            Entity[] queries = new Entity[10000];
            Set<Character> candidates = new HashSet<>();
            for (int j = 0; j < queries.length; ++j) {
                queries[j] = new Entity(in.nextLong(), in.next());
                if (candidates.size() < 10) {
                    for (char ch : queries[j].r.toCharArray()) {
                        candidates.add(ch);
                    }
                }
            }

            String result = String.format("Case #%d: %s", i, sol.recover(u, queries, candidates));
            System.out.println(result);
        }
    }

    private String recover(int u, Entity[] queries, Set<Character> candidates) {
        if (queries[0].m == -1) {
            return recoverUnknownM(u, queries);
        }

        char[] code = new char[10];

        Map<Long, Set<String>> map = new TreeMap<>();
        for (Entity q : queries) {
            Set<String> set = map.getOrDefault(q.m, new HashSet<>());
            set.add(q.r);
            map.put(q.m, set);
        }

        for (Map.Entry<Long, Set<String>> entry : map.entrySet()) {
            if (candidates.isEmpty()) {
                break;
            }

            long m = entry.getKey();
            if (m < 10) {
                Set<Character> set = new HashSet<>();
                for (String s : entry.getValue()) {
                    for (char ch : s.toCharArray()) {
                        set.add(ch);
                    }
                }

                set.retainAll(candidates);
                if (set.size() == 1) {
                    code[(int)m] = set.iterator().next();
                    candidates.removeAll(set);
                }
            }
        }

        return new String(code);
    }

    private String recoverUnknownM(int u, Entity[] queries) {

        return "";
    }
}