import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author dbatchunag
 */

public class Solution {
    static class Entry implements Comparable<Entry>{
        char c;
        int count;
        Entry(char c, int count) {
            this.c = c;
            this.count = count;
        }

        @Override
        public int compareTo(final Entry o) {
            return o.count - count;
        }
    }
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        String[] inputArray;

        input = br.readLine();
        final int T = Integer.parseInt(input);
        for (int t=1; t<=T; t++) {
            input = br.readLine();
            final int U = Integer.parseInt(input);
            final ArrayList<ArrayList<String>> numbers = new ArrayList<>();
            for (int i=0; i<=U; i++){
                numbers.add(new ArrayList<>());
            }
            final Set<Character> letters = new HashSet<>();
            Map<Character, Integer> digits = new HashMap<>();
            for (int i=0; i<10000; i++) {
                input = br.readLine();
                inputArray = input.split(" ");
                final String q = inputArray[1];
                numbers.get(q.length()).add(q);
                char c = q.charAt(0);
                if (!digits.containsKey(c)) {
                    digits.put(c, 0);
                }
                digits.put(c, digits.get(c) + 1);
                letters.add(q.charAt(q.length()-1));
            }
            for (int i=0; i<U; i++){
                Collections.sort(numbers.get(i));
            }

            final ArrayList<Entry> entries = new ArrayList<>();
            for (Map.Entry<Character, Integer> c : digits.entrySet()) {
                entries.add(new Entry(c.getKey(), c.getValue()));
//                System.out.println(c.getKey() + ": " + c.getValue());
                letters.remove(c.getKey());
            }
            letters.stream().findFirst().map(zero -> entries.add(new Entry(zero, 10000)));
            Collections.sort(entries);
            final StringBuilder ans = new StringBuilder();
            for (final Entry entry : entries) {
                ans.append(entry.c);
            }
            System.out.println(String.format("Case #%d: %s", t, ans));
        }
    }
}



