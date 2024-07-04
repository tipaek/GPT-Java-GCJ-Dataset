import java.util.*;

public class Solution {

    public static class CharCounter implements Comparable<CharCounter> {
        public int count;
        public char c;

        public CharCounter(int count, char c) {
            this.count = count;
            this.c = c;
        }

        @Override
        public int compareTo(CharCounter other) {
            return Integer.compare(other.count, this.count);
        }

        @Override
        public String toString() {
            return "count=" + count + ",c=" + c;
        }
    }

    private static String solve(List<Integer> queries, List<String> responses) {
        Map<Character, Integer> charCount = new HashMap<>();
        for (String response : responses) {
            char c = response.charAt(0);
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }
        
        List<CharCounter> charCounters = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
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