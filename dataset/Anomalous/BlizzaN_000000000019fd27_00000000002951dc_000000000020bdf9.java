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

    private static String solve2(List<Integer> time, int length) {
        StringBuilder sb = new StringBuilder();

        List<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < time.size(); i += 2) {
            pairs.add(new Pair(time.get(i), time.get(i + 1)));
        }

        int jamieStart = 0, jamieEnd = 0;
        int cameronStart = 0, cameronEnd = 0;

        for (int i = 0; i < length; i++) {
            Pair currentPair = pairs.get(i);
            int currentStart = currentPair.getStartTime();
            int currentEnd = currentPair.getEndTime();

            if ((cameronEnd <= currentStart) || (currentEnd <= cameronStart)) {
                cameronStart = currentStart;
                cameronEnd = currentEnd;
                sb.append("C");
            } else if ((jamieEnd <= currentStart) || (currentEnd <= jamieStart)) {
                jamieStart = currentStart;
                jamieEnd = currentEnd;
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
                List<Integer> time = new ArrayList<>();

                for (int i = 0; i < input; i++) {
                    time.add(scanner.nextInt());
                    time.add(scanner.nextInt());
                }

                System.out.println("Case #" + testNumber + ": " + solve2(time, input).trim());
            }
        }
    }
}