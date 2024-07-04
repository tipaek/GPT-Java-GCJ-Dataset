import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.MessageFormat;
import java.util.*;

public class Solution {
    private static final String RESULT_PATTERN = "Case #{0}: {1}";

    private static String getSolution(final Scanner scanner) {
        final int digits = scanner.nextInt();
        Map<String, Counter> counterMap = new HashMap<>();
        List<Counter> counterList = new ArrayList<>();
        Set<Character> uniqueChars = new HashSet<>();

        for (int i = 0; i < 10000; i++) {
            final String limitString = scanner.next();
            final long limit = Long.parseLong(limitString);
            final String response = scanner.next();
            for (char c : response.toCharArray()) {
                uniqueChars.add(c);
            }

            final String firstChar = String.valueOf(response.charAt(0));
            counterMap.computeIfAbsent(firstChar, k -> {
                Counter newCounter = new Counter(firstChar);
                counterList.add(newCounter);
                return newCounter;
            }).incrementCount();
        }
        Collections.sort(counterList);

        StringBuilder result = new StringBuilder();
        for (Character uniqueChar : uniqueChars) {
            boolean foundInCounters = counterList.stream().anyMatch(counter -> counter.s.equals(String.valueOf(uniqueChar)));
            if (!foundInCounters) {
                result.append(uniqueChar);
            }
        }

        for (Counter counter : counterList) {
            result.append(counter.s);
        }

        return result.toString();
    }

    private static class Counter implements Comparable<Counter> {
        int count = 1;
        String s;

        public Counter(final String s) {
            this.s = s;
        }

        public void incrementCount() {
            this.count++;
        }

        @Override
        public int compareTo(final Counter other) {
            return Integer.compare(other.count, this.count);
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
//        Scanner scanner = new Scanner(new FileInputStream("B.in"));

        final int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            final String solution = getSolution(scanner);
            System.out.println(MessageFormat.format(RESULT_PATTERN, i, solution));
        }
    }
}