import java.util.*;
import java.io.*;

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

            Arrays.sort(intervals, Comparator.comparingInt(arr -> arr[0]));

            System.out.print("Case #" + z + ": ");
            List<Interval> listA = new ArrayList<>();
            List<Interval> listB = new ArrayList<>();
            boolean possible = true;

            for (int i = 0; i < n; i++) {
                if (canAddToList(listA, intervals[i])) {
                    listA.add(new Interval(intervals[i][0], intervals[i][1]));
                } else if (canAddToList(listB, intervals[i])) {
                    listB.add(new Interval(intervals[i][0], intervals[i][1]));
                } else {
                    possible = false;
                    break;
                }
            }

            if (!possible) {
                System.out.println("IMPOSSIBLE");
            } else {
                for (int i = 0; i < n; i++) {
                    Interval current = intervalMap.get(i);
                    if (listA.contains(current)) {
                        System.out.print("C");
                    } else {
                        System.out.print("J");
                    }
                }
                System.out.println();
            }
        }
        pr.close();
    }

    static class Interval {
        int start, end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Interval interval = (Interval) o;
            return start == interval.start && end == interval.end;
        }

        @Override
        public int hashCode() {
            return Objects.hash(start, end);
        }
    }

    static boolean canAddToList(List<Interval> list, Integer[] interval) {
        for (Interval i : list) {
            if ((interval[0] < i.end && interval[0] >= i.start) || (interval[1] > i.start && interval[1] <= i.end)) {
                return false;
            }
        }
        return true;
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