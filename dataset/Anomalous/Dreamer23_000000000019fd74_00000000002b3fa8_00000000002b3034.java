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
        // Uncomment the following line to enable testing with a file
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
        List<String[]> middleParts = new ArrayList<>();

        for (int n = 0; n < patterns; n++) {
            String[] parts = in.nextLine().split("\\*");
            if (parts[0].length() > 0) beginsWith.add(parts[0]);
            if (parts[parts.length - 1].length() > 0) endsWith.add(parts[parts.length - 1]);
            if (parts.length > 2) {
                String[] middle = new String[parts.length - 2];
                System.arraycopy(parts, 1, middle, 0, parts.length - 2);
                middleParts.add(middle);
            }
        }

        String beginning = getConsistentString(beginsWith, true);
        if (beginning == null) return "*";

        String end = getConsistentString(endsWith, false);
        if (end == null) return "*";

        // TODO: Process Middle Parts

        return beginning + end;
    }

    private static String getConsistentString(Set<String> strs, boolean isPrefix) {
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