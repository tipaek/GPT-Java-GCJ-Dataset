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

    private static String assignTasks(List<Integer> times, int count) {
        StringBuilder result = new StringBuilder();
        List<Pair> pairs = new ArrayList<>();

        for (int i = 0; i < times.size(); i += 2) {
            pairs.add(new Pair(times.get(i), times.get(i + 1)));
        }

        pairs.sort(new PairComparator());

        int cameronEnd = 0;
        int jamieEnd = 0;

        for (Pair pair : pairs) {
            if (pair.getStartTime() >= cameronEnd) {
                cameronEnd = pair.getEndTime();
                result.append("C");
            } else if (pair.getStartTime() >= jamieEnd) {
                jamieEnd = pair.getEndTime();
                result.append("J");
            } else {
                return "IMPOSSIBLE";
            }
        }

        return result.toString();
    }

    public static void main(String[] args) throws FileNotFoundException {
        InputStream inputStream = new FileInputStream("src/main/resources/qualification/ParentingReturn");
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(inputStream)))) {
            int testCases = scanner.nextInt();
            for (int testCase = 1; testCase <= testCases; testCase++) {
                int tasksCount = scanner.nextInt();
                List<Integer> times = new ArrayList<>();

                for (int i = 0; i < tasksCount; i++) {
                    times.add(scanner.nextInt());
                    times.add(scanner.nextInt());
                }

                String result = assignTasks(times, tasksCount);
                System.out.println("Case #" + testCase + ": " + result);
            }
        }
    }
}