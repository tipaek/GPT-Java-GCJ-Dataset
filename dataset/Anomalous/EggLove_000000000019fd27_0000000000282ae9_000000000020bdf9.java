import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int i = 0; i < testCases; i++) {
            processTestCase(scanner, i + 1);
        }
    }

    public static void processTestCase(Scanner scanner, int caseNumber) {
        boolean isPossible = true;
        int n = scanner.nextInt();
        List<Interval> intervals = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            intervals.add(new Interval(i, scanner.nextInt(), scanner.nextInt()));
        }

        for (int i = 0; i < intervals.size() - 1; i++) {
            for (int j = i + 1; j < intervals.size(); j++) {
                if (intervals.get(i).overlapsWith(intervals.get(j))) {
                    intervals.get(i).addOverlap(intervals.get(j));
                    intervals.get(j).addOverlap(intervals.get(i));
                }
            }
        }

        Queue<Interval> queue = new LinkedList<>();
        for (Interval interval : intervals) {
            if (interval.owner == -1) {
                interval.owner = 0;
                interval.visited = true;
                queue.add(interval);

                while (!queue.isEmpty()) {
                    Interval current = queue.poll();
                    for (Interval overlap : current.overlappingIntervals) {
                        if (!overlap.visited) {
                            overlap.visited = true;
                            overlap.owner = 1 - current.owner;
                            queue.add(overlap);
                        } else if (current.owner == overlap.owner) {
                            isPossible = false;
                            break;
                        }
                    }
                }
            }
        }

        System.out.print("Case #" + caseNumber + ": ");
        if (!isPossible) {
            System.out.println("IMPOSSIBLE");
        } else {
            for (Interval interval : intervals) {
                System.out.print(interval.owner == 0 ? "C" : "J");
            }
            System.out.println();
        }
    }
}

class Interval {
    public int number;
    public int start;
    public int end;
    public int owner;
    public boolean visited;
    public List<Interval> overlappingIntervals;

    Interval(int number, int start, int end) {
        this.number = number;
        this.start = start;
        this.end = end;
        this.owner = -1;
        this.visited = false;
        this.overlappingIntervals = new ArrayList<>();
    }

    public void addOverlap(Interval interval) {
        overlappingIntervals.add(interval);
    }

    public boolean overlapsWith(Interval interval) {
        return (this.start < interval.end && this.end > interval.start);
    }
}