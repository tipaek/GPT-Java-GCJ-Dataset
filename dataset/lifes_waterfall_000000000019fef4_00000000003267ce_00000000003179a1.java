import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int u = in.nextInt();

            Map<Character, Integer> possible = new HashMap<>();

            StringBuilder result = new StringBuilder(10);
            for (int j  = 0; j < 10_000; j++) {
                int m = in.nextInt();
                String r = in.nextLine().trim();

                if (m > Math.pow(10, u - 1) && r.length() == u) {//>10
                    boolean stop = false;
                    for (int x = 0; x < u - 1 && !stop; x++) {
                        char letter = r.charAt(x);
                        int newValue = (int) Math.floor(m / Math.pow(10, x + 1));
                        if (possible.get(letter) != null && possible.get(letter) > newValue || possible.get(letter) == null) {
                            possible.put(letter, newValue);
                        } else if (possible.get(letter) != null && possible.get(letter) < newValue) {
                            stop = true;
                        }
                    }
                    if (!stop) {
                        char letter = r.charAt(u - 1);

                        int newValue = (int) Math.floor(m % Math.pow(10, u - 1));
                        if (possible.get(letter) == null) {
                            possible.put(letter, newValue);
                        } else if (possible.get(letter) != null && possible.get(letter) > newValue) {
                            possible.put(letter, possible.get(letter)-1);
                        }
                    }
                } else if (m < 10) {
                    char letter = r.charAt(0);
                    if (possible.get(letter) != null && possible.get(letter) > m || possible.get(letter) == null) {
                        possible.put(letter, m);
                    }
                }
            }

            for (Map.Entry<Character, Integer> mapEntry : possible.entrySet().stream()
                    .sorted(Comparator.comparingInt(Map.Entry::getValue)).collect(Collectors.toList())) {
                result.insert(mapEntry.getValue(), mapEntry.getKey().toString());
            }

            System.out.println("Case #" + i + ": " + result.toString());
        }
    }
}
