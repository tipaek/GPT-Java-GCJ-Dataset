import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        // Scanner sc = new Scanner(new File("sample.in.txt"));

        int p = sc.nextInt();
        int t = p;

        while (t-- > 0) {
            int u = sc.nextInt();
            int n = 10000;
            Query[] queries = new Query[n];
            HashMap<Character, Integer> charset = new HashMap<>();

            for (int i = 0; i < n; i++) {
                long m = sc.nextLong();
                String st = sc.next();
                queries[i] = new Query(m, st);
                for (char ch : st.toCharArray()) {
                    charset.put(ch, 0);
                }
            }

            for (char ch : charset.keySet()) {
                charset.put(ch, 9);
            }

            HashSet<Character> lastSet = new HashSet<>(charset.keySet());

            Arrays.sort(queries, (Query a, Query b) -> Long.compare(a.qq, b.qq));

            for (int i = 0; i < n; i++) {
                String k = String.valueOf(queries[i].qq);
                if (k.length() > queries[i].rec.length()) {
                    continue;
                }
                char ch = queries[i].rec.charAt(0);
                if (lastSet.contains(ch)) {
                    lastSet.remove(ch);
                }
                charset.put(ch, Math.min(charset.get(ch), k.charAt(0) - '0'));
            }

            for (char ch : lastSet) {
                charset.put(ch, 0);
            }

            char[] starr = new char[10];
            for (char ch : charset.keySet()) {
                starr[charset.get(ch)] = ch;
            }

            System.out.println("Case #" + (p - t) + ": " + new String(starr));
        }
    }
}

class Query {
    long qq;
    String rec;

    public Query(long a, String r) {
        qq = a;
        rec = r;
    }
}