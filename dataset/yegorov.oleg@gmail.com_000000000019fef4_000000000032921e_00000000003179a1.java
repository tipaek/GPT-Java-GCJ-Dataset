import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;
import static java.util.Map.Entry.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
                    int U = in.nextInt();
        for (int i = 1; i <= t; ++i) {


            Set<Character> charSet = new HashSet<>();
            Map<Character, Integer> counts = new HashMap<>();
            for (int n=0; n < 10000; n++) {
                int M = in.nextInt();
                String R = in.next();

                charSet.add(R.charAt(0));
                charSet.add(R.charAt(R.length()-1));

                if (!counts.containsKey(R.charAt(0))) {
                    counts.put(R.charAt(0), 1);
                } else {
                    counts.put(R.charAt(0), counts.get(R.charAt(0)) + 1);
                }
            }

            Map<Character, Integer> sorted = counts.entrySet().stream()
                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                            (oldValue, newValue) -> oldValue, LinkedHashMap::new));

            char zeroCharacter = ' ';
            for (char c : charSet) {
                if (!counts.containsKey(c)) {
                    zeroCharacter = c;
                }
            }

            StringBuilder result = new StringBuilder();
            result.append(zeroCharacter);
            for (char c : sorted.keySet()) {
                result.append(c);
            }

            System.out.printf("Case #%d: %s%n", i, result);
        }
    }
}