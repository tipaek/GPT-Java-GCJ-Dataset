import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static class TimePair implements Comparable<TimePair> {
        int start;
        int end;
        String original;

        public TimePair(int start, int end, String original) {
            this.start = start;
            this.end = end;
            this.original = original;
        }

        @Override
        public int compareTo(TimePair other) {
            return Integer.compare(this.end, other.end);
        }
    }

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int numberTests = Integer.parseInt(br.readLine());

            for (int i = 0; i < numberTests; i++) {
                int numTimes = Integer.parseInt(br.readLine());
                List<TimePair> times = new ArrayList<>();

                for (int j = 0; j < numTimes; j++) {
                    String[] time = br.readLine().split(" ");
                    int start = Integer.parseInt(time[0]);
                    int end = Integer.parseInt(time[1]);
                    times.add(new TimePair(start, end, time[0] + " " + time[1]));
                }

                solveTestCase(i + 1, times);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void solveTestCase(int testNumber, List<TimePair> times) {
        Map<String, String> allocationMap = new LinkedHashMap<>();
        for (TimePair pair : times) {
            allocationMap.put(pair.original, "");
        }

        Collections.sort(times);

        StringBuilder result = new StringBuilder();
        int endC = -1, endJ = -1;

        for (TimePair pair : times) {
            if (pair.start >= endJ) {
                endJ = pair.end;
                allocationMap.put(pair.original, "J");
            } else if (pair.start >= endC) {
                endC = pair.end;
                allocationMap.put(pair.original, "C");
            } else {
                System.out.println("Case #" + testNumber + ": IMPOSSIBLE");
                return;
            }
        }

        for (String assignment : allocationMap.values()) {
            result.append(assignment);
        }

        System.out.println("Case #" + testNumber + ": " + result.toString());
    }
}