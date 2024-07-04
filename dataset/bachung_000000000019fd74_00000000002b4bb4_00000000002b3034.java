import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(reader.readLine());
        for (int i = 0; i < T; i++) solve(reader, i + 1);
    }

    static void solve(BufferedReader reader, int caseNum) throws Exception {
        int N = Integer.parseInt(reader.readLine());

        String[] patterns = new String[N];
        for (int i = 0; i < N; i++) {
            patterns[i] = reader.readLine();
        }

        String startsWith = "";
        String endsWith = "";
        List<String> contains = new ArrayList<>();
        boolean possible = true;
        for (String pattern : patterns) {
            int firstAsterisk = pattern.indexOf("*");
            int lastAsterisk = pattern.lastIndexOf("*");
            if (firstAsterisk != -1) {
                String s = pattern.substring(0, firstAsterisk);
                if (s.length() >= startsWith.length()) {
                    if (s.startsWith(startsWith)) {
                        startsWith = s;
                    } else {
                        // System.out.println("Break on " + pattern + ", " + s);
                        possible = false;
                        break;
                    }
                } else if (s.length() < startsWith.length()) {
                    if (startsWith.startsWith(s)) {

                    } else {
                        // System.out.println("Break on " + pattern + ", " + s);
                        possible = false;
                        break;
                    }
                }
            }
            if (lastAsterisk != -1) {
                String s = pattern.substring(lastAsterisk + 1, pattern.length());
                if (s.length() >= endsWith.length()) {
                    if (s.endsWith(endsWith)) {
                        endsWith = s;
                    } else {
                        // System.out.println("Break on " + pattern + ", " + s);
                        possible = false;
                        break;
                    }
                } else {
                    if (endsWith.endsWith(s)) {

                    } else {
                        // System.out.println("Break on " + pattern + ", " + s);
                        possible = false;
                        break;
                    }
                }
            }
            if (firstAsterisk != lastAsterisk) {
                contains.add(filter(pattern, firstAsterisk + 1, lastAsterisk));
            }
        }
        StringBuilder result = new StringBuilder();
        result.append(startsWith);
        for (String s : contains) {
            result.append(s);
        }
        result.append(endsWith);
        // System.out.println(startsWith + ":" + endsWith);
        System.out.printf("Case #%d: %s%n", caseNum, possible ? result.toString() : "*");
    }

    static String filter(String input, int start, int end) {
        StringBuilder builder = new StringBuilder();
        while (start < end) {
            if (input.charAt(start) != '*') {
                builder.append(input.charAt(start));
            }
            start++;
        }
        return builder.toString();
    }
}