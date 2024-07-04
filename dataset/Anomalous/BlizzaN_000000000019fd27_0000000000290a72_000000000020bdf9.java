import java.io.*;
import java.util.*;

public class Solution {

    private static class Pair {
        private final int startTime;
        private final int endTime;

        Pair(int start, int end) {
            this.startTime = start;
            this.endTime = end;
        }

        public int getStartTime() {
            return startTime;
        }

        public int getEndTime() {
            return endTime;
        }
    }

    private static class PairComparator implements Comparator<Pair> {
        @Override
        public int compare(Pair p1, Pair p2) {
            return Integer.compare(p1.getEndTime(), p2.getEndTime());
        }
    }

    private static String scheduleTasks(List<Pair> pairs) {
        StringBuilder result = new StringBuilder();
        pairs.sort(new PairComparator());

        int cameronEnd = 0;
        int jamieEnd = 0;

        for (Pair pair : pairs) {
            if (cameronEnd <= pair.getStartTime()) {
                cameronEnd = pair.getEndTime();
                result.append('C');
            } else if (jamieEnd <= pair.getStartTime()) {
                jamieEnd = pair.getEndTime();
                result.append('J');
            } else {
                return "IMPOSSIBLE";
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(inputStream)))) {
            int testCases = scanner.nextInt();
            for (int testCase = 1; testCase <= testCases; testCase++) {
                int taskCount = scanner.nextInt();
                List<Pair> pairs = new ArrayList<>();

                for (int i = 0; i < taskCount; i++) {
                    int start = scanner.nextInt();
                    int end = scanner.nextInt();
                    pairs.add(new Pair(start, end));
                }

                String result = scheduleTasks(pairs);
                System.out.println("Case #" + testCase + ": " + result);
            }
        }
    }
}