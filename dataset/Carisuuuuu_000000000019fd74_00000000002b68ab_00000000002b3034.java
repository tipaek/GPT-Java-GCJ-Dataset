import java.io.PrintStream;
import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;

public class Solution {
    private static final Scanner IN = new Scanner(System.in);
    private static final PrintStream OUT = System.out;
    private static final PrintStream LOG = System.err;

    public static void main(String[] args) {
        int t = IN.nextInt();
        for (int g = 1; g <= t; ++g) {
            int m = IN.nextInt();
            String [] words = new String[m];
            for (int w = 0; w < m; ++w) {
                words[w] = IN.next();
            }
            String word = Arrays.stream(words)
                    .map(w -> w.substring(0, w.indexOf('*')))
                    .map(Optional::of)
                    .peek(LOG::println)
                    .reduce(Optional.of(""),
                            (result, next) -> result.flatMap(r -> next.map(n ->
                                    r.length() >= n.length() ?
                                            (r.startsWith(n) ? r : null) :
                                            (n.startsWith(r) ? n : null))))
                    .flatMap(s -> Arrays.stream(words)
                        .map(w -> w.indexOf("*")+1< w.length()?w.substring(w.indexOf("*")+1):"")
                        .map(Optional::of)
                            .peek(LOG::println)
                        .reduce(Optional.of(""),
                                (result, next) -> result.flatMap(r -> next.map(n ->
                                        r.length() >= n.length() ?
                                                (r.endsWith(n) ? r : null) :
                                                (n.endsWith(r) ? n : null))))
                        .map(e -> s+e))
                        .orElse("*");
            OUT.println("Case #" + g + ": " + word);
        }
    }
}