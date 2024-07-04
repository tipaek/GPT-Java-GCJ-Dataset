import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int numPatterns = scanner.nextInt();
            scanner.nextLine();

            ArrayList<String[]> patterns = new ArrayList<>();
            ArrayList<String> starts = new ArrayList<>();
            ArrayList<String> ends = new ArrayList<>();
            ArrayList<String> middles = new ArrayList<>();
            int maxPatternLength = 0;

            for (int n = 0; n < numPatterns; n++) {
                String pattern = scanner.nextLine().trim();
                if (pattern.endsWith("*")) {
                    pattern += " ";
                }
                String[] parts = pattern.split("\\*");
                patterns.add(parts);

                if (!parts[0].trim().isEmpty()) {
                    starts.add(parts[0]);
                }
                if (!parts[parts.length - 1].trim().isEmpty()) {
                    ends.add(parts[parts.length - 1]);
                }

                maxPatternLength = Math.max(maxPatternLength, parts.length);
            }

            String commonStart = findCommonPattern(starts, 1);
            String commonEnd = findCommonPattern(ends, 3);
            String commonString = commonStart;

            if ("*".equals(commonStart) || "*".equals(commonEnd)) {
                System.out.println("Case #" + t + ": *");
                continue;
            }

            for (int j = 1; j < maxPatternLength - 1; j++) {
                for (String[] pattern : patterns) {
                    if (j < pattern.length - 1) {
                        middles.add(pattern[j]);
                    }
                }
                String commonMiddle = findCommonPattern(middles, 2);
                if ("*".equals(commonMiddle)) {
                    commonString = "*";
                    break;
                }
                commonString += commonMiddle;
            }

            if (!"*".equals(commonString)) {
                commonString += commonEnd;
            }

            System.out.println("Case #" + t + ": " + commonString);
        }
    }

    static String findCommonPattern(ArrayList<String> patternList, int position) {
        if (patternList.isEmpty()) {
            return "";
        }

        String common = patternList.get(0);
        for (String pattern : patternList) {
            if (common.length() > pattern.length()) {
                common = getCommonSegment(common, pattern, position);
            } else {
                common = getCommonSegment(pattern, common, position);
            }

            if ("*".equals(common)) {
                break;
            }
        }

        return common;
    }

    static String getCommonSegment(String longer, String shorter, int position) {
        switch (position) {
            case 1:
                return longer.startsWith(shorter) ? longer : "*";
            case 2:
                return longer.contains(shorter) ? longer : "*";
            case 3:
                return longer.endsWith(shorter) ? longer : "*";
            default:
                return "*";
        }
    }
}