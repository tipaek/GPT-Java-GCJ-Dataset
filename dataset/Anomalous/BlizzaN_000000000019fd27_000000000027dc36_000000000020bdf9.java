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

    private static class SortPair implements Comparator<Pair> {
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

        pairs.sort(new SortPair());

        int cameronEnd = 0;
        int jamieEnd = 0;

        for (Pair pair : pairs) {
            if (cameronEnd <= pair.getStartTime()) {
                cameronEnd = pair.getEndTime();
                result.append("C");
            } else if (jamieEnd <= pair.getStartTime()) {
                jamieEnd = pair.getEndTime();
                result.append("J");
            } else {
                return "IMPOSSIBLE";
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        InputStream input = System.in;
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(input)))) {
            int testCount = scanner.nextInt();
            for (int testNumber = 1; testNumber <= testCount; testNumber++) {
                int inputCount = scanner.nextInt();
                List<Integer> times = new ArrayList<>();

                for (int i = 0; i < inputCount; i++) {
                    times.add(scanner.nextInt());
                    times.add(scanner.nextInt());
                }

                System.out.println("Case #" + testNumber + ": " + solve(times, inputCount));
            }
        }
    }
}