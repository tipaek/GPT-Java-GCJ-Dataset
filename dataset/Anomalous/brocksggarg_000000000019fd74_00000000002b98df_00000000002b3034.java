import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 1; i <= t; i++) {
            System.out.println(solve(br));
        }
    }

    private static String solve(BufferedReader br) throws IOException {
        int n = Integer.parseInt(br.readLine());
        ArrayList<String> patterns = new ArrayList<>();
        Map<Integer, Integer> lastIndex = new HashMap<>();
        Map<Integer, Integer> startIndex = new HashMap<>();
        Map<Integer, Boolean> lastActive = new HashMap<>();
        Map<Integer, Boolean> startActive = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String pattern = br.readLine();
            patterns.add(pattern);
            lastIndex.put(i, pattern.length() - 1);
            startIndex.put(i, 0);
            lastActive.put(i, true);
            startActive.put(i, true);
        }

        String suffix = buildSuffix(patterns, lastIndex, lastActive);
        if (suffix.equals("*")) return "*";

        String prefix = buildPrefix(patterns, startIndex, startActive);
        if (prefix.equals("*")) return "*";

        String middle = buildMiddle(patterns, startIndex, lastIndex);

        return prefix + middle + suffix;
    }

    private static String buildSuffix(ArrayList<String> patterns, Map<Integer, Integer> lastIndex, Map<Integer, Boolean> lastActive) {
        StringBuilder suffix = new StringBuilder();
        while (true) {
            char currentChar = '@';
            for (int i = 0; i < patterns.size(); i++) {
                if (lastActive.get(i)) {
                    char c = patterns.get(i).charAt(lastIndex.get(i));
                    if (c == '*') {
                        lastActive.put(i, false);
                    } else if (currentChar == '@') {
                        currentChar = c;
                    } else if (currentChar != c) {
                        return "*";
                    }
                    lastIndex.put(i, lastIndex.get(i) - 1);
                }
            }
            if (currentChar == '@') break;
            suffix.insert(0, currentChar);
        }
        return suffix.toString();
    }

    private static String buildPrefix(ArrayList<String> patterns, Map<Integer, Integer> startIndex, Map<Integer, Boolean> startActive) {
        StringBuilder prefix = new StringBuilder();
        while (true) {
            char currentChar = '@';
            for (int i = 0; i < patterns.size(); i++) {
                if (startActive.get(i)) {
                    char c = patterns.get(i).charAt(startIndex.get(i));
                    if (c == '*') {
                        startActive.put(i, false);
                        continue;
                    } else if (currentChar == '@') {
                        currentChar = c;
                    } else if (currentChar != c) {
                        return "*";
                    }
                    startIndex.put(i, startIndex.get(i) + 1);
                }
            }
            if (currentChar == '@') break;
            prefix.append(currentChar);
        }
        return prefix.toString();
    }

    private static String buildMiddle(ArrayList<String> patterns, Map<Integer, Integer> startIndex, Map<Integer, Integer> lastIndex) {
        StringBuilder middle = new StringBuilder();
        for (int i = 0; i < patterns.size(); i++) {
            String substring = patterns.get(i).substring(startIndex.get(i), lastIndex.get(i) + 1);
            for (char c : substring.toCharArray()) {
                if (c != '*') {
                    middle.append(c);
                }
            }
        }
        return middle.toString();
    }
}