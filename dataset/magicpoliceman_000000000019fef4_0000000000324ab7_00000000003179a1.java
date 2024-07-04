import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int testCases = Integer.parseInt(reader.readLine());
        for (int i = 1; i <= testCases; i++) {
            int u = Integer.parseInt(reader.readLine());
            Map<Character, Integer> counts = new HashMap<>();
            Set<Character> d = new HashSet<>();
            for (int j = 0; j < 10000; j++) {
                String[] line = reader.readLine().split(" ");
                int m = Integer.parseInt(line[0]);
                String str = line[1];
                char letter = str.charAt(0);
                d.add(letter);
                if (!counts.containsKey(letter)) {
                    counts.put(letter, 1);
                } else {
                    int count = counts.get(letter);
                    counts.put(letter, count + 1);
                }
            }
            StringBuilder result = new StringBuilder();
            for (char c : d) {
                if (!counts.containsKey(c)) {
                    result.append(c);
                }
            }
            while (result.length() < d.size()) {
                int max = 0;
                char letter = 0;
                for (Map.Entry<Character, Integer> entry : counts.entrySet()) {
                    if (entry.getValue() > max) {
                        letter = entry.getKey();
                        max = entry.getValue();
                    }
                }
                result.append(letter);
                counts.remove(letter);
            }

            System.out.println("Case #" + i + ": " + result.toString());
        }
    }
}