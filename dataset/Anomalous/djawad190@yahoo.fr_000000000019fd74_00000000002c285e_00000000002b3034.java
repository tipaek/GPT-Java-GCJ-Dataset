import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCaseCount = scanner.nextInt();

        for (int i = 1; i <= testCaseCount; i++) {
            int patternCount = scanner.nextInt();
            scanner.nextLine();

            List<String[]> patterns = new ArrayList<>();
            List<String> startSegments = new ArrayList<>();
            List<String> endSegments = new ArrayList<>();
            List<String> middleSegments = new ArrayList<>();
            int maxPatternLength = 0;

            for (int j = 0; j < patternCount; j++) {
                String pattern = scanner.nextLine().trim();
                if (pattern.endsWith("*")) {
                    pattern += " ";
                }
                String[] segments = pattern.split("\\*");
                patterns.add(segments);

                if (!segments[0].trim().isEmpty()) {
                    startSegments.add(segments[0]);
                }
                if (!segments[segments.length - 1].trim().isEmpty()) {
                    endSegments.add(segments[segments.length - 1]);
                }

                maxPatternLength = Math.max(maxPatternLength, segments.length);
            }

            String commonStart = findCommonPattern(startSegments, 1);
            String commonEnd = findCommonPattern(endSegments, 3);
            String commonString = commonStart;

            if (commonStart.equals("*") || commonEnd.equals("*")) {
                System.out.println("Case #" + i + ": *");
                continue;
            }

            for (int j = 1; j < maxPatternLength - 1; j++) {
                middleSegments.clear();
                for (String[] segments : patterns) {
                    if (j < segments.length - 1) {
                        middleSegments.add(segments[j]);
                    }
                }
                String commonMiddle = findCommonPattern(middleSegments, 2);
                if (commonMiddle.equals("*")) {
                    commonString = "*";
                    break;
                }
                commonString += commonMiddle;
            }

            if (!commonString.equals("*")) {
                commonString += commonEnd;
            }

            System.out.println("Case #" + i + ": " + commonString);
        }
    }

    private static String findCommonPattern(List<String> segments, int position) {
        if (segments.isEmpty()) {
            return "";
        }
        if (segments.size() == 1) {
            return segments.get(0);
        }

        String common = segments.get(0);
        for (int i = 1; i < segments.size(); i++) {
            String segment = segments.get(i);
            if (common.length() > segment.length()) {
                common = getCommonPattern(common, segment, position);
            } else {
                common = getCommonPattern(segment, common, position);
            }

            if (common.equals("*")) {
                break;
            }
        }
        return common;
    }

    private static String getCommonPattern(String longer, String shorter, int position) {
        switch (position) {
            case 1:
                return longer.startsWith(shorter) ? longer : "*";
            case 2:
                return longer.contains(shorter) ? longer : longer + shorter;
            case 3:
                return longer.endsWith(shorter) ? longer : "*";
            default:
                return "*";
        }
    }
}