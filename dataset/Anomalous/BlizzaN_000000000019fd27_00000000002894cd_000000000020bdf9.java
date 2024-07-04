import java.io.*;
import java.util.*;

public class Solution {

    private static class Pair {
        private int startTime;
        private int endTime;

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

    private static String solve(List<Integer> times, int length) {
        StringBuilder result = new StringBuilder();
        List<Pair> pairs = new ArrayList<>();

        for (int i = 0; i < times.size(); i += 2) {
            pairs.add(new Pair(times.get(i), times.get(i + 1)));
        }

        pairs.sort(new PairComparator());

        int cameronEnd = 0;
        int jamieEnd = 0;

        for (Pair pair : pairs) {
            if (pair.getStartTime() >= jamieEnd) {
                jamieEnd = pair.getEndTime();
                result.append("J");
            } else if (pair.getStartTime() >= cameronEnd) {
                cameronEnd = pair.getEndTime();
                result.append("C");
            } else {
                return "IMPOSSIBLE";
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(inputStream)))) {
            int testCount = scanner.nextInt();
            for (int testNumber = 1; testNumber <= testCount; testNumber++) {
                int activityCount = scanner.nextInt();
                List<Integer> times = new ArrayList<>();

                for (int i = 0; i < activityCount; i++) {
                    times.add(scanner.nextInt());
                    times.add(scanner.nextInt());
                }

                String result = solve(times, activityCount);
                System.out.println("Case #" + testNumber + ": " + result);
            }
        }
    }
}