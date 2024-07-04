import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    private static final String IMPOSSIBLE = "IMPOSSIBLE";
    private static final int TOTAL = 10000;


    private static class Pair implements Comparable<Pair>
    {
        public int compareTo(Pair other) {
            return this.max - other.max;
        }

        private int max;
        private String encoded;

        private Pair(int max, String encoded)
        {
            this.max = max;
            this.encoded = encoded;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCount = in.nextInt();
        for (int t = 1; t <= testCount; ++t) {
            int u = in.nextInt();
            Pair[] pairs = new Pair[TOTAL];
            HashMap<Character, Integer> chars = new HashMap<>();
            for (int i = 0; i < TOTAL; i++) {
                int max = in.nextInt();
                String encoded = in.next();
                for(Character c: encoded.toCharArray()) {
                    if (chars.containsKey(c)) {
                        chars.put(c, chars.get(c) + 1);
                    } else {
                        chars.put(c, 1);
                    }
                }
                pairs[i] = new Pair(max, encoded);
            }

            String res = calculate(u, pairs, chars);
            System.out.println("Case #" + t + ": " + res);
        }
    }

    private static String calculate(int u, Pair[] pairs, HashMap<Character, Integer> characters)
    {
        if (u > 2) {
            return characters.values().toArray().toString();
        }

        Set<Character> discoverd = new HashSet<>();

        Map.Entry<Character, Integer> min = Collections.min(characters.entrySet(), new Comparator<Map.Entry<Character, Integer>>() {
            public int compare(Map.Entry<Character, Integer> entry1, Map.Entry<Character, Integer> entry2) {
                return entry1.getValue().compareTo(entry2.getValue());
            }
        });
        char[] encode = new char[10];
        encode[0] = min.getKey();
        discoverd.add(min.getKey());

        Arrays.sort(pairs);
        for (int i = 0; i < pairs.length; i++) {
            if (pairs[i].max < 10 && !discoverd.contains(pairs[i].encoded.charAt(0))) {
                discoverd.add(pairs[i].encoded.charAt(0));
                encode[pairs[i].max] = pairs[i].encoded.charAt(0);
            }
        }

        return String.valueOf(encode);
    }

}
