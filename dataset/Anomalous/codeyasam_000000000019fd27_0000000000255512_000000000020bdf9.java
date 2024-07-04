import java.io.PrintStream;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    class Interval implements Comparable<Interval> {
        int start, end;
        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
        @Override
        public String toString() {
            return String.format("[%d,%d]", start, end);
        }
        @Override
        public int compareTo(Interval other) {
            return Integer.compare(this.start, other.start);
        }
    }

    public String solve(Scanner scanner) {
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        Interval[] intervalsA = new Interval[m];
        Interval[] intervalsB = new Interval[n];

        for (int i = 0; i < m; i++) {
            intervalsA[i] = new Interval(scanner.nextInt(), scanner.nextInt());
        }
        for (int j = 0; j < n; j++) {
            intervalsB[j] = new Interval(scanner.nextInt(), scanner.nextInt());
        }

        Arrays.sort(intervalsA);
        Arrays.sort(intervalsB);

        if (m == 0 && n == 0) {
            return "2";
        }
        if (m == 0) {
            return String.valueOf(2 * calculateOverlap(n, intervalsB, m, intervalsA));
        }
        return String.valueOf(2 * calculateOverlap(m, intervalsA, n, intervalsB));
    }

    private int calculateOverlap(int m, Interval[] a, int n, Interval[] b) {
        TreeMap<Integer, Integer> validMap = new TreeMap<>();
        int offset = a[0].start;

        for (int i = 0; i < m; i++) {
            if (!(i == m - 1 && offset == 0 && a[i].end == 1440)) {
                validMap.put(a[i].end - offset, i == m - 1 ? 1440 : a[i + 1].start - offset);
            }
        }

        List<Interval> mustCover = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int start = b[i].start - offset;
            if (start <= 0) start += 1440;
            int end = b[i].end - offset;
            if (end <= 0) end += 1440;
            mustCover.add(new Interval(start, end));
        }

        Collections.sort(mustCover);
        int remainingTime = 720;

        for (Interval interval : mustCover) {
            remainingTime -= interval.end - interval.start;
        }

        // Merge intervals if possible
        while (true) {
            int mergeIndex = -1;
            int smallestGap = Integer.MAX_VALUE;

            for (int i = 0; i < mustCover.size() - 1; i++) {
                Interval current = mustCover.get(i);
                Interval next = mustCover.get(i + 1);

                if (validMap.floorKey(current.start).equals(validMap.floorKey(next.start)) && next.start - current.end < smallestGap) {
                    mergeIndex = i;
                    smallestGap = next.start - current.end;
                }
            }

            if (smallestGap == Integer.MAX_VALUE) break;

            if (smallestGap > remainingTime) return mustCover.size();

            List<Interval> newList = new ArrayList<>();
            for (int i = 0; i < mustCover.size(); i++) {
                if (i != mergeIndex && i != mergeIndex + 1) {
                    newList.add(mustCover.get(i));
                }
            }
            newList.add(new Interval(mustCover.get(mergeIndex).start, mustCover.get(mergeIndex + 1).end));
            remainingTime -= smallestGap;
            mustCover = newList;
            Collections.sort(mustCover);
        }

        // Add intervals if needed
        while (true) {
            List<Interval> newList = new ArrayList<>();
            boolean intervalAdded = false;

            for (Interval interval : mustCover) {
                if (!intervalAdded) {
                    Map.Entry<Integer, Integer> entry = validMap.floorEntry(interval.start);
                    if (entry.getValue() - entry.getKey() != interval.end - interval.start) {
                        intervalAdded = true;
                        newList.add(new Interval(entry.getKey(), entry.getValue()));
                        remainingTime -= (entry.getValue() - entry.getKey()) - (interval.end - interval.start);
                    } else {
                        newList.add(interval);
                    }
                } else {
                    newList.add(interval);
                }
            }

            if (remainingTime <= 0) return newList.size();
            if (!intervalAdded) break;
            mustCover = newList;
        }

        // Add more intervals if needed
        while (true) {
            int start = -1, end = -1, maxDelta = 0;

            for (Map.Entry<Integer, Integer> entry : validMap.entrySet()) {
                boolean exists = mustCover.stream().anyMatch(interval -> interval.start == entry.getKey());
                if (exists) continue;

                int delta = entry.getValue() - entry.getKey();
                if (delta > maxDelta) {
                    maxDelta = delta;
                    start = entry.getKey();
                    end = entry.getValue();
                }
            }

            if (start == -1) break;

            mustCover.add(new Interval(start, end));
            Collections.sort(mustCover);
            remainingTime -= maxDelta;

            if (remainingTime <= 0) return mustCover.size();
        }

        System.err.println("ERROR!");
        return 0;
    }

    public static void main(String[] args) throws Exception {
        System.setOut(new PrintStream("output.txt"));
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        long startTime = System.currentTimeMillis();

        for (int t = 1; t <= testCases; t++) {
            System.out.println(String.format("Case #%d: %s", t, new Main().solve(scanner)));
        }

        long endTime = System.currentTimeMillis();
        System.err.println(String.format("Time used: %.3fs", (endTime - startTime) / 1000.0));
    }
}