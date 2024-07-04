import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Solution {

    private static void test() throws IOException {
        StringBuilder total = new StringBuilder();
        try (BufferedReader read = new BufferedReader(new FileReader("data/testIn"))) {
            String s;
            while ((s = read.readLine()) != null) {
                total.append(s).append("\n");
            }
        }
        InputStream testInput = new ByteArrayInputStream(total.toString().getBytes(StandardCharsets.UTF_8));
        System.setIn(testInput);
    }

    public static void main(String[] args) throws IOException {
        // test();
        try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int t = Integer.parseInt(in.nextLine());
            for (int x = 1; x <= t; ++x) {
                int patterns = Integer.parseInt(in.nextLine());
                System.out.println("Case #" + x + ": " + getResult(patterns, in));
            }
        }
    }

    private static String getResult(int patterns, Scanner in) {
        Set<String> beginsWith = new HashSet<>();
        Set<String> endsWith = new HashSet<>();
        List<MiddlePart> middleParts = new ArrayList<>();
        for (int n = 0; n < patterns; n++) {
            String m = in.nextLine().replace("**", "*");
            String[] s = m.split("\\*", -1);
            if (s[0].length() > 0) beginsWith.add(s[0]);
            if (s[s.length - 1].length() > 0) endsWith.add(s[s.length - 1]);
            if (s.length > 2) {
                middleParts.add(new MiddlePart(s));
            }
        }
        String beginning = areConsistentBeginStrings(beginsWith);
        if (beginning == null) return "*";
        String end = areConsistentEndStrings(endsWith);
        if (end == null) return "*";

        Collections.sort(middleParts, Collections.reverseOrder());
        StringBuilder middlePart = new StringBuilder();
        for (MiddlePart mp : middleParts) {
            boolean maybeContains = true;
            String tempMiddle = middlePart.toString();
            for (String s : mp.strings) {
                if (!maybeContains) {
                    middlePart.append(s);
                    continue;
                }
                int maybeIndex = tempMiddle.indexOf(s);
                if (maybeIndex == -1) {
                    maybeContains = false;
                    middlePart.append(s);
                    continue;
                }
                int newIndex = maybeIndex + s.length();
                if (newIndex == tempMiddle.length()) tempMiddle = "";
                else tempMiddle = tempMiddle.substring(newIndex);
            }
        }

        return beginning + middlePart + end;
    }

    private static class MiddlePart implements Comparable<MiddlePart> {
        private final String[] strings;
        private final int length;

        private MiddlePart(String[] fullLine) {
            this.strings = Arrays.copyOfRange(fullLine, 1, fullLine.length - 1);
            this.length = Arrays.stream(strings).mapToInt(String::length).sum();
        }

        @Override
        public int compareTo(MiddlePart o) {
            return Integer.compare(this.length, o.length);
        }
    }

    private static String areConsistentBeginStrings(Set<String> strs) {
        String longest = "";
        for (String s : strs) {
            if (s.length() >= longest.length()) {
                if (!s.startsWith(longest)) return null;
                longest = s;
            } else if (!longest.startsWith(s)) return null;
        }
        return longest;
    }

    private static String areConsistentEndStrings(Set<String> strs) {
        String longest = "";
        for (String s : strs) {
            if (s.length() >= longest.length()) {
                if (!s.endsWith(longest)) return null;
                longest = s;
            } else if (!longest.endsWith(s)) return null;
        }
        return longest;
    }
}