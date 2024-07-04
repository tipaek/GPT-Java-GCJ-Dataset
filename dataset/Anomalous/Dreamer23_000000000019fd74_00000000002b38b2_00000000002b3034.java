import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    private static void test() throws IOException {
        StringBuilder total = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader("data/testIn"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                total.append(line).append("\n");
            }
        }
        InputStream testInput = new ByteArrayInputStream(total.toString().getBytes("UTF-8"));
        System.setIn(testInput);
    }

    public static void main(String[] args) throws IOException {
        // Uncomment the next line to enable testing from file
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
        Set<List<String>> middleParts = new HashSet<>();

        for (int n = 0; n < patterns; n++) {
            String[] parts = in.nextLine().split("\\*");
            if (!parts[0].isEmpty()) beginsWith.add(parts[0]);
            if (!parts[parts.length - 1].isEmpty()) endsWith.add(parts[parts.length - 1]);
            if (parts.length > 2) {
                List<String> middlePart = new ArrayList<>();
                for (int i = 1; i < parts.length - 1; i++) {
                    middlePart.add(parts[i]);
                }
                middleParts.add(middlePart);
            }
        }

        String beginning = findConsistentString(beginsWith, true);
        if (beginning == null) return "*";
        String end = findConsistentString(endsWith, false);
        if (end == null) return "*";

        // TODO: Handle middle parts if necessary

        return beginning + end;
    }

    private static String findConsistentString(Set<String> strings, boolean isPrefix) {
        String longest = "";
        for (String str : strings) {
            if (str.length() >= longest.length()) {
                if (isPrefix ? !str.startsWith(longest) : !str.endsWith(longest)) {
                    return null;
                }
                longest = str;
            }
        }
        return longest;
    }
}