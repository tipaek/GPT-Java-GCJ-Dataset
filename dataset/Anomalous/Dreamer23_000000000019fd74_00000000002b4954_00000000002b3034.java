import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
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
        test();
        try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int t = Integer.parseInt(in.nextLine());
            for (int x = 1; x <= t; x++) {
                int patterns = Integer.parseInt(in.nextLine());
                System.out.println("Case #" + x + ": " + getResult(patterns, in));
            }
        }
    }

    private static String getResult(int patterns, Scanner in) {
        Set<String> beginsWith = new HashSet<>();
        Set<String> endsWith = new HashSet<>();
        Set<List<String>> middleParts = new HashSet<>();

        for (int n = 0; n < patterns; n++) {
            String[] parts = in.nextLine().split("\\*", -1);
            if (!parts[0].isEmpty()) beginsWith.add(parts[0]);
            if (!parts[parts.length - 1].isEmpty()) endsWith.add(parts[parts.length - 1]);
            if (parts.length > 2) {
                List<String> middleP = new ArrayList<>();
                for (int i = 1; i < parts.length - 1; i++) {
                    middleP.add(parts[i]);
                }
                middleParts.add(middleP);
            }
        }

        String beginning = areConsistentStrings(beginsWith, true);
        if (beginning == null) return "*";

        String end = areConsistentStrings(endsWith, false);
        if (end == null) return "*";

        return beginning + end;
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