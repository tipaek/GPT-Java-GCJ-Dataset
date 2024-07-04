import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    private static void test() throws IOException {
        StringBuilder total = new StringBuilder();
        try (BufferedReader read = new BufferedReader(new FileReader("data/testIn"))) {
            String line;
            while ((line = read.readLine()) != null) {
                total.append(line).append("\n");
            }
        }
        InputStream testInput = new ByteArrayInputStream(total.toString().getBytes("UTF-8"));
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
            String m = in.nextLine().replaceAll("\\*{2,}", "*");
            String[] parts = m.split("\\*", -1);
            if (parts[0].length() > 0) beginsWith.add(parts[0]);
            if (parts[parts.length - 1].length() > 0) endsWith.add(parts[parts.length - 1]);
            if (parts.length > 2) middleParts.add(new MiddlePart(parts));
        }

        String beginning = areConsistentStrings(beginsWith, true);
        if (beginning == null) return "*";

        String end = areConsistentStrings(endsWith, false);
        if (end == null) return "*";

        middleParts.sort(Collections.reverseOrder());
        StringBuilder middlePart = new StringBuilder();

        for (MiddlePart mp : middleParts) {
            String tempMiddle = middlePart.toString();
            for (String s : mp.strings) {
                int maybeIndex = tempMiddle.indexOf(s);
                if (maybeIndex == -1) {
                    middlePart.append(s);
                    continue;
                }
                tempMiddle = tempMiddle.substring(maybeIndex + s.length());
            }
        }

        return beginning + middlePart + end;
    }

    private static class MiddlePart implements Comparable<MiddlePart> {
        private final String[] strings;
        private final int length;

        private MiddlePart(String[] fullLine) {
            strings = Arrays.copyOfRange(fullLine, 1, fullLine.length - 1);
            length = Arrays.stream(strings).mapToInt(String::length).sum();
        }

        @Override
        public int compareTo(MiddlePart other) {
            return Integer.compare(this.length, other.length);
        }
    }

    private static String areConsistentStrings(Set<String> strs, boolean isBegin) {
        String longest = "";
        for (String s : strs) {
            if (s.length() >= longest.length()) {
                if (isBegin ? !s.startsWith(longest) : !s.endsWith(longest)) return null;
                longest = s;
            } else if (isBegin ? !longest.startsWith(s) : !longest.endsWith(s)) return null;
        }
        return longest;
    }
}