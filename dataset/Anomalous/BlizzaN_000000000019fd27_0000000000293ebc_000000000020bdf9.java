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

    private static String solve2(List<Pair> pairs) {
        StringBuilder sb = new StringBuilder();

        int jamieEnd = 0;
        int cameronEnd = 0;

        for (Pair pair : pairs) {
            if (cameronEnd <= pair.getStartTime()) {
                cameronEnd = pair.getEndTime();
                sb.append("C");
            } else if (jamieEnd <= pair.getStartTime()) {
                jamieEnd = pair.getEndTime();
                sb.append("J");
            } else {
                return "IMPOSSIBLE";
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) throws FileNotFoundException {
        InputStream is = System.in;
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(is)))) {
            int testCount = scanner.nextInt();
            for (int testNumber = 1; testNumber <= testCount; testNumber++) {
                int input = scanner.nextInt();
                List<Pair> pairs = new ArrayList<>();

                for (int i = 0; i < input; i++) {
                    int startTime = scanner.nextInt();
                    int endTime = scanner.nextInt();
                    pairs.add(new Pair(startTime, endTime));
                }

                pairs.sort(Comparator.comparingInt(Pair::getStartTime));

                System.out.println("Case #" + testNumber + ": " + solve2(pairs));
            }
        }
    }
}