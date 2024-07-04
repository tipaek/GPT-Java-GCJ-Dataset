import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();

        for (int i = 1; i <= t; ++i) {
            int n = scanner.nextInt();

            String[] patterns = new String[n];
            for (int j = 0; j < n; ++j) {
                patterns[j] = scanner.next();
            }

            System.out.println("Case #" + i + ": " + findWord(patterns));
        }

        scanner.close();
    }

    public static String findWord(String[] patterns) {
        String merged = patterns[0];

        for (int i = 1; i < patterns.length; ++i) {
            int firstStarIndex = merged.indexOf("*");
            int lastStartIndex = merged.lastIndexOf("*");
            String prefixA = merged.substring(0, firstStarIndex);
            String middleA = merged.substring(firstStarIndex, lastStartIndex);
            String suffixA = merged.substring(lastStartIndex + 1);

            firstStarIndex = patterns[i].indexOf("*");
            lastStartIndex = patterns[i].lastIndexOf("*");
            String prefixB = patterns[i].substring(0, firstStarIndex);
            String middleB = patterns[i].substring(firstStarIndex, lastStartIndex);
            String suffixB = patterns[i].substring(lastStartIndex + 1);

            StringBuffer sb = new StringBuffer();

            if (prefixA.length() > prefixB.length()) {
                if (prefixB.equals("") || prefixA.startsWith(prefixB)) {
                    sb.append(prefixA);
                } else {
                    return "*";
                }
            } else {
                if (prefixA.equals("") || prefixB.startsWith(prefixA)) {
                    sb.append(prefixB);
                } else {
                    return "*";
                }
            }

            sb.append("*");

            sb.append(middleA);
            sb.append(middleB);

            sb.append("*");

            if (suffixA.length() > suffixB.length()) {
                if (suffixB.equals("") || suffixA.endsWith(suffixB)) {
                    sb.append(suffixA);
                } else {
                    return "*";
                }
            } else {
                if (suffixA.equals("") || suffixB.endsWith(suffixA)) {
                    sb.append(suffixB);
                } else {
                    return "*";
                }
            }

            merged = sb.toString();
        }

        merged = merged.replace("*", "");

        return merged;
    }
}