import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCaseCount = in.nextInt();
        for (int t = 1; t <= testCaseCount; t++) {
            int u = in.nextInt();
            Query[] queries = new Query[10000];
            Map<Character, Integer> distinctDigits = new HashMap<>();
            Set<Character> nonZeroDigits = new HashSet<>();

            for (int i = 0; i < 10000; i++) {
                String s = in.next();
                String r = in.next();
                queries[i] = new Query(s, r);

                if (!s.equals("-1") && s.length() == r.length()) {
                    distinctDigits.merge(r.charAt(0), s.charAt(0) - '0', Math::min);
                    nonZeroDigits.add(r.charAt(0));
                } else if (!s.equals("-1")) {
                    distinctDigits.merge(r.charAt(0), 9, Math::min);
                    nonZeroDigits.add(r.charAt(0));
                }

                for (Character ch : queries[i].r) {
                    distinctDigits.merge(ch, 9, Math::min);
                }
            }

            char[] result = new char[10];
            Map<Character, Integer> sortedDigits = distinctDigits.entrySet().stream()
                    .sorted(Map.Entry.comparingByValue())
                    .collect(Collectors.toMap(
                            Map.Entry::getKey, 
                            Map.Entry::getValue, 
                            (e1, e2) -> e2, 
                            LinkedHashMap::new));

            int index = 1;
            for (Character c : sortedDigits.keySet()) {
                if (nonZeroDigits.contains(c)) {
                    result[index++] = c;
                } else {
                    result[0] = c;
                }
            }

            System.out.printf("Case #%d: %s\n", t, new String(result));
        }
    }

    static class Query {
        String q;
        char[] r;

        public Query(String q, String r) {
            this.q = q;
            this.r = r.toCharArray();
        }
    }
}