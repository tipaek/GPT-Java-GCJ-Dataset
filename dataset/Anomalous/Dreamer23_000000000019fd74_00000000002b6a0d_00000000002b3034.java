import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    private static void test() throws IOException {
        StringBuilder total = new StringBuilder();
        try (BufferedReader read = new BufferedReader(new FileReader("data/testIn"))) {
            String line;
            while ((line = read.readLine()) != null) {
                total.append(line).append("\n");
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
            String[] parts = in.nextLine().split("\\*", -1);
            if (!parts[0].isEmpty()) beginsWith.add(parts[0]);
            if (!parts[parts.length - 1].isEmpty()) endsWith.add(parts[parts.length - 1]);
            if (parts.length > 2) {
                middleParts.add(new MiddlePart(parts));
            }
        }
        String beginning = areConsistentStrings(beginsWith, true);
        if (beginning == null) return "*";
        String end = areConsistentStrings(endsWith, false);
        if (end == null) return "*";

        Collections.sort(middleParts);
        Collections.reverse(middleParts);
        StringBuilder middlePart = new StringBuilder();
        for (MiddlePart mp : middleParts) {
            addMiddleParts(middlePart, mp);
        }

        if (beginning.isEmpty() && middlePart.length() == 0 && end.isEmpty()) return "A";
        return beginning + middlePart + end;
    }

    private static void addMiddleParts(StringBuilder middlePart, MiddlePart mp) {
        String tempMiddle = middlePart.toString();
        for (String s : mp.strings) {
            int index = tempMiddle.indexOf(s);
            if (index == -1) {
                middlePart.append(s);
            } else {
                tempMiddle = tempMiddle.substring(index + s.length());
            }
        }
    }

    private static class MiddlePart implements Comparable<MiddlePart> {
        private final String[] strings;
        private final int length;

        private MiddlePart(String[] fullLine) {
            this.strings = new String[fullLine.length - 2];
            int len = 0;
            for (int i = 1; i < fullLine.length - 1; i++) {
                strings[i - 1] = fullLine[i];
                len += strings[i - 1].length();
            }
            this.length = len;
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
                if ((isBegin && !s.startsWith(longest)) || (!isBegin && !s.endsWith(longest))) {
                    return null;
                }
                longest = s;
            } else if ((isBegin && !longest.startsWith(s)) || (!isBegin && !longest.endsWith(s))) {
                return null;
            }
        }
        return longest;
    }
}