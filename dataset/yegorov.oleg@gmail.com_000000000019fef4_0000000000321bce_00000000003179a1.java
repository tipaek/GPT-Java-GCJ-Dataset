import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import static java.util.stream.Collectors.*;
import static java.util.Map.Entry.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int U = in.nextInt();

            Set<Character> charSet = new HashSet<>();
            Map<Character, Integer> counts = new HashMap<>();
            for (int n=0; n < 10000; n++) {
                int M = in.nextInt();
                String R = in.nextLine().trim();

                charSet.add(R.charAt(0));
                charSet.add(R.charAt(R.length()-1));

                if (!counts.containsKey(R.charAt(0))) {
                    counts.put(R.charAt(0), 0);
                } else {
                    counts.put(R.charAt(0), counts.get(R.charAt(0)) + 1);
                }
            }

            Map<Character, Integer> sorted = counts
                    .entrySet()
                    .stream()
                    .sorted(comparingByValue())
                    .collect(
                            toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e2,
                                    LinkedHashMap::new));

            char zeroCharacter = ' ';
            for (char c : charSet) {
                if (!counts.containsKey(c)) {
                    zeroCharacter = c;
                }
            }

            StringBuilder result = new StringBuilder();
            for (char c : sorted.keySet()) {
                result.append(c);
            }
            result.append(zeroCharacter);
            result.reverse();

            System.out.printf("Case #%d: %s%n", i, result);
        }
    }
}

