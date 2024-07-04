import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseIndex = 1; caseIndex <= testCases; caseIndex++) {
            int numIntervals = scanner.nextInt();
            ArrayList<Interval> intervals = new ArrayList<>();
            boolean isPossible = true;

            // Reading intervals and constructing the graph
            for (int i = 0; i < numIntervals; i++) {
                Interval interval = new Interval(scanner.nextInt(), scanner.nextInt());
                for (Interval existingInterval : intervals) {
                    existingInterval.addConflictIfNeeded(interval);
                }
                intervals.add(interval);
            }

            for (Interval interval : intervals) {
                if (!assignCameronOrJamie(interval)) {
                    isPossible = false;
                    break;
                }
            }

            System.out.print("Case #" + caseIndex + ": ");
            if (!isPossible) {
                System.out.println("IMPOSSIBLE");
            } else {
                for (Interval interval : intervals) {
                    System.out.print(interval.assignedToCameron ? "C" : "J");
                }
                System.out.println();
            }
        }
        scanner.close();
    }

    public static boolean assignCameronOrJamie(Interval interval) {
        if (interval.conflictingIntervals.isEmpty()) return true;

        if (!interval.visited) {
            interval.assignedToCameron = !interval.conflictingIntervals.get(0).assignedToCameron;
            interval.visited = true;
        }

        boolean assignedToCameron = interval.assignedToCameron;

        for (Interval conflictingInterval : interval.conflictingIntervals) {
            if (conflictingInterval.visited) {
                if (conflictingInterval.assignedToCameron == assignedToCameron) {
                    return false;
                }
            } else {
                conflictingInterval.visited = true;
                conflictingInterval.assignedToCameron = !assignedToCameron;
            }
        }

        return true;
    }
}

class Interval {
    ArrayList<Interval> conflictingIntervals = new ArrayList<>();
    int startTime, endTime;
    boolean assignedToCameron;
    boolean visited;

    Interval(int start, int end) {
        this.startTime = start;
        this.endTime = end;
    }

    void addConflictIfNeeded(Interval other) {
        if (this.startTime < other.startTime && this.endTime > other.startTime) {
            this.conflictingIntervals.add(other);
        } else if (this.startTime < other.endTime && this.endTime > other.endTime) {
            this.conflictingIntervals.add(other);
        }
    }
}