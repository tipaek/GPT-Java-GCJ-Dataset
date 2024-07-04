import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {

    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();
        for (int i = 1; i <= t; ++i) {
            System.out.println("Case #" + i + ": " + solve());
        }
    }

    private static String solve() {
        int n = scanner.nextInt();
        scanner.nextLine();

        List<String> patterns = IntStream.range(0, n)
                .boxed()
                .map(operand -> scanner.nextLine())
                .collect(Collectors.toList());

        Integer maxBefore = patterns.stream()
                .map(s -> s.indexOf('*'))
                .reduce(Math::max)
                .get();

        Integer maxAfter = patterns.stream()
                .map(s -> s.length() - s.indexOf('*'))
                .reduce(Math::max)
                .get();

        Integer maxLength = maxBefore + maxAfter + 1;

        List<char[]> patternMults = patterns.stream()
                .map(s -> {
                    String s1 = s.substring(0, s.indexOf('*'));
                    String s2 = s.substring(s.indexOf('*') + 1);
                    String ast = "";
                    for (int i = 0; i <= maxLength - s.length(); i++) {
                        ast += '*';
                    }
                    return s1 + ast + s2;
                })
                .map(String::toCharArray)
                .collect(Collectors.toList());

        String name = "";

        for (int i = 0; i < maxLength; i++) {
            Character c = null;
            for (int p = 0; p < patternMults.size(); p++) {
                Character pC = patternMults.get(p)[i];
                if (pC != '*') {
                    if (c == null) {
                        c = pC;
                    } else if (!c.equals(pC)) {
                        return "*";
                    }
                }
            }
            if (c != null) {
                name += c;
            }
        }

        return name;
    }

}
