import java.util.*;
import java.io.*;
public class Solution {

    public static class Tuple {
        long val;
        String answer;

        Tuple(long val, String answer) {
            this.val = val;
            this.answer = answer;
        }
    }

    private static Map<Character, Long> charMap = new HashMap<>();
    private static Set<Character> chars = new HashSet<>();



    public static String getString(Tuple[] rows) {
        for (Tuple row : rows) {
            String answer = row.answer;
            if (answer.length() == 1) {
                charMap.computeIfAbsent(answer.charAt(0), k -> row.val);
                charMap.computeIfPresent(answer.charAt(0), (k, v) -> v = Math.min(v, row.val));
                continue;
            }

            long val = row.val;
            for (int i = 0; i < answer.length(); i++) {
                if (i == 0) {
                    charMap.merge(answer.charAt(i), val / 10, Math::min);
                } else {
                    chars.add(answer.charAt(i));
                }

            }
        }
        char[] chr = new char[10];
        for (Character ch : charMap.keySet()) {
            chr[Math.toIntExact(charMap.get(ch))] = ch;
            chars.remove(ch);
        }
        Object[] ob = chars.toArray();
        chr[0] = (char) ob[0];
        return new String(chr);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int u = in.nextInt();
            Tuple[] rows = new Tuple[10000];
            for (int j = 0; j < 10000; j++) {
                rows[j] = new Tuple(in.nextLong(), in.nextLine().trim());
            }

            System.out.println("Case #" + i + ": " + getString(rows));
        }
    }
}