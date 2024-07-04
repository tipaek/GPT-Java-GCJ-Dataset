import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());

        for (int t = 0; t < testCases; t++) {
            int n = Integer.parseInt(reader.readLine());
            Map<Integer, Interval> intervals = new TreeMap<>();
            
            for (int i = 0; i < n; i++) {
                StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                intervals.put(i, new Interval(Integer.parseInt(tokenizer.nextToken()), Integer.parseInt(tokenizer.nextToken())));
            }

            boolean[] cOccupied = new boolean[24 * 60];
            boolean[] jOccupied = new boolean[24 * 60];
            char[] result = new char[n];
            boolean isImpossible = false;

            List<Interval> intervalList = new ArrayList<>(intervals.values());
            Collections.sort(intervalList);

            for (Interval interval : intervalList) {
                int start = interval.start;
                int end = interval.end;
                
                if (canAssign(cOccupied, start, end)) {
                    Arrays.fill(cOccupied, start, end, true);
                    result[getKey(intervals, interval)] = 'C';
                } else if (canAssign(jOccupied, start, end)) {
                    Arrays.fill(jOccupied, start, end, true);
                    result[getKey(intervals, interval)] = 'J';
                } else {
                    isImpossible = true;
                    break;
                }
            }

            if (isImpossible) {
                System.out.printf("Case #%d: IMPOSSIBLE\n", t + 1);
            } else {
                System.out.printf("Case #%d: %s\n", t + 1, new String(result));
            }
        }
        reader.close();
    }

    private static boolean canAssign(boolean[] occupied, int start, int end) {
        for (int i = start; i < end; i++) {
            if (occupied[i]) {
                return false;
            }
        }
        return true;
    }

    private static int getKey(Map<Integer, Interval> map, Interval interval) {
        for (Map.Entry<Integer, Interval> entry : map.entrySet()) {
            if (entry.getValue().equals(interval)) {
                return entry.getKey();
            }
        }
        return -1;
    }
}

class Interval implements Comparable<Interval> {
    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Interval interval = (Interval) obj;
        return start == interval.start && end == interval.end;
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, end);
    }

    @Override
    public String toString() {
        return "(" + start + "," + end + ")";
    }

    @Override
    public int compareTo(Interval other) {
        return Integer.compare(this.start, other.start);
    }
}