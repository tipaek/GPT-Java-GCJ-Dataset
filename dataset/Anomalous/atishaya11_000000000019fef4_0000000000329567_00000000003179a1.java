import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCaseCount = scanner.nextInt();
        for (int t = 1; t <= testCaseCount; t++) {
            int u = scanner.nextInt();
            Query[] queries = new Query[10000];
            Map<Character, Integer> characterFrequency = new HashMap<>();
            Set<Character> nonZeroCharacters = new HashSet<>();

            for (int i = 0; i < 10000; i++) {
                String s = scanner.next();
                String r = scanner.next();
                queries[i] = new Query(s, r);

                if (!s.equals("-1") && s.length() == r.length()) {
                    characterFrequency.merge(r.charAt(0), s.charAt(0) - '0', Math::min);
                    nonZeroCharacters.add(r.charAt(0));
                } else if (!s.equals("-1")) {
                    characterFrequency.merge(r.charAt(0), 9, Math::min);
                    nonZeroCharacters.add(r.charAt(0));
                } else {
                    characterFrequency.put(r.charAt(0), 9);
                    nonZeroCharacters.add(r.charAt(0));
                }

                for (Character ch : queries[i].response) {
                    characterFrequency.merge(ch, 9, Math::min);
                }
            }

            char[] result = new char[10];

            Map<Character, Integer> sortedCharacters = characterFrequency.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));

            int index = 1;
            for (Character c : sortedCharacters.keySet()) {
                if (nonZeroCharacters.contains(c)) {
                    result[index++] = c;
                } else {
                    result[0] = c;
                }
            }

            System.out.printf("Case #%d: %s\n", t, new String(result));
        }
    }

    static class Query {
        String query;
        char[] response;

        public Query(String query, String response) {
            this.query = query;
            this.response = response.toCharArray();
        }
    }
}