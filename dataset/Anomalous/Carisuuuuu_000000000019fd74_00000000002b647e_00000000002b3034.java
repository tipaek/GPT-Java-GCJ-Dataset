import java.io.PrintStream;
import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;

public class Solution {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final PrintStream OUTPUT = System.out;
    private static final PrintStream ERROR_LOG = System.err;

    public static void main(String[] args) {
        int testCases = SCANNER.nextInt();
        for (int caseIndex = 1; caseIndex <= testCases; ++caseIndex) {
            int wordCount = SCANNER.nextInt();
            String[] words = new String[wordCount];
            for (int i = 0; i < wordCount; ++i) {
                words[i] = SCANNER.next();
            }

            String prefix = Arrays.stream(words)
                    .map(word -> word.substring(0, word.indexOf('*')))
                    .map(Optional::of)
                    .peek(OUTPUT::println)
                    .reduce(Optional.of(""),
                            (result, next) -> result.flatMap(r -> next.map(n -> 
                                    r.length() >= n.length() ? 
                                            (r.startsWith(n) ? r : null) : 
                                            (n.startsWith(r) ? n : null))))
                    .orElse("");

            String suffix = Arrays.stream(words)
                    .map(word -> word.indexOf('*') + 1 < word.length() ? word.substring(word.indexOf('*') + 1) : "")
                    .map(Optional::of)
                    .peek(OUTPUT::println)
                    .reduce(Optional.of(""),
                            (result, next) -> result.flatMap(r -> next.map(n -> 
                                    r.length() >= n.length() ? 
                                            (r.endsWith(n) ? r : null) : 
                                            (n.endsWith(r) ? n : null))))
                    .orElse("");

            String result = prefix + suffix;
            if (result.isEmpty()) {
                result = "*";
            }

            OUTPUT.println("Case #" + caseIndex + ": " + result);
        }
    }
}