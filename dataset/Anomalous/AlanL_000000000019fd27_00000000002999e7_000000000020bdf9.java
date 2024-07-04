import java.io.*;
import java.util.*;

public class Solution {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String[] args) throws IOException {
        int t = readInt();
        for (int z = 1; z <= t; z++) {
            int n = readInt();
            Integer[][] intervals = new Integer[n][2];
            Map<Integer, Interval> intervalMap = new HashMap<>();

            for (int i = 0; i < n; i++) {
                intervals[i][0] = readInt();
                intervals[i][1] = readInt();
                intervalMap.put(i, new Interval(intervals[i][0], intervals[i][1]));
            }

            Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

            System.out.print("Case #" + z + ": ");
            List<Interval> aList = new ArrayList<>();
            List<Interval> bList = new ArrayList<>();
            boolean possible = true;

            for (int i = 0; i < n; i++) {
                boolean canAddToA = true;
                for (Interval e : aList) {
                    if (overlaps(intervals[i], e)) {
                        canAddToA = false;
                        break;
                    }
                }
                if (canAddToA) {
                    aList.add(new Interval(intervals[i][0], intervals[i][1]));
                } else {
                    boolean canAddToB = true;
                    for (Interval e : bList) {
                        if (overlaps(intervals[i], e)) {
                            canAddToB = false;
                            break;
                        }
                    }
                    if (!canAddToB) {
                        possible = false;
                        break;
                    } else {
                        bList.add(new Interval(intervals[i][0], intervals[i][1]));
                    }
                }
            }

            if (!possible) {
                System.out.println("IMPOSSIBLE");
            } else {
                printSchedule(intervalMap, aList, bList, n);
            }
        }
    }

    static class Interval {
        int start, end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    static boolean overlaps(Integer[] interval, Interval e) {
        return (interval[0] < e.end && interval[0] >= e.start) || (interval[1] > e.start && interval[1] <= e.end);
    }

    static void printSchedule(Map<Integer, Interval> intervalMap, List<Interval> aList, List<Interval> bList, int n) {
        List<Interval> processedList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Interval currentInterval = intervalMap.get(i);
            boolean found = false;

            for (Interval e : processedList) {
                if (e.start == currentInterval.start && e.end == currentInterval.end) {
                    found = true;
                    break;
                }
            }

            processedList.add(currentInterval);

            if (!found) {
                if (aList.contains(currentInterval)) {
                    System.out.print("C");
                } else {
                    System.out.print("J");
                }
            } else {
                System.out.print("J");
            }
        }
        System.out.println();
    }

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(input.readLine().trim());
        }
        return st.nextToken();
    }

    static int readInt() throws IOException {
        return Integer.parseInt(next());
    }

    static long readLong() throws IOException {
        return Long.parseLong(next());
    }

    static double readDouble() throws IOException {
        return Double.parseDouble(next());
    }

    static char readChar() throws IOException {
        return next().charAt(0);
    }

    static String readLine() throws IOException {
        return input.readLine().trim();
    }
}