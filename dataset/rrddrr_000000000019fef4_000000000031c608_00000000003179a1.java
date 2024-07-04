import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {

    static interface Solver {
        public String solve();
    }

    ////////// TODO: solver /////////////////
    private static class ListSolver implements Solver {

        List<String> tokens;

        public ListSolver(Scanner scanner) {
            tokens = new ArrayList<>();

            int numLines = Integer.parseInt(scanner.nextLine());
            for (int i=0; i<10000; ++i) {
                String line = scanner.nextLine().trim().split(" ")[1];
                tokens.add(line);
            }
        }

        @Override
        public String solve() {
            Set<Character> chars = new HashSet<>();
            for (String s : tokens) {
                for (char c : s.toCharArray())
                    chars.add(c);
            }
            for (String s : tokens) {
                chars.remove(s.charAt(0));
            }

            char zero = chars.iterator().next();

            Map<Character, Integer> charCount = new HashMap<>();
            for (String s : tokens) {
                char c = s.charAt(0);
                if (!charCount.containsKey(c)) {
                    charCount.put(c, 1);
                }
                else {
                    charCount.put(c, charCount.get(c) + 1);
                }
            }

            Stream<Map.Entry<Character, Integer>> sortedCharsByCount = charCount.entrySet().stream().sorted(Map.Entry.comparingByValue());

            StringBuilder ret = new StringBuilder();
            for (Map.Entry<Character, Integer> e : sortedCharsByCount.collect(Collectors.toList())) {
                if (e.getKey() != zero) {
                    ret.append(e.getKey());
                }
            }


            return zero + ret.reverse().toString();
        }
    }

    private static void handleInput(Scanner inputReader) {
        int numTestCases = Integer.parseInt(inputReader.nextLine());
        for (int i = 0; i < numTestCases; ++i) {
            Solver s = new ListSolver(inputReader); // TODO
            String output = s.solve();
            System.out.println(String.format("Case #%d: %s", (i + 1), output));
        }
    }

    public static void main(String[] args) {
        handleInput((new Scanner(new BufferedReader(new InputStreamReader(System.in)))));
        // testCases();
    }

    public static void testCases() {
        String input = "";
        handleInput(new Scanner(input));
    }
}
