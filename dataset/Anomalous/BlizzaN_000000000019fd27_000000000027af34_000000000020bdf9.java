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
            return Integer.compare(p1.getStartTime(), p2.getStartTime());
        }
    }

    private static String assignActivities(List<Pair> pairs) {
        StringBuilder schedule = new StringBuilder();
        int cameronEnd = 0;
        int jamieEnd = 0;

        for (Pair pair : pairs) {
            if (cameronEnd <= pair.getStartTime()) {
                cameronEnd = pair.getEndTime();
                schedule.append("C");
            } else if (jamieEnd <= pair.getStartTime()) {
                jamieEnd = pair.getEndTime();
                schedule.append("J");
            } else {
                return "IMPOSSIBLE";
            }
        }

        return schedule.toString();
    }

    public static void main(String[] args) {
        InputStream is = System.in;
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(is)))) {
            int testCount = scanner.nextInt();
            for (int testNumber = 1; testNumber <= testCount; testNumber++) {
                int activityCount = scanner.nextInt();
                List<Pair> pairs = new ArrayList<>();

                for (int i = 0; i < activityCount; i++) {
                    int start = scanner.nextInt();
                    int end = scanner.nextInt();
                    pairs.add(new Pair(start, end));
                }

                pairs.sort(new PairComparator());

                String result = assignActivities(pairs);
                System.out.println("Case #" + testNumber + ": " + result);
            }
        }
    }
}