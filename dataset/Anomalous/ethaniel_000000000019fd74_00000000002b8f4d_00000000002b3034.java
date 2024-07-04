import java.util.*;
import java.io.*;

public class PatternMatching {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());

        for (int t = 1; t <= testCases; t++) {
            int patternCount = Integer.parseInt(reader.readLine());
            List<String> prefixes = new ArrayList<>();
            List<String> suffixes = new ArrayList<>();

            for (int n = 0; n < patternCount; n++) {
                String pattern = reader.readLine();
                if (pattern.charAt(0) == '*') {
                    suffixes.add(pattern.substring(1));
                } else if (pattern.charAt(pattern.length() - 1) == '*') {
                    prefixes.add(pattern.substring(0, pattern.length() - 1));
                } else {
                    prefixes.add(pattern.substring(0, pattern.indexOf('*')));
                    suffixes.add(pattern.substring(pattern.indexOf('*') + 1));
                }
            }

            prefixes.sort(Comparator.comparingInt(String::length));
            suffixes.sort(Comparator.comparingInt(String::length));

            boolean isValid = true;

            while (prefixes.size() > 1 && isValid) {
                if (prefixes.get(prefixes.size() - 1).contains(prefixes.get(0))) {
                    prefixes.remove(0);
                } else {
                    isValid = false;
                }
            }

            while (suffixes.size() > 1 && isValid) {
                if (suffixes.get(suffixes.size() - 1).contains(suffixes.get(0))) {
                    suffixes.remove(0);
                } else {
                    isValid = false;
                }
            }

            if (isValid) {
                String prefix = prefixes.isEmpty() ? "" : prefixes.get(0);
                String suffix = suffixes.isEmpty() ? "" : suffixes.get(0);

                while (!prefix.isEmpty() && !suffix.isEmpty() && suffix.charAt(0) == prefix.charAt(prefix.length() - 1)) {
                    suffix = suffix.substring(1);
                }

                System.out.println("Case #" + t + ": " + prefix + suffix);
            } else {
                System.out.println("Case #" + t + ": *");
            }
        }
    }
}