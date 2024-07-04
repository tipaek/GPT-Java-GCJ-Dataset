import java.io.*;
import java.util.Arrays;
import java.util.HashMap;

public class Solution {

    static FastReader in = new FastReader(System.in);

    public static void main(String[] args) throws IOException {
        int testCases = in.nextInt();
        StringBuilder result = new StringBuilder();
        for (int tc = 1; tc <= testCases; tc++) {
            int n = in.nextInt();
            int[][] intervals = new int[n][2];
            Interval[] intervalArray = new Interval[n];
            int[] startTimes = new int[n];
            int[] endTimes = new int[n];

            // Read input and initialize arrays
            for (int i = 0; i < n; i++) {
                intervals[i][0] = in.nextInt();
                intervals[i][1] = in.nextInt();
                startTimes[i] = intervals[i][0];
                endTimes[i] = intervals[i][1];
                intervalArray[i] = new Interval(intervals[i][0], intervals[i][1], i);
            }

            result.append("Case #").append(tc).append(": ");
            Arrays.sort(intervalArray);

            int platformCount = calculatePlatforms(startTimes, endTimes);
            if (platformCount > 2) {
                result.append("IMPOSSIBLE");
            } else if (platformCount == 1) {
                result.append("C".repeat(n));
            } else {
                int previousEnd = intervalArray[0].end, assign = 0;
                HashMap<Integer, Integer> assignmentMap = new HashMap<>();
                assignmentMap.put(intervalArray[0].index, 0);

                for (int i = 1; i < n; i++) {
                    int currentStart = intervalArray[i].start;
                    if (currentStart >= previousEnd) {
                        assignmentMap.put(intervalArray[i].index, assign);
                    } else {
                        assign = 1 - assign;
                        assignmentMap.put(intervalArray[i].index, assign);
                    }
                    previousEnd = intervalArray[i].end;
                }

                for (int i = 0; i < n; i++) {
                    result.append(assignmentMap.get(i) == 0 ? "C" : "J");
                }
            }
            result.append("\n");
        }
        System.out.print(result);
    }

    public static int calculatePlatforms(int[] arrival, int[] departure) {
        Arrays.sort(arrival);
        Arrays.sort(departure);
        int platforms = 0, count = 0, i = 0, j = 0;

        while (i < arrival.length) {
            if (arrival[i] < departure[j]) {
                platforms = Math.max(platforms, ++count);
                i++;
            } else {
                count--;
                j++;
            }
        }
        return platforms;
    }

    static class Interval implements Comparable<Interval> {
        int start, end, index;

        Interval(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }

        @Override
        public int compareTo(Interval other) {
            return this.start != other.start ? this.start - other.start : this.end - other.end;
        }
    }

    static class FastReader {
        byte[] buffer = new byte[2048];
        int index, total;
        InputStream input;

        FastReader(InputStream input) {
            this.input = input;
        }

        int scan() throws IOException {
            if (index >= total) {
                index = 0;
                total = input.read(buffer);
                if (total <= 0) return -1;
            }
            return buffer[index++];
        }

        String next() throws IOException {
            int c;
            while ((c = scan()) <= 32);
            StringBuilder sb = new StringBuilder();
            while (c > 32) {
                sb.append((char) c);
                c = scan();
            }
            return sb.toString();
        }

        String nextLine() throws IOException {
            int c;
            while ((c = scan()) <= 32);
            StringBuilder sb = new StringBuilder();
            while (c != 10 && c != 13) {
                sb.append((char) c);
                c = scan();
            }
            return sb.toString();
        }

        char nextChar() throws IOException {
            int c;
            while ((c = scan()) <= 32);
            return (char) c;
        }

        int nextInt() throws IOException {
            int c, value = 0;
            while ((c = scan()) <= 32);
            boolean negative = c == '-';
            if (c == '-' || c == '+') c = scan();
            while (c >= '0' && c <= '9') {
                value = value * 10 + (c - '0');
                c = scan();
            }
            return negative ? -value : value;
        }

        long nextLong() throws IOException {
            int c;
            long value = 0;
            while ((c = scan()) <= 32);
            boolean negative = c == '-';
            if (c == '-' || c == '+') c = scan();
            while (c >= '0' && c <= '9') {
                value = value * 10 + (c - '0');
                c = scan();
            }
            return negative ? -value : value;
        }
    }
}