import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    private static void test() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("data/testIn"));
        StringBuilder total = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            total.append(line).append("\n");
        }
        InputStream testInput = new ByteArrayInputStream(total.toString().getBytes("UTF-8"));
        System.setIn(testInput);
        reader.close();
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
            String[] parts = m.split("\\*", -1);
            if (!parts[0].isEmpty()) beginsWith.add(parts[0]);
            if (!parts[parts.length - 1].isEmpty()) endsWith.add(parts[parts.length - 1]);
            if (parts.length > 2) middleParts.add(new MiddlePart(parts));
        }

        String beginning = areConsistentStrings(beginsWith, true);
        if (beginning == null) return "*";
        String end = areConsistentStrings(endsWith, false);
        if (end == null) return "*";

        Collections.sort(middleParts, Collections.reverseOrder());
        StringBuilder middlePart = new StringBuilder();

        for (MiddlePart mp : middleParts) {
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

        String total = beginning + middlePart + end;
        return total.length() > 1000 ? "*" : total;
    }

    private static class MiddlePart implements Comparable<MiddlePart> {
        private final String[] strings;
        private final int length;

        private MiddlePart(String[] parts) {
            this.strings = new String[parts.length - 2];
            int len = 0;
            for (int i = 1; i < parts.length - 1; i++) {
                strings[i - 1] = parts[i];
                len += strings[i - 1].length();
            }
            this.length = len;
        }

        @Override
        public int compareTo(MiddlePart other) {
            return Integer.compare(this.length, other.length);
        }
    }

    private static String areConsistentStrings(Set<String> strs, boolean isPrefix) {
        String longest = "";
        for (String s : strs) {
            if (s.length() >= longest.length()) {
                if (isPrefix ? !s.startsWith(longest) : !s.endsWith(longest)) return null;
                longest = s;
            } else if (isPrefix ? !longest.startsWith(s) : !longest.endsWith(s)) return null;
        }
        return longest;
    }
}