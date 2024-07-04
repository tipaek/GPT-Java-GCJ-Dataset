import java.util.*;

public class Solution {

    public static class CharCounter implements Comparable<CharCounter> {

        public long count;
        public char c;

        public CharCounter(long count, char c) {
            this.count = count;
            this.c = c;
        }

        @Override
        public int compareTo(CharCounter other) {
            return Long.compare(other.count, this.count);
        }

        @Override
        public String toString() {
            return "count=" + count + ",c=" + c;
        }
    }

    private static String solve(List<Integer> queries, List<String> responses) {
        Map<Character, Long> charCount = new HashMap<>();
        for (String response : responses) {
            char c = response.charAt(0);
            charCount.put(c, charCount.getOrDefault(c, 0L) + 1);
        }

        List<CharCounter> charCounters = new ArrayList<>();
        for (Map.Entry<Character, Long> entry : charCount.entrySet()) {
            charCounters.add(new CharCounter(entry.getValue(), entry.getKey()));
        }
        Collections.sort(charCounters);

        StringBuilder sb = new StringBuilder(10);
        for (CharCounter charCounter : charCounters) {
            sb.append(charCounter.c);
        }
        String oneToNine = sb.toString();

        for (String response : responses) {
            for (char c : response.toCharArray()) {
                if (!charCount.containsKey(c)) {
                    return c + oneToNine;
                }
            }
        }
        return "";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int u = sc.nextInt();
            List<Integer> queries = new ArrayList<>();
            List<String> responses = new ArrayList<>();
            for (int i = 0; i < 10000; i++) {
                queries.add(sc.nextInt());
                responses.add(sc.next());
            }
            String dictionary = solve(queries, responses);
            System.out.println("Case #" + t + ": " + dictionary);
        }
    }
}