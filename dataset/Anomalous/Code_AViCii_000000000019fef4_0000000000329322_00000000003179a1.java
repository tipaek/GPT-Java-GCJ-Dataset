import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        
        int p = sc.nextInt();
        int t = p;

        while (t-- > 0) {
            int u = sc.nextInt();
            Query[] queries = new Query[10000];
            Map<Character, Long> charset = new HashMap<>();

            for (int i = 0; i < 10000; i++) {
                long m = sc.nextLong();
                String st = sc.next();
                queries[i] = new Query(m, st);
                for (char ch : st.toCharArray()) {
                    charset.put(ch, charset.getOrDefault(ch, 0L) + 1);
                }
            }

            Set<Character> lastset = new HashSet<>(charset.keySet());

            for (Query query : queries) {
                char firstChar = query.rec.charAt(0);
                lastset.remove(firstChar);
            }

            Iterator<Character> iter = lastset.iterator();
            char lach = iter.next();
            List<Pair> pairs = new ArrayList<>();

            for (Map.Entry<Character, Long> entry : charset.entrySet()) {
                if (entry.getKey() != lach) {
                    pairs.add(new Pair(entry.getKey(), entry.getValue()));
                }
            }

            pairs.sort((Pair a, Pair b) -> Long.compare(b.frequency, a.frequency));

            for (char ch : lastset) {
                charset.put(ch, 0L);
            }

            char[] result = new char[10];
            result[0] = lach;
            for (int i = 1; i <= 9; i++) {
                result[i] = pairs.get(i - 1).character;
            }

            System.out.println("Case #" + (p - t) + ": " + new String(result));
        }
    }
}

class Query {
    long id;
    String rec;

    public Query(long id, String rec) {
        this.id = id;
        this.rec = rec;
    }
}

class Pair {
    char character;
    long frequency;

    public Pair(char character, long frequency) {
        this.character = character;
        this.frequency = frequency;
    }
}