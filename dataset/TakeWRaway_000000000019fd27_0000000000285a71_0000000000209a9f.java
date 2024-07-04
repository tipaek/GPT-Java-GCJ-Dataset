import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

import static java.lang.String.format;
import static java.util.stream.Collectors.joining;

public class Solution {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int T = scanner.nextInt();
        IntStream.rangeClosed(1, T).forEach(t -> {
            String string = scanner.next();
            solve(string, t);
        });
    }

    private static void solve(String string, int t) {
        AtomicInteger previous = new AtomicInteger(0);
        String answer = string.chars().boxed().map(c -> c - '0')
                .map(d -> {
                    int delta = d - previous.get();
                    previous.set(d);
                    String prefix = delta == 0 ? "" : 
                        repeat(delta > 0 ? "(" : ")", Math.abs(delta));
                    return prefix + d;
                })
                .collect(joining());
        answer += repeat(")", previous.get());
        System.out.println(format("Case #%s: %s", t, answer));
    }

    private static String repeat(String string, int times) {
        return IntStream.range(0, times).boxed().map(i -> string).collect(joining());
    }
}
