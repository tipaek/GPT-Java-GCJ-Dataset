import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    private static final String RESULT_PATTERN = "Case #{0}: {1}";

    private static String getSolution(final Scanner scanner) {
        final int digits = scanner.nextInt();
        Map<String, Counter> counter = new HashMap<>();
        List<Counter> counters = new ArrayList<>();
        Set<Character> chars = new HashSet<>();

        for(int i = 0; i < 10000; i++) {
            final String limitString = scanner.next();
            final long limit = Long.parseLong(limitString);
            final String response = scanner.next();
            for (int j = 0; j < response.length(); j++) {
                chars.add(response.charAt(j));
            }

            final String s = "" + response.charAt(0);
            if(counter.containsKey(s)) {
                counter.get(s).count++;
            } else {
                final Counter value = new Counter(s);
                counter.put(s, value);
                counters.add(value);
            }
        }
        Collections.sort(counters);
        // TODO Add Zero
        StringBuilder sb = new StringBuilder();
        final Iterator<Character> iterator = chars.iterator();
        while(iterator.hasNext()) {
            final Character next = iterator.next();
            boolean foundCounter = false;
            for (final Counter counter1 : counters) {
                if(counter1.s.equals("" + next)) {
                    foundCounter = true;
                    break;
                }
            }
            if(!foundCounter) {
                sb.append(next);
            }
        }

        for(int i = 0; i < counters.size(); i++) {
            sb.append(counters.get(i).s);
        }
        return sb.toString();
    }

    private static class Counter  implements Comparable<Counter> {
        int count = 1;
        String s;

        public Counter(final String s) {
            this.s = s;
        }

        @Override
        public int compareTo(final Counter o) {
            return Integer.compare(o.count, this.count);
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        final Scanner scanner = new Scanner(System.in);
//        final Scanner scanner = new Scanner(new FileInputStream("B.in"));

        final int testCases = scanner.nextInt();
        for(int i = 1; i<= testCases; i++) {
            final String solution = getSolution(scanner);
            System.out.println(MessageFormat.format(RESULT_PATTERN, i, solution));
        }
    }
}
