import java.io.InputStream;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        InputStream in = System.in;
        Scanner sc = new Scanner(in);

        int cases = sc.nextInt();

        for (int cs = 1; cs <= cases; cs++) {
            int u = sc.nextInt();
            List<String> inp = new ArrayList<>();

            for (int i = 0; i < 10000; i++) {
                sc.next(); // Skip the first input
                inp.add(sc.next());
            }

            boolean[] usedChars = new boolean[26];
            for (String s : inp) {
                for (int i = 0; i < s.length(); i++) {
                    usedChars[s.charAt(i) - 'A'] = true;
                }
            }

            int[] count = new int[26];
            for (String s : inp) {
                if (s.length() == u) {
                    count[s.charAt(0) - 'A']++;
                }
            }

            StringBuilder result = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                if (usedChars[i] && count[i] == 0) {
                    result.append((char) (i + 'A'));
                }
            }

            TreeMap<Integer, String> charCountMap = new TreeMap<>();
            for (int i = 0; i < 26; i++) {
                charCountMap.put(count[i], String.valueOf((char) (i + 'A')));
            }

            charCountMap.descendingMap().values().stream().limit(9).forEach(result::append);

            System.out.printf("Case #%d: %s%n", cs, result);
        }
    }
}