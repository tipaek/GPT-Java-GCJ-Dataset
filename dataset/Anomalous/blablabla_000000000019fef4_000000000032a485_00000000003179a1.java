import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();

        for (int caseId = 1; caseId <= t; caseId++) {
            int u = scanner.nextInt();

            Map<Integer, Map<Character, Integer>> counters = new HashMap<>();

            for (int i = 0; i < 10_000; i++) {
                long q = scanner.nextLong();
                String r = scanner.next();

                char[] chars = r.toCharArray();

                if (q > 10L) {
                    int dec = (int) (q / 10);
                    char decChar = chars[0];
                    updateCounter(counters, dec, decChar);

                    if (chars.length > 1) {
                        int sin = (int) (q % 10);
                        updateCounter(counters, sin, chars[1]);
                    }
                } else {
                    updateCounter(counters, (int) q, chars[0]);
                }
            }

            StringBuilder sb = new StringBuilder();
            Set<Character> used = new HashSet<>();

            for (int i = 0; i < 10; i++) {
                Map<Character, Integer> forDigit = counters.get(i);

                int max = -1;
                char key = '-';
                for (Map.Entry<Character, Integer> e : forDigit.entrySet()) {
                    if (e.getValue() > max && !used.contains(e.getKey())) {
                        max = e.getValue();
                        key = e.getKey();
                    }
                }
                used.add(key);
                sb.append(key);
            }
            String result = sb.toString();
            System.out.println("Case #" + caseId + ": " + result);
        }
    }

    private static void updateCounter(Map<Integer, Map<Character, Integer>> counters, int digit, char ch) {
        counters.computeIfAbsent(digit, k -> new HashMap<>())
                .merge(ch, 1, Integer::sum);
    }
}