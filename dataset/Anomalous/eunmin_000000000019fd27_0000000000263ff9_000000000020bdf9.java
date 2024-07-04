import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static class Range {
        private int start;
        private int end;

        public Range(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public boolean isDisjoint(Range other) {
            return other.end <= this.start || this.end <= other.start;
        }
    }

    public static class Schedule {
        private List<Range> ranges = new ArrayList<>();

        public boolean addRange(Range range) {
            for (Range r : ranges) {
                if (!r.isDisjoint(range)) {
                    return false;
                }
            }
            ranges.add(range);
            return true;
        }
    }

    public static void generateCombinations(List<List<Integer>> combinations, List<Integer> current, int toPick) {
        if (toPick == 0) {
            combinations.add(new ArrayList<>(current));
            return;
        }
        for (int next = 0; next < 2; next++) {
            current.add(next);
            generateCombinations(combinations, current, toPick - 1);
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            List<Range> ranges = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                ranges.add(new Range(start, end));
            }

            List<List<Integer>> combinations = new ArrayList<>();
            generateCombinations(combinations, new ArrayList<>(), n);

            List<Integer> validCombination = null;

            for (List<Integer> combination : combinations) {
                Schedule cameronSchedule = new Schedule();
                Schedule jamieSchedule = new Schedule();
                boolean isValid = true;

                for (int i = 0; i < combination.size(); i++) {
                    boolean canAdd;
                    if (combination.get(i) == 0) {
                        canAdd = cameronSchedule.addRange(ranges.get(i));
                    } else {
                        canAdd = jamieSchedule.addRange(ranges.get(i));
                    }
                    if (!canAdd) {
                        isValid = false;
                        break;
                    }
                }

                if (isValid) {
                    validCombination = combination;
                    break;
                }
            }

            String result;
            if (validCombination != null) {
                StringBuilder resultBuilder = new StringBuilder();
                for (int assignment : validCombination) {
                    resultBuilder.append(assignment == 0 ? "C" : "J");
                }
                result = resultBuilder.toString();
            } else {
                result = "IMPOSSIBLE";
            }

            System.out.println("Case #" + testCase + ": " + result);
        }
    }
}