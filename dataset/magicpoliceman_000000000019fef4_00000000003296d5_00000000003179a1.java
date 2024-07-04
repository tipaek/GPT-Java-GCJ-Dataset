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
            Map<Integer, Set<Character>> chars = new HashMap<>();
            Set<Character> d = new HashSet<>();
            for (int j = 0; j < 10000; j++) {
                String[] line = reader.readLine().split(" ");
                int m = Integer.parseInt(line[0]);
                if (m == -1) {
                    continue;
                }
                String str = line[1];
                for (char letter : str.toCharArray()) {
                    d.add(letter);
                    if (m < 10) {
                        if (!chars.containsKey(m)) {
                            Set<Character> letters = new HashSet<>();
                            letters.add(letter);
                            chars.put(m, letters);
                        } else {
                            Set<Character> letters = chars.get(m);
                            letters.add(letter);
                            chars.put(m, letters);
                        }
                    }
                }
            }
            StringBuilder result = new StringBuilder();
            Set<Character> used = new HashSet<>();
            for (int j = 1; j < d.size(); j++) {
                Set<Character> letters = chars.get(j);
                for (char letter : letters) {
                    if (!used.contains(letter)) {
                        result.append(letter);
                        used.add(letter);
                        break;
                    }
                }
            }
            for (char l : d) {
                if (!used.contains(l)) {
                    result.insert(0, l);
                }
            }
            System.out.println("Case #" + i + ": " + result.toString());
        }
    }
}