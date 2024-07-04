import java.io.PrintStream;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Solution {
    private static final Scanner IN = new Scanner(System.in);
    private static final PrintStream OUT = System.out;
    private static final PrintStream LOG = System.err;

    public static void main(String[] args) {
        int t = IN.nextInt();
        for (int g = 1; g <= t; ++g) {
            int u = IN.nextInt();
            Entry[] entries = new Entry[1000];
            for (int i = 0; i < 1000; ++i) {
                entries[i] = new Entry(IN.nextInt(), IN.next());
            }
            StringBuffer map = new StringBuffer(10);
            Map<String, Boolean> mapToPos = Arrays.stream(entries)
                    .map(e -> e.value)
                    .collect(Collectors.joining())
                    .chars()
                    .distinct()
                    .mapToObj(c -> String.valueOf((char)c))
                    .peek(LOG::print)
                    .collect(Collectors.toMap(Function.identity(), c -> false));
            IntStream.range(0, 1000)
                    .forEach(i -> {
                        final String s = Integer.valueOf(entries[i].random).toString();
                        entries[i].checkNum = Integer.parseInt(s.substring(0, 1));
                        entries[i].checkChar = s.length() == entries[i].value.length() ?
                                Optional.of(entries[i].value.substring(0, 1)) :
                                Optional.empty();
                    });
            Arrays.sort(entries, Comparator.comparingInt(e -> e.checkNum));
            Arrays.stream(entries)
                    .filter(e -> e.checkChar.isPresent())
                    .forEach(e -> {
                        int i = e.checkNum;
                        String c = e.checkChar.get();
                        if (map.length() < i && !mapToPos.get(c)) {
                            mapToPos.put(c, true);
                            map.append(c);
                        }
                    });
            map.insert(0, mapToPos.entrySet().stream()
                    .filter(e -> !e.getValue())
                    .map(Map.Entry::getKey)
                    .findAny().orElse(""));
            response(g, map);
        }
    }

    private static <R> void response(int go, R message) {
        OUT.println("Case #" + go + ": " + message);
    }

    private static class Entry {
        int random;
        String value;
        int checkNum;
        Optional<String> checkChar;
        private Entry(int random, String value) {
            this.random = random;
            this.value = value;
        }
    }
}