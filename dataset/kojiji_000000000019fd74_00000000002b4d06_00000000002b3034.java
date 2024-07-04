
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Optional;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int count = in.nextInt();
        for (int i = 1; i <= count; i++) {
            final int patterns = in.nextInt();
            String currentPrefix = "";
            String currentPostfix = "";
            boolean success = true;
            for (int i1 = 0; i1 < patterns; i1++) {
                final String line = in.next();
                if (!success) {
                    continue;
                }
                final int position = line.indexOf("*");
                if (position == 0) {
                    final String tmp = line.substring(1);
                    final Optional<String> match = match(tmp, currentPostfix);
                    if (!match.isPresent()) {
                        success = false;
                    } else {
                        currentPostfix = match.get();
                    }
                } else if (position == line.length() - 1) {
                    final String tmp = line.substring(0, line.length() - 1);
                    final Optional<String> match = match(tmp, currentPrefix);
                    if (!match.isPresent()) {
                        success = false;
                    } else {
                        currentPrefix = match.get();
                    }

                } else {
                    final String maybePrefix = line.substring(0, position);
                    final Optional<String> match1 = match(maybePrefix, currentPrefix);
                    if (!match1.isPresent()) {
                        success = false;
                    } else {
                        currentPrefix = match1.get();
                    }
                    final String maybePostfix = line.substring(0, position);
                    final Optional<String> match = match(maybePostfix, currentPostfix);
                    if (!match.isPresent()) {
                        success = false;
                    } else {
                        currentPostfix = match.get();
                    }
                }
            }
            if (success) {
                System.out.println("Case #" + i + ": " + currentPrefix + currentPostfix);
            } else {
                System.out.println("Case #" + i + ": *");
            }
        }
    }

    private static Optional<String> match(String first, String second) {
        if (first.length() >= second.length() && first.contains(second)) {
            return Optional.of(first);
        } else if (second.length() > first.length() && second.contains(first)) {
            return Optional.of(second);
        } else {
            return Optional.empty();
        }
    }
}
