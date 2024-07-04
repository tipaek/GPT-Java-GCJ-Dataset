import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int T = readInput()[0];
        for (int i = 0; i < T; i++) {
            int N = readInput()[0];

            Asterisk[] asterisks = new Asterisk[101];
            for (int j = 0; j < asterisks.length; j++) {
                asterisks[j] = new Asterisk();
            }

            for (int j = 0; j < N; j++) {
                String line = scanner.nextLine();

                int currentAsterisk = 0;
                int lastIndex = 0;
                for (int k = 0; k < line.length(); k++) {
                    if (line.charAt(k) == '*') {
                        String segment = line.substring(lastIndex, k);
                        asterisks[currentAsterisk].add(segment);
                        lastIndex = k + 1;
                        currentAsterisk++;
                    }
                }
                String segment = line.substring(lastIndex);
                asterisks[currentAsterisk].add(segment);
            }

            StringBuilder result = new StringBuilder();
            for (Asterisk asterisk : asterisks) {
                String containedString = asterisk.getContainedString();
                if (containedString.equals("\\*")) {
                    result.setLength(0);
                    result.append('*');
                    break;
                } else {
                    result.append(containedString);
                }
            }

            System.out.println("Case #" + (i + 1) + ": " + result.toString());
        }
    }

    static int[] readInput() {
        return Arrays.stream(scanner.nextLine().split(" "))
                     .mapToInt(Integer::parseInt)
                     .toArray();
    }
}

class Asterisk {
    private HashSet<String> segments;

    Asterisk() {
        segments = new HashSet<>();
    }

    void add(String segment) {
        segments.add(segment);
    }

    String getContainedString() {
        if (segments.isEmpty()) {
            return "";
        }
        String[] sortedSegments = segments.toArray(new String[0]);
        Arrays.sort(sortedSegments, (a, b) -> b.length() - a.length());

        String largestSegment = sortedSegments[0];
        for (int i = 1; i < sortedSegments.length; i++) {
            if (!largestSegment.contains(sortedSegments[i])) {
                return "\\*";
            }
        }
        return largestSegment;
    }
}