
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCount = scanner.nextInt();
            List<String> dataPoints;
            for (int t = 0; t < testCount; t++) {
                int u = scanner.nextInt();
                Map<Character, Integer> occurrence = new HashMap<Character, Integer>();
                Set<Character> all = new HashSet<Character>();
                for (int i = 0; i < 10000; i++) {
                    int q = scanner.nextInt();
                    String r = scanner.next();
                    Character c = r.charAt(0);
                    all.add(r.charAt(r.length() - 1));
                    if (occurrence.containsKey(c)) {
                        occurrence.put(c, occurrence.get(c) + 1);
                    } else {
                        occurrence.put(c, 1);
                    }
                }
                for (Character c : all) {
                    if (!occurrence.containsKey(c))
                        occurrence.put(c, Integer.MAX_VALUE - 1);
                }
                char[] results = new char[10];
                int roof = Integer.MAX_VALUE;
                for (int i = 0; i < 10; i++) {
                    char maxChar = 0;
                    int max = -1;
                    for (Character c : occurrence.keySet()) {
                        int v = occurrence.get(c);
                        if (max < v && v < roof) {
                            maxChar = c;
                            max = v;
                        }
                    }
                    results[i] = maxChar;
                    roof = max;

                }
                String acc = "";
                for (int i = 0; i < 10; i++) {
                    acc += results[i];
                }
                System.out.println("Case #" + (t+1) + ": " + acc);
            }
        }
    }

}
