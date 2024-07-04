import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());

        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(reader.readLine());
            List<String> prefixes = new ArrayList<>();
            List<String> suffixes = new ArrayList<>();

            for (int n = 0; n < N; n++) {
                String line = reader.readLine();
                if (line.startsWith("*")) {
                    suffixes.add(line.substring(1));
                } else if (line.endsWith("*")) {
                    prefixes.add(line.substring(0, line.length() - 1));
                } else {
                    prefixes.add(line.substring(0, line.indexOf('*')));
                    suffixes.add(line.substring(line.indexOf('*') + 1));
                }
            }

            prefixes.sort(Comparator.comparingInt(String::length));
            suffixes.sort(Comparator.comparingInt(String::length));

            boolean isValid = true;

            while (prefixes.size() > 1 && isValid) {
                String lastPrefix = prefixes.get(prefixes.size() - 1);
                String firstPrefix = prefixes.get(0);
                if (lastPrefix.startsWith(firstPrefix)) {
                    prefixes.remove(0);
                } else {
                    isValid = false;
                }
            }

            while (suffixes.size() > 1 && isValid) {
                String lastSuffix = suffixes.get(suffixes.size() - 1);
                String firstSuffix = suffixes.get(0);
                if (lastSuffix.endsWith(firstSuffix)) {
                    suffixes.remove(0);
                } else {
                    isValid = false;
                }
            }

            if (isValid) {
                String prefix = prefixes.isEmpty() ? "" : prefixes.get(0);
                String suffix = suffixes.isEmpty() ? "" : suffixes.get(0);
                int totalLength = prefix.length() + suffix.length();

                if (totalLength > 10000) {
                    System.out.println("Case #" + t + ": *");
                } else {
                    System.out.println("Case #" + t + ": " + prefix + suffix);
                }
            } else {
                System.out.println("Case #" + t + ": *");
            }
        }
    }
}