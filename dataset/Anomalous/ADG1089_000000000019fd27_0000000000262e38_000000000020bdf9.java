import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int numRanges = scanner.nextInt();
            List<Range> ranges = new ArrayList<>();

            for (int i = 0; i < numRanges; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                ranges.add(new Range(start, end));
            }

            ranges.sort(Comparator.comparingInt(range -> range.start));

            Range jRange = null;
            Range cRange = null;
            boolean isPossible = true;
            StringBuilder schedule = new StringBuilder();

            for (Range range : ranges) {
                if (jRange == null || jRange.end <= range.start) {
                    jRange = range;
                    schedule.append("J");
                } else if (cRange == null || cRange.end <= range.start) {
                    cRange = range;
                    schedule.append("C");
                } else {
                    isPossible = false;
                    break;
                }
            }

            String result = isPossible ? schedule.toString() : "IMPOSSIBLE";
            System.out.printf("Case #%d: %s\n", caseNum, result);
        }
    }

    static class Range {
        int start;
        int end;

        Range(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}