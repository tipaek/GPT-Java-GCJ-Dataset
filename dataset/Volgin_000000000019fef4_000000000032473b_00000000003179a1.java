import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {

    private static final BufferedReader reader = submission();

    private static BufferedReader submission() {
        return new BufferedReader(new InputStreamReader(System.in));
    }

    private static BufferedReader playGround() {
        try {
            return new BufferedReader(new FileReader("C:/temp/codejam/testInput.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Wrong File path", e);
        }
    }

    private static String formatResult(int caseId, String result) {
        return "Case #" + caseId + ": " + result;
    }

    public static void main(String... args) throws IOException {
        String[] mainEntry = reader.readLine().split(" ");
        int T = Integer.parseInt(mainEntry[0]);
        for (int i = 0; i < T; i++) {
            mainLoop(i + 1, reader, mainEntry);
        }
    }

    private static void mainLoop(int caseId, BufferedReader reader, String[] globalEntry) throws IOException {
        int u = Integer.parseInt(reader.readLine());
//        long M = (long) Math.pow(10, u) - 1;
        Map<Character, CharStats> stats = new HashMap<>();
        for (int i = 0; i < 10_000; i++) {
            String[] input = reader.readLine().split(" ");
            String miStr = input[0];
            String out = input[1];
            if (miStr.length() == out.length()) {
                char c = out.charAt(0);
                CharStats charStats = stats.computeIfAbsent(c, CharStats::new);
                charStats.addDigits(Integer.parseInt("" + miStr.charAt(0)));
                charStats.addImpossibleValue(0);
                out = out.substring(1);
            }
            for (char c : out.toCharArray()) {
                CharStats charStats = stats.computeIfAbsent(c, CharStats::new);
                charStats.addDigits(9);
            }
        }
        boolean hasNotFound = true;
        while (hasNotFound) {
            hasNotFound = false;
            for (CharStats stat : stats.values()) {
                if (stat.found) {
                    for (CharStats other : stats.values()) {
                        if (other != stat) {
                            other.addImpossibleValue(stat.value);
                        }
                    }
                } else {
                    hasNotFound = true;
                }
            }
        }
        List<CharStats> values = new ArrayList<>(stats.values());
        values.sort(Comparator.comparingInt(o -> o.value));
        StringBuilder result = new StringBuilder();
        for (CharStats stat : values) {
            result.append(stat.c);
        }
        System.out.println(formatResult(caseId, result.toString()));
    }

    private static class CharStats {
        List<Integer> possibleValues = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
        Set<Integer> impossibleValues = new HashSet<>();
        char c;
        int value;
        boolean found;

        public CharStats(char c) {
            this.c = c;
        }

        private void addDigits(int max) {
            if (!found) {
                for (int digit = max + 1; digit < 10; digit++) {
                    impossibleValues.add(digit);
                }
                impossibleUpdated();
            }
        }

        private void addImpossibleValue(int value) {
            if (!found) {
                impossibleValues.add(value);
                impossibleUpdated();
            }
        }

        private void impossibleUpdated() {
            found = impossibleValues.size() == 9;
            if (found) {
                possibleValues.removeAll(impossibleValues);
                value = possibleValues.iterator().next();
            }
        }
    }
}
