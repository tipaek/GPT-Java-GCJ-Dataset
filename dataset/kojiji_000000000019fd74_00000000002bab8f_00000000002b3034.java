
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int count = in.nextInt();
        for (int i = 1; i <= count; i++) {
            final int patterns = in.nextInt();
            final List<String> all = new ArrayList<>();
            for (int i1 = 0; i1 < patterns; i1++) {
                all.add(in.next());
            }
            System.out.println("Case #" + i + ": " + solve(all));
        }
    }

    private static String solve(List<String> all) {
        Object[] preProcess = preProcess(all);
        all = (List<String>) preProcess[0];
        String currentPrefix = "";
        String currentPostfix = "";
        boolean success = true;
        for (String line : all) {
            if (!success) {
                continue;
            }
            final int position = line.indexOf('*');
            if (position == 0) {
                final String tmp = line.substring(1);
                final Optional<String> match = match(tmp, currentPostfix, false);
                if (!match.isPresent()) {
                    success = false;
                } else {
                    currentPostfix = match.get();
                }
            } else if (position == line.length() - 1) {
                final String tmp = line.substring(0, line.length() - 1);
                final Optional<String> match = match(tmp, currentPrefix, true);
                if (!match.isPresent()) {
                    success = false;
                } else {
                    currentPrefix = match.get();
                }
            } else {
                final String maybePrefix = line.substring(0, position);
                final Optional<String> match1 = match(maybePrefix, currentPrefix, true);
                if (!match1.isPresent()) {
                    success = false;
                } else {
                    currentPrefix = match1.get();
                }
                final String maybePostfix = line.substring(position + 1);
                final Optional<String> match = match(maybePostfix, currentPostfix, false);
                if (!match.isPresent()) {
                    success = false;
                } else {
                    currentPostfix = match.get();
                }
            }
        }
        List<String> others = (List<String>) preProcess[1];
        StringBuilder sb = new StringBuilder();
        for (String other : others) {
            sb.append(other);
        }
        if (success) {
            return currentPrefix + sb.toString() + currentPostfix;
        } else {
            return "*";
        }
    }

    private static Object[] preProcess(List<String> all) {
        List<String> result = new ArrayList<>();
        List<String> others = new ArrayList<>();
        for (String line : all) {
            int count = countOf(line);
            if (count == 1) {
                result.add(line);
                continue;
            }
            int first = line.indexOf("*");
            int last = line.lastIndexOf("*");
            String prefix = line.substring(0, first);
            if (prefix.length() != 0) {
                result.add(prefix + "*");
            }
            String postfix = line.substring(last + 1);
            if (postfix.length() != 0) {
                result.add("*" + postfix);
            }
            others.add(line.substring(first + 1, last).replaceAll("\\*", ""));
        }
        return new Object[]{
                result, others
        };
    }

    private static int countOf(String line) {
        return (int) line.chars().filter(ch -> ch == '*').count();
    }

    private static Optional<String> match(String first, String second, boolean fromLeft) {
        if (first.isEmpty()) {
            return Optional.of(second);
        }
        if (second.isEmpty()) {
            return Optional.of(first);
        }
        if (first.length() >= second.length() && ((fromLeft && first.indexOf(second) == 0)
                || (!fromLeft && first.lastIndexOf(second) == first.length() - second.length()))) {
            return Optional.of(first);
        } else if (second.length() > first.length() && ((fromLeft && second.indexOf(first) == 0)
                || (!fromLeft && second.lastIndexOf(first) == second.length() - first.length()))) {
            return Optional.of(second);
        } else {
            return Optional.empty();
        }
    }
}

